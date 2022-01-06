package br.com.vinicius.viniflix.service;

import br.com.vinicius.viniflix.repository.SerieRepository;

public class CrudSerieService {
	
	private SerieRepository serieRepository;
	
	CrudSerieService(SerieRepository serieRepository){
		this.serieRepository = serieRepository;
	}

}
