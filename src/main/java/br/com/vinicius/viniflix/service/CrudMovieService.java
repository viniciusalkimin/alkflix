package br.com.vinicius.viniflix.service;

import org.springframework.stereotype.Service;

import br.com.vinicius.viniflix.repository.MovieRepository;

@Service
public class CrudMovieService {
	
	private MovieRepository movieRepository;
	
	public CrudMovieService(MovieRepository movieRepository){
		this.movieRepository  = movieRepository;
		
	}
}
