package spring.practice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fuga")
public class FugaCs {
	private IHogeCs hoge;

	@Autowired
	public FugaCs(@Qualifier("mockhoge") IHogeCs hoge) {
		this.hoge = hoge;
	}

	public IHogeCs getHoge() {
		return this.hoge;
	}

}
