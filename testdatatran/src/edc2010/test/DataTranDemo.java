package edc2010.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;

public class DataTranDemo {
	
	/**
	 * 服务器的域名地址
	 */
//	private final String SERVICE_URL="http://edc/hqcm_tran2";
//	private final String SERVICE_URL = "http://localhost:8080/hqcm_tran2";
	
	
	
	
	public static int row = 0;
	
	/**
	 * 获取token
	 * 
	 */
	public String getToken() throws IOException{
	String sUrl = CONFIG.SERVICE_URL+"/docking/auto/gettoken.shtml?loginid="+CONFIG.USER+"&isDev=1&CONFIG.PWD="+CONFIG.PWD+"&datatype="+CONFIG.DATA_TYPE;
    System.out.println("send getToken request url:"+sUrl);
    String response="{}";
    try {
      MyProcURLConnection mpuc = new MyProcURLConnection();
//      response = JustHttp.doGetStr(sUrl, 3 * 60000, mpuc, "UTF-8");
      HttpTool tool = new HttpTool();
      response = tool.sendGetData(sUrl, "");
      System.out.println(response);
//      comdzy.strUtil.getMPartStr(oriStr, bMark, eMark)
//      JSESSIONID=0AC8F36F61DF91F1AA71878F5B9DAA48;
    } catch (Exception e) {
      e.printStackTrace();
    }
    JSONObject obj = JSONObject.fromObject(response);
    String token = "";
    if (obj.getBoolean("succ")){
      token=obj.getJSONObject("result").getString("token");
    } else {
      System.out.println(obj.toString());
      System.err.println("获得Token失败，errCode="+obj.getString("errorCode")+"\r\nerrMsg="+obj.getString("errMsg"));
    }
    return token;
	}
	
	
	/**
	 * 发送数据 
	 * 本方法不使用justHttp的原因：因为这是给用户的Demo，用户并没有JustHttp
	 */
	public void sendData(String token){
		try {
			//定义数据的年份、月份、中心编号、数据地址
			//请在使用时更改这些值 
			String year = "2012";
			String month="04";
//			String orgid="14343";
			String data_url="E:/201204_2012-09-21 14_55_51.0236563_14343.zip";
			String sUrl = CONFIG.SERVICE_URL+"/autoReqTran.shtml?year="+year+"&month="+month+"&token="+token+"&datatype="+CONFIG.DATA_TYPE+"&genLargeDat=0";//+"&orgid="+orgid
//			sUrl = CONFIG.SERVICE_URL+"/usp/doInnerAction?Action=autoreqFile&year="+year+"&month="+month+"&orgid="+orgid+"&token="+token+"&datatype="+CONFIG.DATA_TYPE;
			System.out.println("senddata url="+sUrl);
			URL url = new URL(sUrl);
//			URL url = new URL(CONFIG.SERVICE_URL+"/usp/doInnerAction?Action=autoreqFile&year="+year+"&month="+month+"&orgid="+orgid+"&token="+token+"&datatype="+CONFIG.DATA_TYPE);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			//设置连接超时时长，根据数据量大小而定
			connection.setConnectTimeout(10*60*1000);
			
			//设置读取超时
			connection.setReadTimeout(50000);
			
			//设置允许输出
			connection.setDoOutput(true);
			
			//设置允许输入
			connection.setDoInput(true);
			
			//设置不缓存
			connection.setUseCaches(false);
			
			//设置为POST方式，必须的
			connection.setRequestMethod("POST");
			
			//读取本地ZIP文件
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			File file = new File(data_url);
			InputStream is = new FileInputStream(file);
			IOUtils.copy(is, bout);
			
			//----------设置连接的参数---------------
			
			//设置维持长连接
			connection.setRequestProperty("Connection", "Keep-Alive");
			
			//设置字符编码集
			connection.setRequestProperty("Charset", "UTF-8");
			
			//设置长度
			connection.setRequestProperty("Content-Length", String.valueOf(bout.toByteArray().length));
			
			//设置内容为流
			connection.setRequestProperty( 
	                 "Accept",
	                 "image/gif,   image/x-xbitmap,   image/jpeg,   image/pjpeg,   application/vnd.ms-excel,   application/vnd.ms-powerpoint,   application/msword,   application/x-shockwave-flash,   application/x-quickviewplus,   */*");
			connection.setRequestProperty("Content-Type","multipart/form-data; boundary=Bounday---------------------------7d318fd100112");
			
			//设置不缓存
	        connection.setRequestProperty("Cache-Control","no-cache"); 
	        
	        //不允许服务器以压缩的格式返回结果：因为是需要本地解压的
//	        connection.setRequestProperty("Accept-Encoding", "gzip,   deflate");
	        
	        //将文件写入输出流
			OutputStream os = connection.getOutputStream();
			
			os.write(bout.toByteArray());
			bout.close();
			os.close();
			is.close();
			
			InputStream in = connection.getInputStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			for (int b = in.read(); b >= 0; b = in.read()) {
				outputStream.write((byte) b);
			}
			String res = new String(outputStream.toByteArray(), "UTF-8").trim();
			outputStream.close();
			in.close();
			System.out.println("sendData return: "+res);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  查询结果
	 */
	public void findResult(String token){
//		String token="45fb2ab1e81d4762a78ca82f0de6e3cc";
		try {
			URL url = new URL(CONFIG.SERVICE_URL+"/docking/auto/findResult.shtml?token="+token+"&datatype="+CONFIG.DATA_TYPE);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(50000);
			connection.setReadTimeout(50000);
			//设置允许输出
			connection.setDoOutput(true);
			//设置允许输入
			connection.setDoInput(true);
			//设置不缓存
			connection.setUseCaches(false);
			//设置字符编码集
			connection.setRequestProperty("Charset", "UTF-8");
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			connection.setRequestProperty("contentType", "UTF-8");
			
			//开始连接并获得结果
			InputStream in = connection.getInputStream();
			
			//读取数据
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			for (int b = in.read(); b >= 0; b = in.read()) {
				outputStream.write((byte) b);
			}
			String response = new String(outputStream.toByteArray(), "UTF-8").trim();
			outputStream.close();
			in.close();  
			
			System.out.println("findResult return:"+response);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void testjson(){
	  JSONObject j = new JSONObject();
	  j.put("a1","aaa123");
	  System.out.println(j.toString());
	}
	
	public static void main(String[] args){
////	  testjson();
////	  if(true)return ;
//		DataTranDemo demo = new DataTranDemo();
//		try {
//			String token = demo.getToken();
//			System.out.println(token);
////			String token = "gqntanru28ob8mqvqsltuc5fn";
//			if (StringUtils.isNotBlank(token)){//false && 
//			demo.sendData(token);
//			Thread.sleep(2000);
////			String token = "15097f92d103483fbe02d29d1ee9cd25";
//			demo.findResult(token);
//			}
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		} 

//		JDBCUtil util = new JDBCUtil();
//		Thread t = new Thread(util);
//		t.start();
		ExecutorService exec = Executors.newCachedThreadPool();
		long begin = System.currentTimeMillis(); 
		//开始清空template
		System.out.println("开始清空template表");
		boolean isClean = JDBCUtil.CleanUpTable(CONFIG.dataTable);
		if (isClean) {
			System.out.println("清空template表成功");
		} else {
			System.out.println("template表内无数据");
		}
		
//		// 开始插入数据库
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
		// 开始读取template数据库
		ResultSet res = JDBCUtil.GetTableData(CONFIG.dataTable);
		try {
			DBFUtil.DoDBF(res);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        final long end = System.currentTimeMillis();
        System.out.println((end-begin)/1000);
	}
}

