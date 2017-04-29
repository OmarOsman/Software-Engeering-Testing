package com.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Teacher extends IUser {

	/**
	 *
	 */
	private static final long serialVersionUID = 8195289506885115373L;

	@OneToMany(mappedBy = "courseOwner")
	private List<Course> courses;

	@OneToMany(mappedBy = "gameOwner")
	private List<Game> games;

	public Teacher() {
	}

	public Teacher(String fullname, String gender, String email, String username, String password) {
		super(username, password, fullname, email, gender);
		setTeacher(true);
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

}
