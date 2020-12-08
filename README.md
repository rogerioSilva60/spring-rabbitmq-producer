# Spring Boot com RabbitMQ - Producer
>Integração de dados

Projeto voltado para integração de dados utilizando o RabbitMQ como gerenciador da fila. 

## Instalação
- [JDK 11: Necessário para executar o projeto Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3.6.3: Necessário para realizar o build do projeto Java](https://maven.apache.org/docs/3.6.3/release-notes.html)
- [Spring Tools 4 for Eclipse: Para desenvolvimento do projeto](https://spring.io/tools)
- [Docker: Necessário para gerar e rodar a imagem dos projetos (Opcional)](https://docs.docker.com/get-docker/)
- [RabbitMQ: Deve ser gerado pelo docker](https://www.rabbitmq.com/)

### Comando para executar no Docker antes de rodar o projeto

*Instalação do RabbitMQ*
```d
docker run -d -p 15672:15672 -p 5672:5672 --name rabbitmq rabbitmq:3-management
```

## Documentação

Basta acessar a url: http://localhost:8080/swagger-ui.html#/ na máquina que esteja executando o projeto e terá a documentação da api pelo Swagger.

![spring-rabbitmq-producer](https://user-images.githubusercontent.com/23174611/101501076-0c358b00-394e-11eb-8805-cfb2cdabe8a7.png)

## Meta

Rogério Silva - rogerioSilva60@gmail.com

[https://github.com/rogerioSilva60/spring-rabbitmq-producer](https://github.com/rogerioSilva60)
