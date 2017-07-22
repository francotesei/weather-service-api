#De la imagen que partimos
FROM frolvlad/alpine-oraclejdk8:slim

RUN mkdir -p /usr/src/api


WORKDIR /usr/src/api

# directorio de trabajo
COPY ./target/weather-service-api-1.0-SNAPSHOT.jar /usr/src/api

#Exponemos el puerto 8080
EXPOSE 8080

#Comando que se ejecutará una vez ejecutemos el contendor
CMD ["java","-jar","weather-service-api-1.0-SNAPSHOT.jar"]