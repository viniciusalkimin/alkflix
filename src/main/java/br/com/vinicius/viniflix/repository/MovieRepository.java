package br.com.vinicius.viniflix.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.viniflix.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
