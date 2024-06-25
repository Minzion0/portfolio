FROM openjdk:17
LABEL maintainer="aert12435@gmail.com"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/portfolio-0.0.1-SNAPSHOT.jar

RUN echo "test.."
ADD ${JAR_FILE} portfolio.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/portfolio.jar"]
