package com.softserve.app.queries;

import java.util.List;

import com.softserve.app.entity.Exhibit;

public class ExhibitInfoQuery implements Query {

	@Override
	public List executeQuery(SessionFactory factory,String ...args) { //args not used in this method as we take all Exhibits without any constraints
		Session session=factory.openSession();
		List exhibitsInfo=null;
		String sql = "select exhibit.id_exhibit, exhibit.id_hall, exhibit.id_author,"+
        "exhibit.name, exhibit.material, exhibit.technique, hall.name as name_of_hall,"+
         "author.first_name as author_first_name, author.last_name as author_last_name"+
         "from (hall inner join exhibit) inner join author"+
           "on hall.id_hall = exhibit.id_hall"+
           "and exhibit.id_author = author.id_author"+
            "group by id_exhibit;";
	    Transaction tx = null;
	    try{
	         tx = session.beginTransaction();
	         SQLQuery query = session.createSQLQuery(sql);
	         query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	         exhibitsInfo = query.list(); // here we get the list of all exhibits in base
	       }
	         tx.commit();
	     }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	     }finally {
	         session.close(); 
	     }
		return exhibitsInfo;
	}
    
	