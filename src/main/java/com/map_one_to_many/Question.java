package com.map_one_to_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;

	@OneToMany(mappedBy = "question" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	private List<Answer> answers;


	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Question(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	/*
	 * @Override public String toString() { return "Question [questionId=" +
	 * questionId + ", question=" + question + "]"; }
	 */

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
