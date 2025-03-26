# Desafio Backend - Plataforma de Pagamentos Simplificada

Este repositório contém a estrutura inicial do projeto desenvolvido como resposta ao desafio técnico proposto. A solução visa implementar uma plataforma de pagamentos simplificada, permitindo transferências entre usuários e lojistas, conforme descrito no enunciado do desafio.

## 🛠️ Tecnologias e Ferramentas Utilizadas

- ☑️ **Java 21**
- ☑️ **Spring Boot 3.4.4**
- ☑️ **Spring Web**
- ☑️ **Spring Data JPA**
- ☑️ **Bean Validation (javax.validation)**
- ☑️ **MySQL** (via Docker Compose)
- ☑️ **Lombok**
- ☑️ **Maven**
- ☑️ **JUnit (Testes)**

## Funcionalidades a Serem Implementadas

- Cadastro de usuários com validação de CPF e e-mail únicos
- Transferência de valores entre usuários
- Validação de saldo antes da transferência
- Consulta de serviço autorizador externo
- Envio de notificações via serviço externo
- Operações realizadas com transação (rollback em falhas)
- Padrão RESTful para comunicação com a API

## Como Executar

1. Certifique-se de ter o **Docker** e **Docker Compose** instalados
2. Configure o banco de dados MySQL (um `docker-compose.yml` será adicionado posteriormente)
3. Execute o projeto via IDE ou terminal com:
```bash
./mvnw spring-boot:run
```

## ⏳ Progresso

:white_check_mark: Projeto iniciado

:hourglass_flowing_sand: Implementação de entidades e regras de negócio

## ✅ Testes

O projeto contará com cobertura de testes de unidade e testes de integração utilizando o JUnit.

## 👤 Autor

**Waldir Chagas Leite Júnior**  
[LinkedIn](https://www.linkedin.com/in/waldirjuniorgpn/)  

