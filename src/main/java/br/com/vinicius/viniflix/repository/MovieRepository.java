package br.com.vinicius.viniflix.repository;

import br.com.vinicius.viniflix.model.Serie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.viniflix.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Page<Movie> findByName(String nameMovie, Pageable pagination);
}
