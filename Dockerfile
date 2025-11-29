# Java 17 の Amazon Corretto
FROM amazoncorretto:17

# OS の SQLite をインストール
RUN dnf install -y sqlite

# 作業ディレクトリ
WORKDIR /app

# ソースコードと jar をコピー
COPY . /app

# コンパイル
RUN javac -cp .:sqlite-jdbc-3.45.3.0.jar SQLiteTest.java

# 実行コマンド（必要に応じて変更）
CMD ["java", "-cp", ".:sqlite-jdbc-3.45.3.0.jar:slf4j-api-1.7.36.jar:slf4j-simple-1.7.36.jar", "SQLiteTest"]
