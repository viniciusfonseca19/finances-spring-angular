# 💰 Finance App

Aplicação **Full Stack** para controle financeiro pessoal, permitindo cadastro de usuários, autenticação, visualização de saldo e gerenciamento de transações (entradas e saídas).

Projeto desenvolvido com **Angular no frontend** e **Java + Spring Boot no backend**, seguindo uma estrutura profissional em **monorepo**.

---

## 🧠 Funcionalidades

### 🔐 Autenticação
- Cadastro de usuário
- Login
- Logout
- Proteção de rotas

### 📊 Dashboard
- Visualização do saldo total
- Listagem de transações
- Integração direta com o backend

### 💸 Transações
- Cadastro de transações
- Entradas e saídas financeiras
- Atualização automática do saldo

---

## 🏗️ Arquitetura do Projeto

finance/
├── backend/ # API REST em Spring Boot
├── frontend/ # Aplicação Angular
├── .gitignore
└── README.md


---

## 🚀 Tecnologias Utilizadas

### 🔙 Backend
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Maven
- Banco de Dados (MySQL / PostgreSQL)

### 🎨 Frontend
- Angular
- TypeScript
- HTML5
- CSS3
- Angular Forms
- Angular Router
- HttpClient

### 🛠️ Ferramentas
- Git & GitHub
- IntelliJ IDEA
- Visual Studio Code
- Insomnia / Postman

---

## ▶️ Como Rodar o Projeto

### 🔧 Backend
cd backend

./mvnw spring-boot:run
A API será iniciada em:
http://localhost:8080


🎨 Frontend

cd frontend
npm install
ng serve

A aplicação estará disponível em:
http://localhost:4200

🔗 Integração Frontend ↔ Backend
O frontend consome a API REST do backend usando HttpClient.

Exemplo de URL base:

http://localhost:8080
📌 Status do Projeto
🚧 Em desenvolvimento
Novas funcionalidades serão adicionadas, como:

Categorias de gastos

Gráficos financeiros

Filtros por período

Deploy em cloud

👨‍💻 Autor
Vinícius Fonseca
Desenvolvedor Backend | Full Stack

☕ Java & Spring Boot

🌐 Angular | TypeScript

💾 SQL & NoSQL

⭐ Observação
Este projeto faz parte do meu portfólio profissional, com foco em boas práticas, organização de código e arquitetura Full Stack.

Se curtir, deixa uma ⭐ no repositório!
