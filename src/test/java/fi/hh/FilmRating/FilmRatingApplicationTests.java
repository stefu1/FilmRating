package fi.hh.FilmRating;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.FilmRating.web.FilmController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmRatingApplicationTests {

	@Autowired
	private FilmController controller;
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
