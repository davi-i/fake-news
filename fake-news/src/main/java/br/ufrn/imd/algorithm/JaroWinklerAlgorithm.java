package br.ufrn.imd.algorithm;

import org.apache.commons.text.similarity.JaroWinklerDistance;

public class JaroWinklerAlgorithm implements Algorithm {
    public Double calculate(CharSequence left, CharSequence right) {
        var algorithm = new JaroWinklerDistance();
        return algorithm.apply(left, right);
    }
}
