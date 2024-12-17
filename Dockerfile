FROM amazoncorretto:21-alpine

WORKDIR /app

USER root

RUN apk update && apk --no-cache add bind-tools

COPY target/*.jar /app/agent.jar

CMD ["java", "-jar", "agent.jar"]