package com.tlglearning.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Comparator;
import java.util.Map.Entry;

/**
 * Demonstrates the practice of word counting, used (for example) in authorship studies.
 * This demonstration uses (in the included methods) implementations of the {@link java.util.Map},
 * {@link java.util.Map.Entry}, and {@link java.util.stream.Stream} interfaces.
 */
public final class Main {

  private static final String TEST_FILE_NAME = "hound-of-the-baskervilles.txt";

  private Main() {}

  /**
   * Creates an instance of  {@link WordCounter}, using it to process the contents of "The Hound of
   * the Baskervilles", by Arthur Conan Doyle. After processing, the word counts (excluding short
   * words) are in descending order.
   * <p>This method assumes that a text file named {@code hound-of-the-baskervilles.txt} is located
   * on the classpath; otherwise (or if that file cannot be read for some reason), an instance of
   * {@link IOException} is thrown.</p>
   *
   * @param args Command-line arguments (currently ignored).
   * @throws IOException Thrown if input file cannot be located or read.
   */
  public static void main(String[] args) throws IOException {
    try (
        InputStream input = Main.class.getClassLoader().getResourceAsStream(TEST_FILE_NAME);
        Reader reader = new InputStreamReader(input);
        BufferedReader buffer = new BufferedReader(reader)
    ) {
      WordCounter counter = new WordCounter();
      String line;
      while ((line = buffer.readLine()) != null) {
        //TODO pass line to a method of WordCounter.
        counter.add(line);
      }

      counter
          .getCounts()
          .entrySet()
          .stream()
          .sorted(Comparator.comparing(Entry<String, Integer>::getValue).reversed())
          .limit(10)
          .forEach(System.out::println);
    }
  }
}
