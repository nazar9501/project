package com.softserve.app.queries;

import java.util.List;

import com.softserve.app.entity.Exhibit;
import com.softserve.app.entity.Workers;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class GuidsQuery implements Query {

	
	public List executeQuery(SessionFactory factory,String ...args) { //args not used in this method as we take all Exhibits without any constraints
		
		Session session=factory.openSession();
		List workers=null;
		String sql = "select * from workers WHERE post='Guide';";
	    Transaction tx = null;
	    try{
	         tx = session.beginTransaction();
	         SQLQuery query = session.createSQLQuery(sql);
	         query.addEntity(Workers.class);
	         workers = query.list(); // here we get the list of all exhibits in base
	       
	         tx.commit();
	     }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	     }finally {
	         session.close(); 
	     }
		return workers;
	}
    
	
}
