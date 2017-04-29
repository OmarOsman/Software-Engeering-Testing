package com.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Game implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 4637459274080499509L;

	@Id
	private String gameName;

	public String gameCourse;

	public String gameOwner;

	private int numberOfQuestions;

	@ManyToOne
	private Course course;

	@ManyToOne
	private Teacher teacher;

	public Game() {
	}

	public Game(String gameName, String gameCourse, String gameOwner, int numberOfQuestions) {
		super();
		this.gameName = gameName;
		this.gameCourse = gameCourse;
		this.gameOwner = gameOwner;
		this.numberOfQuestions = numberOfQuestions;
	}

	public Game(String gamename, int questions, String gamecourse) {
		super();
		this.gameName = gamename;
		this.gameCourse = gamecourse;
		this.numberOfQuestions = questions;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameCourse() {
		return gameCourse;
	}

	public void setGameCourse(String gameCourse) {
		this.gameCourse = gameCourse;
	}

	public String getGameOwner() {
		return gameOwner;
	}

	public void setGameOwner(String gameOwner) {
		this.gameOwner = gameOwner;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
