package br.com.vinicius.viniflix.service;

import br.com.vinicius.viniflix.dto.MovieDto;
import br.com.vinicius.viniflix.model.Movie;
import br.com.vinicius.viniflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public Page<MovieDto> listMovies(String nameMovie, Pageable pagination) {

        if (nameMovie != null) {
            Page<Movie> list = repository.findByName(nameMovie, pagination);
            return MovieDto.converter(list);
        } else {
            Page<Movie> list = repository.findAll(pagination);
            return MovieDto.converter(list);
        }
    }

    public Optional<MovieDto> movieById(Integer id) {
        Optional<Movie> serie = repository.findById(id);
        Optional<MovieDto> movieDto = serie.map(e -> new MovieDto(e));
        return movieDto;
    }

    public ResponseEntity<MovieDto> saveMovie(Movie movie) {
        repository.save(movie);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<MovieDto> updateMovie(Integer id, MovieDto movieDto){
        Optional<Movie> optional = repository.findById(id);
        if (optional.isPresent()) {
            Movie newMovie = movieDto.update(id, repository);
            repository.save(newMovie);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<MovieDto> deleteOne(Integer id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }else
            return ResponseEntity.notFound().build();
    }

    public List<Movie> all() {
        return repository.findAll();
    }

}
