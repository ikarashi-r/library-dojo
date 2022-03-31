# Spring

## Spring Framework

- [Springを通してインスタンスを作成してみよう](https://github.com/ikarashi-r/library-dojo/blob/82946307eebfe7b7a80486f4e3acea2faa8761bf/src/main/java/spring/practice1/README.md)　(1時間)
- [ComponentScanを使ってみよう](https://github.com/ikarashi-r/library-dojo/blob/82946307eebfe7b7a80486f4e3acea2faa8761bf/src/main/java/spring/practice2/README.md) (45分)

- [Jdbc history](https://github.com/kobain-jp/jdbc-history) (3時間)

## Spring Boot
- [30分～1時間でworldclockを作ろう！！](https://github.com/kobain-jp/world-clock) (1時間)

## 事前準備
`build.gradle`の`dependencies`に以下を追加する
```xml
dependencies {
　　implementation 'org.springframework:spring-core:5.3.7'
    implementation 'org.springframework:spring-context:5.3.7'
    implementation 'org.springframework:spring-beans:5.3.7'
}
```
※[Logback](https://github.com/ikarashi-r/library-dojo/blob/13a2b9dd2502382bc0fe27be9eed94c69df95f42/src/main/java/logback/README.md)未実施の場合は`implementation 'ch.qos.logback:logback-classic:1.1.3'`も追加してください