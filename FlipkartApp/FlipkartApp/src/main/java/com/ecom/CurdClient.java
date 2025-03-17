package com.ecom;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CurdClient {

	public static void main(String[] args) {
		 SessionFactory factory = HibernateUtil.getSessionFactory();
	        Session ses = factory.openSession();
	        Transaction tx = ses.beginTransaction();
	        
	      /*  //insert
	        Product p = new Product();
	        p.setPname("RealMe");
	        p.setPrice(30000);
	        ses.save(p);
	        tx.commit();*/
	        
	       /* //update
	        Product p = new Product();
	        p.setPid(2);
	        p.setPname("RealMe_Pro");
	        p.setPrice(35000);
	        ses.update(p);
	        tx.commit();*/
	        
	       /* //delete
	        Product p = new Product();
	        p.setPid(2);
	        ses.remove(p);
	        tx.commit();*/
	        
	        //get
	        Product p = ses.load(Product.class, 1);
	        System.out.println(p.getPid() +" " +p.getPname() +" "+p.getPrice());
	}

}
