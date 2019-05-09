package scs;

import java.util.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class onetomany_opr {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("st.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		//parent object
		vendor v = new vendor();
		v.setVendorid(1);
		v.setVendorname("Sunidhi");
		
		//creating 3 customer

		customer c = new customer();
		c.setCustomerId(100);
		c.setCustomerName("Das");
		
		customer c1 = new customer();
		c1.setCustomerId(101);
		c1.setCustomerName("Shubhashish Das");
		
		customer c2 = new customer();
		c2.setCustomerId(102);
		c2.setCustomerName("Shubhashish");
		
		//adding objects 
		Set s1 = new HashSet();
		s1.add(c);
		s1.add(c1);
		s1.add(c2);
		
		v.setChild(s1);
		
		Transaction tx = s.beginTransaction();
		s.save(v);
		tx.commit();
		s.close();
		sf.close();
		
		
	}

}
