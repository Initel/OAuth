# Autenticação Federada com Spring Boot, Keycloak, OpenID Connect e SSO

Este repositório apresenta uma arquitetura completa de **autenticação
federada** utilizando **Spring Boot**, **OpenID Connect**, **SSO** e
**Keycloak**.\
O projeto foi desenvolvido para demonstrar, na prática, como implementar
uma solução moderna de autenticação e autorização distribuída em
múltiplos serviços.

A aplicação é dividida em **três módulos**:

-   **Gateway** --- Responsável pelo roteamento e segurança
    centralizada\
-   **Secured Service** --- API protegida que só pode ser acessada com
    token válido\
-   **Front-End (React)** --- Interface web para testes do fluxo de
    autenticação

------------------------------------------------------------------------

## Visão Geral da Arquitetura

    React (Front-End)  →  API Gateway (Spring Boot)  →  Secured Service (Spring Boot)
                               ↓
                           Keycloak (OIDC Provider)

------------------------------------------------------------------------

## Funcionalidades

✔ Autenticação via **Keycloak**\
✔ Fluxo **Authorization Code** com PKCE\
✔ **SSO** completo\
✔ API protegida via OAuth2 Resource Server\
✔ Validação de tokens no Gateway\
✔ Tokens repassados corretamente para o serviço protegido\
✔ Projeto modular, ideal para estudos, demos e empresas

------------------------------------------------------------------------

## Mapeamento de Portas

  Serviço             Porta
  ------------------- -------
  Keycloak            8080

  API Gateway         9000

  Secured Service     8000
  
  Front-End (React)   3000

------------------------------------------------------------------------

## Tecnologias Utilizadas

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

------------------------------------------------------------------------

# 🛠️ Como Executar o Projeto

## Clone o repositório

    git clone https://github.com/Initel/OAuth.git
    cd OAuth

------------------------------------------------------------------------

## Suba o Keycloak com Docker

    docker run -d   --name keycloak   -p 8081:8080   -e KEYCLOAK_ADMIN=admin   -e KEYCLOAK_ADMIN_PASSWORD=admin   quay.io/keycloak/keycloak:latest   start-dev

Acesse o painel:\
👉 http://localhost:8081/

------------------------------------------------------------------------

## Inicie o Gateway

    cd gateway
    ./mvnw spring-boot:run

------------------------------------------------------------------------

## Inicie o Secured Service

    cd secured-service
    ./mvnw spring-boot:run

------------------------------------------------------------------------

## Inicie o Front-End

    cd front-end
    npm install
    npm run dev

Acesse: http://localhost:3000/

------------------------------------------------------------------------

# Fluxo de Teste

1.  Abra o front-end\
2.  Clique em **Login**\
3.  Faça login no Keycloak\
4.  Retorne ao front com o token\
5.  Clique em **Chamar API Protegida**\
6.  Requisição → Gateway → Secured Service\
7.  Resposta protegida exibida

------------------------------------------------------------------------

# Estrutura do Projeto

    /gateway
    /secured-service
    /front-end
    /docs

------------------------------------------------------------------------

# Apontamentos Técnicos

## Secured Service

### application.properties

-   Linha 1 --- **Própria porta do serviço**\
-   Linha 6 --- **URI do Keycloak (com o realm)**

**Porta usada nos testes:** **9000**

------------------------------------------------------------------------

## 🚪 Gateway

### application.yml

-   Linha 2 --- **Porta do gateway**\
-   Linha 13 --- **Client ID (Keycloak)**\
-   Linha 14 --- **Client Secret (Keycloak)**\
-   Linha 16 --- **URI do front-end + `/callback`** (deve estar
    cadastrada no Keycloak)\
-   Linha 19 --- **URI do Realm**\
-   Linha 25 --- **URI + porta do Secured Service**

### SecurityConfig.java

-   Linha 27 --- **Página para redirecionamento após login**

### GatewayApplication.java

Contém lógica extra de mapeamento das informações do usuário
autenticado, útil para integração com outros serviços.

**Porta usada nos testes:** **8000**

------------------------------------------------------------------------

## 🖥️ Front-End (React + Vite)

Dependências básicas importantes:\
- Axios\
- React Router

### App.jsx

-   Tela de login\
-   Linha 14 --- **URL do front com porta + token**

### Vite.config.js

-   Linha 10 --- Regras relacionadas ao Gateway\
-   Linha 16 --- Informações do usuário\
-   Linha 22\
-   Linha 28

### Profile.jsx

-   Linha 9 --- **URI do front com `/userinfo`**\
-   Observação: recomenda-se migrar para memória temporária para evitar
    chamadas repetidas.

**Porta usada nos testes:** **3000**

------------------------------------------------------------------------

# Objetivo do Projeto

-   Demonstrar arquitetura real com **SSO + OIDC**\
-   Template completo para empresas\
-   Base de estudo para microserviços seguros\
-   Integração total entre React, Gateway e serviços protegidos

------------------------------------------------------------------------

# Roadmap

-   [ ] Suporte a Refresh Token\
-   [ ] docker-compose unificado\
-   [ ] RBAC completo no Keycloak\
-   [ ] Documentação detalhada\
-   [ ] Testes automatizados

------------------------------------------------------------------------

# Contribuição

Pull Requests e Issues são bem-vindos!

------------------------------------------------------------------------
