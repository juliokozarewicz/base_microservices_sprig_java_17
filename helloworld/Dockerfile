# Etapa 1: Usar a imagem oficial do OpenJDK para compilar a aplicação
FROM openjdk:17-jdk-slim as build

# Definir diretório de trabalho
WORKDIR /app

# Copy the executable JAR file to the working directory
COPY build/libs/helloworld-0.0.1-SNAPSHOT.jar /app/app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]