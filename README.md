# Moodify API

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-blue.svg)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

API RESTful para o **Moodify**, uma plataforma inovadora para catalogar e recomendar conteúdos com base no humor do usuário. Em vez de focar em um único tipo de mídia, o Moodify permite que os usuários registrem músicas, vídeos, livros e artigos, associando cada um a um estado de humor.

O principal objetivo é oferecer sugestões personalizadas de conteúdo que correspondam ao estado emocional atual do usuário, ajudando-o a encontrar a mídia perfeita para cada momento.

## ✨ Funcionalidades Principais

- **Autenticação Segura**: Sistema completo de registro e login com autenticação baseada em JSON Web Tokens (JWT).
- **Gerenciamento de Conteúdo**: CRUD completo para `Contents` (conteúdos), `Moods` (humores) e `Platforms` (plataformas).
- **Busca Inteligente**: Endpoints otimizados para:
  - Filtrar conteúdos por um ou mais humores.
  - Buscar conteúdos por tipo (música, vídeo, livro).
  - Listar sugestões personalizadas com base no humor do usuário.
- **Documentação Interativa**: API totalmente documentada com Swagger (OpenAPI) para fácil exploração e teste dos endpoints.
- **Migrações de Banco de Dados**: Versionamento e gerenciamento de schema do banco de dados de forma automatizada com Flyway.

## 🛠️ Tecnologias e Ferramentas

Este projeto foi construído utilizando uma stack moderna e robusta, focada em performance e escalabilidade:

- **Linguagem**: Java 17
- **Framework**: Spring Boot 3
- **Módulos Spring**:
  - `Spring Web`: Para a construção de APIs RESTful.
  - `Spring Data JPA`: Para persistência de dados de forma simplificada.
  - `Spring Security`: Para a implementação de autenticação e autorização com JWT.
- **Banco de Dados**: PostgreSQL
- **Migrations**: Flyway
- **Bibliotecas**:
  - `Lombok`: Para reduzir código boilerplate.
  - `Spring Boot Validation`: Para validação de dados de entrada.
  - `java-jwt`: Para a criação e validação de tokens JWT.
- **Documentação**: `springdoc-openapi` (Swagger UI)

## 🚀 Como Executar o Projeto

Siga os passos abaixo para configurar e executar o projeto em seu ambiente local.

### **Pré-requisitos**

- **Java 17** ou superior
- **Maven 3.8** ou superior
- **PostgreSQL 12** ou superior (pode ser executado localmente ou via Docker)
- Uma IDE de sua preferência (IntelliJ, VS Code, Eclipse)

### Desenvolvido com ❤️ por Gabriel Moreira
