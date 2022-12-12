package br.ufrn.imd.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opencsv.exceptions.CsvException;

import br.ufrn.imd.entity.News;
import br.ufrn.imd.io.ReadCSV;

public interface NewsRepository extends JpaRepository<News, Long> {
    public static List<News> csvToNews(List<String[]> lines) {
        return lines.stream()
                .skip(1)
                .map(data -> new News(data))
                .collect(Collectors.toList());
    }

    public static List<News> csvToNews(String path) throws IOException, CsvException {
        return csvToNews(ReadCSV.readCSV(path));
    }

    public static List<News> csvToNews(InputStream is) throws IOException, CsvException {
        return csvToNews(ReadCSV.readCSV(is));
    }
}
