package logback.practice2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *logback.xmlを編集し、Hogeクラスのみデバッグレベルをtraceにしましょう（デフォルトはinfo）
 */
public class Hoge {
	private static final Logger logger = LoggerFactory.getLogger(Hoge.class);

	public void hogeLog() {
		logger.trace("Hoge: trace message");
		logger.debug("Hoge: debug message");
		logger.info("Hoge: info message");
		logger.warn("Hoge: warn message");
		logger.error("Hoge: error message");
	}

}
