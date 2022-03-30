package spring.practice2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("mockhoge")
public class MockHogeCs implements IHogeCs {
	private static final Logger logger = LoggerFactory.getLogger(IHogeCs.class);

	@Override
	public void hoge() {
		logger.info("mockhoge called");
	}

}
