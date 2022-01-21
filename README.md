# TodoList as a microservice
TodoList is a simple todo list project, which I developed using spring, and spring cloud as my first microservices architecture project.
# Docker
If you want to run more than one instance of each micro service, then you better run them as a docker containers.
To build a docker container of any micro service you will need to add a docker directory, in that directory put the jar file for the micro service then add a ```Dockerfile``` in the folder, the content of the docker file should look like the following.
```
FROM openjdk:17
ADD /jarfilename.jar //
EXPOSE 8080
ENV ENCRYPT_KEY=your encryption key
ENTRYPOINT ["java", "-jar", "jarfilename.jar"]
```
First of all the JDK image should be version 17 or later, the port should be similar to the port used in the micro service, and last things last the ENCRYPT_KEY environment variable should contain an encryption key which the application will use to encrypt, or decrypt private fields in the configuration files (You can remove it and keep the configuration without encryption, but it is recommended that you encrypt any sensitive data).
#### Default port for each micro service
application|Port
------------|----
discovery service|8761
config service|8080
user service|8080
list service|8080
todo service|8080
postgres database|5432
***
