package br.com.vinicius.viniflix.endpoint;

import br.com.vinicius.viniflix.dto.MovieDto;
import br.com.vinicius.viniflix.model.Movie;
import br.com.vinicius.viniflix.model.Serie;
import br.com.vinicius.viniflix.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<Movie>> listSeries(@RequestParam(required = false) String nameMovie,
                                                  @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 5, page = 0) Pageable pagination) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.listMovies(nameMovie, pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMovie(@PathVariable Integer id) {
        Optional<Movie> movie = movieService.movieById(id);
        if (!movie.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> newMovie(@RequestBody MovieDto movieDto) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.saveMovie(movieDto));
    }

    @PutMapping
    public ResponseEntity<Movie> updateMovie(@RequestBody MovieDto movieDto) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.updateMovie(movieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        Movie movie = movieService.movieById(id).get();
        if (movie == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found!");
        }
        movieService.deleteOne(movie);
        return ResponseEntity.status(HttpStatus.OK).body("Movie deleted!");
    }

    @GetMapping("/all")
    public List<Movie> all() {
        return movieService.all();
    }
}

