package br.ufrn.imd.algorithm;

import java.util.stream.Stream;

public interface Algorithm {
    public abstract Double calculate(CharSequence left, CharSequence right);

    public default Double average(CharSequence left, Stream<String> rights) {
        return rights.mapToDouble(right -> this.calculate(left, right))
                .average()
                .orElse(0);
    }

    public static Algorithm fromId(int id) {
        if (id == 0) {
            return new CosineAlgorithm();
        } else if (id == 1) {
            return new JaroWinklerAlgorithm();
        } else {
            return new LevenshteinAlgorithm();
        }
    }
}
