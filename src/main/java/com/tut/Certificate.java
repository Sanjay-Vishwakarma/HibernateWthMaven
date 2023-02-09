package com.tut;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	
	private String duration;
	private String course;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Certificate [duration=" + duration + ", course=" + course + "]";
	}

	public Certificate(String duration, String course) {
		super();
		this.duration = duration;
		this.course = course;
	}

}
