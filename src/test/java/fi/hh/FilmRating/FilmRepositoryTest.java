package fi.hh.FilmRating;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.FilmRating.domain.Category;
import fi.hh.FilmRating.domain.Film;
import fi.hh.FilmRating.domain.FilmRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FilmRepositoryTest {

    @Autowired
    private FilmRepository repository;

    @Test
    public void findByNameShouldReturnFilm() {
        List<Film> films = repository.findByName("Titanic");
        
        assertThat(films).hasSize(1);
        assertThat(films.get(0).getDirector()).isEqualTo("James Cameron");
    }
    
    @Test
    public void createNewFilm() {
    	Film film = new Film("Pretty woman", 1990, "Garry Marshall" , "Richard Gere, Julia Roberts", 3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris risus est, maximus molestie volutpat eu, laoreet id nisi. Integer bibendum mattis augue, ut imperdiet leo dignissim nec. ", new Category("Romantic comedy"));
    	repository.save(film);
    	assertThat(film.getId()).isNotNull();
    }    
    

    

}