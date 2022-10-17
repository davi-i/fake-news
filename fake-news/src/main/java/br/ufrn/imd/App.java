package br.ufrn.imd;

import br.ufrn.imd.algorithm.CosineAlgorithm;
import br.ufrn.imd.algorithm.JaroWinklerAlgorithm;
import br.ufrn.imd.algorithm.LevenshteinAlgorithm;

import br.ufrn.imd.io.ReadCsv;

import br.ufrn.imd.model.News;

import java.util.List;
import java.io.IOException;

import com.opencsv.exceptions.CsvException;

public class App 
{
    public static void main( String[] args )
    {
        // var cosine = new CosineAlgorithm();
        // var jaroWinkler = new JaroWinklerAlgorithm();
        // var levenshtein = new LevenshteinAlgorithm();

        // var list = List.of("antes apenas bandido bolsonaro brasil campos carteirinha contatos contra corrente demais desmascarar enviar esclarecidos essa este folha incautos inteiro jornalista materia mello minuto para patricia petista precisam quebre seja tarde voce", "a terra e plana", "tomar cafe evita cancer");

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

        try {
            ReadCsv.readCsv("src/main/resources/fake-news.csv")
                   .stream()
                   .skip(1)
                   .map(data -> new News(data))
                   .forEach(news -> System.out.println(news.toString()));
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
