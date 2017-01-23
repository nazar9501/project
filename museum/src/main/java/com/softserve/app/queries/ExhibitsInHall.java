package com.softserve.app.queries;

import java.util.List;

import com.softserve.app.entity.Exhibit;

public class ExhibitsInHall implements Query {

	@Override
	public List executeQuery(SessionFactory factory, String... args) {
		String hallID=args[0];
		Session session=factory.openSession();
		List exhibits=null;
		String sql = "select * FROM exhibits"+
        "WHERE exhibits.id_hall="+hallID;
	    Transaction tx = null;
	    try{
	         tx = session.beginTransaction();
	         SQLQuery query = session.createSQLQuery(sql);
	         query.addEntity(Exhibit.class);
	         exhibits = query.list(); // here we get the list of all exhibits in base
	       }
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
