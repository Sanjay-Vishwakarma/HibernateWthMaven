package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map_one_to_many.Answer;
import com.map_one_to_many.Question;

public class CascadeExample {

	public static void main(String[] args) {
		// cascade using for the question's answers save - Question
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();

		// one to many
		Question q1 = new Question();
		q1.setQuestionId(123);
		q1.setQuestion("What is cascading ?");

		Answer a1 = new Answer(101, "first ans");
		Answer a2 = new Answer(102, "secod ans");
		Answer a3 = new Answer(103, "third ans");

		List<Answer> ll = new ArrayList<Answer>();

		ll.add(a1);
		ll.add(a2);
		ll.add(a3);
		q1.setAnswers(ll);

		Transaction tx = s.beginTransaction();

		s.save(q1);

		tx.commit();
		s.close();
		factory.close();
	}

}
