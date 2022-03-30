package spring.practice2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCs {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring/practice2/applicationContext.xml");

		IHogeCs hoge = ctx.getBean("hoge", IHogeCs.class);
		hoge.hoge();

		FugaCs fuga = ctx.getBean("fuga", FugaCs.class);
		fuga.getHoge().hoge();

	}

}
