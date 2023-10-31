package com.ml.demo;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;

import com.ml.config.HBM_Config;

public class ID_Generator implements IdentifierGenerator {

    public static Serializable getNextCustomerID(Session session) {
	return session;

    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
	String cid = "";
	/*
	 * try { String HQL="select max(cust.cid) from customers cust"; String
	 * id=session.createQuery(HQL, String.class).uniqueResult();
	 */
	try {
	    SessionFactory sf = HBM_Config.getSessionFactory();
	    Session s = sf.openSession();
	    Transaction tx = s.beginTransaction();
	    Query<Customer> q1 = s.createQuery("from customers cust", Customer.class);
	    int size = q1.list().size();
	    if (size != 0) {
		Query query = s.createQuery("select max(cust.cid) from customers cust");
		List list = query.list();
		System.out.println(list.size());
		Object o = list.get(0);
		System.out.println(o);
		String id = "";
		id = o.toString();
		String p2 = id.substring(2);
		int x = Integer.parseInt(p2);
		x = x + 1;
		if (x <= 9) {
		    cid = "C-00" + x;
		} else if (x <= 99) {
		    cid = "C-0" + x;
		} else if (x <= 999) {
		    cid = "C-" + x;
		}
	    }
	    
	    return cid;

	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}

    }
}
