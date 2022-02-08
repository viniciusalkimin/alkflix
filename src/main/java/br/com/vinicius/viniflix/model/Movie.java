package br.com.vinicius.viniflix.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "movies")
public class Movie implements Content{
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "genre")@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@Enumerated(EnumType.STRING) @Column(name = "state_of_content")
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
