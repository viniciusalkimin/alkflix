package br.com.vinicius.viniflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.viniflix.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
