package edc2010.test;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	public static boolean useLoop(String[] arr,String targetValue){
	    for(String s:arr){
	        if(s.equals(targetValue))
	            return true;
	        }  
	        return false;
	    }
	
	public static List<Map<String,String>> addressResolution(String address){
		/* 
		 * java.util.regex是一个用正则表达式所订制的模式来对字符串进行匹配工作的类库包。它包括两个类：Pattern和Matcher Pattern
	     *    一个Pattern是一个正则表达式经编译后的表现模式。 Matcher
	     *    一个Matcher对象是一个状态机器，它依据Pattern对象做为匹配模式对字符串展开匹配检查。
         *    首先一个Pattern实例订制了一个所用语法与PERL的类似的正则表达式经编译后的模式，然后一个Matcher实例在这个给定的Pattern实例的模式控制下进行字符串的匹配工作。
    	*/
        String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m=Pattern.compile(regex).matcher(address);
        String province=null,city=null,county=null,town=null,village=null;
        List<Map<String,String>> table=new ArrayList<Map<String,String>>();
        Map<String,String> row=null;
        while(m.find()){
            row=new LinkedHashMap<String,String>();
            province=m.group("province");
            row.put("province", province==null?"":province.trim());
            city=m.group("city");
            row.put("city", city==null?"":city.trim());
            county=m.group("county");
            row.put("county", county==null?"":county.trim());
            town=m.group("town");
            row.put("town", town==null?"":town.trim());
            village=m.group("village");
            row.put("village", village==null?"":village.trim());
            table.add(row);
        }
        return table;
    }
	
	/**
	* 根据字符编码得到字符串实际占用长度
	*/
	public static int getStringLength(String str,String encoding) throws UnsupportedEncodingException{
		if(isNullOrEmpty(str)) {
			return 0;
		} else {
			return str.getBytes(encoding).length;
		}
	}

	/**
	* 判断字段是否为空
	* @return true 为空， false 不为空
	*/
	public static boolean isNullOrEmpty(String str){
		return null == str || "".equals(str);
	}
	
	public static String bSubstring(String s, int length) throws Exception
    {

        byte[] bytes = s.getBytes(CONFIG.encode);
        int n = 0; // 表示当前的字节数
        int i = 2; // 要截取的字节数，从第3个字节开始
        for (; i < bytes.length && n < length; i++)
        {
            // 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
            if (i % 2 == 1)
            {
                n++; // 在UCS2第二个字节时n加1
            }
            else
            {
                // 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
                if (bytes[i] != 0)
                {
                    n++;
                }
            }
        }
        // 如果i为奇数时，处理成偶数
        if (i % 2 == 1)

        {
            // 该UCS2字符是汉字时，去掉这个截一半的汉字
            if (bytes[i - 1] != 0)
                i = i - 1;
            // 该UCS2字符是字母或数字，则保留该字符
            else
                i = i + 1;
        }

        return new String(bytes, 0, i, CONFIG.encode);
    }
	
	/*方法二：推荐，速度最快
	  * 判断是否为整数 
	  * @param str 传入的字符串 
	  * @return 是整数返回true,否则返回false 
	*/

	  public static boolean isInteger(String str) {  
	        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	        return pattern.matcher(str).matches();  
	  }
	  
	  /** 根据地址获取到经纬度
	 * @return 
	  */
//		public static String getGeocoderLatitude(String address, String city) {
//			BufferedReader in = null;
//			String lng = "";
//			String lat = "";
//			try {
//				address = URLEncoder.encode(address, "UTF-8");
//				URL tirc = new URL("http://api.map.com/geocoder/v2/?address="
//						+ address
//						+ "&output=json&ak=" + ak + "&city="
//						+ city);
//				in = new BufferedReader(new InputStreamReader(tirc.openStream(),
//						"UTF-8"));
//				String res;
//				StringBuilder sb = new StringBuilder("");
//				while ((res = in.readLine()) != null) {
//					sb.append(res.trim());
//				}
//				String str = sb.toString();
//				if (StringUtils.isNotEmpty(str)) {
//					int lngStart = str.indexOf("lng\":");
//					int lngEnd = str.indexOf(",\"lat");
//					int latEnd = str.indexOf("},\"precise");
//					if (lngStart > 0 && lngEnd > 0 && latEnd > 0) {
//						lng = str.substring(lngStart + 5, lngEnd);
//						lat = str.substring(lngEnd + 7, latEnd);
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					in.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			return lat + "," + lng;
//	 
//		}
//
//		/**
//		 * 根据经纬度获取省市区
//		 */
//		public static JsonNode getposition(String LatitudeAndLongitude)
//				throws MalformedURLException {
//			BufferedReader in = null;
//			JsonNode locationNode = null;
//			URL tirc = new URL("http://api.map.com/geocoder/v2/?location="
//					+ LatitudeAndLongitude + "&output=json&ak="
//					+ ak);
//			try {
//				in = new BufferedReader(new InputStreamReader(tirc.openStream(),
//						"UTF-8"));
//				String res;
//				StringBuilder sb = new StringBuilder("");
//				while ((res = in.readLine()) != null) {
//					sb.append(res.trim());
//				}
//				String str = sb.toString();
//				ObjectMapper mapper = new ObjectMapper();
//				if (StringUtils.isNotEmpty(str)) {
//					JsonNode jsonNode = mapper.readTree(str);
//					jsonNode.findValue("status").toString();
//					JsonNode resultNode = jsonNode.findValue("result");
//					locationNode = resultNode
//							.findValue("addressComponent");
//				}
//	 
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			return locationNode;
//	 
//		}
	  
	  public static Object[][] ResultsetToArray(ResultSet rs) {
	        try {
	            ResultSetMetaData meta = rs.getMetaData();
	            int columnCount = meta.getColumnCount();
	            String[] strutName = new String[columnCount];
	            byte[] strutType = new byte[columnCount];
	            rs.last();
	            int itemCount = rs.getRow();
	            rs.first();
	            Object[][] data = new Object[columnCount][itemCount];
	            for (int i = 0; i < columnCount; i++) {
	                strutType[i] = (byte) meta.getColumnType(i);//esultSetMetaData中的字段类型表示应该是不一致的，这里做一个类型映射和转换即可
	                strutName[i] = meta.getColumnName(i);
	            }
	            for (int i = 0; rs.next(); i++) {
	                for (int j = 0; j < columnCount; j++) {
	                    data[i][j] = rs.getObject(j);
	                }
	            }
	            return data;
	        } catch (Exception e) {
	            e.printStackTrace();
	            LoggerManager.setErrorLog(e);
	        }
			return null;
	    }
	
	  /**
		 * 把数据库字段类型转换成DBF字段类型
		 */
		public static DBFDataType ResultsetTypeToDbfType(String rsType) {
			DBFDataType strutType = DBFDataType.CHARACTER;
			if (rsType == null) {
				return DBFDataType.CHARACTER;
			}
			rsType = rsType.trim().toLowerCase();
			if (rsType.equals("float") || rsType.equals("int")
					|| rsType.equals("numeric") || rsType.equals("decimal")
					|| rsType.equals("smallint") || rsType.equals("tinyint") || rsType.equals("bigint")) {
				strutType = DBFDataType.NUMERIC;
			} else if (rsType.equals("datetime") || rsType.equals("smalldatetime")) {
				strutType = DBFDataType.CHARACTER;
			} else if (rsType.equals("bit")) {
				strutType = DBFDataType.DOUBLE;
			} else {
				strutType = DBFDataType.CHARACTER;
			}
			return strutType;
		}
		
		public static String getNowDate() {
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
			return dateFormat.format( now ); 
		}
		
		public static String getNowTime() {
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
			return dateFormat.format( now ); 
		}
		
		public static String getSomedayEarly(int days) {
			java.util.Calendar c=java.util.Calendar.getInstance();    
	        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyyMMdd");    
	        // Reduce 10 Days
	        c.add(java.util.Calendar.DATE, days);
//	        System.out.println( "获取日期：" + f.format(c.getTime()));
//	        LoggerManager.setInfoLog( "获取日期：" + f.format(c.getTime()));
	        return f.format(c.getTime());
		}
		
		public static String getCaseWhen(String[][] double_dimensional_arrays,String table_alias,String column) {
			String case_when = " case ";
			for (int i = 0; i < double_dimensional_arrays.length; i++) {
				if ("null".equals(double_dimensional_arrays[i][0])) {
					case_when += " when " + (table_alias == "" ? "" : table_alias + ".") + column + " is " + double_dimensional_arrays[i][0] + " then '" + double_dimensional_arrays[i][1] + "' ";
				} else {
					case_when += " when " + (table_alias == "" ? "" : table_alias + ".") + column + " = '" + double_dimensional_arrays[i][0] + "' then '" + double_dimensional_arrays[i][1] + "' ";
				}
			}
			case_when += " end ";
			System.out.println( case_when );
			return case_when;
		}
}
