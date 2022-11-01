package br.ufrn.imd.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/uploadFile")
    public Double uploadFile(@RequestParam("file") MultipartFile file, Algorithm alg) throws IOException, CsvException  {
        
        List<News> newsArray = NewsRepository.CSVtoNEWS(file.getInputStream());
        List<News> newsArray2 = fileService.load();

        List<String> test = newsArray2.stream().map(news -> news.getOriginalText()).collect(Collectors.toList());

        return newsArray.stream()
                  .mapToDouble(news -> alg.average(news.getOriginalText(), test))
                  .average()
                  .orElse(0);
    }
}
