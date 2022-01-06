package br.com.vinicius.viniflix.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.viniflix.model.Serie;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Integer> {

}
