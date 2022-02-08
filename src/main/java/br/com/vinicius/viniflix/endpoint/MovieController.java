package br.com.vinicius.viniflix.endpoint;

import br.com.vinicius.viniflix.dto.MovieDto;
import br.com.vinicius.viniflix.dto.SerieDto;
import br.com.vinicius.viniflix.model.Movie;
import br.com.vinicius.viniflix.model.Serie;
import br.com.vinicius.viniflix.repository.MovieRepository;
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
    private MovieRepository movieRepository;

    @GetMapping
    public Page<MovieDto> listMovies(@RequestParam(required = false) String nameMovie, @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 5, page = 0) Pageable pagination) {

        if (nameMovie != null) {
            Page<Movie> list = movieRepository.findByName(nameMovie, pagination);
            return MovieDto.converter(list);
        } else {
            Page<Movie> list = movieRepository.findAll(pagination);
            return MovieDto.converter(list);
        }
    }

	@GetMapping("/{id}")
	public Optional<MovieDto> listMovies(@PathVariable Integer id){
	    Optional<Movie> movie = movieRepository.findById(id);
        Optional<MovieDto> movieDto = movie.map(e -> new MovieDto(e));

        return movieDto;
	}

    @PostMapping
    public ResponseEntity<Movie> newMovie (@RequestBody @Valid Movie movie){
        movieRepository.save(movie);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody MovieDto movieDto){
        Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isPresent()) {
            Movie newMovie = movieDto.update(id, movieRepository);
            movieRepository.save(newMovie);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/all")
    public List<Movie> all(){
        return movieRepository.findAll();
    }


}

