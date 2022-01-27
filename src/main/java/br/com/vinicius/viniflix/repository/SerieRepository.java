package br.com.vinicius.viniflix.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.viniflix.model.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {

    Page<Serie> findByName(String name, Pageable pagination);
}
