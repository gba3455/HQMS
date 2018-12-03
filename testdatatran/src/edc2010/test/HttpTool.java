package edc2010.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;
/**
 * Http操作辅助工具
 * @author ajun
 *
 */
public class HttpTool {
	/**
	 * GET请求数据
	 * @param get_url url地址
	 * @param content  key=value形式
	 * @return 返回结果
	 * @throws Exception
	 */
	public String sendGetData(String get_url, String content) throws Exception {
		String result = "";
		URL getUrl = null;
		BufferedReader reader = null;
		String lines = "";
		HttpURLConnection connection = null;
		try {
			if (content != null && !content.equals(""))
				get_url = get_url + "?" + content;
				//get_url = get_url + "?" + URLEncoder.encode(content, "utf-8");
			getUrl = new URL(get_url);
			connection = (HttpURLConnection) getUrl.openConnection();
			connection.connect();
			// 取得输入流，并使用Reader读取
			reader = new BufferedReader(new InputStreamReader(connection
					.getInputStream(), "utf-8"));// 设置编码
			while ((lines = reader.readLine()) != null) {
				result = result + lines;
			}
			return result;
		} catch (Exception e) {
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
				reader = null;
			}
			connection.disconnect();
		}
	}
	/**
	 * @param POST_URL url地址
	 * @param content  key=value形式
	 * @return 返回结果
	 * @throws Exception
	 */
	public String sendPostData(String POST_URL, String content)
			throws Exception {
		HttpURLConnection connection=null;
		DataOutputStream out=null;
		BufferedReader reader=null;
		String line = "";
		String result="";
		try {
			URL postUrl = new URL(POST_URL);
			connection= (HttpURLConnection) postUrl.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			// Post 请求不能使用缓存
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.connect();
			
			out = new DataOutputStream(connection.getOutputStream());
			//content = URLEncoder.encode(content, "utf-8");
			// DataOutputStream.writeBytes将字符串中的16位的unicode字符�?8位的字符形式写道流里�?
			out.writeBytes(content);
			out.flush();
			out.close();
			//获取结果
			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));// 设置编码
			while ((line = reader.readLine()) != null) {
				result=result+line;
			}		
			return result;
		} catch (Exception e) {
			throw e;
		}finally
		{
			if(out!=null)
			{
				out.close();
				out=null;				
			}
			if(reader!=null)
			{
				reader.close();
				reader=null;				
			}
			connection.disconnect();
		}
	}
	/*
	 * 过滤掉html里不安全的标签，不允许用户输入这些标�?
	 */
	public static String htmlFilter(String inputString) {
		//return inputString;
		  String htmlStr = inputString; // 含html标签的字符串
		  String textStr = "";
		  java.util.regex.Pattern p_script;
		  java.util.regex.Matcher m_script;
		 	
		
		  try {
		   String regEx_script = "<[\\s]*?(script|style)[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?(script|style)[\\s]*?>"; 
		   String regEx_onevent="on[^\\s]+=\\s*";
		   String regEx_hrefjs="href=javascript:";
		   String regEx_iframe="<[\\s]*?(iframe|frameset)[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?(iframe|frameset)[\\s]*?>";
		   String regEx_link="<[\\s]*?link[^>]*?/>";
		  
		   htmlStr = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE).matcher(htmlStr).replaceAll(""); 
		   htmlStr=Pattern.compile(regEx_onevent, Pattern.CASE_INSENSITIVE).matcher(htmlStr).replaceAll("");
		   htmlStr=Pattern.compile(regEx_hrefjs, Pattern.CASE_INSENSITIVE).matcher(htmlStr).replaceAll("");
		   htmlStr=Pattern.compile(regEx_iframe, Pattern.CASE_INSENSITIVE).matcher(htmlStr).replaceAll("");
		   htmlStr=Pattern.compile(regEx_link, Pattern.CASE_INSENSITIVE).matcher(htmlStr).replaceAll("");
		  
		   //p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		  // m_html = p_html.matcher(htmlStr);
		  // htmlStr = m_html.replaceAll(""); // 过滤html标签

		   textStr = htmlStr;

		  } catch (Exception e) {
		   System.err.println("Html2Text: " + e.getMessage());
		  }

		  return textStr;
		}
}

