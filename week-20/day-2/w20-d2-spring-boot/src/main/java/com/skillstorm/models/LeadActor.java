package com.skillstorm.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Entity tells our app that this class refers to a database record
@Entity
// Table tells it which specific table it refers to
@Table(name = "lead_actor")
public class LeadActor {
	
	// Id indicates that this property is a primary key
	@Id
	// GeneratedValue indicates that this field will be auto-generated by the database
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Column tells us which table column goes with this variable
	@Column(name = "lead_actor_id")
	private int leadActorId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "academy_awards")
	private int academyAwards;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "imdb_url")
	private String imdbUrl;
	
	public LeadActor() {}
	
	public LeadActor(int leadActorId, String name, int age, int academyAwards, String imageUrl, String imdbUrl) {
		super();
		this.leadActorId = leadActorId;
		this.name = name;
		this.age = age;
		this.academyAwards = academyAwards;
		this.imageUrl = imageUrl;
		this.imdbUrl = imdbUrl;
	}

	public int getLeadActorId() {
		return leadActorId;
	}

	public void setLeadActorId(int leadActorId) {
		this.leadActorId = leadActorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAcademyAwards() {
		return academyAwards;
	}

	public void setAcademyAwards(int academyAwards) {
		this.academyAwards = academyAwards;
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
	public String toString() {
		return "LeadActor [leadActorId=" + leadActorId + ", name=" + name + ", age=" + age + ", academyAwards="
				+ academyAwards + ", imageUrl=" + imageUrl + ", imdbUrl=" + imdbUrl + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(academyAwards, age, imageUrl, imdbUrl, leadActorId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeadActor other = (LeadActor) obj;
		return academyAwards == other.academyAwards && age == other.age && Objects.equals(imageUrl, other.imageUrl)
				&& Objects.equals(imdbUrl, other.imdbUrl) && leadActorId == other.leadActorId
				&& Objects.equals(name, other.name);
	}
	
}
