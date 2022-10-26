package br.ufrn.imd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.ufrn.imd.entity")
@EnableJpaRepositories("br.ufrn.imd.repository")
public class FakeNewsApplication {
    public static void main(String[] args) {
        // var cosine = new CosineAlgorithm();
        // var jaroWinkler = new JaroWinklerAlgorithm();
        // var levenshtein = new LevenshteinAlgorithm();

        // var list = List.of("antes apenas bandido bolsonaro brasil campos carteirinha
        // contatos contra corrente demais desmascarar enviar esclarecidos essa este
        // folha incautos inteiro jornalista materia mello minuto para patricia petista
        // precisam quebre seja tarde voce", "a terra e plana", "tomar cafe evita
        // cancer");

        // String left = "a terra e plana";
        // String right = "bolsonaro não forjou a facada";

        // System.out.println("\"" + left + "\" e \"" + right + "\":");
        // System.out.println( "Cosine: " + cosine.calculate(left, right) );
        // System.out.println( "Jaro-Winkler: " + jaroWinkler.calculate(left, right) );
        // System.out.println( "Levenshtein: " + levenshtein.calculate(left, right) );

        // System.out.println("\"" + left +"\" comparado com a lista:");
        // System.out.println( "Cosine: " + cosine.average(left, list) );
        // System.out.println( "Jaro-Winkler: " + jaroWinkler.average(left, list) );
        // System.out.println( "Levenshtein: " + levenshtein.average(left, list) );

        // try {
        // ReadCsv.readCsv("src/main/resources/fake-news.csv")
        // .stream()
        // .skip(1)
        // .map(data -> new News(data))
        // .forEach(news -> System.out.println(news.toString()));
        // } catch (IOException | CsvException e) {
        // e.printStackTrace();
        // }

        SpringApplication.run(FakeNewsApplication.class, args);
    }
}
