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

O backend é desenvolvido em **Spring Boot**, organizado em camadas (controller, service, repository, model), facilitando a manutenção e futura evolução da aplicação.

### Estrutura de Pastas

```plaintext
├── build
│   ├── classes
│   │   └── java
│   │       └── main
│   │           └── br
│   │               └── com
│   │                   └── fiap
│   │                       └── wefood
│   │                           ├── domain
│   │                           │   └── model
│   │                           ├── dto
│   │                           ├── mapper
│   │                           ├── repository
│   │                           │   └── dao
│   │                           │       └── mapper
│   │                           └── utils
    └── resources
        └── application.properties
Dockerfile
docker-compose.yml
README.md