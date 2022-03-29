# Spring (Spring Framework, Spring Boot)

## 概要
### 課題
- ApplicationContext
- ComponentScan
- JdbcDaoSupport
- Spring Bootを使ってみよう（1h）

### ゴール

-
-
-

## build.gradleへの追記
`build.gradle`の`dependencies`に以下を追加する
```xml
dependencies {
　　implementation 'org.springframework:spring-core:5.3.7'
    implementation 'org.springframework:spring-context:5.3.7'
    implementation 'org.springframework:spring-beans:5.3.7'
}
```

## practice1: ApplicationContext
### 最初の状態
- Main クラスと、Mainクラスから呼ばれるHogeクラスがあります。
- mainメソッドを実行すると、Hogeクラスのメソッドhoge()が呼ばれ、consoleに"hoge called"が出力されます

### Springを通してインスタンスを作成する
1. `src/main/resources`に`applicationContext.xml`を以下の通り作成する
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
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hoge hoge = context.getBean("hoge", Hoge.class);
		hoge.hoge();
	}
```
3. 実行してconsoleに"hoge called"が出力されることを確認する

### インスタンス作成時のフィールドのセット
1. Hogeフィールドを持つFugaクラスを作成する

2. Mainクラスを変更する
```
public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

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

### 生成されるインスタンスをシングルトンでなくす
デフォルトで生成されるインスタンスはシングルトンなので、シングルトンでなくなるように変更します。

1. 

### applicationContext.xmlをリファクタリングする



## Spring Bootを使ってみよう
- [30分～1時間でworldclockを作ろう！！](https://github.com/kobain-jp/world-clock)
