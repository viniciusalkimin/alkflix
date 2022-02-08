package br.com.vinicius.viniflix.dto;

import br.com.vinicius.viniflix.model.Genre;
import br.com.vinicius.viniflix.model.Movie;
import br.com.vinicius.viniflix.model.Serie;
import br.com.vinicius.viniflix.repository.MovieRepository;
import br.com.vinicius.viniflix.repository.SerieRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class MovieDto {

	private Integer id;
	private String name;
	private Genre genre;


	public MovieDto(Movie movie) {
		this.id = movie.getId();
		this.name = movie.getName();
		this.genre = movie.getGenre();
	}
	
	public static Page<MovieDto> converter(Page<Movie>listaMovie){
		return listaMovie.map(MovieDto::new);
	}

	public Movie update(Integer id, MovieRepository movieRepository) {
		Movie movie = movieRepository.getOne(id);

		movie.setId(this.id);
		movie.setName(this.name);
		movie.setGenre(this.genre);

		return movie;
	}

}
