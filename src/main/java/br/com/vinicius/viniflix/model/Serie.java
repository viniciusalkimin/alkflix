package br.com.vinicius.viniflix.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "series")
public class Serie implements Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_seasons")
    private Integer numberOfSeasons;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    @Column(name = "state_of_content")
    private StateOfContent stateOfContent = StateOfContent.UNINITIALIZED;

}
