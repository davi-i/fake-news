# Projeto de PDS

Para executar o projeto:

```
> cd fake-news
> mvn install
> ./mvnw spring-boot:run
```

Para rodar sem erros, é necessário que exista um banco de dados com o nome `fake_news` e que ele tenha uma tabela `news` assim como no arquivo [database.sql](database.sql). Atualize o arquivo [application.properties](fake-news/src/main/resources/application.properties) com as informações adequadas para acessar seu banco de dados.

Por enquanto, o programa só está salvando os conteúdos de [fake-news.csv](fake-news/src/main/resources/fake-news.csv) no banco de dados.
