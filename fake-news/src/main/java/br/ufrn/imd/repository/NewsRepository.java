package br.ufrn.imd.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opencsv.exceptions.CsvException;

import br.ufrn.imd.entity.News;
import br.ufrn.imd.io.ReadCSV;

public interface NewsRepository extends JpaRepository<News, Long> {
    public static List<News> CSVtoNEWS(String path) throws IOException, CsvException {
        try {
            List<News> news_array = new ArrayList<News>();
            ReadCSV.readCSV(path)
                        .stream()
                        .skip(1)
                        .map(data -> new News(data))
                        .forEach(news -> news_array.add(news));
            return news_array;
          } catch (IOException | CsvException e) {
            e.printStackTrace();
            throw e;
          }
    }

    public static List<News> CSVtoNEWS(InputStream is) throws IOException, CsvException {
        try {
            List<News> news_array = new ArrayList<News>();
            ReadCSV.readCSV(is)
                        .stream()
                        .skip(1)
                        .map(data -> new News(data))
                        .forEach(news -> news_array.add(news));
            return news_array;
          } catch (IOException | CsvException e) {
            e.printStackTrace();
            throw e;
          }
    }
}
