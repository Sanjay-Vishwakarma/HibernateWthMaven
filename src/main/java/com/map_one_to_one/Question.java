package com.map_one_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;

	@OneToOne
	@JoinColumn(name="ans_id")
	private Answer answer;
	
	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + "]";
	}

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
