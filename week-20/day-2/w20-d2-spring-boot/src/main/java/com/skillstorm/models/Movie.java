package com.skillstorm.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private int movieId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "genre")
	private String genre;

	@Column(name = "release_year")
	private int releaseYear;

	// this creates a one-to-one relationship with the lead_actor table -- one movie refers to one lead_actor
	@OneToOne
	// which column in the lead_actor table does this Movie's lead_actor_id refer to?
	@JoinColumn(name = "lead_actor_id")
	private LeadActor leadActor;

	@OneToOne
	@JoinColumn(name = "lead_actress_id")
	private LeadActress leadActress;

	@Column(name = "box_office_gross")
	private int boxOfficeGross;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "imdb_url")
	private String imdbUrl;
	
	public Movie() {}

	public Movie(int movieId, String name, String genre, int releaseYear, LeadActor leadActor, LeadActress leadActress,
			int boxOfficeGross, String imageUrl, String imdbUrl) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.leadActor = leadActor;
		this.leadActress = leadActress;
		this.boxOfficeGross = boxOfficeGross;
		this.imageUrl = imageUrl;
		this.imdbUrl = imdbUrl;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", genre=" + genre + ", releaseYear=" + releaseYear
				+ ", leadActor=" + leadActor + ", leadActress=" + leadActress + ", boxOfficeGross=" + boxOfficeGross
				+ ", imageUrl=" + imageUrl + ", imdbUrl=" + imdbUrl + "]";
	}
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public LeadActor getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(LeadActor leadActor) {
		this.leadActor = leadActor;
	}

	public LeadActress getLeadActress() {
		return leadActress;
	}

	public void setLeadActress(LeadActress leadActress) {
		this.leadActress = leadActress;
	}

	public int getBoxOfficeGross() {
		return boxOfficeGross;
	}

	public void setBoxOfficeGross(int boxOfficeGross) {
		this.boxOfficeGross = boxOfficeGross;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImdbUrl() {
		return imdbUrl;
	}

	public void setImdbUrl(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boxOfficeGross, genre, imageUrl, imdbUrl, leadActor, leadActress, movieId, name,
				releaseYear);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return boxOfficeGross == other.boxOfficeGross && Objects.equals(genre, other.genre)
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(imdbUrl, other.imdbUrl)
				&& Objects.equals(leadActor, other.leadActor) && Objects.equals(leadActress, other.leadActress)
				&& movieId == other.movieId && Objects.equals(name, other.name) && releaseYear == other.releaseYear;
	}
	
}
