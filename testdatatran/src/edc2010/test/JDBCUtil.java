package edc2010.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edc2010.test.Patient.P_Diagnose;
import edc2010.test.Patient.P_Operation;

public class JDBCUtil implements Runnable{

//    PreparedStatement statement = null;
//    PreparedStatement diagnose_statement = null;
//    PreparedStatement operation_statement = null;
	private int start;
	private int end;
	private boolean updated = true;
	 void setStart(int start) {
			updated = false;
			this.start = start;
	}
	public void setEnd(int end) {
		this.end = end;
		updated = true;
	}
	public boolean getState() {
		return this.updated;
	}
	public synchronized void setState() {
		this.updated = true;
	}
    Statement insert_stm = null;
    public int getCount() {
    	Connection con = ConManager.getDBConnection(CONFIG.url, CONFIG.U, CONFIG.P);
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            // SQL
String sql = "select count(*) as COUNT "
            		+ "from TPATIENTVISIT a "
            		+ "left join TOPERATION c on a.FPRN=c.FPRN "
            		+ "left join HIS_BA1 d on a.FPRN=d.FPRN "
					+ "";//查询test表
            
            statement = con.prepareStatement(sql);
            res = statement.executeQuery();
            res.next();
            return res.getInt(1);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) con.commit();con.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
		return 0;
    }
    @Override
	public void run() {
    	Connection con = ConManager.getDBConnection(CONFIG.url, CONFIG.U, CONFIG.P);
        PreparedStatement statement = null;
        PreparedStatement diagnose_statement = null;
        PreparedStatement operation_statement = null;
//        PreparedStatement insert_statement = null;
        Statement insert_stm = null;
        ResultSet res = null;
        ResultSet diagnose_res = null;
        ResultSet operation_res = null;
//        DBFUtil dbfFileRAndW = null;
//        DBFField dbf_fields[] = null;
//        Object rowData[] = null;
        try {
            // SQL
String sql = "select  * from (select row_number() over (order by a.FPRN) as rowNum, '48965210-X' 医疗机构代码P900,'漳州市第三医院' 机构名称P6891,'' \"医疗保险手册（卡号）P686\",a.FASCARD1 健康卡号P800,case when LEN(a.FFBBHNEW) > 1 then SUBSTRING(a.FFBBHNEW,2,1) when LEN(a.FFBBHNEW) < 1 then 7 when a.FFBBHNEW is null then 7 else a.FFBBHNEW end 医疗付款方式P1,a.FFBNEW 医疗付款方式代码,a.FTIMES 住院次数P2,a.FPRN 病案号P3,a.FNAME 姓名P4,a.FSEXBH 性别P5,a.FSEX 性别代码,CONVERT(varchar(100), a.FBIRTHDAY,23) 出生日期P6,SUBSTRING(a.FAGE,2,3) 年龄P7,a.FSTATUSBH 婚姻状况P8,a.FJOBBH 职业P9,case when PATINDEX('%省%',a.FBIRTHPLACE) > 0 then left(a.FBIRTHPLACE,PATINDEX('%省%',a.FBIRTHPLACE)) else '' end 出生省份P101,case when PATINDEX('%市%',a.FBIRTHPLACE) > 0 then substring(a.FBIRTHPLACE,PATINDEX('%省%',a.FBIRTHPLACE)+1,PATINDEX('%市%',a.FBIRTHPLACE)-PATINDEX('%省%',a.FBIRTHPLACE)) else '' end 出生地市P102,case when PATINDEX('%市%',a.FBIRTHPLACE) > 0 then substring(a.FBIRTHPLACE,PATINDEX('%市%',a.FBIRTHPLACE)+1,LEN(a.FBIRTHPLACE)) else a.FBIRTHPLACE end 出生地县P103,a.FNATIONALITY 民族P11,a.FCOUNTRY 国籍P12,a.FIDCARD 身份证号P13,a.FCURRADDR 现住址P801,a.FCURRTELE 住宅电话P802,a.FCURRPOST 现住址邮政编码P803,a.FDWADDR+a.FDWNAME 工作单位及地址P14,a.FDWTELE 电话P15,a.FDWPOST 工作单位邮政编码P16,a.FHKADDR 户口地址P17,a.FHKPOST 户口所在地邮政编码P171,a.FLXNAME 联系人姓名P18,a.FRELATE 关系P19,a.FLXADDR 联系人地址P20,a.FRYTJBH 入院途径P804,a.FLXTELE 联系人电话P21,CONVERT(varchar(100),a.FRYDATE,20) 入院日期P22,case when a.FRYDEPT='呼吸内科' then '0301'  when a.FRYDEPT='消化内科' then '0302'when a.FRYDEPT='神经内科' then '0303'when a.FRYDEPT='心血管内科' then '0304'when a.FRYDEPT='肾内风湿科' then '0306'when a.FRYDEPT='内分泌科' then '0307'when a.FRYDEPT='神经外科' then '0402'when a.FRYDEPT like '泌尿%科' then '0404'  when a.FRYDEPT = '肛肠科' then '04'when a.FRYDEPT='妇产二科' then '05'when a.FRYDEPT like '骨%科' then '0403'when a.FRYDEPT = '普外三科(含胸外)' then '0401'when a.FRYDEPT like '普%科' then '0401'when a.FRYDEPT='儿科' then '07'when a.FRYDEPT like '妇产%科' then '05'when a.FRYDEPT like '眼科%' then '10'when a.FRYDEPT like '%外科' then '04'when a.FRYDEPT = '重症医学科' then '28'when a.FRYDEPT = '耳鼻咽喉科' then '11'when a.FRYDEPT = '中医科' then '50'when a.FRYDEPT = '急诊医学科' then '20'end 入院科别P23,a.FRYBS 入院病室P231,case when a.FZKDEPT='呼吸内科' then '0301'  when a.FZKDEPT='消化内科' then '0302'when a.FZKDEPT='神经内科' then '0303'when a.FZKDEPT='心血管内科' then '0304'when a.FZKDEPT='肾内风湿科' then '0306'when a.FZKDEPT='内分泌科' then '0307'when a.FZKDEPT='神经外科' then '0402'when a.FZKDEPT like '泌尿%科' then '0404'  when a.FZKDEPT = '肛肠科' then '04'when a.FZKDEPT='妇产二科' then '05'when a.FZKDEPT like '骨%科' then '0403'when a.FZKDEPT = '普外三科(含胸外)' then '0401'when a.FZKDEPT like '普%科' then '0401'when a.FZKDEPT='儿科' then '07'when a.FZKDEPT like '妇产%科' then '05'when a.FZKDEPT like '眼科%' then '10'when a.FZKDEPT like '%外科' then '04'when a.FZKDEPT = '重症医学科' then '28'when a.FZKDEPT = '耳鼻咽喉科' then '11'when a.FZKDEPT = '中医科' then '50'when a.FZKDEPT = '急诊医学科' then '20'end 转科科别P24,CONVERT(varchar(100),a.FCYDATE,20) 出院日期P25,case when a.FCYDEPT='呼吸内科' then '0301'  when a.FCYDEPT='消化内科' then '0302'when a.FCYDEPT='神经内科' then '0303'when a.FCYDEPT='心血管内科' then '0304'when a.FCYDEPT='肾内风湿科' then '0306'when a.FCYDEPT='内分泌科' then '0307'when a.FCYDEPT='神经外科' then '0402'when a.FCYDEPT like '泌尿%科' then '0404'  when a.FCYDEPT = '肛肠科' then '04'when a.FCYDEPT='妇产二科' then '05'when a.FCYDEPT like '骨%科' then '0403'when a.FCYDEPT = '普外三科(含胸外)' then '0401'when a.FCYDEPT like '普%科' then '0401'when a.FCYDEPT='儿科' then '07'when a.FCYDEPT like '妇产%科' then '05'when a.FCYDEPT like '眼科%' then '10'when a.FCYDEPT like '%外科' then '04'when a.FCYDEPT = '重症医学科' then '28'when a.FCYDEPT = '耳鼻咽喉科' then '11'when a.FCYDEPT = '中医科' then '50'when a.FCYDEPT = '急诊医学科' then '20'end 出院科别P26,case when a.FCYBS='呼吸内科' then '0301'  when a.FCYBS='消化内科' then '0302'when a.FCYBS='神经内科' then '0303'when a.FCYBS='心血管内科' then '0304'when a.FCYBS='肾内风湿科' then '0306'when a.FCYBS='内分泌科' then '0307'when a.FCYBS='神经外科' then '0402'when a.FCYBS like '泌尿%科' then '0404'  when a.FCYBS = '肛肠科' then '04'when a.FCYBS='妇产二科' then '05'when a.FCYBS like '骨%科' then '0403'when a.FCYBS = '普外三科(含胸外)' then '0401'when a.FCYBS like '普%科' then '0401'when a.FCYBS='儿科' then '07'when a.FCYBS like '妇产%科' then '05'when a.FCYBS like '眼科%' then '10'when a.FCYBS like '%外科' then '04'when a.FCYBS = '重症医学科' then '28'when a.FCYBS = '耳鼻咽喉科' then '11'when a.FCYBS = '中医科' then '50'when a.FCYBS = '急诊医学科' then '20'end 出院病室P261,a.FDAYS 实际住院天数P27,a.FMZZDBH '门（急）诊诊断编码P28',a.FMZZD '门（急）诊诊断描述P281',a.FRYINFOBH 入院时情况P29,a.FRYZDBH 入院诊断编码P30,a.FRYZD 入院诊断描述P301,CONVERT(varchar(100),a.FQZDATE,23) 入院后确诊日期P31,"
            		+ "a.FYNGR 医院感染总次数P689,"
            		+ "'' 病理诊断编码1P351,'' 病理诊断名称1P352,a.FPHZDNUM 病理号1P816,"
            		+ "'' 病理诊断编码2P353,'' 病理诊断名称2P354,'' 病理号2P817,"
            		+ "'' 病理诊断编码3P355,'' 病理诊断名称3P356,'' 病理号3P818,"
            		+ "'' '损伤、中毒的外部因素编码1P361','' '损伤、中毒的外部因素名称1P362',"
            		+ "'' '损伤、中毒的外部因素编码2P363','' '损伤、中毒的外部因素名称2P364',"
            		+ "'' '损伤、中毒的外部因素编码3P365','' '损伤、中毒的外部因素名称3P366',"
            		+ "'' 过敏源P371,a.FGMYW 过敏药物名称P372,a.FHBSAGBH HBsAgP38,a.FHCVABBH 'HCV-AbP39',a.FHIVABBH 'HIV-AbP40',a.FMZCYACCOBH 门诊与出院诊断符合情况P411,a.FRYCYACCOBH 入院与出院诊断符合情况P412,'' 术前与术后诊断符合情况P413,'' 临床与病理诊断符合情况P414,'' 放射与病理诊断符合情况P415, a.FQJTIMES 抢救次数P421,a.FQJSUCTIMES 抢救成功次数P422,'' 最高诊断依据P687,'' 分化程度P688,a.FKZR 科主任P431,a.FZRDOCTOR '主(副主)任医师P432',a.FZZDOCT 主治医师P433,a.FZYDOCT 住院医师P434,a.FNURSE 责任护士P819,a.FJXDOCT 进修医师P435,a.FYJSSXDOCT 研究生实习医师P436,a.FSXDOCT 实习医师P437,a.FBMY 编码员P438,a.FQUALITYBH 病案质量P44,a.FZKDOCT 质控医师P45,a.FZKNURSE 质控护师P46,CONVERT(varchar(100),a.FZKRQ,23) 质控日期P47,"
            		+ "a.FHLTJ 特级护理天数P561,a.FHL1 一级护理天数P562,a.FHL2 二级护理天数P563,a.FHL3 三级护理天数P564,"
            		+ "'' 重症监护室名称1P6911,'' 进入时间1P6912,'' 退出时间1P6913,"
            		+ "'' 重症监护室名称2P6914,'' 进入时间2P6915,'' 退出时间2P6916,"
            		+ "'' 重症监护室名称3P6917,'' 进入时间3P6918,'' 退出时间3P6919,"
            		+ "'' 重症监护室名称4P6920,'' 进入时间4P6921,'' 退出时间4P6922,"
            		+ "'' 重症监护室名称5P6923,'' 进入时间5P6924,'' 退出时间5P6925,"
            		+ "a.FBODYBH 死亡患者尸检P57,case when a.FISOPFIRSTBH=1 then '1' else case when a.FISZLFIRSTBH = 1 then '1' else case when a.FISJCFIRSTBH = 1 then '1' else case when a.FISZDFIRSTBH = 1 then '1' end end end end as '手术、治疗、检查、诊断为本院第一例P58',"
//            		+ "case when a.FIFSS = 1 then case when c.FZQSSBH = 1 then '2' else '1' end else '0' end 手术患者类型P581,"
            		+ "'' 手术患者类型P581,"
            		+ "a.FISSZBH 随诊P60,'' 随诊周数P611,'' 随诊月数P612,'' 随诊年数P613,a.FSAMPLEBH 示教病例P59,a.FBLOODBH ABO血型P62,a.FRHBH Rh血型P63,a.FSXFYBH 输血反应P64,d.FREDCELL 红细胞P651,d.FPLAQUE 血小板P652,d.FSEROUS 血浆P653,d.FALLBLOOD 全血P654,'' 自体回收P655,d.FOTHERBLOOD 其它P656,'' '（年龄不足1 周岁的）年龄P66',"
            		+ "a.FCSTZ 新生儿出生体重1P681,'' 新生儿出生体重2P682,'' 新生儿出生体重3P683,'' 新生儿出生体重4P684,'' 新生儿出生体重5P685,a.FRYTZ 新生儿入院体重P67,a.FRYQHMHOURS '入院前多少小时(颅脑损伤患者昏迷时间)P731',a.FRYQHMMINS '入院前多少分钟(颅脑损伤患者昏迷时间)P732',a.FRYHMHOURS '入院后多少小时(颅脑损伤患者昏迷时间)P733',a.FRYHMMINS '入院后多少分钟(颅脑损伤患者昏迷时间)P734','' 呼吸机使用时间P72,a.FISAGAINRYBH '是否有出院31天内再住院计划P830',a.FISAGAINRYMD '出院31天再住院计划目的P831',a.FLYFSBH 离院方式P741,a.FYZOUTHOSTITAL 转入医院名称P742,a.FSQOUTHOSTITAL '转入社区服务机构/乡镇卫生院名称P743',a.FSUM1 住院总费用P782,a.FZFJE 住院总费用其中自付金额P751,a.FZHFWLYLF 一般医疗服务费P752,a.FZHFWLCZF 一般治疗操作费P754,a.FZHFWLHLF 护理费P755,a.FZHFWLQTF 综合医疗服务类其他费用P756,a.FZDLBLF 病理诊断费P757,a.FZDLSSSF 实验室诊断费P758,a.FZDLYXF 影像学诊断费P759,a.FZDLLCF 临床诊断项目费P760,a.FZLLFFSSF 非手术治疗项目费P761,a.FZLLFWLZWLF 临床物理治疗费P762,a.FZLLFSSF 手术治疗费P763,a.FZLLFMZF 麻醉费P764,a.FZLLFSSZLF 手术费P765,a.FKFLKFF 康复费P767,a.FZYLZF 中医治疗费P768,a.FXYF 西药费P769,a.FXYLGJF 抗菌药物费用P770,a.FZCHYF 中成药费P771,a.FZCYF 中草药费P772,a.FXYLXF 血费P773,a.FXYLBQBF  白蛋白类制品费P774,a.FXYLQDBF 球蛋白类制品费P775,a.FXYLYXYZF 凝血因子类制品费P776, a.FXYLXBYZF 细胞因子类制品费P777,a.FHCLCJF 检查用一次性医用材料费P778,a.FHCLZLF 治疗用一次性医用材料费P779,a.FHCLSSF 手术用一次性医用材料费P780,a.FQTF 其他费P781 "
            		+ "from TPATIENTVISIT a "
//            		+ "left join TOPERATION c on a.FPRN=c.FPRN "
            		+ "left join HIS_BA1 d on a.FPRN=d.FPRN "
//            		+ "left join HIS_BA3 e on a.FPRN = e.FPRN"
//            		+ " where a.FPRN = '00175611'"
            		+ ")as t where rowNum between " + start + " and " + end
					+ "";//查询test表
           System.out.println(sql); 
            statement = con.prepareStatement(sql);
	        con.setAutoCommit(false);
		    insert_stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            res = statement.executeQuery();
            
            // 生成病人实例
            Patient patient = new Patient();
            
            // 生成诊断实例
            P_Diagnose diagnose = patient.new P_Diagnose();
            
            // 生成手术实例
            P_Operation operation = patient.new P_Operation();
            
            // 创建病人invoke
            Class<?> p_invoke = Patient.class;
            
            // 创建诊断invoke
            Class<?> d_invoke = P_Diagnose.class;
            
            // 创建手术invoke
            Class<?> o_invoke = P_Operation.class;
//            Object pt = p_invoke.newInstance();
            Method getMethod = null;
            String diagnose_sql = null;
            String operation_sql = null;
            String columnName = null;
            String diagcolumnName = null;
            String opercolumnName = null;
//            Object result = null;
            // 获取病人字段属性
            Field[] fields = patient.getClass().getDeclaredFields();
            while(res.next()){
            	System.out.println("-----------------开始处理第" + res.getRow() + "条数据");
            	for (int i = 0; i < fields.length; i++) {
            		columnName = fields[i].getName();
            		if (columnName == "columnMap" || columnName == "bigint_flag" || columnName == "lenth_map") {
            			continue;
            		}
                	getMethod = p_invoke.getMethod("set" + columnName, new Class[] {String.class});
//                	result = 
                	getMethod.invoke(patient, res.getString(patient.getColumnMap().get(columnName)));
            	}
            	
            	
            	// ---------------- 诊断 ---------------------------
            	// 创建诊断SQL
            	diagnose_sql = "select FICDM 主要诊断编码,fsxzd 主要诊断疾病描述,FRYBQBH 主要诊断入院病情,FZLJGBH 主要诊断出院情况 from HIS_BA3 where FPRN = '" + patient.getP3() + "' order by FZDLX asc";
            	System.out.println("病人病案号" + patient.getP3());
//            	System.out.println(diagnose_sql);
            	diagnose_statement = con.prepareStatement(diagnose_sql);
            	diagnose_res = diagnose_statement.executeQuery();
            	while (diagnose_res.next()) {
            		int row = diagnose_res.getRow() - 1;
            		if (row > 10) {break;}
                		getMethod = d_invoke.getMethod("set" + diagnose.getDiag_flag()[row][0], new Class[] {String.class});
                		getMethod.invoke(diagnose, diagnose_res.getString("主要诊断编码"));
                		getMethod = d_invoke.getMethod("set" + diagnose.getDiag_flag()[row][1], new Class[] {String.class});
                		getMethod.invoke(diagnose, diagnose_res.getString("主要诊断疾病描述"));
                		getMethod = d_invoke.getMethod("set" + diagnose.getDiag_flag()[row][2], new Class[] {String.class});
                		getMethod.invoke(diagnose, diagnose_res.getString("主要诊断入院病情"));
                		getMethod = d_invoke.getMethod("set" + diagnose.getDiag_flag()[row][3], new Class[] {String.class});
                		getMethod.invoke(diagnose, diagnose_res.getString("主要诊断出院情况"));
            	}
//            	// ---------------- 手术 ---------------------------
//            	// 创建手术SQL
            	operation_sql = "select \r\n" + 
            			"FOPCODE 手术操作编码,CONVERT(varchar(100),FOPDATE,20) 手术操作日期,case when FSSJBBH is null then 1 else FSSJBBH end 手术级别,FOP 手术操作名称,\r\n" + 
            			"case when s.sszlid is null then '9999' \r\n" + 
            			"when s.sszlid = '01' then '0001' \r\n" + 
            			"when s.sszlid = '02' then '0008'\r\n" + 
            			"when s.sszlid = '03' then '0031'\r\n" + 
            			"when s.sszlid = '04' then '0004'\r\n" + 
            			"when s.sszlid = '05' then '0020'\r\n" + 
            			"when s.sszlid = '06' then '0046'\r\n" + 
            			"when s.sszlid = '07' then '0021'\r\n" + 
            			"when s.sszlid = '08' then '0023'\r\n" + 
            			"when s.sszlid = '09' then '0049'\r\n" + 
            			"when s.sszlid = '10' then '0029'\r\n" + 
            			"when s.sszlid = '11' then '0014'\r\n" + 
            			"when s.sszlid = '12' then '0041'\r\n" + 
            			"when s.sszlid = '13' then '0015'\r\n" + 
            			"when s.sszlid = '14' then '0013'\r\n" + 
            			"when s.sszlid = '15' then '0013'\r\n" + 
            			"when s.sszlid = '16' then '0040'\r\n" + 
            			"when s.sszlid = '17' then '0028'\r\n" + 
            			"when s.sszlid = '18' then '9999'\r\n" + 
            			"when s.sszlid = '19' then '0002'\r\n" + 
            			"when s.sszlid = '20' then '0018'\r\n" + 
            			"when s.sszlid = '21' then '9999'\r\n" + 
            			"when s.sszlid = '22' then '9999'\r\n" + 
            			"when s.sszlid = '23' then '9999'\r\n" + 
            			"when s.sszlid = '24' then '0011'\r\n" + 
            			"when s.sszlid = '25' then '0009'\r\n" + 
            			"when s.sszlid = '26' then '0036'\r\n" + 
            			"when s.sszlid = '27' then '9999' end 手术操作部位,'1' 手术持续时间,FDOCNAME 术者,FOPDOCT1 Ⅰ助,FOPDOCT2 Ⅱ助,case when LEN(FMAZUIBH) < 2 then '0'+FMAZUIBH else FMAZUIBH end 麻醉方式,'1' 麻醉分级,\r\n" + 
            			"case when FQIEKOUBH is null or FQIEKOUBH = 0 or FQIEKOUBH = 9 then 0\r\n" + 
            			"when FQIEKOUBH = 1 and FYUHEBH = 1 then 1 when FQIEKOUBH = 1 and FYUHEBH = 2 then 2 when FQIEKOUBH = 1 and FYUHEBH = 3 then 3 when FQIEKOUBH = 1 and FYUHEBH is null or FYUHEBH = 4 then 10 \r\n" + 
            			"when FQIEKOUBH = 2 and FYUHEBH = 1 then 4 when FQIEKOUBH = 2 and FYUHEBH = 2 then 5 when FQIEKOUBH = 2 and FYUHEBH = 3 then 6 when FQIEKOUBH = 2 and FYUHEBH is null or FYUHEBH = 4 then 11\r\n" + 
            			"when FQIEKOUBH = 3 and FYUHEBH = 1 then 7 when FQIEKOUBH = 3 and FYUHEBH = 2 then 8 when FQIEKOUBH = 3 and FYUHEBH = 3 then 9 when FQIEKOUBH = 3 and FYUHEBH is null or FYUHEBH = 4 then 12\r\n" + 
            			" end 切口愈合等级,FMZDOCT 麻醉医师\r\n" + 
            			"from TOPERATION t left join [13.18.1.150].THIS4.dbo.SS_SSDJK s on t.FPRN = s.blh collate Chinese_PRC_CI_AS where t.FPRN = '" + patient.getP3() + "';";
//            	System.out.println(operation_sql);
            	operation_statement = con.prepareStatement(operation_sql);
            	operation_res = operation_statement.executeQuery();
            	while (operation_res.next()) {
            		int row = operation_res.getRow() - 1;
            		if (row >= 10) {break;}
                	//手术操作编码 手术操作日期 手术级别 手术操作名称 手术操作部位 手术持续时间 术者 Ⅰ助 Ⅱ助 麻醉方式 麻醉分级 切口愈合等级 麻醉医师
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][0], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("手术操作编码"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][1], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("手术操作日期"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][2], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("手术级别"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][3], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("手术操作名称"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][4], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("手术操作部位"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][5], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("手术持续时间"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][6], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("术者"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][7], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("Ⅰ助"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][8], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("Ⅱ助"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][9], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("麻醉方式"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][10], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("麻醉分级"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][11], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("切口愈合等级"));
                		getMethod = o_invoke.getMethod("set" + operation.getOper_flag()[row][12], new Class[] {String.class});
                		getMethod.invoke(operation, operation_res.getString("麻醉医师"));
            	}
            	System.out.println("-----------------第" + res.getRow() + "条数据读取完毕");
            	
            	// 开始插入数据库
            	columnName = null;
            	diagcolumnName = null;
            	opercolumnName = null;
            	String insert_SQL = "insert into " + CONFIG.dataTable + "(";
            	String values_SQL = " values(";
            	Field[] patientFields = patient.getClass().getDeclaredFields();
                // 获取诊断字段属性
                Field[] diagnose_fields = diagnose.getClass().getDeclaredFields();
                Field[] operation_fields = operation.getClass().getDeclaredFields();
                for (int i = 0; i < patientFields.length; i++) {
                	columnName = patientFields[i].getName();
                	if (columnName == "columnMap" || columnName == "bigint_flag" || columnName == "this$0" || columnName == "lenth_map") {
                		continue;
                	}
                	// 诊断字段
                	if (columnName == "P689") {
                		for (int j = 0; j < diagnose_fields.length; j++) {
                			diagcolumnName = diagnose_fields[j].getName();
                        	if (diagcolumnName == "diag_flag" || diagcolumnName == "this$0" || columnName == "lenth_map") {
                        		continue;
                        	}
                        	insert_SQL += diagcolumnName + ",";
                        	getMethod = d_invoke.getMethod("get" + diagcolumnName);
//                        	result = 
                        	String value = (String)getMethod.invoke(diagnose);
                        	if ("".equals(value)) {
                        		values_SQL +=  null + ",";
                        	} else if (value == null || value.toString().length() <= 0) {
                        		values_SQL +=  null + ",";
                        	} else {
                        		// 非null
                        		// 处理字段长度
                        		value = BCConvert.handleLenth(patient.getLenthMap(), diagcolumnName, value);
                        		// 判断该字段是否为数字类型
                        		if (Util.useLoop(patient.getBigint_flag(), diagcolumnName)) {
                                	values_SQL += BCConvert.handleColumn((String)value) + ",";
                        		} else {
                                	values_SQL +=  "'" + BCConvert.handleColumn((String)value) + "',";
                        		}
                        	}
                        }
                	}
                	// 手术字段
                	if (columnName == "P561") {
                		for (int k = 0; k < operation_fields.length; k++) {
                			opercolumnName = operation_fields[k].getName();
                        	if (opercolumnName == "oper_flag" || opercolumnName == "this$0" || columnName == "lenth_map") {
                        		continue;
                        	}
                        	insert_SQL += opercolumnName + ",";
                        	getMethod = o_invoke.getMethod("get" + opercolumnName);
//                        	result = 
                        	String value = (String)getMethod.invoke(operation);
                        	if ("".equals(value)) {
                        		values_SQL +=  null + ",";
                        	} else if (value == null || value.toString().length() <= 0) {
                        		values_SQL +=  null + ",";
                        	} else {
                        		// 非null
                        		// 处理字段长度
                        		value = BCConvert.handleLenth(patient.getLenthMap(), opercolumnName, value);
                        		// 判断该字段是否为数字类型
                        		if (Util.useLoop(patient.getBigint_flag(), opercolumnName)) {
                                	values_SQL += BCConvert.handleColumn((String)value) + ",";
                        		} else {
                                	values_SQL +=  "'" + BCConvert.handleColumn((String)value) + "',";
                        		}
                        	}
                        }
                	}
                	insert_SQL += columnName + ",";
                	getMethod = p_invoke.getMethod("get" + columnName);
//                	result = 
                	String value = (String)getMethod.invoke(patient);
                	
//                	dbf_fields[i] = new DBFField();
//                	dbf_fields[i].setName(columnName);
//                	dbf_fields[i].setType(DBFDataType.CHARACTER);
//                	dbf_fields[i].setLength(patient.getLenthMap().get(columnName));
                	if ("".equals(value)) {
                		values_SQL +=  null + ",";
                	} else if (value == null || value.toString().length() <= 0) {
                		values_SQL +=  null + ",";
                	} else {
                		// 非null
                		// 处理字段长度
                		value = BCConvert.handleLenth(patient.getLenthMap(), columnName, value);
                		// 判断该字段是否为数字类型
                		if (Util.useLoop(patient.getBigint_flag(), columnName)) {
                        	values_SQL += BCConvert.handleColumn((String)value) + ",";
                		} else {
                        	values_SQL +=  "'" + BCConvert.handleColumn((String)value) + "',";
                		}
                	}
                }
                String sql_to_insert = insert_SQL.substring(0, insert_SQL.length() - 1) + ")" + values_SQL.substring(0, values_SQL.length() - 1) + ");";
            	System.out.println("-----------------第" + res.getRow() + "条数据插入SQL生成完成，开始插入数据库");
                System.out.println(sql_to_insert);
//            	insert_statement = con.prepareStatement(sql_to_insert);
//            	insert_statement.executeUpdate();
                insert_stm.addBatch(sql_to_insert);
            	System.out.println("-----------------第" + res.getRow() + "条数据插入数据库成功");
            	// 杀死病人
            	patient.KillPatient();
            	// 重置诊断
            	diagnose.reset_diagnose();
            	// 重置手术
            	operation.reset_operation();
            }
            insert_stm.executeBatch();

            
        } catch (Exception e) {
            // TODO: handle exception
        	try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
            e.printStackTrace();
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) con.commit();con.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }
}
