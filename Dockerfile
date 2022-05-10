FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/contacts-0.0.1-SNAPSHOT.jar contacts.jar
ENTRYPOINT ["java","-jar","/contacts.jar"]