package edc2010.test;

public class CONFIG {
	// 使用权限数据库相关信息
	public final static String mysql_url = "jdbc:mysql://zzsdsyyhqms.cq0jsnkjplaj.ap-northeast-1.rds.amazonaws.com:3306/zzsdsyy_hqms?autoReconnect=true";
	public final static String mysql_U = "gba3455";
	public final static String mysql_P = "5408821234";
	public final static String mysql_cfn = "com.mysql.jdbc.Driver";
	public final static String mysql_datatable = "hqms";
	// 病案数据库相关信息
	public final static String HIS_IP = "13.18.1.150";
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
	
	// 是否显示SQL日志
	public final static boolean SHOW_SQL_LOG = true;
	
	// 是否显示DBF生成日志
	public final static boolean SHOW_DBF_LOG = false;
	
	// 日志输出地址
	public final static String LOG_PATH = "D:/hqms/log/";
	//用户名
	public final static String USER="zzsdsyy_hqms"; 
	//密码
	public final static String PWD="dsyy@HQMS"; //  
	//返回数据的类型
	public final static String DATA_TYPE="json"; 
	// 限制出院日期
	public static String OUT_DATE = " a.FCYDATE between '" + Util.getSomedayEarly(-10) + "' and '" + Util.getSomedayEarly(-10) + "' ";
	// 启动时是否清空template
	public final static boolean CleanTable = true;
	// 是否多线程
	public final static boolean IsMultiThread = true;
	
	// 飞鸽
	public final static String secret = "26ef06f62deeb2c26cf8f0c5e908d7de";
	public final static String token = "dc6438fc7b6c20efd4b6071db04224c9";
	public final static String template_id = "LwKYoC6h87akctOEqQV74lcZgJKuQzSFQv6JkVsth-A";
	
	// 科别代码表
	public final static String[][] CASE_WHEN_DEPT = {
			{"医院感染管理科", "16"}, 
			{"急诊医学科", "20"}, 
			{"门诊输液室", "20"}, 
			{"疼痛科门诊", "27"}, 
			{"麻醉科", "26"}, 
			{"手术室", "26"}, 
			{"中医科", "50"}, 
			{"中医科门诊", "50"}, 
			{"康复科", "21"}, 
			{"康复科门诊", "21"}, 
			{"重症医学科", "28"}, 
			{"呼吸与危重症医学科", "0301"}, 
			{"呼吸与危重症医学科门诊", "0301"}, 
			{"呼吸与危重症医学科", "0301"}, 
			{"呼吸与危重症医学科门诊", "0301"}, 
			{"肾内风湿科", "0306"}, 
			{"肾内风湿科门诊", "0306"}, 
			{"血液透析室", "0306"}, 
			{"心血管内科", "0304"}, 
			{"心血管内科门诊", "0304"}, 
			{"神经内科", "0303"}, 
			{"神经内科门诊", "0303"}, 
			{"消化内科", "0302"}, 
			{"消化内科门诊", "0302"}, 
			{"内分泌科", "0307"}, 
			{"内分泌科门诊", "0307"}, 
			{"普一科", "0401"}, 
			{"普一科门诊", "0401"}, 
			{"普二科", "0401"}, 
			{"普二科门诊", "0401"}, 
			{"乳腺甲状腺外科", "0409"}, 
			{"乳腺甲状腺外科门诊", "0409"}, 
			{"肛肠科", "0409"}, 
			{"肛肠科门诊", "0409"}, 
			{"普外一科", "0401"}, 
			{"普外一科门诊", "0401"}, 
			{"泌尿外科", "0404"}, 
			{"泌尿外科门诊", "0404"}, 
			{"体外震波碎石室", "0404"}, 
			{"泌尿一科", "0404"}, 
			{"泌尿一科门诊", "0404"}, 
			{"泌尿二科", "0404"}, 
			{"泌尿二科门诊", "0404"}, 
			{"神经外科", "0402"}, 
			{"神经外科门诊", "0402"}, 
			{"老年病科", "0310"}, 
			{"老年病科门诊", "0310"}, 
			{"骨科综合门诊", "0403"}, 
			{"骨一科", "0403"}, 
			{"骨一科门诊", "0403"}, 
			{"骨二科", "0403"}, 
			{"骨二科门诊", "0403"}, 
			{"手足外科·慢创治疗科", "0403"}, 
			{"手足外科·慢创治疗科门诊", "0403"}, 
			{"急慢性创口治疗科", "0409"}, 
			{"眼科二", "10"}, 
			{"妇产科", "05"}, 
			{"妇产科门诊", "05"}, 
			{"生殖内分泌科", "05"}, 
			{"妇产一科", "05"}, 
			{"妇产二科", "05"}, 
			{"妇产一科门诊", "05"}, 
			{"妇产二科门诊", "05"}, 
			{"生殖内分泌科门诊", "0505"}, 
			{"儿科", "07"}, 
			{"儿科门诊", "07"}, 
			{"眼科", "10"}, 
			{"眼科门诊", "10"}, 
			{"耳鼻咽喉科", "11"}, 
			{"耳鼻咽喉科门诊", "11"}, 
			{"口腔科", "12"}, 
			{"口腔科门诊", "12"}, 
			{"皮肤科", "13"}, 
			{"皮肤科门诊", "13"}, 
			{"呼吸与结核病科", "1602"}, 
			{"呼吸与结核病科门诊", "1602"}, 
			{"呼吸与结核病科", "17"}, 
			{"呼吸与结核病科门诊", "17"}, 
			{"内科综合门诊", "5001"}, 
			{"院外门诊", "5001"}, 
			{"预防保健科", "5017"}, 
			{"肿瘤科", "19"}, 
			{"肿瘤科门诊", "19"}, 
			{"放射治疗科", "3210"}, 
			{"放射治疗科门诊", "3210"}, 
			{"外科综合门诊", "04"}, 
			{"普外二科", "0401"}, 
			{"普外二科门诊", "0401"}, 
			{"普外三科", "0401"}, 
			{"胸外科", "0405"}, 
			{"普外三科(含胸外)", "0401"}, 
			{"普外三科门诊", "0401"}, 
			{"医学检验科", "30"}, 
			{"病理科", "31"}, 
			{"输血科", "69"}, 
			{"放射科", "3211"}, 
			{"普通放射", "3201"}, 
			{"CT", "3202"}, 
			{"MR", "3203"}, 
			{"超声科", "3205"}, 
			{"超声介入", "3205"}, 
			{"心电图室", "3206"}, 
			{"脑电图室", "3207"}, 
			{"脑磁治疗室", "3207"}, 
			{"消化内镜室", "3211"}, 
			{"支气管镜室", "3211"}, 
			{"消毒供应室", "3211"}, 
			{"眼震视图室", "3211"}, 
			{"肺功能室", "3211"}, 
			{"药剂科", "3211"}, 
			{"门诊西药房", "3211"}, 
			{"中药房", "3211"}, 
			{"中心药房", "3211"}, 
			{"西药库", "3211"}, 
			{"中药库", "3211"}, 
			{"健康体检科", "3211"}, 
			{"健检服务部", "3211"}, 
			{"驾照体检", "3211"}, 
			{"驻外体检", "3211"}, 
			{"医学美容科", "0408"}, 
			{"医学美容科门诊", "0408"}, 
			{"生活美容", "0408"}
			};
	
	// 转科代码表
	public final static String[][] CASE_WHEN_ZKDEPT = {
		{"呼吸内科", "0301"},  
		{"消化内科", "0302"},
		{"神经内科", "0303"},
		{"心血管内科", "0304"},
		{"肾内风湿科", "0306"},
		{"内分泌科", "0307"},
		{"神经外科", "0402"},
		{"泌尿%科", "0404"},  
		{"肛肠科", "04"},
		{"妇产二科", "05"},
		{"骨%科", "0403"},
		{"普外三科(含胸外)", "0401"},
		{"普%科", "0401"},
		{"儿科", "07"},
		{"妇产%科", "05"},
		{"眼科%", "10"},
		{"%外科", "04"},
		{"重症医学科", "28"},
		{"耳鼻咽喉科", "11"},
		{"中医科", "50"},
		{"急诊医学科", "20"}
		};
	// 出院病室表
	public final static String[][] CASE_WHEN_CYBS = {
			{"呼吸内科", "0301"},  
			{"消化内科", "0302"},
			{"神经内科", "0303"},
			{"心血管内科", "0304"},
			{"肾内风湿科", "0306"},
			{"内分泌科", "0307"},
			{"神经外科", "0402"},
			{"泌尿%科", "0404"},  
			{"肛肠科", "04"},
			{"妇产二科", "05"},
			{"骨%科", "0403"},
			{"普外三科(含胸外)", "0401"},
			{"普%科", "0401"},
			{"儿科", "07"},
			{"妇产%科", "05"},
			{"眼科%", "10"},
			{"%外科", "04"},
			{"重症医学科", "28"},
			{"耳鼻咽喉科", "11"},
			{"中医科", "50"},
			{"急诊医学科", "20"}
	};
	// 手术操作部位表
	public final static String[][] CASE_WHEN_OPER_PART = {
			 {"null", "9999"},
			 {"01", "0001"},
			 {"02", "0008"},
			 {"03", "0031"},
			 {"04", "0004"},
			 {"05", "0020"},
			 {"06", "0046"},
			 {"07", "0021"},
			 {"08", "0023"},
			 {"09", "0049"},
			 {"10", "0029"},
			 {"11", "0014"},
			 {"12", "0041"},
			 {"13", "0015"},
			 {"14", "0013"},
			 {"15", "0013"},
			 {"16", "0040"},
			 {"17", "0028"},
			 {"18", "9999"},
			 {"19", "0002"},
			 {"20", "0018"},
			 {"21", "9999"},
			 {"22", "9999"},
			 {"23", "9999"},
			 {"24", "0011"},
			 {"25", "0009"},
			 {"26", "0036"},
			 {"27", "9999"}
	};
}
