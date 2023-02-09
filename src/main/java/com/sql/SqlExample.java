package com.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SqlExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
// native query (Sql query only)
		String q ="select * from Employee";
		NativeQuery nativeQuery = session.createSQLQuery(q);
		List<Object[]> list = nativeQuery.list();
		
		for(Object[] obj :list)
		{
			System.out.println("id: "+ obj[0] +" name:"+obj[4] + " course:"+obj[1]);
		}
		
		
		session.close();
		factory.close();
	}

}
