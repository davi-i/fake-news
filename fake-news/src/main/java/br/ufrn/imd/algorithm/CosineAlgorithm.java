package br.ufrn.imd.algorithm;

import org.apache.commons.text.similarity.CosineDistance;

public class CosineAlgorithm implements Algorithm {
    public Double calculate(CharSequence left, CharSequence right) {
        var distance = new CosineDistance();
        return 1 - distance.apply(left, right);
    }
}
