FROM openjdk:17
ADD target/WebMVCProject-1.0.jar WebMVCProject-1.0.jar
ENTRYPOINT ["java", "-jar", "/WebMVCProject-1.0.jar"]