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

## Spring Framework

- [ApplicationContext](src/main/java/spring/README_applicationcontext.md)


## Spring Boot
- [30分～1時間でworldclockを作ろう！！](https://github.com/kobain-jp/world-clock)