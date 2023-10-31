package com.ml.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.config.HBM_Config;
import com.ml.demo.Customer;

public class Client_1 {
    
    public static void main(String[] args) {
	Transaction tx=null;
	try {
	SessionFactory sf=HBM_Config.getSessionFactory();
	Session session= sf.openSession();
	tx=session.beginTransaction();
	Customer customer=new Customer("Himanshu", "swavyast@gmail.com", 7275855535L, "Noida");
	session.save(customer);
	tx.commit();
	}catch(Exception e) {
	    System.out.println("Problem in client code");
	    e.printStackTrace();
	    if(tx!=null)
		tx.rollback();
	}
    }
}
