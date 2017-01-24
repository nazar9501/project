package com.softserve.app.queries;

import java.util.List;

import com.softserve.app.entity.Workers;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class FreeGuidesQuery implements Query {

	
	public List executeQuery(SessionFactory factory,String ...args) { //args not used in this method as we take all Exhibits without any constraints
		String startDate=args[0];
		String endDate=args[1];
		Session session=factory.openSession();
		List workers=null;
		String sql = "select *"+
                      "from workers"+
                       "where post = 'Guide' and id_worker not in"+
                      " (select workers.id_worker"+
                     "from (schedule inner join excursion) inner join workers"+
                      "on excursion.id_excursion = schedule.id_excursion"+
                      "and workers.id_worker = excursion.id_guide"+
                      "where schedule.date_start > "+startDate+" AND schedule.date_end < "+endDate+");";
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