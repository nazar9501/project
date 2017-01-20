package com.softserve.app.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.SQLException;


public class ElementDAOImpl<E> implements GenericDAO<E>  {
	
	private Class<E> elementClass;

    public ElementDAOImpl(Class<E> elementClass) {
        this.elementClass = elementClass;
    }
    
    public void addElement(E element) throws SQLException {
    	Session session = null;
        try {
        	session = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(element);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }

    public void updateElement(E element) throws SQLException {
    	Session session = null;
        try {
        	session = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(element);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }

    public E getElementByID(Long elementId) throws SQLException {
    	Session session = null;
        E element = null;
        try {
        	session = HibernateSessionFactory.getSessionFactory().openSession();
            element = session.get(elementClass, elementId);
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return element;
    }

    public List<E> getAllElements() throws SQLException {
    	Session session = null;
        List<E> elements = new ArrayList<E>();
        try {
        	session = HibernateSessionFactory.getSessionFactory().openSession();
            elements = session.createCriteria(elementClass).list();
        } finally {
           if ((session != null) && (session.isOpen())) {
                session.close();
           }
        }
        return elements;
    }

    public void deleteElement(E element) throws SQLException {
    	Session session = null;
    	try {
    		session = HibernateSessionFactory.getSessionFactory().openSession();
    		Transaction transaction = session.beginTransaction();
    		session.delete(element);
    		transaction.commit();
    	} finally {
    		if ((session != null) && (session.isOpen())) {
                session.close();
    		}
    	}
    }

	
}
