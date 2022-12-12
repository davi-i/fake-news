package br.ufrn.imd.string;

import java.text.Normalizer;
import java.util.Arrays;

public class StringProcessor {
  public static String process(String input) {
    // remove accents
    input = Normalizer.normalize(input, Normalizer.Form.NFD);
    input = input.replaceAll("[^\\x00-\\x7F]", "");
    // remove words with less than 3 letters
    input = input.replaceAll("\\b\\w{1,3}\\b\\s?", "");
    // remove non alfanumeric symbols
    input = input.replaceAll("[^a-zA-Z0-9\\s]", "");

    input = input.toLowerCase();

    var words = input.split("\\s+");
    Arrays.sort(words);

    StringBuilder output = new StringBuilder();

    // Remove repeated strings
    var prev = 0;
    var curr = 1;
    output.append(words[0]);
    while (curr < words.length) {
      if (words[prev].equals(words[curr])) {
        curr++;
        prev++;
        continue;
      }
      output.append(" ");
      output.append(words[curr]);
      curr++;
      prev++;
    }

    return output.toString();
  }
}
