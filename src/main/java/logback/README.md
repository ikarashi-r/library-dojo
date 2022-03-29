# logback

## 課題
- practice1: デフォルト設定で使ってみよう
- practice2: logback.xmlで設定を変更してみよう

## 事前準備
このリポジトリをcloneして、EclipseでImportしてください。

## logbackのインポート
`build.gradle`の`dependencies`に以下を追加する
```xml
dependencies {
　　implementation 'ch.qos.logback:logback-classic:1.1.3'
}
```

## practice1:デフォルト設定で使ってみよう
Mainクラスにロガーを実装し、実行してコンソールを確認してください。
- info,debugを使う
- パラメータを使う
- スタックトレースを出力する

参考：
https://qiita.com/opengl-8080/items/49719f2d35171f017aa9#logger-%E3%82%A4%E3%83%B3%E3%82%BF%E3%83%BC%E3%83%95%E3%82%A7%E3%83%BC%E3%82%B9%E3%81%AE%E4%BD%BF%E3%81%84%E6%96%B9

## practice2: logback.xmlで設定を変更してみよう
Mainクラスから呼ばれるHogeクラス、Fugaクラスがあります。
`logback.xml`を編集し、以下の通り設定してください。
- Hogeクラスのみデバッグレベルをtraceにし、それ以外はinfoにする
- Fugaクラスのみファイル出力にし、それ以外はConsoleに出力する

参考：
- https://qiita.com/opengl-8080/items/49719f2d35171f017aa9#%E3%83%AD%E3%82%AC%E3%83%BC%E3%81%AE%E5%87%BA%E5%8A%9B%E3%83%AC%E3%83%99%E3%83%AB%E3%82%92%E6%8C%87%E5%AE%9A%E3%81%99%E3%82%8B
- https://qiita.com/opengl-8080/items/49719f2d35171f017aa9#%E3%83%95%E3%82%A1%E3%82%A4%E3%83%AB%E5%87%BA%E5%8A%9B

余裕がある場合は、他の設定も試してみてください。




