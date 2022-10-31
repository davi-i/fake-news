package br.ufrn.imd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.imd.entity.News;
import br.ufrn.imd.repository.NewsRepository;

@Service
public class NewsService {
    @Autowired
    NewsRepository repository;
    
    public List<News> load() {
        return repository.findAll();
    }
}
