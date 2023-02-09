package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainDriver {

	public static void main(String[] args) {

		try {
			
			SessionFactory factory = new Configuration().configure().buildSessionFactory();

			Session session = factory.openSession();

			Person p1 = new Person(1, "suraj", "mumbai", "1234567");
			Transaction tx = session.beginTransaction();

			session.save(p1);

			tx.commit();
			session.close();
			factory.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
