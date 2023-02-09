package com.map_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("/com/map_one_to_one/hibernate.cfg.xml");
		SessionFactory factory =cfg.buildSessionFactory();
		

		// Object Question 1
		
		Question q1= new Question();
		q1.setQuestionId(101);
		q1.setQuestion("what is java ?");
		 
		Answer ans = new Answer();
		ans.setAnswerId(102);
		ans.setAnswer("java is programming language");
		ans.setQuestion(q1);
		q1.setAnswer(ans);
		
		// Object Question 2

		Question q2= new Question();
		q2.setQuestionId(102);
		q2.setQuestion("what is python ?");
		
		Answer ans2 = new Answer();
		ans2.setAnswerId(103);
		ans2.setAnswer("python is programming language");
		ans2.setQuestion(q2);
		q2.setAnswer(ans2);
		
		// session
		Session session =factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//save
		session.save(q1);
		session.save(q2);
		session.save(ans);
		session.save(ans2);
		tx.commit();
		
		// fetching.... data
		Question q= (Question)session.get(Question.class,102);
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswer().getAnswer());
		
		session.close();
		factory.close();

	}

}
