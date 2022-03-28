package logback.practice2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		logger.trace("Main: trace message");
		logger.debug("Main: debug message");
		logger.info("Main: info message");
		logger.warn("Main: warn message");
		logger.error("Main: error message");

		new Hoge().hogeLog();
		new Fuga().fugaLog();

	}

}
