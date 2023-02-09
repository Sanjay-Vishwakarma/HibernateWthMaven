package com.tut;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		try {
			Configuration cfg = new Configuration();
			cfg.configure("/com/tut/hibernate.cfg.xml");

			SessionFactory factory = cfg.buildSessionFactory();
			System.out.println(factory);

			// creating object of employee
			Employee emp = new Employee();
			emp.setId(101);
			emp.setName("rahul");
			emp.setCity("mumbai");

			// creating object of address

			Address add = new Address();
			add.setCity("dehradun");
			add.setStreet("appapada");
			add.setX(0);
			add.setAddressdate(new Date());

			// reading image
			FileInputStream fis = new FileInputStream("src/main/java/sdd.jpeg");
			byte[] data = new byte[fis.available()];
			fis.read(data);
			add.setImage(data);

			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			for (int i = 1; i <= 50; i++) {
				System.out.println("inside for");
				session.save(emp);

			}
//			session.save(add);
			tx.commit();
			System.out.println("Done...!!");

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
}
