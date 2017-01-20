package com.softserve.app.dao;

import java.util.List;
import java.sql.SQLException;

public interface GenericDAO<E> {
	
	public void addElement(E element) throws SQLException;
    public void updateElement(E element) throws SQLException;
    public E getElementByID(Long elementId) throws SQLException;
    public List<E> getAllElements() throws SQLException;
    public void deleteElement(E element) throws SQLException;

}
