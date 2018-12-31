package edc2010.test;

public class CONFIG {
	public final static String SERVICE_URL="https://hqmststest.medidata.com.cn";
	public final static String DBFNAME_prefix = "hqms_";
	public final static String DBFPath = "D:/hqms/";
	public final static String U = "sa";
	public final static String P = "1qaz@WSX";
	public final static String cfn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public final static String url = "jdbc:sqlserver://13.18.1.149:1433;DatabaseName=bagl_java";
	public final static String dataTable = "template";
	public final static String encode = "GBK";
	public final static int Thread_Page_Size = 300;
	public final static int Column_Num = 346;
	public final static int Column_Num_part1 = 254;
	public final static int Column_Num_part2 = 94; // Part1内的P3和P20在前2位
	//用户名
	public final static String USER="zzsdsyy_hqms"; 
	//密码
	public final static String PWD="dsyy@HQMS"; //  
	//返回数据的类型
	public final static String DATA_TYPE="json"; 
	// 限制出院日期
	public final static String OUT_DATE = " a.FCYDATE between '20181101' and '20181130' ";
	// 启动时是否清空template
	public final static boolean CleanTable = false;
	// 是否多线程
	public final static boolean IsMultiThread = false;
}
