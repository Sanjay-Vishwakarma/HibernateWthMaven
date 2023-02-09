package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {
	public static void main(String[] args) {

		try {
			/*
			 * get() = if have data in session then it will pick the data from session cache
			 * memory if data exist will get proper data otherwise return null
			 * 
			 * load () = if required the data then it will execute the query if data exist
			 * will get proper data otherwise it throws exception ObjectNotFoundException
			 */
			Configuration cfg = new Configuration();
			cfg.configure("/com/tut/hibernate.cfg.xml");

			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			Employee emp = (Employee) session.get(Employee.class, 5);
			System.out.println("get the data from employee :::" + emp);

			Address address = session.load(Address.class, 9);
			System.out.println("address data :" + address.getAddressId() + " " + address.getCity());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
