package spring.practice1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/practice1/applicationContext.xml");

		Hoge hoge = context.getBean("hoge", Hoge.class);
		hoge.hoge();

		Fuga fuga = context.getBean("fuga", Fuga.class);
		fuga.getHoge().hoge();

		System.out.println(hoge == fuga.getHoge());
	}

}
