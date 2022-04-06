package br.com.vinicius.viniflix.dto;

import br.com.vinicius.viniflix.model.Genre;

import javax.validation.constraints.NotBlank;


public class SerieDto {
    @NotBlank
    private String name;
    @NotBlank
    private Integer numberOfSeasons;
    @NotBlank
    private Genre genre;


    public SerieDto(String name, Integer numberOfSeasons, Genre genre) {

        this.name = name;
        this.numberOfSeasons = numberOfSeasons;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
