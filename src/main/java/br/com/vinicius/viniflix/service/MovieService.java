package br.com.vinicius.viniflix.service;

import br.com.vinicius.viniflix.dto.MovieDto;
import br.com.vinicius.viniflix.model.Movie;
import br.com.vinicius.viniflix.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

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


    public Movie saveMovie(MovieDto movieDto) {
        var movie = new Movie();
        BeanUtils.copyProperties(movieDto, movie);
        return repository.save(movie);
    }

    public Movie updateMovie(MovieDto movieDto) {
        var movie = new Movie();
        BeanUtils.copyProperties(movieDto, movie);
        return repository.save(movie);
    }

    public void deleteOne(Movie movie) {
        repository.delete(movie);
    }

    public List<Movie> all() {
        return repository.findAll();
    }
}
