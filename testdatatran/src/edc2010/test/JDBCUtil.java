package edc2010.test;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edc2010.test.Patient.P_Diagnose;
import edc2010.test.Patient.P_Operation;

public class JDBCUtil implements Runnable{

	private int start;
	private int end;
	public JDBCUtil() {
		
	}
	public void setStart(int start) {
			this.start = start;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	public static boolean canUse() {
        Connection con;
		while (true) {
			con = ConManager.getDBConnection(CONFIG.mysql_url, CONFIG.mysql_U, CONFIG.mysql_P);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				LoggerManager.setErrorLog(e);
			}
			if (con != null) {
				break;
			}
		}
        PreparedStatement statement = null;
        ResultSet res = null;
		try {
            // SQL
String sql = "select hqms_can_use "
            		+ "from " + CONFIG.mysql_datatable + ";"
					+ "";//查询test表
            
            statement = con.prepareStatement(sql);
            res = statement.executeQuery();
            res.next();
            if (res.getInt(1) == 1) {
            	return true;
            } else {
            	return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
			LoggerManager.setErrorLog(e);
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) {
                	if (!con.getAutoCommit()) {
                		con.commit();
                	}
                	con.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
				LoggerManager.setErrorLog(e2);
            }
        }
		return false;
	}
	
    Statement insert_stm = null;
    public int getCount() {
    	Connection con = ConManager.getDBConnection(CONFIG.url, CONFIG.U, CONFIG.P);
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            // SQL
String sql = "select count(*) as COUNT from ( "
		+ "select *,NAME1 as 新生儿出生体重1P681,NAME2 as 新生儿出生体重2P682,NAME3 as 新生儿出生体重3P683,NAME4 as 新生儿出生体重4P684,NAME5 as 新生儿出生体重5P685 from ( " 
            		+ "select a.FPRN,b.FTZ,b.NAME from TPATIENTVISIT a "
            		+ "left join HIS_BA1 d on a.FPRN=d.FPRN "
            		+ "left join (select * from Tdiagnose where FZDLX = 's') g on a.FPRN = g.FPRN "
            		+ "left join (select FPRN,'NAME' + convert(varchar,FBABYNUM) as NAME,FTZ from TBABYCARD) b on a.FPRN = b.FPRN "
            		+ " where "
            		+ " a.FCYDATE between '" + Util.getSomedayEarly(CONFIG.days) + "' and '" + Util.getSomedayEarly(CONFIG.days) + "' "
					+ " ) AS P "
					+ "PIVOT"
					+ " ( "
					+ " sum(FTZ) for "
					+ " P.NAME in (NAME1,NAME2,NAME3,NAME4,NAME5) "
					+ " ) as t"
					+ ") as C";//查询test表
            
			if (CONFIG.SHOW_SQL_LOG) {
				LoggerManager.setInfoLog("get count sql ------------------------->" + sql);
			}
            statement = con.prepareStatement(sql);
            res = statement.executeQuery();
            res.next();
            return res.getInt(1);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
			LoggerManager.setErrorLog(e);
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) {
                	if (!con.getAutoCommit()) {
                		con.commit();
                	}
                	con.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
				LoggerManager.setErrorLog(e2);
            }
        }
		return 0;
    }
    
    public static boolean CleanUpTable(String tableName) {
    	Connection con = ConManager.getDBConnection(CONFIG.url, CONFIG.U, CONFIG.P);
        Statement statement = null;
        ResultSet res = null;
        try {
            // SQL
String sql = "delete from " + tableName;//查询test表
            
            statement = con.createStatement();
            res = statement.executeQuery(sql);
            if (res == null) {
            	return false;
            } else {
            	return true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        	if (e.getMessage() != "该语句没有返回结果集。") {
                e.printStackTrace();
    			LoggerManager.setErrorLog(e);
        	}
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) {
                	if (!con.getAutoCommit()) {
                		con.commit();
                	}
                	con.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
				LoggerManager.setErrorLog(e2);
            }
        }
        return false;
    }

    public static ResultSet GetTableData(String tableName) {
    	Connection con = ConManager.getDBConnection(CONFIG.url, CONFIG.U, CONFIG.P);
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            // SQL
        	String sql = "select P900,P6891,P686,P800,P1,P2,P3,P4,P5,CONVERT(varchar(100), P6,23) P6,P7,P8,P9,P101,P102,P103,P11,P12,P13,P801,P802,P803,P14,P15,P16,"
        			+ "P17,P171,P18,P19,P20,P804,P21,CONVERT(varchar(100),P22,20) P22,P23,P231,P24,CONVERT(varchar(100),P25,20) P25,P26,P261,P27,P28,P281,P29,P30,"
        			+ "P301,CONVERT(varchar(100),P31,23) P31,P321,P322,P805,P323,P324,P325,P806,P326,P327,P328,P807,P329,P3291,P3292,P808,P3293,P3294,P3295,P809,"
        			+ "P3296,P3297,P3298,P810,P3299,P3281,P3282,P811,P3283,P3284,P3285,P812,P3286,P3287,P3288,P813,P3289,P3271,P3272,P814,P3273,P3274,P3275,P815,"
        			+ "P3276,P689,P351,P352,P816,P353,P354,P817,P355,P356,P818,P361,P362,P363,P364,P365,P366,P371,P372,P38,P39,P40,P411,P412,P413,P414,P415,P421,"
        			+ "P422,P687,P688,P431,P432,P433,P434,P819,P435,P436,P437,P438,P44,P45,P46,CONVERT(varchar(100),P47,23) P47,P490,CONVERT(varchar(100),P491,20) P491,"
        			+ "P820,P492,P493,P494,P495,P496,P497,P498,P4981,P499,P4910,P4911,CONVERT(varchar(100),P4912,20) P4912,P821,P4913,P4914,P4915,P4916,P4917,P4918,"
        			+ "P4919,P4982,P4920,P4921,P4922,CONVERT(varchar(100),P4923,20) P4923,P822,P4924,P4925,P4526,P4527,P4528,P4529,P4530,P4983,P4531,P4532,P4533,"
        			+ "CONVERT(varchar(100),P4534,20) P4534,P823,P4535,P4536,P4537,P4538,P4539,P4540,P4541,P4984,P4542,P4543,P4544,CONVERT(varchar(100),P4545,20) P4545,"
        			+ "P824,P4546,P4547,P4548,P4549,P4550,P4551,P4552,P4985,P4553,P4554,P45002,CONVERT(varchar(100),P45003,20) P45003,P825,P45004,P45005,P45006,P45007,"
        			+ "P45008,P45009,P45010,P45011,P45012,P45013,P45014,CONVERT(varchar(100),p45015,20) p45015,P826,P45016,P45017,P45018,P45019,P45020,P45021,P45022,"
        			+ "P45023,P45024,P45025,P45026,CONVERT(varchar(100),p45027,20) p45027,P827,P45028,P45029,P45030,P45031,P45032,P45033,P45034,P45035,P45036,P45037,"
        			+ "P45038,CONVERT(varchar(100),p45039,20) p45039,P828,P45040,P45041,P45042,P45043,P45044,P45045,P45046,P45047,P45048,P45049,P45050,CONVERT(varchar(100),"
        			+ "p45051,20) p45051,P829,P45052,P45053,P45054,P45055,P45056,P45057,P45058,P45059,P45060,P45061,P561,P562,P563,P564,P6911,P6912,P6913,P6914,P6915,P6916,"
        			+ "P6917,P6918,P6919,P6920,P6921,P6922,P6923,P6924,P6925,P57,P58,P581,P60,P611,P612,P613,P59,P62,P63,P64,P651,P652,P653,P654,P655,P656,P66,P681,P682,P683,"
        			+ "P684,P685,P67,P731,P732,P733,P734,P72,P830,P831,P741,P742,P743,P782,P751,P752,P754,P755,P756,P757,P758,P759,P760,P761,P762,P763,P764,P765,P767,P768,P769,"
        			+ "P770,P771,P772,P773,P774,P775,P776,P777,P778,P779,P780," + 
		"P782 - P752 - P754 - P755 -P756-P757-P758-P759-P760-P761-P763-P767-P768-P769 -P771-P772-P773-P774-P775-P776-P777-P778-P779-P780 P781 from " + tableName;//查询test表
		if (CONFIG.SHOW_SQL_LOG) {
			LoggerManager.setInfoLog(sql);
		}
            statement = con.prepareStatement(sql);
            res = statement.executeQuery();
            return res;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
			LoggerManager.setErrorLog(e);
//        }finally{
//            try {
//                if(res != null) res.close();
//                if(statement != null) statement.close();
//                if(con != null) con.commit();con.close();
//            } catch (Exception e2) {
//                // TODO: handle exception
//                e2.printStackTrace();
//            }
        }
        return null;
    }
    
	public static boolean ReupdateFromFile(String filePath) {
        	String fprns_String = ReadTxtFile.listToString(ReadTxtFile.readTxt(filePath));
        	boolean IsReupdated = false;
			// reupload process
			if (fprns_String.length() > 0) {
		    // SQL
		    	Connection con = ConManager.getDBConnection(CONFIG.url, CONFIG.U, CONFIG.P);
		    	PreparedStatement statement = null; 
		        ResultSet res = null;
				FileOutputStream fos = null;
				String sql;
		        try {
		            // SQL
		        	sql = getCommonSQL();
		            		sql += " where  "
		            		+ " a.FPRN in (" + fprns_String + ") "
		    				+ ") AS P "
		    				+ "PIVOT"
		    				+ "("
		    				+ " sum(FTZ) for "
		    				+ "P.NAME in (NAME1,NAME2,NAME3,NAME4,NAME5) "
		    				+ " ) as t"
		    				+ " ) as G"
		    				+ " ) as C";
							sql += "";//查询test表
		            if (CONFIG.SHOW_SQL_LOG) {
						LoggerManager.setInfoLog("执行补传sql------------------------->" + sql); 
		            }
		            statement = con.prepareStatement(sql);
			        con.setAutoCommit(false);
//				    insert_stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
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
		            Method getMethod = null;
		            // 获取病人字段属性
		            Field[] fields = patient.getClass().getDeclaredFields();
		            while(res.next()){
		            	getMethod = invokeColumn(res, patient, p_invoke, getMethod, fields);
		            	
		            	getMethod = invokeDiagnose(con, patient, diagnose, d_invoke, getMethod);
//		            	// ---------------- 手术 ---------------------------
		            	getMethod = invokeOperation(con, patient, operation, o_invoke, getMethod);

		            	// 开始插入数据库
		            	getMethod = insertIntoDatabase(con, patient, diagnose, operation, p_invoke, d_invoke, o_invoke,
								getMethod);
		            	
		            	// 杀死病人
		            	patient.KillPatient();
		            	// 重置诊断
		            	diagnose.reset_diagnose();
		            	// 重置手术
		            	operation.reset_operation();
		            }
//		            insert_stm.executeBatch();

		            IsReupdated = true;
		            
		        } catch (Exception e) {
		            // TODO: handle exception
		        	try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
						LoggerManager.setErrorLog(e1);
					}
		            e.printStackTrace();
					LoggerManager.setErrorLog(e);
		        }finally{
		            try {
		                if(res != null) res.close();
		                if(statement != null) statement.close();
		                if(con != null) {
		                	if (!con.getAutoCommit()) {
		                		con.commit();
		                	}
		                	con.close();
		                }
		                if(fos != null) fos.close();
		            } catch (Exception e2) {
		                // TODO: handle exception
		                e2.printStackTrace();
						LoggerManager.setErrorLog(e2);
		            }
		        }
		    }
			return IsReupdated;
    }

	private static String getCommonSQL() {
		String sql;
		if (CONFIG.IsMultiThread) {
			sql = "select * from (" + "select row_number() over (order by G.FPRN) as rowNum,* from ("
					+ "select *,NAME1 as 新生儿出生体重1P681,NAME2 as 新生儿出生体重2P682,NAME3 as 新生儿出生体重3P683,NAME4 as 新生儿出生体重4P684,NAME5 as 新生儿出生体重5P685 from ( "
					+ "select '48965210-X' 医疗机构代码P900,'漳州市第三医院' 机构名称P6891,'' \"医疗保险手册（卡号）P686\",a.FASCARD1 健康卡号P800,case when LEN(a.FFBBHNEW) > 1 then SUBSTRING(a.FFBBHNEW,2,1) when LEN(a.FFBBHNEW) < 1 then 7 when a.FFBBHNEW is null then 7 else a.FFBBHNEW end 医疗付款方式P1,a.FFBNEW 医疗付款方式代码,a.FTIMES 住院次数P2,a.FPRN 病案号P3,a.FNAME 姓名P4,a.FSEXBH 性别P5,a.FSEX 性别代码,CONVERT(varchar(100), a.FBIRTHDAY,23) 出生日期P6,FLOOR(datediff(day,a.FBIRTHDAY,a.FRYDATE)/365.25) as ddd,case when FLOOR(datediff(day,a.FBIRTHDAY,a.FRYDATE)/365.25) > 0 then FLOOR(datediff(day,a.FBIRTHDAY,a.FRYDATE)/365.25) else null end 年龄P7,case when a.FSTATUSBH = '' or a.FSTATUSBH = NULL then '9' else a.FSTATUSBH end 婚姻状况P8,case when a.FJOBBH = 11 then 11 when a.FJOBBH = 13 then 13 when a.FJOBBH = 17 then 17 when a.FJOBBH = 21 then 21 when a.FJOBBH = 24 then 24 when a.FJOBBH = 27 then 27 when a.FJOBBH = 31 then 31 when a.FJOBBH = 37 then 37 when a.FJOBBH = 51 then 51 when a.FJOBBH = 54 then 54 when a.FJOBBH = 70 then 70 when a.FJOBBH = 80 then 80 when a.FJOBBH = 90 then 90 else 00 end 职业P9,case when PATINDEX('%省%',a.FBIRTHPLACE) > 0 then left(a.FBIRTHPLACE,PATINDEX('%省%',a.FBIRTHPLACE)) else '' end 出生省份P101,case when PATINDEX('%市%',a.FBIRTHPLACE) > 0 then substring(a.FBIRTHPLACE,PATINDEX('%省%',a.FBIRTHPLACE)+1,PATINDEX('%市%',a.FBIRTHPLACE)-PATINDEX('%省%',a.FBIRTHPLACE)) else '' end 出生地市P102,case when PATINDEX('%市%',a.FBIRTHPLACE) > 0 then substring(a.FBIRTHPLACE,PATINDEX('%市%',a.FBIRTHPLACE)+1,LEN(a.FBIRTHPLACE)) else a.FBIRTHPLACE end 出生地县P103,a.FNATIONALITY 民族P11,a.FCOUNTRY 国籍P12,a.FIDCARD 身份证号P13,a.FCURRADDR 现住址P801,a.FCURRTELE 住宅电话P802,a.FCURRPOST 现住址邮政编码P803,a.FDWADDR+a.FDWNAME 工作单位及地址P14,a.FDWTELE 电话P15,a.FDWPOST 工作单位邮政编码P16,a.FHKADDR 户口地址P17,a.FHKPOST 户口所在地邮政编码P171,a.FLXNAME 联系人姓名P18,case when a.FRELATE = '配偶' then 1 when a.FRELATE = '子' then 2 when a.FRELATE = '女' then 3 when a.FRELATE = '孙子、孙女或外孙子、外孙女' then 4 when a.FRELATE = '父母' then 5 when a.FRELATE = '祖父母或外祖父母' then 6 when a.FRELATE = '兄、弟、姐、妹' then 7 else 8 end 关系P19,a.FLXADDR 联系人地址P20,case when a.FRYTJBH is null then 4 when a.FRYTJBH = '' then 4 when a.FRYTJBH = 9 then 4 else a.FRYTJBH end 入院途径P804,a.FLXTELE 联系人电话P21,CONVERT(varchar(100),a.FRYDATE,20) 入院日期P22,"
					+ Util.getCaseWhen(CONFIG.CASE_WHEN_DEPT, "a", "FRYDEPT") + " 入院科别P23," // 入院科别
					+ "a.FRYBS 入院病室P231," + Util.getCaseWhen(CONFIG.CASE_WHEN_ZKDEPT, "a", "FZKDEPT")
					+ " 转科科别P24,CONVERT(varchar(100),a.FCYDATE,20) 出院日期P25,"
					+ Util.getCaseWhen(CONFIG.CASE_WHEN_DEPT, "a", "FCYDEPT") + " 出院科别P26," // 出院科别
					+ Util.getCaseWhen(CONFIG.CASE_WHEN_CYBS, "a", "FCYBS")
					+ " 出院病室P261,a.FDAYS 实际住院天数P27,a.FMZZDBH '门（急）诊诊断编码P28',a.FMZZD '门（急）诊诊断描述P281',a.FRYINFOBH 入院时情况P29,a.FRYZDBH 入院诊断编码P30,a.FRYZD 入院诊断描述P301,CONVERT(varchar(100),a.FQZDATE,23) 入院后确诊日期P31,";
		} else {
			sql = "select '48965210-X' 医疗机构代码P900,'漳州市第三医院' 机构名称P6891,'' \"医疗保险手册（卡号）P686\",a.FASCARD1 健康卡号P800,case when LEN(a.FFBBHNEW) > 1 then SUBSTRING(a.FFBBHNEW,2,1) when LEN(a.FFBBHNEW) < 1 then 7 when a.FFBBHNEW is null then 7 else a.FFBBHNEW end 医疗付款方式P1,a.FFBNEW 医疗付款方式代码,a.FTIMES 住院次数P2,a.FPRN 病案号P3,a.FNAME 姓名P4,a.FSEXBH 性别P5,a.FSEX 性别代码,CONVERT(varchar(100), a.FBIRTHDAY,23) 出生日期P6,FLOOR(datediff(day,a.FBIRTHDAY,a.FRYDATE)/365.25) as ddd,case when FLOOR(datediff(day,a.FBIRTHDAY,a.FRYDATE)/365.25) > 0 then FLOOR(datediff(day,a.FBIRTHDAY,a.FRYDATE)/365.25) else null end 年龄P7,case when a.FSTATUSBH = '' or a.FSTATUSBH = NULL then '9' else a.FSTATUSBH end 婚姻状况P8,a.FJOBBH 职业P9,case when PATINDEX('%省%',a.FBIRTHPLACE) > 0 then left(a.FBIRTHPLACE,PATINDEX('%省%',a.FBIRTHPLACE)) else '' end 出生省份P101,case when PATINDEX('%市%',a.FBIRTHPLACE) > 0 then substring(a.FBIRTHPLACE,PATINDEX('%省%',a.FBIRTHPLACE)+1,PATINDEX('%市%',a.FBIRTHPLACE)-PATINDEX('%省%',a.FBIRTHPLACE)) else '' end 出生地市P102,case when PATINDEX('%市%',a.FBIRTHPLACE) > 0 then substring(a.FBIRTHPLACE,PATINDEX('%市%',a.FBIRTHPLACE)+1,LEN(a.FBIRTHPLACE)) else a.FBIRTHPLACE end 出生地县P103,a.FNATIONALITY 民族P11,a.FCOUNTRY 国籍P12,a.FIDCARD 身份证号P13,a.FCURRADDR 现住址P801,a.FCURRTELE 住宅电话P802,a.FCURRPOST 现住址邮政编码P803,a.FDWADDR+a.FDWNAME 工作单位及地址P14,a.FDWTELE 电话P15,a.FDWPOST 工作单位邮政编码P16,a.FHKADDR 户口地址P17,a.FHKPOST 户口所在地邮政编码P171,a.FLXNAME 联系人姓名P18,a.FRELATE 关系P19,a.FLXADDR 联系人地址P20,case when a.FRYTJBH is null then 4 when a.FRYTJBH = '' then 4 when a.FRYTJBH = 9 then 4 else a.FRYTJBH end 入院途径P804,a.FLXTELE 联系人电话P21,CONVERT(varchar(100),a.FRYDATE,20) 入院日期P22,"
					+ Util.getCaseWhen(CONFIG.CASE_WHEN_DEPT, "a", "FRYDEPT") + " 入院科别P23," // 入院科别
					+ "a.FRYBS 入院病室P231," + Util.getCaseWhen(CONFIG.CASE_WHEN_ZKDEPT, "a", "FZKDEPT")
					+ " 转科科别P24,CONVERT(varchar(100),a.FCYDATE,20) 出院日期P25,"
					+ Util.getCaseWhen(CONFIG.CASE_WHEN_DEPT, "a", "FCYDEPT") + " 出院科别P26," // 出院科别
					+ Util.getCaseWhen(CONFIG.CASE_WHEN_CYBS, "a", "FCYBS")
					+ " 出院病室P261,a.FDAYS 实际住院天数P27,a.FMZZDBH '门（急）诊诊断编码P28',a.FMZZD '门（急）诊诊断描述P281',a.FRYINFOBH 入院时情况P29,a.FRYZDBH 入院诊断编码P30,a.FRYZD 入院诊断描述P301,CONVERT(varchar(100),a.FQZDATE,23) 入院后确诊日期P31,";
		}
		sql += "a.FYNGR 医院感染总次数P689," + "'' 病理诊断编码1P351,'' 病理诊断名称1P352,a.FPHZDNUM 病理号1P816,"
				+ "'' 病理诊断编码2P353,'' 病理诊断名称2P354,'' 病理号2P817," + "'' 病理诊断编码3P355,'' 病理诊断名称3P356,'' 病理号3P818,"
				+ "g.FICDM '损伤、中毒的外部因素编码1P361',g.FJBNAME '损伤、中毒的外部因素名称1P362',"
				+ "'' '损伤、中毒的外部因素编码2P363','' '损伤、中毒的外部因素名称2P364'," + "'' '损伤、中毒的外部因素编码3P365','' '损伤、中毒的外部因素名称3P366',"
				+ "'' 过敏源P371,a.FGMYW 过敏药物名称P372,a.FHBSAGBH HBsAgP38,a.FHCVABBH 'HCV-AbP39',a.FHIVABBH 'HIV-AbP40',a.FMZCYACCOBH 门诊与出院诊断符合情况P411,a.FRYCYACCOBH 入院与出院诊断符合情况P412,'' 术前与术后诊断符合情况P413,'' 临床与病理诊断符合情况P414,'' 放射与病理诊断符合情况P415, a.FQJTIMES 抢救次数P421,a.FQJSUCTIMES 抢救成功次数P422,'' 最高诊断依据P687,'' 分化程度P688,a.FKZR 科主任P431,a.FZRDOCTOR '主(副主)任医师P432',a.FZZDOCT 主治医师P433,a.FZYDOCT 住院医师P434,a.FNURSE 责任护士P819,a.FJXDOCT 进修医师P435,a.FYJSSXDOCT 研究生实习医师P436,a.FSXDOCT 实习医师P437,a.FBMY 编码员P438,a.FQUALITYBH 病案质量P44,a.FZKDOCT 质控医师P45,a.FZKNURSE 质控护师P46,CONVERT(varchar(100),a.FZKRQ,23) 质控日期P47,"
				+ "a.FHLTJ 特级护理天数P561,a.FHL1 一级护理天数P562,a.FHL2 二级护理天数P563,a.FHL3 三级护理天数P564,"
				+ "'' 重症监护室名称1P6911,'' 进入时间1P6912,'' 退出时间1P6913," + "'' 重症监护室名称2P6914,'' 进入时间2P6915,'' 退出时间2P6916,"
				+ "'' 重症监护室名称3P6917,'' 进入时间3P6918,'' 退出时间3P6919," + "'' 重症监护室名称4P6920,'' 进入时间4P6921,'' 退出时间4P6922,"
				+ "'' 重症监护室名称5P6923,'' 进入时间5P6924,'' 退出时间5P6925,"
				+ "a.FBODYBH 死亡患者尸检P57,case when a.FISOPFIRSTBH=1 then '1' else case when a.FISZLFIRSTBH = 1 then '1' else case when a.FISJCFIRSTBH = 1 then '1' else case when a.FISZDFIRSTBH = 1 then '1' end end end end as '手术、治疗、检查、诊断为本院第一例P58',"
//        		+ "case when a.FIFSS = 1 then case when c.FZQSSBH = 1 then '2' else '1' end else '0' end 手术患者类型P581,"
				+ "'' 手术患者类型P581,"
				+ "a.FISSZBH 随诊P60,'' 随诊周数P611,'' 随诊月数P612,'' 随诊年数P613,a.FSAMPLEBH 示教病例P59,a.FBLOODBH ABO血型P62,a.FRHBH Rh血型P63,a.FSXFYBH 输血反应P64,d.FREDCELL 红细胞P651,d.FPLAQUE 血小板P652,d.FSEROUS 血浆P653,d.FALLBLOOD 全血P654,'' 自体回收P655,d.FOTHERBLOOD 其它P656,case when FLOOR(datediff(day,a.FBIRTHDAY,a.FRYDATE)/365.25) = 0 then CAST((cast(datediff(day,a.FBIRTHDAY,a.FRYDATE) - (datediff(month,a.FBIRTHDAY,a.FRYDATE) * 30) as float) / 30) as decimal(4,2)) + datediff(month,a.FBIRTHDAY,a.FRYDATE) else null end '（年龄不足1 周岁的）年龄P66',"
//        		+ "a.FCSTZ 新生儿出生体重1P681,'' 新生儿出生体重2P682,'' 新生儿出生体重3P683,'' 新生儿出生体重4P684,'' 新生儿出生体重5P685,"
				+ "a.FRYTZ 新生儿入院体重P67,a.FRYQHMHOURS '入院前多少小时(颅脑损伤患者昏迷时间)P731',a.FRYQHMMINS '入院前多少分钟(颅脑损伤患者昏迷时间)P732',a.FRYHMHOURS '入院后多少小时(颅脑损伤患者昏迷时间)P733',a.FRYHMMINS '入院后多少分钟(颅脑损伤患者昏迷时间)P734','' 呼吸机使用时间P72,a.FISAGAINRYBH '是否有出院31天内再住院计划P830',a.FISAGAINRYMD '出院31天再住院计划目的P831',a.FLYFSBH 离院方式P741,a.FYZOUTHOSTITAL 转入医院名称P742,a.FSQOUTHOSTITAL '转入社区服务机构/乡镇卫生院名称P743',a.FSUM1 住院总费用P782,a.FZFJE 住院总费用其中自付金额P751,a.FZHFWLYLF 一般医疗服务费P752,a.FZHFWLCZF 一般治疗操作费P754,a.FZHFWLHLF 护理费P755,a.FZHFWLQTF 综合医疗服务类其他费用P756,a.FZDLBLF 病理诊断费P757,a.FZDLSSSF 实验室诊断费P758,a.FZDLYXF 影像学诊断费P759,a.FZDLLCF 临床诊断项目费P760,a.FZLLFFSSF 非手术治疗项目费P761,a.FZLLFWLZWLF 临床物理治疗费P762,a.FZLLFSSF 手术治疗费P763,a.FZLLFMZF 麻醉费P764,a.FZLLFSSZLF 手术费P765,a.FKFLKFF 康复费P767,a.FZYLZF 中医治疗费P768,a.FXYF 西药费P769,a.FXYLGJF 抗菌药物费用P770,a.FZCHYF 中成药费P771,a.FZCYF 中草药费P772,a.FXYLXF 血费P773,a.FXYLBQBF  白蛋白类制品费P774,a.FXYLQDBF 球蛋白类制品费P775,a.FXYLYXYZF 凝血因子类制品费P776, a.FXYLXBYZF 细胞因子类制品费P777,a.FHCLCJF 检查用一次性医用材料费P778,a.FHCLZLF 治疗用一次性医用材料费P779,a.FHCLSSF 手术用一次性医用材料费P780,a.FQTF 其他费P781,b.* "
				+ "from TPATIENTVISIT a " + "left join HIS_BA1 d on a.FPRN=d.FPRN  "
				+ "left join (select * from Tdiagnose where FZDLX = 's') g on a.FPRN = g.FPRN "
				+ "left join (select FPRN,'NAME' + convert(varchar,FBABYNUM) as NAME,FTZ from TBABYCARD) b on a.FPRN = b.FPRN ";
		return sql;
	}

	private static Method invokeOperation(Connection con, Patient patient, P_Operation operation, Class<?> o_invoke,
			Method getMethod)
			throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		PreparedStatement operation_statement;
		ResultSet operation_res;
		String operation_sql;
		//		            	// 创建手术SQL
				            	operation_sql = "select \r\n" + 
				            			"FOPCODE 手术操作编码,CONVERT(varchar(100),FOPDATE,20) 手术操作日期,case when FSSJBBH is null then 1 else FSSJBBH end 手术级别,FOP 手术操作名称,\r\n" + 
				            			Util.getCaseWhen(CONFIG.CASE_WHEN_OPER_PART, "s", "sszlid") + " 手术操作部位,"
				            			+ "'1' 手术持续时间,FDOCNAME 术者,FOPDOCT1 Ⅰ助,FOPDOCT2 Ⅱ助,case when  FMAZUIBH = '1'  or FMAZUIBH = '0.0001' then '01' when FMAZUIBH = '2' or FMAZUIBH = '0.0002' then '03' when FMAZUIBH = '3' or FMAZUIBH = '0.0003' then '99' when FMAZUIBH = '4' or FMAZUIBH = '0.0004' then '0104' when FMAZUIBH = '5' or FMAZUIBH = '0.0005' then '0102' when FMAZUIBH = '6' or FMAZUIBH = '0.0006' then '0502' when FMAZUIBH = '7' or FMAZUIBH = '0.0007' then '0502' when FMAZUIBH = '8' or FMAZUIBH = '0.0008' then '0103' when FMAZUIBH = '9' or FMAZUIBH = '0.0009' then '0502' when FMAZUIBH = '10' or FMAZUIBH = '0.0010' then '0502' when FMAZUIBH = '11' or FMAZUIBH = '0.0011' then '99' when FMAZUIBH = '12' or FMAZUIBH = '0.0012' then '0502' when FMAZUIBH = '13' or FMAZUIBH = '0.0013' then '0102' when FMAZUIBH = '14' or FMAZUIBH = '0.0014' then '0502' when FMAZUIBH = '15' or FMAZUIBH = '0.0015' then '020102' when FMAZUIBH = '16' or FMAZUIBH = '0.0016' then '0502' when FMAZUIBH = '17' or FMAZUIBH = '0.0017' then '020103' when FMAZUIBH = '18' or FMAZUIBH = '0.0018' then '0502' when FMAZUIBH = '19' or FMAZUIBH = '0.0019' then '020201' when FMAZUIBH = '20' or FMAZUIBH = '0.0020' then '0502' when FMAZUIBH = '21' or FMAZUIBH = '0.0021' then '020202' when FMAZUIBH = '22' or FMAZUIBH = '0.0022' then '0502' when FMAZUIBH = '23' or FMAZUIBH = '0.0023' then '99' when FMAZUIBH = '24' or FMAZUIBH = '0.0024' then '99' when FMAZUIBH = '25' or FMAZUIBH = '0.0025' then '020101' when FMAZUIBH = '26' or FMAZUIBH = '0.0026' then '99' when FMAZUIBH is null or FMAZUIBH = '——' then '99' else FMAZUIBH end 麻醉方式,'1' 麻醉分级,\r\n" + 
				            			"case when FQIEKOUBH is null or FQIEKOUBH = 0 or FQIEKOUBH = 9 then 0\r\n" + 
				            			"when FQIEKOUBH = 1 and FYUHEBH = 1 then 1 when FQIEKOUBH = 1 and FYUHEBH = 2 then 2 when FQIEKOUBH = 1 and FYUHEBH = 3 then 3 when FQIEKOUBH = 1 and FYUHEBH is null or FYUHEBH = 4 then 10 \r\n" + 
				            			"when FQIEKOUBH = 2 and FYUHEBH = 1 then 4 when FQIEKOUBH = 2 and FYUHEBH = 2 then 5 when FQIEKOUBH = 2 and FYUHEBH = 3 then 6 when FQIEKOUBH = 2 and FYUHEBH is null or FYUHEBH = 4 then 11\r\n" + 
				            			"when FQIEKOUBH = 3 and FYUHEBH = 1 then 7 when FQIEKOUBH = 3 and FYUHEBH = 2 then 8 when FQIEKOUBH = 3 and FYUHEBH = 3 then 9 when FQIEKOUBH = 3 and FYUHEBH is null or FYUHEBH = 4 then 12\r\n" + 
				            			" end 切口愈合等级,t.FMZDOCT 麻醉医师\r\n" + 
				            			"from TOPERATION t left join (select * from [" + CONFIG.HIS_IP + "].THIS4.dbo.SS_SSDJK s left join TPATIENTVISIT p on s.syxh = p.FZYID where s.syxh in (select FZYID from TPATIENTVISIT where FPRN = '" + patient.getP3() + "' and FTIMES = '" + patient.getP2() + "')) s on t.FPRN = s.blh collate Chinese_PRC_CI_AS" +
				            			" where t.FPRN = '" + patient.getP3() + "' and t.FTIMES = '" + patient.getP2() + "';";
				            	if (CONFIG.SHOW_SQL_LOG) {
				            		LoggerManager.setInfoLog(operation_sql);
				            	}
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
				            	if (CONFIG.SHOW_NORMAL_LOG) {
				                	LoggerManager.setInfoLog("-----------------第" + DataTranDemo.row + "条数据读取完毕");
				            	}
		return getMethod;
	}
	
	private static Method invokeColumn(ResultSet res, Patient patient, Class<?> p_invoke, Method getMethod,
			Field[] fields)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
		String columnName;
		// LoggerManager.setInfoLog("-----------------开始处理第" + res.getRow() + "条数据");
		DataTranDemo.row++;
		if (CONFIG.SHOW_NORMAL_LOG) {
			LoggerManager.setInfoLog("-----------------开始处理第" + DataTranDemo.row + "条数据");
		}
		for (int i = 0; i < fields.length; i++) {
			columnName = fields[i].getName();
			if (columnName == "columnMap" || columnName == "bigint_flag" || columnName == "lenth_map"
					|| columnName == "column_part1" || columnName == "column_part2") {
				continue;
			}
			getMethod = p_invoke.getMethod("set" + columnName, new Class[] { String.class });
			// result =
			// 2.0诊断编码转换
			if ("P28".equals(columnName) || "P361".equals(columnName)) {
				getMethod.invoke(patient, getDYDiagnose(res.getString(patient.getColumnMap().get(columnName))));
			} else {
				getMethod.invoke(patient, res.getString(patient.getColumnMap().get(columnName)));
			}
		}
		return getMethod;
	}
	
	private static Method invokeDiagnose(Connection con, Patient patient, P_Diagnose diagnose, Class<?> d_invoke,
			Method getMethod)
			throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		PreparedStatement diagnose_statement;
		ResultSet diagnose_res;
		String diagnose_sql;
		// ---------------- 诊断 ---------------------------
		// 创建诊断SQL
		diagnose_sql = "select FICDM 主要诊断编码,case when fsxzd is null or fsxzd = '' then '无' else fsxzd end 主要诊断疾病描述,FRYBQBH 主要诊断入院病情,case when FZLJGBH = 5 or FZLJGBH is null or FZLJGBH = '' then 9 else FZLJGBH end 主要诊断出院情况 from tDiagnose where FZDLX != 's' and FPRN = '" + patient.getP3() + "' order by FZDLX asc";
		if (CONFIG.SHOW_NORMAL_LOG) {
			LoggerManager.setInfoLog("病人病案号" + patient.getP3());
		}
		if (CONFIG.SHOW_SQL_LOG) {
			LoggerManager.setInfoLog(diagnose_sql);
		}
		diagnose_statement = con.prepareStatement(diagnose_sql);
		diagnose_res = diagnose_statement.executeQuery();
		if (patient.getP3() == "00212810") {
			System.out.println("00212810");
		}
		while (diagnose_res.next()) {
			int row = diagnose_res.getRow() - 1;
			if (row > 10) {break;}
				getMethod = d_invoke.getMethod("set" + diagnose.getDiag_flag()[row][0], new Class[] {String.class});
				getMethod.invoke(diagnose,getDYDiagnose(diagnose_res.getString("主要诊断编码")));	
				getMethod = d_invoke.getMethod("set" + diagnose.getDiag_flag()[row][1], new Class[] {String.class});
				getMethod.invoke(diagnose, diagnose_res.getString("主要诊断疾病描述"));
				getMethod = d_invoke.getMethod("set" + diagnose.getDiag_flag()[row][2], new Class[] {String.class});
				getMethod.invoke(diagnose, diagnose_res.getString("主要诊断入院病情"));
				getMethod = d_invoke.getMethod("set" + diagnose.getDiag_flag()[row][3], new Class[] {String.class});
				getMethod.invoke(diagnose, diagnose_res.getString("主要诊断出院情况"));
		}
		return getMethod;
	}
	/**
	 *  返回2.0对应的1.0旧编码
	 * @return
	 */
	public static String getDYDiagnose(String Diagnose20) {
    	Connection con = ConManager.getDBConnection(CONFIG.url, CONFIG.U, CONFIG.P);
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            // SQL
String sql = "select ybzddm from ICD20DY where icd10 = '" + Diagnose20 + "' ";//查询test表
            
			if (CONFIG.SHOW_SQL_LOG) {
				LoggerManager.setInfoLog("get oldDiagnose sql ------------------------->" + sql);
			}
            statement = con.prepareStatement(sql);
            res = statement.executeQuery();
            if (res.next()) {
            	return res.getString("ybzddm");
            } else {
            	return Diagnose20;
            }
           
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
			LoggerManager.setErrorLog(e);
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) {
                	if (!con.getAutoCommit()) {
                		con.commit();
                	}
                	con.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
				LoggerManager.setErrorLog(e2);
            }
        }
		return Diagnose20;
    }
	
	public static boolean ReupdateFromTimeFile(String filePath) {
    	ArrayList<String> period_list = ReadTxtFile.readTxt(filePath);
    	boolean IsReupdated = false;
		// reupload process
		if (!period_list.isEmpty()) {
	    // SQL
	    	Connection con = ConManager.getDBConnection(CONFIG.url, CONFIG.U, CONFIG.P);
	    	PreparedStatement statement = null; 
	        ResultSet res = null;
			FileOutputStream fos = null;
			String sql;
	        try {
	            // SQL
	        	sql = getCommonSQL();
        		sql += " where  "
	            		+ " a.FCYDATE between '" + Util.getSomedayEarly(period_list.get(0), CONFIG.days) + "' and '" + Util.getSomedayEarly(period_list.get(1), CONFIG.days) + "' "
	    				+ ") AS P "
	    				+ "PIVOT"
	    				+ "("
	    				+ " sum(FTZ) for "
	    				+ "P.NAME in (NAME1,NAME2,NAME3,NAME4,NAME5) "
	    				+ " ) as t"
	    				+ " ) as G"
	    				+ " ) as C";
//						+ " and a.FPRN = '00175611'"
//	            		+ " where a.FPRN = '00184374'"
						sql += "";//查询test表
						
	            if (CONFIG.SHOW_SQL_LOG) {
					LoggerManager.setInfoLog("执行补传时间段sql------------------------->" + sql); 
	            }
	            statement = con.prepareStatement(sql);
		        con.setAutoCommit(false);
//			    insert_stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
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
	            Method getMethod = null;
	            // 获取病人字段属性
	            Field[] fields = patient.getClass().getDeclaredFields();
	            while(res.next()){
	            	getMethod = invokeColumn(res, patient, p_invoke, getMethod, fields);
	            	
	            	getMethod = invokeDiagnose(con, patient, diagnose, d_invoke, getMethod);
//	            	// ---------------- 手术 ---------------------------
	            	getMethod = invokeOperation(con, patient, operation, o_invoke, getMethod);

	            	// 开始插入数据库
	            	getMethod = insertIntoDatabase(con, patient, diagnose, operation, p_invoke, d_invoke, o_invoke,
							getMethod);
	            	
	            	// 杀死病人
	            	patient.KillPatient();
	            	// 重置诊断
	            	diagnose.reset_diagnose();
	            	// 重置手术
	            	operation.reset_operation();
	            }
//	            insert_stm.executeBatch();

	            IsReupdated = true;
	            
	        } catch (Exception e) {
	            // TODO: handle exception
	        	try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					LoggerManager.setErrorLog(e1);
				}
	            e.printStackTrace();
				LoggerManager.setErrorLog(e);
	        }finally{
	            try {
	                if(res != null) res.close();
	                if(statement != null) statement.close();
	                if(con != null) {
	                	if (!con.getAutoCommit()) {
	                		con.commit();
	                	}
	                	con.close();
	                }
	                if(fos != null) fos.close();
	            } catch (Exception e2) {
	                // TODO: handle exception
	                e2.printStackTrace();
					LoggerManager.setErrorLog(e2);
	            }
	        }
	    }
		return IsReupdated;
}

    @Override
	public synchronized void run() {
    	Connection con = ConManager.getDBConnection(CONFIG.url, CONFIG.U, CONFIG.P);
        PreparedStatement statement = null;
        ResultSet res = null;
		FileOutputStream fos = null;
		String sql;
        try {
            // SQL
        	sql = getCommonSQL();
    		sql += " where  "
            		+ " a.FCYDATE between '" + Util.getSomedayEarly(CONFIG.days) + "' and '" + Util.getSomedayEarly(CONFIG.days) + "' "
    				+ ") AS P "
    				+ "PIVOT"
    				+ "("
    				+ " sum(FTZ) for "
    				+ "P.NAME in (NAME1,NAME2,NAME3,NAME4,NAME5) "
    				+ " ) as t"
    				+ " ) as G"
    				+ " ) as C";
            		if (CONFIG.IsMultiThread) {
                		sql += " where rowNum between " + start + " and " + end;
            		}
//					+ " and a.FPRN = '00175611'"
//            		+ " where a.FPRN = '00184374'"
					sql += "";//查询test表
					
            if (CONFIG.SHOW_SQL_LOG) {
				LoggerManager.setInfoLog("执行sql------------------------->" + sql); 
            }
            statement = con.prepareStatement(sql);
	        con.setAutoCommit(false);
//		    insert_stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
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
            Method getMethod = null;
            // 获取病人字段属性
            Field[] fields = patient.getClass().getDeclaredFields();
            while(res.next()){
            	getMethod = invokeColumn(res, patient, p_invoke, getMethod, fields);
            	
            	getMethod = invokeDiagnose(con, patient, diagnose, d_invoke, getMethod);
//            	// ---------------- 手术 ---------------------------
            	getMethod = invokeOperation(con, patient, operation, o_invoke, getMethod);

            	// 开始插入数据库
            	getMethod = insertIntoDatabase(con, patient, diagnose, operation, p_invoke, d_invoke, o_invoke,
						getMethod);
            	
            	// 杀死病人
            	patient.KillPatient();
            	// 重置诊断
            	diagnose.reset_diagnose();
            	// 重置手术
            	operation.reset_operation();
            }
//            insert_stm.executeBatch();

            
        } catch (Exception e) {
            // TODO: handle exception
        	try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
				LoggerManager.setErrorLog(e1);
			}
            e.printStackTrace();
			LoggerManager.setErrorLog(e);
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) {
                	if (!con.getAutoCommit()) {
                		con.commit();
                	}
                	con.close();
                }
                if(fos != null) fos.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
				LoggerManager.setErrorLog(e2);
            }
        }
    }

	private static Method insertIntoDatabase(Connection con, Patient patient, P_Diagnose diagnose, P_Operation operation,
			Class<?> p_invoke, Class<?> d_invoke, Class<?> o_invoke, Method getMethod)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, Exception, SQLException {
		PreparedStatement insert_statement;
		String columnName;
		String diagcolumnName;
		String opercolumnName;
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
			if (columnName == "columnMap" || columnName == "bigint_flag" || columnName == "this$0" || columnName == "lenth_map" || columnName == "column_part1" || columnName == "column_part2") {
				continue;
			}

			// 诊断字段
			if (columnName == "P689") {
				for (int j = 0; j < diagnose_fields.length; j++) {
					diagcolumnName = diagnose_fields[j].getName();
		        	if (diagcolumnName == "diag_flag" || diagcolumnName == "this$0" || columnName == "lenth_map" || columnName == "column_part1" || columnName == "column_part2") {
		        		continue;
		        	}
		        	insert_SQL += diagcolumnName + ",";
		        	getMethod = d_invoke.getMethod("get" + diagcolumnName);
//                        	result = 
		        	Object value = (String)getMethod.invoke(diagnose);
		        	if ("".equals(value)) {
		        		values_SQL +=  null + ",";
		        	} else if (value == null || value.toString().length() <= 0) {
		        		values_SQL +=  null + ",";
		        	} else {
		        		// 非null
		        		// 处理字段长度
		        		value = BCConvert.handleLenth(patient.getLenthMap(), diagcolumnName, String.valueOf(value));
		        		// 判断该字段是否为数字类型
		        		if (Util.useLoop(patient.getBigint_flag(), diagcolumnName)) {
		                	values_SQL += BCConvert.handleColumn(String.valueOf(value)) + ",";
		                	// 装入数据
		        		} else {
		                	values_SQL +=  "'" + BCConvert.handleColumn(String.valueOf(value)) + "',";
		        		}
		        	}
		    		
		        }
			}
			// 手术字段
			if (columnName == "P561") {
				for (int k = 0; k < operation_fields.length; k++) {
					opercolumnName = operation_fields[k].getName();
		        	if (opercolumnName == "oper_flag" || opercolumnName == "this$0" || columnName == "lenth_map" || columnName == "column_part1" || columnName == "column_part2") {
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
		                	values_SQL += BCConvert.handleColumn(String.valueOf(value)) + ",";
		        		} else {
		                	values_SQL +=  "'" + BCConvert.handleColumn(String.valueOf(value)) + "',";
		        		}
		        	}
		        }
			}
			insert_SQL += columnName + ",";
			getMethod = p_invoke.getMethod("get" + columnName);
//                	result = 
			Object value = (String)getMethod.invoke(patient);
			
			if ("".equals(value)) {
				values_SQL +=  null + ",";
			} else if (value == null || value.toString().length() <= 0) {
				values_SQL +=  null + ",";
			} else {
				// 非null
				// 处理字段长度
				value = BCConvert.handleLenth(patient.getLenthMap(), columnName, String.valueOf(value));
				// 判断该字段是否为数字类型
				if (Util.useLoop(patient.getBigint_flag(), columnName)) {
		        	values_SQL += BCConvert.handleColumn(String.valueOf(value)) + ",";
				} else {
		        	values_SQL +=  "'" + BCConvert.handleColumn(String.valueOf(value)) + "',";
				}
			}
		}
		String sql_to_insert = insert_SQL.substring(0, insert_SQL.length() - 1) + ")" + values_SQL.substring(0, values_SQL.length() - 1) + ");";
		if (CONFIG.SHOW_NORMAL_LOG) {
		    LoggerManager.setInfoLog("-----------------第" + DataTranDemo.row + "条数据插入SQL生成完成，开始插入数据库");
		}
		if (CONFIG.SHOW_SQL_LOG) {
		    LoggerManager.setInfoLog(sql_to_insert);
		}
		insert_statement = con.prepareStatement(sql_to_insert);
		insert_statement.executeUpdate();
//                insert_stm.addBatch(sql_to_insert);
		if (CONFIG.SHOW_NORMAL_LOG) {
			LoggerManager.setInfoLog("-----------------第" + DataTranDemo.row + "条数据插入数据库成功");
		}
		return getMethod;
	}
}
