package edc2010.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerManager {
 
private static Logger logger = new MyLogger(Thread.currentThread().toString(), Thread.currentThread().toString(), Level.INFO);
	// log
	public static void setInfoLog(Object log) {
        logger.setLevel(Level.INFO);//覆盖配置文件中的级别
        logger.info(log);
	}
	// debug
	public static void setDebugLog(Object log) {
        logger.setLevel(Level.DEBUG);//覆盖配置文件中的级别
        logger.debug(log);
	}
	// warn
	public static void setWarnLog(Object log) {
		SendWechatMsg.sendMsg("LoggerManager", "Warn", log.toString());
        logger.setLevel(Level.WARN);//覆盖配置文件中的级别
        logger.warn(log);
	}
	// error
	public static void setErrorLog(Object log) {
		SendWechatMsg.sendMsg("LoggerManager", "Error", log.toString());
        logger.setLevel(Level.ERROR);//覆盖配置文件中的级别
        logger.error(log);
	}
	// fatal
	public static void setFatalLog(Object log) {
		SendWechatMsg.sendMsg("LoggerManager", "FATAL", log.toString());
        logger.setLevel(Level.FATAL);//覆盖配置文件中的级别
        logger.fatal(log);
	}
}