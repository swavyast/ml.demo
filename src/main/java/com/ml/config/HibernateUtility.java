package com.ml.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtility {
    static SessionFactory sessFact=null;
    static {
	Properties properties=new Properties();
	Configuration cfg=new Configuration();
	properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect ");
	properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	properties.put(Environment.HBM2DDL_AUTO, "update");
	properties.put(Environment.HBM2DDL_AUTO, "create");
	properties.put(Environment.AUTO_CLOSE_SESSION, "true");
	properties.put(Environment.AUTOCOMMIT, "true");
	properties.put(Environment.POOL_SIZE, 100);
	properties.put(Environment.SHOW_SQL, "true");
	properties.put(Environment.URL, "jdbc:mysql://localhost:3306/testing");
	properties.put(Environment.USER, "root");
	properties.put(Environment.PASS, "68921794");
	cfg.setProperties(properties);
	cfg.addAnnotatedClass(null);
	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
	sessFact=cfg.buildSessionFactory(ssr);
    }
	public static SessionFactory getSessionFactory() {
		return sessFact;
	}
}
