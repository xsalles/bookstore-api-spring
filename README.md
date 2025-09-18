# Bookstore API

## 📌 Visão Geral

Este projeto é o backend da **Bookstore API**, uma solução RESTful desenvolvida em **Java 21** com **Spring Boot 3**, **JPA/Hibernate** e banco de dados relacional. O objetivo é fornecer uma plataforma robusta para cadastro, consulta, atualização, empréstimo e devolução de livros, com foco em validação, tratamento global de exceções e boas práticas de arquitetura.

O sistema foi projetado para ser modular, seguro e facilmente extensível, utilizando validação de dados, tratamento global de exceções e separação clara de responsabilidades entre camadas (controllers, services, repositories, DTOs e handlers).

---

## 🗂️ Estrutura do Projeto

```
src/
  main/
    java/
      com/bookstore/main/
        common/                # DTOs, enums e handlers globais
        modules/
          Books/               # Modelos, controllers, services, repositórios, exceptions e handlers de livros
    resources/
      application.properties   # Configurações da aplicação
```

---

## 🧩 Modelos Principais

- **BookModel**: Representa livros, com validação de campos (autor, título, gênero, ISBN, ano de publicação e status).
- **Enums**: `Status` define a disponibilidade do livro (`AVAILABLE`, `UNAVAILABLE`).

---

## 🚀 Rotas e Funcionalidades

### 📚 Livros (`/books`)

- `POST /books/create` — Cadastro de novo livro.
- `GET /books` — Lista todos os livros cadastrados.
- `GET /books/{id}` — Detalhes de um livro específico.
- `PUT /books/{id}` — Atualização de dados de um livro.
- `DELETE /books/{id}` — Exclusão de um livro.
- `PATCH /books/make-loan/{id}` — Realiza empréstimo de um livro (marca como indisponível).
- `PATCH /books/return-book/{id}` — Devolução de um livro (marca como disponível).

---

## ⚙️ Principais Implementações e Boas Práticas

- **Validação de Dados**: Uso extensivo de anotações do Bean Validation (`@NotBlank`, `@Pattern`, `@NotNull`, `@ISBN`) para garantir integridade dos dados.
- **Tratamento Global de Erros**: Handlers globais para exceções de validação, entidades não encontradas, duplicidade e erros de padrão.
- **DTOs e Responses Customizadas**: Todas as respostas seguem um padrão consistente com mensagem, status e dados.
- **Relacionamentos JPA**: Mapeamento correto de entidades e uso de sequências para geração de IDs.
- **Boas Práticas de Organização**: Separação clara de camadas, uso de Lombok para reduzir boilerplate, versionamento seguro.

---

## 🔄 Fluxo de Funcionamento

1. **Cadastro**: Livros são cadastrados com validação de todos os campos obrigatórios.
2. **Consulta**: É possível listar todos os livros ou consultar por ID.
3. **Atualização e Exclusão**: Livros podem ser atualizados ou removidos.
4. **Empréstimo e Devolução**: Controle de disponibilidade do livro via endpoints específicos.
5. **Validação e Segurança**: Todos os dados são validados e erros tratados de forma padronizada.

---

## 📚 O que aprendi com este projeto

- **Spring Boot Profissional**: Estruturação de projetos, injeção de dependências e configuração avançada.
- **Validação e Tratamento de Erros**: Aplicação de validação declarativa e tratamento global de exceções para APIs REST.
- **JPA/Hibernate**: Mapeamento de entidades, uso de sequências e integração com bancos relacionais.
- **Boas Práticas de API REST**: Padrão de respostas, organização modular e documentação de rotas.
- **Clean Code & Arquitetura**: Separação de responsabilidades, uso de DTOs, services, handlers e providers.

---

## 📝 Licença

[MIT](LICENSE)

---

**Desenvolvido com dedicação, foco em qualidade e melhores práticas de backend moderno.**
