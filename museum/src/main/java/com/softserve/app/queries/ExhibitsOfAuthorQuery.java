package com.softserve.app.queries;

import java.util.List;

public class ExhibitsOfAuthorQuery extends Query {

	@Override
	public List executeQuery(SessionFactory factory, String... args) {
		String author=args[0];// Author is given like a parameter to this function
		
		return null;
	}

}
