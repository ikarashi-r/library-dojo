package spring.practice2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("hoge")
public class HogeCs implements IHogeCs {
	private static final Logger logger = LoggerFactory.getLogger(HogeCs.class);

	@Override
	public void hoge() {
		logger.info("hoge called");
	}

}
