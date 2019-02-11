package edc2010.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecuteManager implements Runnable {

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		LoggerManager.setInfoLog("当前执行任务时间：" + Util.getNowTime());
		boolean canBeUse = JDBCUtil.canUse();
		LoggerManager.setInfoLog("系统使用权限：" + canBeUse);
		if (!canBeUse) {
			System.out.println("当前系统使用权限关闭，无法使用。");
			LoggerManager.setErrorLog("当前系统使用权限关闭，无法使用。");
			System.exit(-1);
		}
		LoggerManager.setInfoLog(" 验证通过，程序开始执行！");
		ExecutorService exec = Executors.newCachedThreadPool();
//		long begin = System.currentTimeMillis(); 
		//Starting Clean up template
		if (CONFIG.CleanTable) {
			LoggerManager.setInfoLog("开始清空template表");
			boolean isClean = JDBCUtil.CleanUpTable(CONFIG.dataTable);
			if (isClean) {
				LoggerManager.setInfoLog("清空template表成功");
			} else {
				LoggerManager.setInfoLog("template表内无数据");
			}
		}
		
		// Starting Insert Data Into Database
		if (CONFIG.IsMultiThread) {
			int count = new JDBCUtil().getCount();
			for (int i = 0; i < count; i++) {
				JDBCUtil util = new JDBCUtil();
					if (i == 0) {
						util.setStart(0);
						util.setEnd(CONFIG.Thread_Page_Size);
						exec.submit(util);
					} else if (i > 0 && i % CONFIG.Thread_Page_Size == 0) {
						util.setStart(i + 1);
						if (i + CONFIG.Thread_Page_Size > count) {
							util.setEnd(count);
						} else {
							util.setEnd(i + CONFIG.Thread_Page_Size);
						}
						exec.submit(util);
					}
			}
			exec.shutdown();
			try {
				exec.awaitTermination(1, TimeUnit.HOURS);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				LoggerManager.setErrorLog(e);
			}
		} else {
			JDBCUtil util = new JDBCUtil();
			Thread t = new Thread(util);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				LoggerManager.setErrorLog(e);
			}
		}
		
		// 开始读取template数据库
		ResultSet res = JDBCUtil.GetTableData(CONFIG.dataTable);
		boolean DBFCreateStatus = false;
		try {
			DBFCreateStatus = DBFUtil.DoDBF(res);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			LoggerManager.setErrorLog(e);
		}
		if (DBFCreateStatus) {
			try {
				SendWechatMsg.sendMsg("HQMS数据上报情况通知", Util.getNowDate() + "上报数据生成成功", Util.getNowTime());
			} catch (Exception e) {
				e.printStackTrace();
				LoggerManager.setErrorLog(e);
			}
		} else {
			try {
				SendWechatMsg.sendMsg("HQMS数据上报情况通知", Util.getNowDate() + "上报数据生成失败", Util.getNowTime());
			} catch (Exception e) {
				e.printStackTrace();
				LoggerManager.setErrorLog(e);
			}
		}
//        final long end = System.currentTimeMillis();
//        System.out.println((end-begin)/1000);
	}

}