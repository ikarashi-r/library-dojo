# practice1: Springを通してインスタンスを作成してみよう
## 概要
### 課題
- Springを通してインスタンスを作成する
- インスタンス作成時のフィールドのセット
- 生成されるインスタンスがシングルトンでなくなるようにする
- applicationContext.xmlをリファクタリングする

### ゴール
- applocationContext.xmlを使ってインスタンスを作成できる


## 最初の状態
- Main クラス(`src/main/java/spring/practice1/Main.java`)と、Mainクラスから呼ばれるHogeクラス(`src/main/java/spring/practice1/Hoge.java`)があります。
- mainメソッドを実行すると、Hogeクラスのhoge()が呼ばれ、consoleに"hoge called"が出力されます



## Springを通してインスタンスを作成する
1. `src/main/resources/spring/practice1`にapplicationContext.xmlを以下の通り作成する
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
  http://www.springframework.org/schema/beans/spring-beans.xsd
  http://www.springframework.org/schema/context
  http://www.springframework.org/schema/context/spring-context.xsd">

        <bean id="hoge" class="spring.practice1.Hoge">
        </bean>
</beans>
```
　※`class=` の箇所はパッケージとクラス名を指定しています。

2. Mainクラスを変更する
```
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring/practice1/applicationContext.xml");
	Hoge hoge = context.getBean("hoge", Hoge.class);
	hoge.hoge();
}
```
3. 実行してconsoleに"hoge called"が出力されることを確認する

## インスタンス作成時のフィールドのセット
1. Hogeフィールドを持つFugaクラスを作成する

```
public class Fuga {
      Hoge hoge;

      public Fuga(Hoge hoge) {
		this.hoge = hoge;
      }

      public Hoge getHoge() {
		return this.hoge;
      }
}
```


2. Mainクラスを変更する
```
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring/practice1/applicationContext.xml");

	Hoge hoge = context.getBean("hoge", Hoge.class);
	hoge.hoge();

	Fuga fuga = context.getBean("fuga", Fuga.class);
	fuga.getHoge().hoge();
}
```

3. applicationContext.xmlにFugaクラスの設定を追記する
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
  http://www.springframework.org/schema/beans/spring-beans.xsd
  http://www.springframework.org/schema/context
  http://www.springframework.org/schema/context/spring-context.xsd">

        <bean id="hoge" class="spring.practice1.Hoge">
        </bean>

        <bean id="fuga" class="spring.practice1.Fuga">
        	<constructor-arg name="hoge" ref="hoge"/>
        </bean>

</beans>
```

4. 実行してconsoleに"hoge called"が2回出力されることを確認する

## 生成されるインスタンスがシングルトンでなくなるようにする
デフォルトで生成されるインスタンスはシングルトンなので、シングルトンでなくなるように変更する

1. applicationContext.xml の追記

      `hoge`の`<bean>`内に`scope = "prototype"`を追加する
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
  http://www.springframework.org/schema/beans/spring-beans.xsd
  http://www.springframework.org/schema/context
  http://www.springframework.org/schema/context/spring-context.xsd">

        <bean id="hoge" class="spring.practice1.Hoge" scope="prototype">
        </bean>

        <bean id="fuga" class="spring.practice1.Fuga">
        	<constructor-arg name="hoge" ref="hoge"/>
        </bean>

</beans>
```

2. mainメソッドの追記

`System.out.println(hoge == fuga.getHoge());`を追加し、"false"が出力されることを確認する

```
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring/practice1/applicationContext.xml");

	Hoge hoge = context.getBean("hoge", Hoge.class);
	hoge.hoge();

	Fuga fuga = context.getBean("fuga", Fuga.class);
	fuga.getHoge().hoge();

	System.out.println(hoge == fuga.getHoge());
}
```

## applicationContext.xmlをリファクタリングする
1. `src/main/resources/spring/practice1`に`hoge.xml` と`fuga.xml`を新規作成する

hoge.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
  http://www.springframework.org/schema/beans/spring-beans.xsd
  http://www.springframework.org/schema/context
  http://www.springframework.org/schema/context/spring-context.xsd">

      <bean id="hoge" class="spring.practice1.Hoge" scope="prototype">
      </bean>

</beans>
```

fuga.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
  http://www.springframework.org/schema/beans/spring-beans.xsd
  http://www.springframework.org/schema/context
  http://www.springframework.org/schema/context/spring-context.xsd">

	<bean id="fuga" class="spring.practice1.Fuga">
        	<constructor-arg name="hoge" ref="hoge"/>
      </bean>

</beans>
```

2. applicationContext.xml を修正する

作成した`hoge.xml`と`fuga.xml`をimportする形に書き換える

applicationContext.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
  http://www.springframework.org/schema/beans/spring-beans.xsd
  http://www.springframework.org/schema/context
  http://www.springframework.org/schema/context/spring-context.xsd">

        <import resource="classpath:spring/practice1/hoge.xml" />
        <import resource="classpath:spring/practice1/fuga.xml" />

</beans>
```

3. mainメソッドの実行結果が変わらないことを確認する

