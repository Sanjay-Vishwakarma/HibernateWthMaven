package com.tut;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbededDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("/com/tut/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Employee emp = new Employee();
		emp.setId(12);
		emp.setCity("mumbai");
		emp.setName("sneha");
		
		Employee emp2 = new Employee();
		emp2.setId(18);
		emp2.setCity("delhi");
		emp2.setName("rahul");
		
		Certificate cert =new Certificate();
		cert.setCourse("android");
		cert.setDuration("6 months");
		emp.setCertificate(cert);
		
		Certificate cert2 =new Certificate();
		cert2.setCourse("java");
		cert2.setDuration("1.5 months");
		emp2.setCertificate(cert2);
		
		Session s = factory.openSession();
		Transaction tx =s.beginTransaction();
		
		//object save
		s.save(emp);
		s.save(emp2);
		
		tx.commit();
		s.close();
		factory.close();
	}

}
