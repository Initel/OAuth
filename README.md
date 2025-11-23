# Autenticação Federada com Spring Boot, Keycloak, OpenID Connect e SSO

Este repositório apresenta uma arquitetura completa de **autenticação
federada** utilizando **Spring Boot**, **OpenID Connect**, **SSO** e
**Keycloak**.\
O projeto foi desenvolvido para demonstrar, na prática, como implementar
uma solução moderna de autenticação e autorização distribuída em
múltiplos serviços.

A aplicação é dividida em **três módulos**:

-   **Gateway** --- Responsável pelo roteamento e segurança centralizada
-   **Secured Service** --- API protegida que só pode ser acessada com
    token válido
-   **Front-End (React)** --- Interface web para testes do fluxo de
    autenticação

## 📌 Visão Geral da Arquitetura

    React (Front-End)  →  API Gateway (Spring Boot)  →  Secured Service (Spring Boot)
                               ↓
                           Keycloak (OIDC Provider)

## 🚀 Funcionalidades

✔ Autenticação via **Keycloak**\
✔ Fluxo **Authorization Code** com PKCE\
✔ **SSO** completo\
✔ API protegida via OAuth2 Resource Server\
✔ Validação de tokens no Gateway\
✔ Tokens repassados corretamente para o serviço protegido\
✔ Projeto modular, ideal para estudos, demos e empresas

## 🔌 Mapeamento de Portas

  Serviço             Porta   Descrição
  ------------------- ------- -------------------------------------
  Keycloak            8081    Servidor de autenticação
  API Gateway         8080    Entrada das requisições e validação
  Secured Service     8082    Microserviço protegido
  Front-End (React)   5173    Interface de testes

## 🧰 Tecnologias Utilizadas

### Back-end

-   Java 21\
-   Spring Boot\
-   Spring Security\
-   Spring Cloud Gateway\
-   OAuth2 Resource Server\
-   OpenID Connect\
-   Maven

### Front-end

-   React\
-   Node.js\
-   Vite

### Infraestrutura

-   Docker / Podman\
-   Keycloak

## 🛠️ Como Executar o Projeto

### 1️⃣ Clone o repositório

    git clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git
    cd SEU_REPOSITORIO

### 2️⃣ Suba o Keycloak com Docker

    docker run -d   --name keycloak   -p 8081:8080   -e KEYCLOAK_ADMIN=admin   -e KEYCLOAK_ADMIN_PASSWORD=admin   quay.io/keycloak/keycloak:latest   start-dev

### 3️⃣ Inicie o API Gateway

    cd gateway
    ./mvnw spring-boot:run

### 4️⃣ Inicie o Secured Service

    cd secured-service
    ./mvnw spring-boot:run

### 5️⃣ Inicie o Front-End (React)

    cd front-end
    npm install
    npm run dev

## ▶️ Fluxo de Teste

1.  Abra o front-end\
2.  Clique em **Login**\
3.  Você será enviado ao Keycloak\
4.  Faça login\
5.  Você será redirecionado de volta ao React com o token\
6.  Clique em **Chamar API Protegida**\
7.  O front envia o token → Gateway → Secured Service\
8.  A resposta protegida é exibida na tela

## 📁 Estrutura do Projeto

    /gateway
        - Configurações de segurança
        - Roteamento
        - Validação de token JWT

    /secured-service
        - Endpoints protegidos
        - Regras de autorização

    /front-end
        - React + Vite
        - Telas de Login e Testes de API

## 🎯 Objetivo do Projeto

Este projeto foi criado para:

-   Demonstrar uma arquitetura prática usando **OpenID Connect + SSO**
-   Servir como base para estudos sobre segurança moderna
-   Ajudar empresas a integrarem OIDC em microserviços
-   Servir como template para projetos corporativos
-   Mostrar como integrar React, Gateway e serviços protegidos com
    Keycloak

## 🧭 Roadmap

-   [ ] Adicionar Refresh Token no front-end\
-   [ ] Criar docker-compose unificado\
-   [ ] Adicionar RBAC completo (Roles e Groups do Keycloak)\
-   [ ] Criar documentação detalhada em /docs\
-   [ ] Adicionar testes automatizados de segurança

## 🤝 Contribuição

Contribuições são muito bem-vindas!\
Abra uma issue ou envie um pull request com melhorias.

## 📄 Licença

Este projeto está sob a licença MIT.
