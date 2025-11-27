FROM openjdk:17

WORKDIR /app

COPY . /app

RUN javac -cp .:sqlite-jdbc-3.45.3.0.jar Main.java

CMD ["java", "-cp", ".:sqlite-jdbc-3.45.3.0.jar", "Main"]
