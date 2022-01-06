package br.com.vinicius.viniflix.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie implements Content{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer timeDuration;
	private LocalDateTime dataLancamento;
	private Genre genre;
	private StateOfContent stateOfContent = StateOfContent.UNINITIALIZED;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTimeDuration() {
		return timeDuration;
	}
	public void setTimeDuration(Integer timeDuration) {
		this.timeDuration = timeDuration;
	}
	public LocalDateTime getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(LocalDateTime dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public StateOfContent getStateOfContent() {
		return stateOfContent;
	}
	public void setStateOfContent(StateOfContent stateOfContent) {
		this.stateOfContent = stateOfContent;
	}

	

}
