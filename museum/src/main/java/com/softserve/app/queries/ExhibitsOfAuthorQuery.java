package com.softserve.app.queries;

import java.util.List;

import com.softserve.app.entity.Exhibit;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class ExhibitsOfAuthorQuery implements Query {

	public List executeQuery(SessionFactory factory, String... args) {
		String authorName=args[0];
		Session session=factory.openSession();
		List exhibits=null;
		String sql = "select * FROM exhibits"+
        "where (SELECT author.id_author FROM author WHERE author.first_name+author.last_name="+authorName+") as authorid"+
          " authorid.id_author = exhibit.id_author;";
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
