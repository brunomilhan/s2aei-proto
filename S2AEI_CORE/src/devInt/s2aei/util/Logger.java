package devInt.s2aei.util;

public class Logger {
	
	// modules
	public static final String GLOBAL = "GLOBAL";
	public static final String DB_CTRL = "DBController";
	public static final String MB_PROJECT = "MBProject";
	public static final String SESSION_BEAN = "SessionBean";
	public static final String SESSION_UTIL = "SessionUtil";
	public static final String CANVAS_QUESTION = "CanvasQuestion";
	
	// BRs
	public static final String PROJECT_BR = "Project BR";
	public static final String STUDENT_PROJECT_BR = "StudentProject BR";
	public static final String CANVAS_BR = "Canvas BR";
	
	
	// types
	public static final String WARN = "WARN";
	public static final String INFO = "INFO";
	public static final String ERROR = "ERROR";
	public static final String DBG = "DEBUG";
	
	public static void log(String module, String type, String msg) {
		System.out.println("==>  " + "["+module+"]" + " " + type + ": " + msg);
	}

}
