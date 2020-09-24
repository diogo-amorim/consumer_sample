FROM openjdk:8-jdk-alpine
RUN apk update && apk add --no-cache gcompat && apk add --no-cache openssl && apk add wget
VOLUME /tmp
WORKDIR /app
COPY target/integration-service-1.0.0.jar /app/
#RUN wget -O dd-java-agent.jar 'https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=com.datadoghq&a=dd-java-agent&v=LATEST'
RUN wget -O dd-java-agent.jar 'https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=com.datadoghq&a=dd-java-agent&v=0.43.0'
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -javaagent:dd-java-agent.jar \
 -Ddd.service.name=integration-service -Dspring.profiles.active=$PROFILE  -DCONFIG_SERVER_URL=$CONFIG_SERVER_URL \
 -jar integration-service-1.0.0.jar"]
