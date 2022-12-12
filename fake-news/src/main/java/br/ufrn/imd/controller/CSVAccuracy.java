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

@RestController
public class CSVAccuracy {

    @Autowired
    NewsService fileService;

    @CrossOrigin()
    @PostMapping("/accuracy/file")
    public Double accuracy(@RequestParam("file") MultipartFile file, @RequestParam("idAlgorithm") int idAlgorithm)
            throws IOException, CsvException {

        List<News> newsArray = NewsRepository.CsvToNews(file.getInputStream());
        List<News> newsArray2 = fileService.load();

        List<String> test = newsArray2.stream().map(news -> news.getOriginalText()).collect(Collectors.toList());

        var algorithm = Algorithm.fromId(idAlgorithm);

        return newsArray.stream()
                .mapToDouble(news -> algorithm.average(news.getOriginalText(), test))
                .average()
                .orElse(0);
    }

    @CrossOrigin()
    @PostMapping("/accuracy")
    public Double accuracy(@RequestParam("news") String newsText, @RequestParam("idAlgorithm") int idAlgorithm)
            throws IOException, CsvException {

        List<News> newsArray2 = fileService.load();
        List<String> test = newsArray2.stream().map(news -> news.getOriginalText()).collect(Collectors.toList());

        var algorithm = Algorithm.fromId(idAlgorithm);

        return algorithm.average(newsText, test);
    }
}
