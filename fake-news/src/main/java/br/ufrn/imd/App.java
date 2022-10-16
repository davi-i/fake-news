package br.ufrn.imd;

import br.ufrn.imd.algorithm.CosineAlgorithm;
import br.ufrn.imd.algorithm.JaroWinklerAlgorithm;
import br.ufrn.imd.algorithm.LevenshteinAlgorithm;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var cosine = new CosineAlgorithm();
        var jaroWinkler = new JaroWinklerAlgorithm();
        var levenshtein = new LevenshteinAlgorithm();

        String left = "bolsonaro forjou a facada";
        String right = "bolsonaro não forjou a facada";

        System.out.println("\"" + left + "\" e \"" + right + "\":");
        System.out.println( "Cosine: " + cosine.calculate(left, right) );
        System.out.println( "Jaro-Winkler: " + jaroWinkler.calculate(left, right) );
        System.out.println( "Levenshtein: " + levenshtein.calculate(left, right) );
    }
}
