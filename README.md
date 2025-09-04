Kanban API com Spring Boot
API RESTful para gerenciamento de um quadro Kanban, desenvolvida com Java, Spring Boot e PostgreSQL.

Este projeto fornece um back-end completo para uma aplicação Kanban, permitindo a criação e manipulação de quadros e cartões através de endpoints HTTP. A arquitetura é robusta, em camadas, e utiliza ferramentas modernas do ecossistema Java.

📋 Sobre o Projeto
Esta API foi desenvolvida para ser o cérebro de uma aplicação Kanban. Ela gerencia a lógica de negócio e a persistência de dados, permitindo que diferentes clientes (como um front-end web, uma aplicação mobile ou ferramentas como o Insomnia) interajam com os dados.

A estrutura do banco de dados é gerenciada automaticamente pela ferramenta de migração Liquibase, e os dados são armazenados de forma persistente em um banco PostgreSQL.

✨ Funcionalidades
Endpoints RESTful: Interface HTTP para todas as operações.

Listagem de Quadros e Cartões: Endpoint para visualizar o estado completo do quadro.

Criação de Cartões: Endpoint para adicionar novos cartões a um quadro específico.

Movimentação de Cartões: Endpoint para mover cartões entre quadros.

Persistência de Dados: Os dados são salvos em um banco de dados PostgreSQL.

🛠️ Tecnologias Utilizadas
Java 17

Spring Boot: Framework principal, com os módulos:

Spring Web: Para criação de APIs REST.

Spring Data JPA: Para a camada de persistência de dados.

Gradle: Ferramenta de automação de build.

PostgreSQL: Banco de dados relacional para produção.

Liquibase: Para gerenciamento e versionamento de migrações de banco de dados.

Lombok: Para reduzir a verbosidade do código Java.

Insomnia/Postman: Ferramentas recomendadas para testar os endpoints da API.

DBeaver: Ferramenta recomendada para visualizar e gerenciar o banco de dados.

🏛️ Arquitetura
O projeto segue uma arquitetura em camadas para garantir a separação de responsabilidades:

Controller: Camada que expõe os endpoints da API REST e lida com as requisições e respostas HTTP.

Service: Contém a lógica de negócio da aplicação.

Repository: Camada de acesso a dados, utilizando interfaces do Spring Data JPA.

Model/Entity: Classes que representam as entidades do banco de dados.

DTO (Data Transfer Object): Objetos para transferir dados entre o cliente e a API.

🚀 Como Executar o Projeto
Siga os passos abaixo para configurar e executar a API em sua máquina local.

Pré-requisitos
Java Development Kit (JDK) 17 ou superior.

Gradle (já incluído no projeto via wrapper).

PostgreSQL instalado e rodando.

Um cliente de API como o Insomnia ou Postman.

Um cliente de banco de dados como o DBeaver.

Passo 1: Configuração do Banco de Dados
No seu servidor PostgreSQL, crie um banco de dados vazio. Exemplo: kanban_db.

Abra o arquivo src/main/resources/application.properties.

Localize e edite as seguintes linhas com as suas credenciais do PostgreSQL:

spring.datasource.url=jdbc:postgresql://localhost:5432/kanban_db
spring.datasource.username=seu_usuario_postgres
spring.datasource.password=sua_senha_postgres

Passo 2: Executar a Aplicação
Clone o repositório e navegue até o diretório raiz do projeto.

Execute o comando abaixo para iniciar a API:

./gradlew bootRun

O servidor será iniciado, geralmente na porta 8080. Na primeira execução, o Liquibase irá criar automaticamente as tabelas no seu banco kanban_db.

📡 Endpoints da API (Como usar com Insomnia)
A URL base para a API é http://localhost:8080/api/kanban.

Listar todos os Quadros
Retorna uma lista de todos os quadros e seus cartões aninhados.

Método: GET

URL: /boards

Exemplo de uso no Insomnia: GET http://localhost:8080/api/kanban/boards

Criar um Novo Cartão
Cria um novo cartão em um quadro específico.

Método: POST

URL: /cards

Corpo da Requisição (JSON):

{
  "title": "Implementar testes na API",
  "boardId": 1
}

Exemplo de uso no Insomnia: Crie uma requisição POST para http://localhost:8080/api/kanban/cards, vá para a aba "Body", selecione "JSON" e cole o conteúdo acima.

Mover um Cartão
Move um cartão existente para um novo quadro.

Método: PUT

URL: /cards/{cardId}/move/{newBoardId}

Exemplo de uso no Insomnia: Para mover o cartão de ID 1 para o quadro de ID 2, use a URL: PUT http://localhost:8080/api/kanban/cards/1/move/2. Não é necessário enviar um corpo (Body).

🐘 Visualizando os Dados com DBeaver
Crie uma nova conexão no DBeaver do tipo PostgreSQL.

Preencha os detalhes da conexão:

Host: localhost

Base de Dados: kanban_db (o mesmo nome que você configurou)

Usuário: seu_usuario_postgres

Senha: sua_senha_postgres

Após conectar, navegue por [sua conexão] > Bancos de Dados > kanban_db > Schemas > public > Tabelas.

Você encontrará as tabelas board e card. Dê um duplo-clique nelas para ver os dados que você criou através do Insomnia.

📄 Licença
Este projeto está sob a licença MIT.