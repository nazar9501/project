package com.softserve.app.queries;

import java.util.List;

import com.softserve.app.entity.Exhibit;

public class ExhibitsByWorkerQuery implements Query {

	@Override
	public List executeQuery(SessionFactory factory, String... args) {
		String workerName=args[0];
		Session session=factory.openSession();
		List exhibits=null;
		String sql = "select * FROM exhibits"+
        "WHERE (SELECT workers.first_name,workers.last_name,workers.id_worker WHERE workers.first_name+workers.last_name="+workerName+"as worker"+
        ")exhibits.id_worker=worker.id_worker";
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