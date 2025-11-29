# Java 17 の Amazon Corretto
FROM amazoncorretto:17

# 作業ディレクトリ
WORKDIR /app

# プロジェクト一式をコピー（Main.java, jar, student.dbなど）
COPY . /app

# コンパイル（sqlite-jdbc をクラスパスに含める）
RUN javac -cp .:sqlite-jdbc-3.45.3.0.jar Main.java

# 実行コマンド（slf4j と sqlite-jdbc をクラスパスに含める）
CMD ["java", "-cp", ".:sqlite-jdbc-3.45.3.0.jar:slf4j-api-1.7.36.jar:slf4j-simple-1.7.36.jar", "Main"]
