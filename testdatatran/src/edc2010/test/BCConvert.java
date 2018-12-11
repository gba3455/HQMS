package edc2010.test;
import java.util.Map;
import org.apache.commons.lang.StringUtils;    

/**  
 * <PRE>  
 * 提供对字符串的全角->半角，半角->全角转换  
 * </PRE>  
 */    
public class BCConvert {    
    
    /**  
     * ASCII表中可见字符从!开始，偏移位值为33(Decimal)  
     */    
    static final char DBC_CHAR_START = 33; // 半角!    
    
    /**  
     * ASCII表中可见字符到~结束，偏移位值为126(Decimal)  
     */    
    static final char DBC_CHAR_END = 126; // 半角~    
    
    /**  
     * 全角对应于ASCII表的可见字符从！开始，偏移值为65281  
     */    
    static final char SBC_CHAR_START = 65281; // 全角！    
    
    /**  
     * 全角对应于ASCII表的可见字符到～结束，偏移值为65374  
     */    
    static final char SBC_CHAR_END = 65374; // 全角～    
    
    /**  
     * ASCII表中除空格外的可见字符与对应的全角字符的相对偏移  
     */    
    static final int CONVERT_STEP = 65248; // 全角半角转换间隔    
    
    /**  
     * 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理  
     */    
    static final char SBC_SPACE = 12288; // 全角空格 12288    
    
    /**  
     * 半角空格的值，在ASCII中为32(Decimal)  
     */    
    static final char DBC_SPACE = ' '; // 半角空格    
    
    /**  
     * <PRE>  
     * 半角字符->全角字符转换    
     * 只处理空格，!到˜之间的字符，忽略其他  
     * </PRE>  
     */    
    private static String bj2qj(String src) {    
        if (src == null) {    
            return src;    
        }    
        StringBuilder buf = new StringBuilder(src.length());    
        char[] ca = src.toCharArray();    
        for (int i = 0; i < ca.length; i++) {    
            if (ca[i] == DBC_SPACE) { // 如果是半角空格，直接用全角空格替代    
                buf.append(SBC_SPACE);    
            } else if ((ca[i] >= DBC_CHAR_START) && (ca[i] <= DBC_CHAR_END)) { // 字符是!到~之间的可见字符    
                buf.append((char) (ca[i] + CONVERT_STEP));    
            } else { // 不对空格以及ascii表中其他可见字符之外的字符做任何处理    
                buf.append(ca[i]);    
            }    
        }    
        return buf.toString();    
    }    
    
    /**  
     * <PRE>  
     * 全角字符->半角字符转换    
     * 只处理全角的空格，全角！到全角～之间的字符，忽略其他  
     * </PRE>  
     */    
    public static String qj2bj(String src) {    
        if (src == null) {    
            return src;    
        }    
        StringBuilder buf = new StringBuilder(src.length());    
        char[] ca = src.toCharArray();    
        for (int i = 0; i < src.length(); i++) {    
            if (ca[i] >= SBC_CHAR_START && ca[i] <= SBC_CHAR_END) { // 如果位于全角！到全角～区间内    
                buf.append((char) (ca[i] - CONVERT_STEP));    
            } else if (ca[i] == SBC_SPACE) { // 如果是全角空格    
                buf.append(DBC_SPACE);    
            } else { // 不处理全角空格，全角！到全角～区间外的字符    
                buf.append(ca[i]);    
            }    
        }    
        return buf.toString();    
    }    
    
//    public static void main(String[] args) {    
//        System.out.println(StringUtils.trimToEmpty(" a,b ,c "));    
//        String s = "nihaoｈｋ　｜　　　ｎｉｈｅｈｅ　，。　７８　　７　３６３１００";    
//        s=BCConvert.qj2bj(s);    
//        System.out.println(s);    
//        System.out.println(BCConvert.bj2qj(s));    
//    }    
    
    // 字段全角转半角
    public static String handleColumn(String column) {
    	return BCConvert.qj2bj(StringUtils.trimToEmpty(column));
    }
    
    // 判断字段长度并截断
    public static String handleLenth(Map<String, String[]> lenth_map,String column, String value) throws Exception {
    	// 字段是否在map里
    	if (lenth_map.containsKey(column)) {
    		// 如果字段在map里，获取对应长度
    		String[] type_lenth = lenth_map.get(column);
    		if ("BIGINT".equals(type_lenth[0]) || "DATETIME".equals(type_lenth[0]) || "DECIMAL".equals(type_lenth[0])) {
    			return value;
    		}
    		int value_lenth = Integer.parseInt(type_lenth[1]);
    		// 判断是否全是数字
    		if (Util.isInteger(value)) {
    			if (value.length() > value_lenth) {
    				return value.substring(0, value_lenth);
    			} else {
    				return value;
    			}
    			// 不全是数字
    		} else {
        		if (Util.getStringLength(value, CONFIG.encode) > value_lenth) {
        			return Util.bSubstring(value, value_lenth);
        		} else {
        			return value;
        		}
    		}
    	} else {
        	return value;
    	}
    }
    
    // 获取字段长度
    public static int getLenth(Map<String, String[]> lenth_map,String column, String value) throws Exception {
    	// 字段是否在map里
    	if (lenth_map.containsKey(column)) {
    		// 如果字段在map里，返回对应长度
    		String[] type_lenth = lenth_map.get(column);
    		if ("BIGINT".equals(type_lenth[0]) || "DATETIME".equals(type_lenth[0]) || "DECIMAL".equals(type_lenth[0])) {
    			return value == null || "".equals(value) ? 8 : value.length();
    		}
    		return Integer.parseInt(lenth_map.get(column)[1]);
    	} else {
        	return Integer.parseInt(value);
    	}
    }
   
    // 处理数字
    public static Object handleNum(String value) {
    	try {
    		Integer intValue = Integer.parseInt(value);
    		if(intValue instanceof Integer) {
    			return intValue;
    		}
    	} catch(NumberFormatException e) {
    		
    		try {
    			Double doubleValue = Double.parseDouble(value);
    			if (doubleValue instanceof Double) {
    				return doubleValue;
    			}
    		} catch(NumberFormatException ee) {
    			return value;
    		}
    	}
		return value;
 
    }
}    