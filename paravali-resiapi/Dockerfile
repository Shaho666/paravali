FROM java:8
EXPOSE 8001
ARG JAR_FILE
ADD target/${JAR_FILE} /paravali-restapi.jar
ENTRYPOINT ["java", "-jar","/paravali-restapi.jar"]