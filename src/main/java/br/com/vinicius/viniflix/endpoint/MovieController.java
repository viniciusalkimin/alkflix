package br.com.vinicius.viniflix.endpoint;

import br.com.vinicius.viniflix.dto.MovieDto;
import br.com.vinicius.viniflix.dto.SerieDto;
import br.com.vinicius.viniflix.model.Movie;
import br.com.vinicius.viniflix.model.Serie;
import br.com.vinicius.viniflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Page<MovieDto> listSeries(@RequestParam(required = false) String nameMovie, @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 5, page = 0) Pageable pagination) {
        return movieService.listMovies(nameMovie, pagination);
    }

    @GetMapping("/{id}")
    public Optional<MovieDto> listSeries(@PathVariable Integer id) {
        return movieService.movieById(id);
    }

    @PostMapping
    public ResponseEntity<MovieDto> newMovie(@RequestBody @Valid Movie movie) {
        return movieService.saveMovie(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable Integer id, @RequestBody MovieDto movieDto) {
        return movieService.updateMovie(id, movieDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> deleteById(@PathVariable Integer id){
        return movieService.deleteOne(id);
    }

    @GetMapping("/all")
    public List<Movie> all() {
        return movieService.all();
    }
}

