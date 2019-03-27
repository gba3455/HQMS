package edc2010.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

 
public class SendBarkPushMsg {
    public static void sendMsg(String title,String content,String remark) {
        // 创建一个httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        for (int i = 0; i < CONFIG.BARK_KEYS.length; i++) {
        	// 创建一个post对象
            HttpPost post = new HttpPost("https://api.day.app/"+ CONFIG.BARK_KEYS[i] + "/" + title + "/" + content );
    		try {
    	        // 执行post请求
    	        CloseableHttpResponse response = client.execute(post);
    	        // 获取响应码
    	        int statusCode = response.getStatusLine().getStatusCode();
    	        if (statusCode == 200) {
    	            // 获取数据
    	            String resStr = EntityUtils.toString(response.getEntity());
    	            // 输出
    	            System.out.println(resStr);
    	            LoggerManager.setInfoLog(resStr);
    	        } else {
    	            // 输出
    	            System.out.println(statusCode);
    	            SendBarkPushMsg.sendMsg("SendWechatMsg", "bark出错", Util.getNowTime());
    	            LoggerManager.setErrorLog("bark出错" + statusCode);
    	        }
    		} catch (UnsupportedEncodingException e) {
    			SendBarkPushMsg.sendMsg("SendBarkPushMsg", "UnsupportedEncodingException", e.toString());
    			e.printStackTrace();
    		} catch (ClientProtocolException e) {
    			// TODO 自动生成的 catch 块
    			SendBarkPushMsg.sendMsg("SendBarkPushMsg", "ClientProtocolException", e.toString());
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO 自动生成的 catch 块
    			SendBarkPushMsg.sendMsg("SendBarkPushMsg", "IOException", e.toString());
    			e.printStackTrace();
    		}
        }
    }
    
}
