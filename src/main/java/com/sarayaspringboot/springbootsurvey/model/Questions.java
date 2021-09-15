package com.sarayaspringboot.springbootsurvey.model;

import java.util.List;
import java.util.Objects;

public class Questions {
	private String id;
	private String description;
	private String correctAnswer;
	private List<String> options;
	
	public Questions() {
		super();
	}

	public Questions(String id, String description, String correctAnswer, List<String> options) {
		super();
		this.id = id;
		this.description = description;
		this.correctAnswer = correctAnswer;
		this.options = options;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questions other = (Questions) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Questions [id=" + id + ", description=" + description + ", correctAnswer=" + correctAnswer
				+ ", options=" + options + "]";
	}
	
	
}
