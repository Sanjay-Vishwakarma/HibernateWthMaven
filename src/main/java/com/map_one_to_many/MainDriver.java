package com.map_one_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainDriver {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("/com/map_one_to_many/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		/*
		 * // Object Question 1 Question q1 = new Question(); q1.setQuestionId(100);
		 * q1.setQuestion("what is java features ?");
		 * 
		 * // answer 1 Answer ans = new Answer(); ans.setAnswerId(105);
		 * ans.setAnswer("java is robust"); ans.setQuestion(q1);
		 * 
		 * Answer ans2 = new Answer(); ans2.setAnswerId(108);
		 * ans2.setAnswer("Its have OOPs concept"); ans2.setQuestion(q1);
		 * 
		 * Answer ans3 = new Answer(); ans3.setAnswerId(109);
		 * ans3.setAnswer("java support multithreading"); ans3.setQuestion(q1);
		 * 
		 * List<Answer> list = new ArrayList<>(); list.add(ans); list.add(ans2);
		 * list.add(ans3);
		 * 
		 * q1.setAnswers(list);
		 */
		// session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// save
		/*
		 * session.save(q1); session.save(ans); session.save(ans2); session.save(ans3);
		 */

		tx.commit();
			// fetching the data
//		Question q = session.get(Question.class, 100);
//		System.out.println(q.getQuestion());
//
//		for (Answer a : q.getAnswers()) {
//			System.out.println(a.getAnswer());
//		}

		// Lazy loading and eager
		
		Question q = session.get(Question.class, 100);
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswers());
		
		session.close();
		factory.close();
	}
}
