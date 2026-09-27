# AV1-DEV-WEB3

Projeto acadêmico da disciplina **Desenvolvimento Web 3** — microsserviço de cadastro de clientes construído com **Spring Boot**.

## Sobre o projeto

O `automanager` é uma API REST responsável pelo cadastro e gerenciamento de dados de clientes, incluindo seus documentos, endereços e telefones. Cada cliente possui um endereço (relação 1:1) e pode ter múltiplos documentos e telefones (relação 1:N).

## Tecnologias

- Java 17
- Spring Boot 2.6.3
- Spring Data JPA / Spring Data JDBC
- Banco de dados H2 (em memória, usado em runtime)
- Bean Validation (`javax.validation`)
- Lombok
- Maven (com wrapper `mvnw`)

## Estrutura do projeto

```
atvi-autobots-microservico-spring/automanager
├── src/main/java/com/autobots/automanager
│   ├── controles/        # Controllers REST (Cliente, Documento, Endereco, Telefone)
│   ├── Servicos/         # Regras de negócio
│   ├── repositorios/     # Interfaces JPA Repository
│   ├── entidades/        # Entidades JPA (Cliente, Documento, Endereco, Telefone)
│   ├── DTO/Request/      # DTOs de entrada (criação/atualização)
│   ├── DTO/Response/     # DTOs de saída
│   ├── Mappers/          # Conversão entre entidades e DTOs
│   └── exceptions/       # Tratamento global de erros
└── src/test/             # Testes automatizados
```

## Como executar

Pré-requisitos: JDK 17 e Maven (ou use o wrapper incluso).

```bash
cd atvi-autobots-microservico-spring/automanager
./mvnw spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.

Se não conseguir rodar, execute `./mvnw clean` antes e tente novamente.

## Endpoints da API

### Clientes

| Método | Rota            | Descrição                  |
|--------|-----------------|-----------------------------|
| GET    | `/clientes`     | Lista todos os clientes     |
| GET    | `/clientes/{id}`| Busca um cliente por ID     |
| POST   | `/clientes`     | Cadastra um novo cliente    |
| PUT    | `/clientes`     | Atualiza um cliente         |
| DELETE | `/clientes/{id}`| Remove um cliente           |

### Documentos

| Método | Rota              | Descrição                |
|--------|-------------------|----------------------------|
| GET    | `/documentos`     | Lista todos os documentos  |
| GET    | `/documentos/{id}`| Busca um documento por ID  |
| POST   | `/documentos`     | Cadastra um novo documento |
| PUT    | `/documentos`     | Atualiza um documento      |
| DELETE | `/documentos`     | Remove um documento        |

### Endereços

| Método | Rota             | Descrição                 |
|--------|------------------|-----------------------------|
| GET    | `/enderecos`     | Lista todos os endereços    |
| GET    | `/enderecos/{id}`| Busca um endereço por ID    |
| POST   | `/enderecos`     | Cadastra um novo endereço   |
| PUT    | `/enderecos`     | Atualiza um endereço        |
| DELETE | `/enderecos/{id}`| Remove um endereço          |

### Telefones

| Método | Rota             | Descrição                 |
|--------|------------------|-----------------------------|
| GET    | `/telefones`     | Lista todos os telefones    |
| GET    | `/telefones/{id}`| Busca um telefone por ID    |
| POST   | `/telefones`     | Cadastra um novo telefone   |
| PUT    | `/telefones`     | Atualiza um telefone        |
| DELETE | `/telefones/{id}`| Remove um telefone          |

## Modelo de dados

- **Cliente**: nome, nome social, data de nascimento, data de cadastro, endereço (1:1), documentos (1:N), telefones (1:N)
- **Documento**: tipo, número (único), vinculado a um cliente
- **Endereco**: estado, cidade, bairro, rua, número, código postal, informações adicionais
- **Telefone**: DDD, número, vinculado a um cliente

## Autor

Hugo Perestrelo — Fatec São José dos Campos, DSM.
