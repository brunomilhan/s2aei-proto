package devInt.s2aei.util;

public class Logger {
	
	// modules
	public static final String DB_CTRL = "DBController";
	
	// types
	public static final String WARN = "WARN";
	public static final String INFO = "INFO";
	public static final String ERROR = "ERROR";
	
	public static void log(String module, String type, String msg) {
		System.out.println("==>" + "["+module+"]" + " : " + type + " - " + msg);
	}

}
