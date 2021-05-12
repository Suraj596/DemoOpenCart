package utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggerClass {
	static final Logger logger = LogManager.getLogger(LoggerClass.class.getName());
	
	public static void info(String msg) {
		logger.info(msg);
	}
	
}
