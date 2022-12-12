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
    public static List<News> CsvToNews(List<String[]> lines) {
        List<News> news_array = new ArrayList<News>();
        lines.stream()
                .skip(1)
                .map(data -> new News(data))
                .forEach(news -> news_array.add(news));
        return news_array;
    }

    public static List<News> CsvToNews(String path) throws IOException, CsvException {
        return CsvToNews(ReadCSV.readCSV(path));
    }

    public static List<News> CsvToNews(InputStream is) throws IOException, CsvException {
        return CsvToNews(ReadCSV.readCSV(is));
    }
}
