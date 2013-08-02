package Core_System;

public class Logger {
	
	// will be used for database access
		private String driverName;

		public Logger(String driverName) {
			super();
			this.driverName = driverName;
		}

		// will add a Log to database
		public static void log(Log log) {
			System.out.println(log.getData());
		}

		// will retrieve all Logs from database
		public Log[] getLogs() {
			return null;
		}

}
