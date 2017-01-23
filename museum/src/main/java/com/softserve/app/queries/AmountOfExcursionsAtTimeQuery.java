package com.softserve.app.queries;

import java.util.List;

import com.softserve.app.entity.Excursion;

public class AmountOfExcursionsAtTimeQuery {
	public int getAmountOfExcursions(SessionFactory factory,String ...args){
		int k;
		tring startDate=args[0];
		String endDate=args[1];
		Session session=factory.openSession();
		List excursions=null;
		String sql = "select count(excursion.id_excursion) as count_of_excursions"+
             "from schedule inner join excursion"+
             "on excursion.id_excursion = schedule.id_excursion"+
            "where schedule.date_start > "+startDate+" AND schedule.date_end < "+endDate+";";
	    Transaction tx = null;
	    try{
	         tx = session.beginTransaction();
	         SQLQuery query = session.createSQLQuery(sql);
	         List result=query.list();
	         k=(Integer)result.get(0);
	          // here we get the list of all exhibits in base
	       }
	         tx.commit();
	     }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	     }finally {
	         session.close(); 
	     }
		return k;
	}

}
