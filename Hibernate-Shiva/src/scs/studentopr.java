package scs;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;

import javax.servlet.http.HttpSession;


public class studentopr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("st.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();

		Session s = sf.openSession();
		//Object o = s.load(student.class, sid);
		
		Transaction tx = s.beginTransaction();
		student obj = new student();
		obj.setSid(5);
		obj.setSname("das");
		s.save(obj);
		tx.commit();
		
		Query q =  s.createQuery("from student s");
		List lst = q.list();
		Iterator it =  lst.iterator();
		while (it.hasNext()) {
			student stud = (student) it.next();
			System.out.println(stud.getSid() + " " + stud.getSname());
		}
		
		
	}

}
