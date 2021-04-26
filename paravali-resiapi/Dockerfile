FROM java:8
EXPOSE 8001
ARG JAR_FILE
ADD target/${JAR_FILE} /paravali-restapi.jar
ENV JAVA_OPTS="-server -Xmx1g -Xms1g -Xmn256m -XX:MaxMetaspaceSize=128M -XX:MetaspaceSize=128M -XX:+DisableExplicitGC -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70"
ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar