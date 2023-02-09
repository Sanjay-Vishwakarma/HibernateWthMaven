package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Employee;

public class HqlExample {
	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration();

			cfg.configure("/com/hql/hibernate.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();

			// HQL
			// Syntax

			Session s = sf.openSession();

			String query = "from Employee as em where em.city=:x and em.name=:y ";

			Query<Employee> q = s.createQuery(query);
			q.setParameter("x", "mumbai");
			q.setParameter("y", "pinki");

			System.out.println("query ::::" + query);
			List<Employee> list = q.list();
			for (Employee emp : list) {

				System.out.println("Employee details :::" + emp.getName() + " " + emp.getCity());
			}

			System.out.println("___________________________________________________________________");
			// Transaction create for anything happening with database
			Transaction tx = s.beginTransaction();

//			// delete query
//			String deleteQuery = "delete from Employee as st where st.city=:d";
//			Query q2 = s.createQuery(deleteQuery);
//			q2.setParameter("d", "punjab");
//			int r = q2.executeUpdate();
//			System.out.println("delete query rows effected::" + r);
//
//			
			// update query

			Query q3 = s.createQuery("update Employee em set city=:ct  where course=:cs");
			q3.setParameter("ct", "pune");
			q3.setParameter("cs", "java");
			int ro = q3.executeUpdate();
			System.out.println("update query rows affected :" + ro);

			// Joins query

			Query q4 = s.createQuery(
					"select q.questionId ,q.question, a.answer from Question as q INNER JOIN q.answers as a");

			List<Object[]> listData = q4.getResultList();
			for (Object[] arr : listData) {
				System.out.println("data :::" + Arrays.toString(arr));
			}

			tx.commit();
			sf.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
