package br.ufrn.imd.database;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opencsv.exceptions.CsvException;

import br.ufrn.imd.entity.News;
import br.ufrn.imd.io.ReadCSV;
import br.ufrn.imd.repository.NewsRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(NewsRepository repository) {
    return args -> {
      try {
        NewsRepository.CSVtoNEWS("src/main/resources/arq.txt")
                      .stream()
                      .forEach(news -> repository.save(news));
      } catch (IOException | CsvException e) {
        e.printStackTrace();
      }
    };
  }
}
