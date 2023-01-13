# Desafio
Este é um projeto maven desenvolvido na IDE Spring Tool Suite. O projeto conta com duas entidades, são elas: PhysicalStore (Loja Física) e VirtualStore (Loja Virtual).
Para executar a aplicação é só rodar a classe em /Desafio/src/main/java/com/rpetech/desafio

# O que foi feito no projeto?

- Foi criada uma classe Repository para cada uma das entidades estendendo o JpaRepository;
- Foi criado um serviço para cada umas das entidades com as quatro operações básicas de um CRUD;
- Foi criado um Rest Controller para cada uma das entidades com as quatro operações básicas de um CRUD  e foram definidos os endpoints de acesso;
- Foram realizados alguns testes unitários para as classes: PhysicalStoreConverterService, VirtualStoreConverterService, PhysicalStoreDto e VirtualStoreDto

As quatro operações básicas de cada entidade foram testadas com o Insomnia. 
Link para realizar a instalação do insomnia: https://insomnia.rest/download
