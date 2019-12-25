FROM openjdk:8-jre-alpine
ENV APP_HOME /app
EXPOSE 8080
COPY target/*.jar $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -Dspring.profiles.active=native -jar $APP_HOME/*.jar"]