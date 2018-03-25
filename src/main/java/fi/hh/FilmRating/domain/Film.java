package fi.hh.FilmRating.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Film {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private int year;
	private String director;
	private String actors;
	private int rating;
	private String review;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
	
	 public Film() {}

	public Film(String name, int year, String director, String actors, int rating, String review, Category category) {
		super();
		this.name = name;
		this.year = year;
		this.director = director;
		this.actors = actors;
		this.rating = rating;
		this.review = review;
		this.category = category;
	}



	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public String getDirector() {
		return director;
	}



	public void setDirector(String director) {
		this.director = director;
	}



	public String getActors() {
		return actors;
	}



	public void setActors(String actors) {
		this.actors = actors;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public String getReview() {
		return review;
	}



	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		if (this.category != null)
		return "Film [id=" + id + ", name=" + name + ", year=" + year + ", director=" + director + ", actors=" + actors
				+ ", rating=" + rating + ", review=" + review + this.getCategory() + "]";
	
		else return "Film [id=" + id + ", name=" + name + ", year=" + year + ", director=" + director + ", actors=" + actors
				+ ", rating=" + rating + ", review=" + review + "]";
	}
	
	
	

	
}



