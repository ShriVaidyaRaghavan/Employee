FROM openjdk:11-jre
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/EmployeeInfo1-0.0.1-SNAPSHOT.jar employeeinfo1.jar
EXPOSE 3000
ENTRYPOINT exec java $JAVA_OPTS -jar employeeinfo1.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar employeeinfo.jar