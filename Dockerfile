FROM openjdk:8-jdk-alpine

RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY out/artifacts/todo_jar/todo.jar $PROJECT_HOME/springboot-mongo-demo.jar

WORKDIR $PROJECT_HOME

CMD ["java","-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/springmongo-demo","-Djava.security.egd=file:/dev/./urandom","-jar","./springboot-mongo-demo.jar"]