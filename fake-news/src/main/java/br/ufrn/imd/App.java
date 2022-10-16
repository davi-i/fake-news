package br.ufrn.imd;

import br.ufrn.imd.algorithm.CosineAlgorithm;
import br.ufrn.imd.algorithm.JaroWinklerAlgorithm;
import br.ufrn.imd.algorithm.LevenshteinAlgorithm;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        var cosine = new CosineAlgorithm();
        var jaroWinkler = new JaroWinklerAlgorithm();
        var levenshtein = new LevenshteinAlgorithm();

        var list = List.of("antes apenas bandido bolsonaro brasil campos carteirinha contatos contra corrente demais desmascarar enviar esclarecidos essa este folha incautos inteiro jornalista materia mello minuto para patricia petista precisam quebre seja tarde voce", "a terra e plana", "tomar cafe evita cancer");

        String left = "a terra e plana";
        String right = "bolsonaro não forjou a facada";

        System.out.println("\"" + left + "\" e \"" + right + "\":");
        System.out.println( "Cosine: " + cosine.calculate(left, right) );
        System.out.println( "Jaro-Winkler: " + jaroWinkler.calculate(left, right) );
        System.out.println( "Levenshtein: " + levenshtein.calculate(left, right) );

        System.out.println("\"" + left +"\" comparado com a lista:");
        System.out.println( "Cosine: " + cosine.average(left, list) );
        System.out.println( "Jaro-Winkler: " + jaroWinkler.average(left, list) );
        System.out.println( "Levenshtein: " + levenshtein.average(left, list) );
    }
}
