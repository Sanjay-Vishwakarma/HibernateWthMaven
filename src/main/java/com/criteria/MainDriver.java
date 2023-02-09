package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Employee;

public class MainDriver {

	public static void main(String[] args) {
		
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Criteria c = s.createCriteria(Employee.class);
		//c.add(Restrictions.eq("certificate.course", "android"));
		c.add(Restrictions.like("certificate.course", "java%"));
		List<Employee> list = c.list();
		
		for(Employee am : list)
		{
			System.out.println(am);

		}
		s.close();
		
	}
}
