package br.ufrn.imd.algorithm;

import org.apache.commons.text.similarity.LevenshteinDistance;
import java.lang.Math;

public class LevenshteinAlgorithm implements Algorithm {
    public Double calculate(CharSequence left, CharSequence right) {
        var algorithm = new LevenshteinDistance();
        var value = new Double(algorithm.apply(left, right));
        return 1 - value / Math.max(left.length(), right.length());
    }
}
