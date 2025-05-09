# Tech Challenge - Sistema de Gestão para Restaurantes

## Visão Geral

O **Tech Challenge** é um projeto prático da pós graduação de Arquitetura e Desenvolvimento Java da FIAP, para a criação de um sistema de gestão de restaurantes, desenvolvido em fases. O objetivo principal é possibilitar que vários restaurantes da região utilizem um único sistema eficiente para gerenciar suas operações, reduzindo custos e proporcionando uma boa experiência tanto para restaurantes quanto para clientes.

---

## Objetivo Fase 1

Desenvolver um backend completo e robusto utilizando o framework **Spring Boot**, focado no gerenciamento de usuários. As operações implementadas incluem:

- Criação de usuários
- Atualização e alteração de dados do usuário
- Exclusão de usuários
- Validação de login

O projeto está pronto para ser executado em ambiente Docker, com orquestração via Docker Compose e integração com banco de dados relacional (PostgreSQL, MySQL ou H2). O foco está na fácil replicação e escalabilidade do sistema, seguindo boas práticas de arquitetura, organização e segurança.

---

## Funcionalidades

- **Cadastro de Usuários**: Com os seguintes campos:
    - Nome (String)
    - Email (String)
    - Login (String)
    - Senha (String)
    - Data da última alteração (Date)
    - Endereço

- **Gerenciamento de Usuário**: Permite alteração dos dados já cadastrados.
- **Troca de Senha**: Usuários podem trocar sua senha.
- **Validação de Login**: Verifica usuário e senha para autenticação.
- **Tipos de Usuário**:
    - Dono de Restaurante
    - Cliente

---

## Arquitetura

O backend é desenvolvido em **Spring Boot**, respeitando o SOLID e utilizando a arquitetura hexagonal.

A aplicação é dividida em módulos, cada um com sua responsabilidade específica. O sistema é projetado para ser facilmente escalável e adaptável a novas funcionalidades. A estrutura do projeto é modular e bem definida, permitindo fácil manutenção e evolução.

A arquitetura é baseada em princípios de Clean Architecture, onde as regras de negócio estão isoladas das dependências externas. Isso garante que a lógica do sistema permaneça independente de frameworks e tecnologias específicas.

A comunicação entre os módulos é feita através de interfaces, permitindo que cada módulo possa ser testado e desenvolvido de forma independente.

## Tecnologias Utilizadas
- **Java 21**: Linguagem de programação utilizada para o desenvolvimento do backend.
- **Spring Boot**: Framework utilizado para criar aplicações Java de forma rápida e fácil.
- **Spring Data JPA**: Utilizado para simplificar o acesso a dados e a interação com o banco de dados.
- **Spring Security**: Framework de segurança para autenticação e autorização.
- **H2**: Banco de dados em memória utilizado para testes e desenvolvimento.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar os dados da aplicação.
- **Docker**: Utilizado para criar contêineres e facilitar a execução da aplicação em diferentes ambientes.
- **Docker Compose**: Ferramenta para definir e executar aplicativos Docker com múltiplos contêineres.
- **MapStruct**: Biblioteca para mapeamento de objetos Java, facilitando a conversão entre DTOs e entidades.
- **Swagger**: Ferramenta para documentar e testar APIs RESTful, facilitando a interação com a API.
- **Mockito**: Biblioteca para criar mocks e simular comportamentos em testes unitários.
- **JUnit 5**: Framework de testes utilizado para garantir a qualidade do código.
- **Postman**: Ferramenta para testar APIs RESTful, permitindo enviar requisições e visualizar respostas.

## Execução
Para executar o projeto, siga os passos abaixo:
1. **Clone o repositório**:
   ```bash
   git clone
   ```
2. **Navegue até o diretório do projeto**:
   ```bash
    cd wefood
    ```
3. **Execute o Docker Compose**:
    ```bash
   docker-compose up
   ```
4. **Acesse a aplicação**:
    ```bash
   http://localhost:8080
   ```
5. **Acesse o Swagger**:
    ```bash
   http://localhost:8080/swagger-ui/index.html
   ```
6. **Acesse o Postman**:
     ```bash
    http://localhost:8080/api-docs
    ```

### Estrutura de Pastas

```plaintext
└── src
    ├── main
    │   ├── java
    │   │   └── br
    │   │       └── com
    │   │           └── fiap
    │   │               └── wefood
    │   │                   ├── config
    │   │                   ├── controller
    │   │                   ├── domain
    │   │                   │   └── model
    │   │                   ├── dto
    │   │                   ├── mapper
    │   │                   ├── repository
    │   │                   │   └── user
    │   │                   ├── service
    │   │                   └── utils
        └── resources
            └── application.properties
Dockerfile
docker-compose.yml
README.md