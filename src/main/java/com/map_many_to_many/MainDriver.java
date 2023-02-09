package com.map_many_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainDriver {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("/com/map_many_to_many/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		// object create
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		Project p1 = new Project();
		Project p2 = new Project();

		//
		emp1.setEid(22);
		emp1.setName("ramesh");

		emp2.setEid(26);
		emp2.setName("suresh");

		p1.setPid(31);
		p1.setProjectName("liberary management system");

		p2.setPid(32);
		p2.setProjectName("chat bot");

		// list object
		List<Employee> list1 = new ArrayList<>();
		list1.add(emp1);
		list1.add(emp2);
		List<Project> list2 = new ArrayList<>();
		list2.add(p1);
		list2.add(p2);

		//
		emp1.setProjects(list2);
		p2.setEmps(list1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(emp1);
		s.save(emp2);
		s.save(p1);
		s.save(p2);
		
		
		tx.commit();
		
		
		
		factory.close();

	}

}
