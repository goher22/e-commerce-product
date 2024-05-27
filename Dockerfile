FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/mic-e-commerce-product-1.0.0.jar
COPY ${JAR_FILE} app_product.jar
EXPOSE 8000
ENTRYPOINT [ "java", "-jar", "app_product.jar" ]