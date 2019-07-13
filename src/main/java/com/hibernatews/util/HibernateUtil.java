package com.hibernatews.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration config = new Configuration().configure();
			return config.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error creating a seccion factory .....");
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}