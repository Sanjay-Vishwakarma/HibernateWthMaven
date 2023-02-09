package com.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Employee;

public class HqlPegination {

	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			Query query = session.createQuery("from Employee");
			query.setFirstResult(10);  // start from this 
			query.setMaxResults(5); // how many u want to see
			List<Employee> list = query.list();

			for (Employee emp : list) {
				System.out.println(emp.getId() + " " + emp.getName());
			}
session.close();
			factory.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
