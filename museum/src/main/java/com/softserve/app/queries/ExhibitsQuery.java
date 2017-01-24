package com.softserve.app.queries;

import java.util.List;

import com.softserve.app.entity.Exhibit;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class ExhibitsQuery implements Query {

	
	public List executeQuery(SessionFactory factory,String ...args) { //args not used in this method as we take all Exhibits without any constraints
		Session session=factory.openSession();
		List exhibits=null;
		String sql = "select * from exhibit;";
	    Transaction tx = null;
	    try{
	         tx = session.beginTransaction();
	         SQLQuery query = session.createSQLQuery(sql);
	         query.addEntity(Exhibit.class);
	         exhibits = query.list(); // here we get the list of all exhibits in base
	       
	         tx.commit();
	     }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	     }finally {
	         session.close(); 
	     }
		return exhibits;
	}
    
	
}
