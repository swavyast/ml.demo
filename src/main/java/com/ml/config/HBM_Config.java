package com.ml.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.ml.demo.Customer;
import com.ml.demo.ID_Generator;
import com.ml.demo.Item;

public class HBM_Config {
    
    static SessionFactory sessFact;
    
    static {
	Configuration config=new Configuration();
	Properties props=new Properties();
	props.put(Environment.SHOW_SQL, "true");
	props.put(Environment.HBM2DDL_AUTO, "update");
	props.put(Environment.HBM2DDL_AUTO, "create");
	props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
	props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	props.put(Environment.URL, "jdbc:mysql://localhost:3306/testing");
	props.put(Environment.USER, "root");
	props.put(Environment.PASS, "68921794");
	config.setProperties(props);
	config.addAnnotatedClass(Customer.class);
	config.addAnnotatedClass(ID_Generator.class);
	config.addAnnotatedClass(Item.class);
	StandardServiceRegistryBuilder ssrbuilder=new StandardServiceRegistryBuilder();
	StandardServiceRegistry registry=ssrbuilder.applySettings(config.getProperties()).build();
	sessFact=config.buildSessionFactory(registry);
    }
    public static SessionFactory getSessionFactory() {
	return sessFact;
	
    }

}
