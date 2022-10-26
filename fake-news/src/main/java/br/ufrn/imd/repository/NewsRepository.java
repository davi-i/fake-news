package br.ufrn.imd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.entity.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
