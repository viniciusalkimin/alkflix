package br.com.vinicius.viniflix.dto;

import br.com.vinicius.viniflix.repository.SerieRepository;
import org.springframework.data.domain.Page;

import br.com.vinicius.viniflix.model.Genre;
import br.com.vinicius.viniflix.model.Serie;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class SerieDto {

	private Integer id;
	private String name;
	private Integer numberOfSeasons;
	private Genre genre;

	
	public SerieDto(Serie serie) {
		this.id = serie.getId();
		this.name = serie.getName();
		this.numberOfSeasons = serie.getNumberOfSeasons();
		this.genre = serie.getGenre();
	}
	
	public static Page<SerieDto> converter(Page<Serie>listaSerie){
		return listaSerie.map(SerieDto::new);
	}

	public Serie update(Integer id, SerieRepository repository) {
		Serie serie = repository.getOne(id);

		serie.setName(this.name);
		serie.setGenre(this.genre);
		serie.setNumberOfSeasons(this.numberOfSeasons);

		return serie;
	}

}
