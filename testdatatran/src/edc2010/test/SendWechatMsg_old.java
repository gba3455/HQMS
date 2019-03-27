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

 
public class SendWechatMsg {
    public static void sendMsg(String title,String content,String remark) {
        // 创建一个httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建一个post对象
        HttpPost post = new HttpPost("http://u.ifeige.cn/api/send_message");
        // 创建一个Entity，模拟表单数据
        List<NameValuePair> formList = new ArrayList<NameValuePair>();
        // 添加表单数据  
        formList.add(new BasicNameValuePair("secret", CONFIG.secret));
        formList.add(new BasicNameValuePair("token", CONFIG.token));
        formList.add(new BasicNameValuePair("template_id", "LwKYoC6h87akctOEqQV74lcZgJKuQzSFQv6JkVsth-A"));
        formList.add(new BasicNameValuePair("key", "notice"));
        formList.add(new BasicNameValuePair("title", title));
        formList.add(new BasicNameValuePair("content", content));
        formList.add(new BasicNameValuePair("remark", remark));
        formList.add(new BasicNameValuePair("time", "time()"));
        
        // 包装成一个Entity对象
        StringEntity entity;
		try {
			entity = new UrlEncodedFormEntity(formList, "utf-8");
			// 设置请求的内容
	        post.setEntity(entity);
	        // 设置请求的报文头部的编码
	         post.setHeader(new BasicHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8"));
	        // 设置期望服务端返回的编码
	         post.setHeader(new BasicHeader("Accept","text/plain;charset=utf-8"));
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
	            SendWechatMsg.sendMsg("SendWechatMsg", "飞鸽出错", Util.getNowTime());
	            LoggerManager.setErrorLog("飞鸽出错" + statusCode);
	        }
		} catch (UnsupportedEncodingException e) {
			SendWechatMsg.sendMsg("SendWechatMsg", "UnsupportedEncodingException", e.getCause().getMessage());
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			SendWechatMsg.sendMsg("SendWechatMsg", "ClientProtocolException", e.getCause().getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			SendWechatMsg.sendMsg("SendWechatMsg", "IOException", e.getCause().getMessage());
			e.printStackTrace();
		}
        
    }
    
}
