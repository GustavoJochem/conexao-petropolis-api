# Conexão Petrópolis

Projeto para a disciplina de Projetos e Atividades de Extensão do curso de Engenharia de Computação da Universidade Católica de Petrópolis.

![Logo UCP](src/main/resources/static/logo-ucp.png)

## Descrição do Projeto

O **Conexão Petrópolis** é uma plataforma digital que visa dar visibilidade a projetos sociais, eventos de caridade e iniciativas comunitárias na cidade de Petrópolis. Através de um website intuitivo e acessível, buscamos conectar cidadãos, organizações e voluntários, promovendo solidariedade e facilitando o engajamento em causas sociais.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para construção de aplicações web.
- **LocalStack**: Ferramenta de desenvolvimento que simula serviços da AWS localmente, permitindo que desenvolvedores testem e desenvolvam aplicações em um ambiente que replica a nuvem.
- **AWS**:
  - **Amazon S3**: Armazenamento de imagens dos eventos.
  - **Amazon RDS**: Banco de dados relacional (PostgreSQL).
  - **Amazon CloudWatch**: Monitoramento e logging da aplicação.

## Estrutura do Projeto

1. **Camada de Apresentação (Controller)**: Gerencia requisições HTTP e mapeia rotas da API.
2. **Camada de Serviço (Service)**: Contém a lógica de negócios e interage com os repositórios.
3. **Camada de Persistência (Repository)**: Interage com o banco de dados usando Spring Data JPA.
4. **Modelo de Dados (Model)**: Define as entidades que representam os dados (ex: Evento, Projeto).
5. **Configuração (Config)**: Configurações do Spring Boot, integração com AWS S3 e CloudWatch.

## Diagrama de Arquitetura

```plaintext
+-------------------------+
|     Usuário/Cliente     |
+-------------------------+
           |
           | (Requisições HTTP)
           v
+-------------------------+
|     Aplicação Spring    |
|          Boot           |
|                         |
|  +-------------------+  |
|  |   Controller      |  |
|  +-------------------+  |
|  |   Service         |  |
|  +-------------------+  |
|  |   Repository      |  |
|  |   (JPA)           |  |
|  +-------------------+  |
|                         |
|  +-------------------+  |
|  |   AWS S3 Client   |  |
|  +-------------------+  |
|  |   AWS RDS Client  |  |
|  +-------------------+  |
+-------------------------+
           |
           | (JPA)
           v
+-------------------------+
|      Amazon RDS         |
|     PostgreSQL DB       |
+-------------------------+
           |
           | (Armazena a URL das imagens)
           v
+-------------------------+
|        Amazon S3        |
|        (Imagens)        |
+-------------------------+
           |
           | (Metricas & Logs)
           v
+-------------------------+
|     Amazon CloudWatch   |
+-------------------------+
```

### Descrição dos Componentes

- **Usuário/Cliente**: Interage com a aplicação através de chamadas HTTP (REST API).
- **Controller**: Recebe requisições HTTP e chama os serviços apropriados.
- **Service**: Realiza operações como cadastro de eventos e manipulação de imagens.
- **Repository (JPA)**: Facilita a interação com o banco de dados PostgreSQL.
- **AWS Clients**: Utilizados para interagir com S3 e RDS, gerenciando o armazenamento de imagens e informações dos eventos.
- **Amazon RDS**: Banco de dados relacional para armazenar informações.
- **Amazon S3**: Armazena imagens de eventos.
- **Amazon CloudWatch**: Monitora a aplicação, coletando logs e métricas.

## Pré-requisitos

- Java 21 ou superior
- Maven
- Docker

## Passos para Executar

1. **Clonar o Repositório**:
    ```bash
    git clone https://github.com/GustavoJochem/conexao-petropolis-api
    cd conexao-petropolis-api
    ```

2. **Checkout para sua Branch**:
    ```bash
    git checkout <nome-da-sua-branch>
    ```

3. **Compilar a Aplicação**:
    ```bash
    mvn clean install
    ```

4. **Iniciar os serviços Docker para o LocalStack**:
    ```bash
    docker-compose up -d
    ```

5. **Executar a Aplicação**:
    ```bash
    mvn spring-boot:run
    ```

6. **Documentação da API**: Disponível em `http://localhost:8080/swagger-ui.html`.

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).
