package javadbf;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.sun.istack.internal.logging.Logger;

import edc2010.test.CONFIG;
import edc2010.test.DBFUtil;
import edc2010.test.JDBCUtil;

public class NFDFlightDataTimerTask extends TimerTask {

    private static Logger log = Logger.getLogger(NFDFlightDataTimerTask.class);

    @Override
    public void run() {
        try {
    		ExecutorService exec = Executors.newCachedThreadPool();
    		long begin = System.currentTimeMillis(); 
    		//开始清空template
    		if (CONFIG.CleanTable) {
    			System.out.println("开始清空template表");
    			boolean isClean = JDBCUtil.CleanUpTable(CONFIG.dataTable);
    			if (isClean) {
    				System.out.println("清空template表成功");
    			} else {
    				System.out.println("template表内无数据");
    			}
    		}
    		
    		// 开始插入数据库
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
    			}
    		}
    		
    		// 开始读取template数据库
    		ResultSet res = JDBCUtil.GetTableData(CONFIG.dataTable);
    		try {
    			DBFUtil.DoDBF(res);
    		} catch (Exception e) {
    			// TODO 自动生成的 catch 块
    			e.printStackTrace();
    		}
            final long end = System.currentTimeMillis();
            System.out.println((end-begin)/1000);
        } catch (Exception e) {
            log.info("-------------解析信息发生异常--------------");
        }
    }
}