FROM openjdk:11
EXPOSE 8080
COPY target/PhoneBook_app.jar PhoneBook_app.jar
ENTRYPOINT ["java","-jar","/PhoneBook_app.jar"]
