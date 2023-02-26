# Goals

Este projeto é um exemplo de construção da arquitetura hexagonal, trazendo um simples CRUD. 

## Arquitetura 

 - **Domain** - Essa camada contém a regra de negócio da aplicação. 
 Nela, são exportadas interfaces (port) para que os providers possam implementar. 
 - **Provider** - Nessa camada são implementadas as interfaces exportadas pela camada de
 domain. Com o objetivo de suplementar as necessidades do domain. Como exemplo o uso do banco de dados. 
 - **Api-UI** - Camada responsável por receber as requisições dos usuários e encaminhar para o domain 
realizar a operação requisitada. 
 - **Application** - Essa é a camada responsável por executar a aplicação, nela estão as configurações e as properties.


