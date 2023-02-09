package com.first_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Employee;

// first level cache

public class FirstDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Employee employee = session.get(Employee.class, 101);
		System.out.println(employee);
		
		System.out.println("wroking someting .....");
		
		Employee employee1 = session.get(Employee.class, 101);
		System.out.println(employee1);
		
		boolean con = session.contains(employee1);   // return true or false its check have or not in cache
		System.out.println(con);
		session.close();
		factory.close();
	}
	
}
