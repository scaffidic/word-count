package com.tlglearning.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

  private static final String TEST_FILE_NAME = "hound-of-the-baskervilles.txt";

  public static void main(String[] args) throws IOException {
    try (
        InputStream input = Main.class.getClassLoader().getResourceAsStream(TEST_FILE_NAME);
        Reader reader = new InputStreamReader(input);
        BufferedReader buffer = new BufferedReader(reader)
    ) {
      WordCounter counter  = new WordCounter();
      String line;
      while ((line = buffer.readLine()) != null) {
        //TODO pass line to a method of WordCounter.
        counter.add(line);
      }
      //TODO do something with WordCounter.
      System.out.println(counter);
    }
  }
}
