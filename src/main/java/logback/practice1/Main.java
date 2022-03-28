package logback.practice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Main.class);

		//TODO1.debug, infoを使ってみよう
		System.out.println("---log level---");
		logger.debug("debug message");
		logger.info("info message");

		//TODO2.パラメータを使ってみよう
		System.out.println("---Parameters---");
		logger.info("{}", "log1");
		logger.info("{}{}", "log1", "log2");
		logger.info("{}{}", "log1");
		logger.info("{}", "log1", "log2");

		//TODO3.スタックトレースを使ってみよう
		System.out.println("---Stack trace---");
		try {
			throw new Exception("test Exception");
		} catch (Exception e) {
			logger.info("error", e);
		}
	}

}
