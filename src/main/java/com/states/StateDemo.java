package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Employee;

public class StateDemo {

	public static void main(String[] args) {

		// Hibernate object states
//		Transient 
//		persistance
//		detached
//		removed

		SessionFactory f = new Configuration().configure("/com/states/hibernate.cfg.xml").buildSessionFactory();

		// Creating objcet Employee
		Employee emp = new Employee();
		emp.setId(127);
		emp.setName("rohit");
		emp.setCity("delhi");
		emp.setCertificate(new Certificate("6 months", "Java programming"));
// emp : Transient : while we crete obj

		Session s = f.openSession();
		Transaction tx = s.beginTransaction();

		s.save(emp);
		// emp : persistence : while we associate with session and database
		emp.setName("sahil");

		tx.commit();
		s.close(); // session close
		
		emp.setName("seema"); // Detatched : while we close the session . detached in the value can not be change
		f.close();

	}

}
