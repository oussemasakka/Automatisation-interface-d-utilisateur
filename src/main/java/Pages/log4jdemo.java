package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jdemo {
	
	static Logger logger = LogManager.getLogger(log4jdemo.class);
public static void main(String[]args) {
	
	System.out.println("\n hello\n");
	logger.trace("trace");
	logger.info("info");
	logger.error("error");
	logger.warn("warn");
	logger.fatal("fatal");

	System.out.println("\nfini....");
}









}
