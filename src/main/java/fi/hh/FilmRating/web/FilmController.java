package fi.hh.FilmRating.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.FilmRating.domain.CategoryRepository;
import fi.hh.FilmRating.domain.Film;
import fi.hh.FilmRating.domain.FilmRepository;

@Controller
public class FilmController {
	
	@Autowired
	private FilmRepository repository; 
	
	@Autowired
	private CategoryRepository crepository;
	
	 @RequestMapping(value="/filmlist", method=RequestMethod.GET)
	 public String getFilms(Model model){
	model.addAttribute("films", repository.findAll());
	 return "filmlist";
	 }


@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/add")
public String addFilm(Model model){
	model.addAttribute("film", new Film());
   	model.addAttribute("categories", crepository.findAll());
    return "addfilm";
} 


@RequestMapping(value = "/save", method = RequestMethod.POST)
public String save(Film film){
    repository.save(film);
    return "redirect:filmlist";
}

@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public String deleteFilm(@PathVariable("id") Long filmId, Model model) {
	repository.delete(filmId);
    return "redirect:../filmlist";
}   

@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
public String editFilm(@PathVariable("id") Long filmId, Model model) {
	model.addAttribute("film", repository.findOne(filmId));
	model.addAttribute("categories", crepository.findAll());
    return "editfilm";
}  


@RequestMapping(value="/films", method = RequestMethod.GET)
public @ResponseBody List<Film> filmListRest() {	
    return (List<Film>) repository.findAll();
}    


@RequestMapping(value="/film/{id}", method = RequestMethod.GET)
public @ResponseBody Film findFilmRest(@PathVariable("id") Long filmId) {	
	return repository.findOne(filmId);
	
}       

@RequestMapping(value="/login")
public String login() {	
    return "login";
}	


}
