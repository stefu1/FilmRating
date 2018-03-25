package fi.hh.FilmRating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.FilmRating.domain.Category;
import fi.hh.FilmRating.domain.CategoryRepository;
import fi.hh.FilmRating.domain.Film;
import fi.hh.FilmRating.domain.FilmRepository;
import fi.hh.FilmRating.domain.User;
import fi.hh.FilmRating.domain.UserRepository;


@SpringBootApplication
public class FilmRatingApplication {
	
	private static final Logger log = LoggerFactory.getLogger(FilmRatingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FilmRatingApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner filmDemo(FilmRepository frepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of films");
			
			crepository.save(new Category("Comedy"));
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Science"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Action"));
			
			frepository.save(new Film("Red Sparrow", 2018, "Francis Lawrence" , "Jennifer Lawrence", 4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris risus est, maximus molestie volutpat eu, laoreet id nisi. Integer bibendum mattis augue, ut imperdiet leo dignissim nec. ", crepository.findByName("Action").get(0)));
			frepository.save(new Film("Titanic", 1997, "James Cameron" , "Leonardo DiCaprio, Kate Winslet", 5, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris risus est, maximus molestie volutpat eu, laoreet id nisi. Integer bibendum mattis augue, ut imperdiet leo dignissim nec. ", crepository.findByName("Drama").get(0)));
			frepository.save(new Film("Tuntematon sotilas", 2017, "Aku Louhimies" , "Eero Aho, Jussi Vatanen, Aku Hirviniemi", 4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris risus est, maximus molestie volutpat eu, laoreet id nisi. Integer bibendum mattis augue, ut imperdiet leo dignissim nec. ", crepository.findByName("Action").get(0)));
			
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			
		
			log.info("fetch all films");
			for (Film film : frepository.findAll()) {
				log.info(film.toString());
			}

		
		};
	}
}
