package com.fb;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
		
		if(sessionFactory == null)
		{
			Configuration cfg = new Configuration();
			Properties p = new Properties();
			p.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
			p.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/facebook");
			p.put(Environment.JAKARTA_JDBC_USER, "root");
			p.put(Environment.JAKARTA_JDBC_PASSWORD, "root");
			p.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			p.put(Environment.HBM2DDL_AUTO, "update");
			p.put(Environment.SHOW_SQL, "true");
			
			cfg.setProperties(p);
			cfg.addAnnotatedClass(UserInfo.class);
			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			sessionFactory = cfg.buildSessionFactory(registry);
			
		}
		return sessionFactory;
	}

}
