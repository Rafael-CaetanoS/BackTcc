
[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white

<h1 align="center" style="font-weight: bold;">Resenha Esporte Clube Back-End 💻</h1>

![spring][SPRING_BADGE]
![java][JAVA_BADGE]

<p align="center">
 <a href="#started">Iniciar</a> 
  <a href="#routes">API Endpoints</a> 
</p>

<p align="center">
  <b>Este foi o meu sistema de TCC, que consiste na criação e busca de partidas. Ele permite que o usuário crie e gerencie suas partidas, além de buscar jogos para praticar esportes perto de sua localização.</b>​
</p>


<h2 id="started">🚀 Para dar início ao sistema.</h2>


<h3>Pré-requisitos</h3>

- [Java 17](https://github.com/)
- [PostgreSql](https://github.com)
- [Spring Boot](https://github.com)
- [Spring Security](https://github.com)
- [lombok](https://github.com)
- [Maven](https://github.com)
- [Mysql](https://github.com)
  

<h2 id="routes">📍 API Endpoints</h2>

| route               | description                                          
|----------------------|-----------------------------------------------------
|  <kbd>POST /auth/login</kbd>    | Permite realizar o login na aplicação. [response details](#post-login)
|  <kbd>POST /auth/register</kbd>  | Permite criar um usuário. [request details](#post-register)
|  <kbd>GET /atleta</kbd>  | Busca todos os atletas registrados no sistema. [request details](#post-atletas)
|  <kbd>GET /atleta/{id}</kbd>  | Busca o atleta de acordo com o id dele. [request details](#get-atleta)
|  <kbd>PUT /atleta</kbd>  | Atualiza os dados do atleta. [request details](#get-atleta)
|  <kbd>GET /esporte</kbd>  | Busca todos os esportes registrados no sistema. [request details](#post-atletas)
|  <kbd>GET /esporte/{id}</kbd>  | Busca o esporte de acordo com o id dele. [request details](#get-atleta)
|  <kbd>POST /esporte</kbd>  | Permite criar um novo esporte. [request details](#get-atleta)
|  <kbd>PUT /esporte</kbd>  | Atualiza os dados do esporte. [request details](#get-atleta)
|  <kbd>GET /gerenciar/{idpartida}</kbd>  | Buscar os times da partida. [request details](#get-atleta)
|  <kbd>POST /gerenciar</kbd>  | Salvar os times gerados da paritda. [request details](#get-atleta)
|  <kbd>GET /inscricao</kbd>  | Busca todas as inscrições registradas no sistema. [request details](#post-atletas)
|  <kbd>GET /inscricao/{id}</kbd>  | Busca todas as inscrições de um atleta de acordo com o id dele. [request details](#post-atletas)
|  <kbd>GET /inscricao/partida/{idPartida}</kbd>  | Busca os inscritos de uma partida. [request details](#get-atleta)
|  <kbd>POST /inscricao</kbd>  | O atleta se inscreve em uma partida [request details](#get-atleta)
|  <kbd>PUT /inscricao/cancelar/{id}</kbd>  | Cancelar inscricao em uma partida. [request details](#get-atleta)
|  <kbd>GET /partidas{id}</kbd>  | Busca a partida pelo id dela. [request details](#post-atletas)
|  <kbd>GET /partidas/retornarPartida/{idAtleta</kbd>  | retorna partidas com status = 1 e que não foi criada pelo próprio atleta. [request details](#post-atletas)
|  <kbd>GET /partidas/inscricao/{atletaId}</kbd>  | retorna as partidas que o atleta tá inscrito[request details](#get-atleta)
|  <kbd>GET /partidas/minhasPartidas/{atletaId}</kbd>  |retorna as partidas criadas pelo usuario.[request details](#get-atleta)
|  <kbd>POST /partidas</kbd>  | Criar uma nova partida. [request details](#get-atleta)
|  <kbd>PUT /partidas</kbd>  | Atualizar dados da partida. [request details](#get-atleta)
|  <kbd>PUT /partidas/cancelar/{id}</kbd>  | Cancelar partida de acordo com o id. [request details](#get-atleta)







