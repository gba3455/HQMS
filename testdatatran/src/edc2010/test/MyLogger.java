package edc2010.test;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.helpers.AppenderAttachableImpl;

public class MyLogger extends Logger {

	AppenderAttachableImpl aai;

	protected MyLogger(String name) {
		super(name);
	}
	
	public MyLogger(String name, String logID, Level level) {
		super(name);
		
		PatternLayout layout = new PatternLayout();
		layout.setConversionPattern("%-d{yyyy-MM-dd HH:mm:ss} [%t %l] %m%n");
		
		RollingFileAppender appender = new RollingFileAppender();
		appender.setLayout(layout);
		appender.setFile(CONFIG.LOG_PATH + "/hqms_log" + Util.getSomedayEarly(0) + ".log");
		appender.setEncoding("UTF-8");
		appender.setAppend(true);
		appender.activateOptions();
		
		this.repository = Logger.getRootLogger().getLoggerRepository();
		this.addAppender(appender);
		this.setLevel(level);
		this.parent = Logger.getRootLogger();
	}
}
