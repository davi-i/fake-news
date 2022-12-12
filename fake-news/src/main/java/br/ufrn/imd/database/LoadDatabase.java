package br.ufrn.imd.database;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opencsv.exceptions.CsvException;

import br.ufrn.imd.repository.NewsRepository;

@Configuration
class LoadDatabase {
  @Bean
  CommandLineRunner initDatabase(NewsRepository repository) {
    return args -> {
      try {
        NewsRepository.CsvToNews("src/main/resources/fake-news.csv")
            .stream()
            .forEach(news -> repository.save(news));
      } catch (IOException | CsvException e) {
        e.printStackTrace();
      }
    };
  }
}
