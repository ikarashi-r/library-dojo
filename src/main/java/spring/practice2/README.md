# practice2: ComponentScanを使ってみよう
## 課題
- ComponentScanを使ったインスタンスの生成
- インスタンス作成時のフィールドのセット
- インターフェースを実装してQualifierタグを使う

## 最初の状態
- MainCs クラス(`src/main/java/spring/practice2/MainCs.java`)と、Mainクラスから呼ばれるHogeCsクラス(`src/main/java/spring/practice2/HogeCs.java`)があります
- mainメソッドを実行すると、HogeCsクラスのhoge()が呼ばれ、consoleに"hoge called"が出力されます


## ComponentScanを使ったインスタンスの生成

1. `src/main/resources/spring/practice2`に`applicationContext.xml`を作成する

`<context>`でComponentScanを使うパッケージを指定します
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="
      http://www.springframework.org/schema/beans
      http://www.springframework.org/schema/beans/spring-beans.xsd
      http://www.springframework.org/schema/context
      http://www.springframework.org/schema/context/spring-context.xsd">

	<context:component-scan base-package="spring.practice2" />
</beans>
```
2. HogeCsクラスに`@Component`をつける

practice1で`applicationContext.xml`に`<bean id="hoge" class="spring.practice1.Hoge">`と記載した代わりに、`@Component("hoge")`をHogeCsクラスに付与します
```
@Component("hoge")
public class HogeCs {
	private static final Logger logger = LoggerFactory.getLogger(HogeCs.class);

	public void hoge() {
		logger.info("hoge called");
	}
}
```

3. MainCsクラスの変更

```
public static void main(String[] args) {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/practice2/applicationContext.xml");

	HogeCs hoge = ctx.getBean("hoge", HogeCs.class);
	hoge.hoge();
}
```

4. 実行してconsoleに"hoge called"が出力されることを確認する

## インスタンス作成時のフィールドのセット

1. HogeCsフィールドを持つFugaCsクラスを作成する
- HogeCsクラスと同様に`@Component`を使う
- インスタンス生成時のフィールドセットのために`@AutoWired`を使う

```
@Component("fuga")
public class FugaCs {
	private HogeCs hoge;

	@Autowired
	public FugaCs(HogeCs hoge) {
		this.hoge = hoge;
	}

	public HogeCs getHoge() {
		return this.hoge;
	}

}
```
2. MainCsクラスの変更

```
public static void main(String[] args) {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/practice2/applicationContext.xml");

	HogeCs hoge = ctx.getBean("hoge", HogeCs.class);
	hoge.hoge();

	FugaCs fuga = ctx.getBean("fuga", FugaCs.class);
	fuga.getHoge().hoge();

}
```

3. 実行してconsoleに"hoge called"が2回出力されることを確認する


## インターフェースを実装してQualifierタグを使う
1. インターフェースIHogeCsを作成し、HogeCsクラスに実装する


2. IHogeCsを実装したMockHogeCsクラスを作成する
```
@Component("mockhoge")
public class MockHogeCs implements IHogeCs {
	private static final Logger logger = LoggerFactory.getLogger(IHogeCs.class);

	@Override
	public void hoge() {
		logger.info("mockhoge called");
	}

}
```

この段階でmainメソッドを実行すると、consoleに"hoge called"が2回出力されます
これを、`fuga.getHoge().hoge();` では"mockhoge called"が出力されるように修正します


3. `@Qualifier`を使う

`@Qualifier` を使うと、セットするインスタンスをbean名で指定できます
```
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
```

3. 実行してconsoleに"hoge called"と"mockhoge called"が出力されることを確認する




## 参考記事

- [【Spring Framework】component-scanのいろいろ①](https://www.shookuro.com/entry/2016/08/10/175948)
- [@Component、@Service、@Repository、@Controllerの違いについて](https://qiita.com/KevinFQ/items/abc7369cb07eb4b9ae29)
- [SpringFrameworkのAutowiredでQualifierタグを利用](https://blog.e2info.co.jp/2014/03/13/springframework_autowired/)
