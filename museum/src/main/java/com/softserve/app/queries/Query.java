package com.softserve.app.queries;

import java.util.List;
import org.hibernate.SessionFactory;

public interface Query {
	public List executeQuery(SessionFactory factory,String ...args);
}
