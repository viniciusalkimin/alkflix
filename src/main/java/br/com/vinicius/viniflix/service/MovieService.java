package br.com.vinicius.viniflix.service;

import br.com.vinicius.viniflix.model.Movie;
import br.com.vinicius.viniflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public Page<Movie> listMovies(String nameMovie, Pageable pagination) {

        if (nameMovie != null) {
            return repository.findByName(nameMovie, pagination);
        } else {
            return repository.findAll(pagination);
        }
    }

    public Optional<Movie> movieById(Integer id) {
        return repository.findById(id);
    }


    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        return repository.save(movie);
    }

    public void deleteOne(Movie movie) {
        repository.delete(movie);
    }

    public List<Movie> all() {
        return repository.findAll();
    }
}
