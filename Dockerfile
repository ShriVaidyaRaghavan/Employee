FROM openjdk:11-jre
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/*.jar employeeinfo1.jar
EXPOSE 3000
ENTRYPOINT exec java $JAVA_OPTS -jar employeeinfo1.jar
