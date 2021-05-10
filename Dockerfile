FROM demo/java:11
EXPOSE 8080
ADD /target/superheroes.jar superheroes.jar
ENTRYPOINT ["java", "-jar", "superheroes.jar"]