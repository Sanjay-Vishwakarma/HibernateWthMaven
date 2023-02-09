package com.second_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Employee;

public class SecondDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session1 = factory.openSession();
		// first session

		Employee employee = session1.get(Employee.class, 101);
		System.out.println(employee);

		session1.close();

		Session session2 = factory.openSession();
		// second session
		Employee employee2 = session2.get(Employee.class, 101);
		System.out.println(employee2);
		session2.close();

	}

}
