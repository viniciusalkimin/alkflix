package br.com.vinicius.viniflix.dto;

import br.com.vinicius.viniflix.model.Genre;
import lombok.Data;

@Data
public class MovieDto {

    private Integer id;

    private String name;

    private Genre genre;

}
