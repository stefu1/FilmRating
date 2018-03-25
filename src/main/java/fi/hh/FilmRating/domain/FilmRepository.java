package fi.hh.FilmRating.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository <Film, Long> {

	 List<Film> findByName(String name);

}
