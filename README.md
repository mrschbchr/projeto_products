## Projeto de carrinho de pedidos

### Dependencias para executar o projeto

 - JDK 17 - https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
 - PostgreSQL Database 16 - https://www.postgresql.org/about/news/postgresql-162-156-1411-1314-and-1218-released-2807
 - Gradle 

### Construção do projeto
Projeto foi construido utilizando o framework Springboot com os packs iniciais de RESTful e JPA, projeto base criado utilizando a ferramenta spring initializr (https://start.spring.io/)

### Módulos
#### Estrutura
Todos os módulos possuem as finções ```/list```, ```/create```, ```/update```, ```/delete?uuid={uuid}``` e ```/read?uuid={uuid}```.
 - ```/list```: Executa a função *list* do módulo order para listar todos os pedidos
 - ```/create```: Executa a função *save* do módulo order para criar o pedido ***Detalhe: Para salvar deve ser informado o pedido total para que ele crie o registro com as informações dos campos*** 
 - ```/update```: Executa a função *update* do módulo order para atualizar o pedido ***Detalhe: Para atualizar deve ser informado o registro total para que ele atualize os campos*** 
 - ```/delete?uuid={uuid}```: Executa a função *delete* do módulo order para remover o pedido ***Detalhe: Para excluir deve ser informado o UUID do registro para realizar a exclusão*** 
 - ```/read?uuid={uuid}```: Executa a função *read* do módulo order para criar o pedido ***Detalhe: Para listar deve ser informado o UUID do registro para realizar a leitura***
##### Módulos disponíveis
***Módulos criados***:
 - ```/order```
 - ```/order_itens```
 - ```/item```
