package br.ufrn.imd.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvException;

import br.ufrn.imd.algorithm.Algorithm;
import br.ufrn.imd.entity.News;
import br.ufrn.imd.repository.NewsRepository;
import br.ufrn.imd.service.NewsService;
import br.ufrn.imd.string.StringProcessor;

@RestController
public class CSVAccuracy {

    @Autowired
    NewsService newsService;

    @CrossOrigin()
    @PostMapping("/accuracy/file")
    public Double accuracy(@RequestParam("file") MultipartFile file, @RequestParam("idAlgorithm") int idAlgorithm)
            throws IOException, CsvException {

        var fileNews = NewsRepository.csvToNews(file.getInputStream());
        var storedNews = newsService.load();

        var newsText = storedNews.stream().map(news -> news.getFormattedText());

        var algorithm = Algorithm.fromId(idAlgorithm);

        return fileNews.stream()
                .mapToDouble(news -> algorithm.max(news.getFormattedText(), newsText))
                .average()
                .orElse(0);
    }

    @CrossOrigin()
    @PostMapping("/accuracy")
    public Double accuracy(@RequestParam("news") String newsText, @RequestParam("idAlgorithm") int idAlgorithm)
            throws IOException, CsvException {

        var storedNews = newsService.load();
        var test = storedNews.stream().map(news -> news.getFormattedText());

        var algorithm = Algorithm.fromId(idAlgorithm);

        return algorithm.max(StringProcessor.process(newsText), test);
    }
}
