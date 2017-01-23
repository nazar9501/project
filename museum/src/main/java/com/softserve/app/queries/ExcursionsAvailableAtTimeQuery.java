package com.softserve.app.queries;
import java.util.List;

import com.softserve.app.entity.*;
public class ExcursionsAvailableAtTimeQuery implements Query {

	@Override
	public List executeQuery(SessionFactory factory,String ...args) { //args not used in this method as we take all Exhibits without any constraints
		String startDate=args[0];
		String endDate=args[1];
		Session session=factory.openSession();
		List excursions=null;
		String sql = "select * FROM excursion;"+
		"WHERE (SELECT schedule.id_excursion WHEREschedule.date_start >"+startDate+" AND schedule.date_end < "+endDate+";)as scheduleID"+
				"scheduleID.id_excursion=excursion.id_excursion";
	    Transaction tx = null;
	    try{
	         tx = session.beginTransaction();
	         SQLQuery query = session.createSQLQuery(sql);
	         query.addEntity(Excursion.class);
	         workers = query.list(); // here we get the list of all exhibits in base
	       }
	         tx.commit();
	     }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	     }finally {
	         session.close(); 
	     }
		return excursions;
	}
    
	
}