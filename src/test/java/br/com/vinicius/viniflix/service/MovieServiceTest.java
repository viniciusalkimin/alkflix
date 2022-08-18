package br.com.vinicius.viniflix.service;

import br.com.vinicius.viniflix.model.Genre;
import br.com.vinicius.viniflix.model.Movie;
import br.com.vinicius.viniflix.model.StateOfContent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class MovieServiceTest {

    @BeforeEach
    void init() {
    }

   @Test
   void certificatedIfStateIsUnintialized(){

        Movie movie = new Movie();
        movie.setId(1);
        movie.setName("Titanic");
        movie.setGenre(Genre.DRAMA);
        Assertions.assertAll( () -> Assertions.assertEquals("Titanic", movie.getName()),
                () -> Assertions.assertEquals(StateOfContent.UNINITIALIZED, movie.getStateOfContent()));
    }

}