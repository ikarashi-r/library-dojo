package logback.practice2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *src/main/resources/logback.xmlを作成し、Fugaクラスのみファイル出力にしましょう
 */
public class Fuga {
	private static final Logger logger = LoggerFactory.getLogger(Fuga.class);

	public void fugaLog() {
		logger.trace("Fuga: trace message");
		logger.debug("Fuga: debug message");
		logger.info("Fuga: info message");
		logger.warn("Fuga: warn message");
		logger.error("Fuga: error message");
	}

}
