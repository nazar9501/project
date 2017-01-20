package com.softserve.app.dao;

public class DaoFactory {
	
	private AuthorDAO authorDAO = null;
	private ExcursionDAO excursionDAO = null;
	private ExhibitDAO exhibitDAO = null;
	private HallDAO hallDAO = null;
	private ScheduleDAO scheduleDAO = null;
	private WorkersDAO workersDAO = null;
	
	private static DaoFactory instance = null;

    private DaoFactory() {
    	authorDAO = new AuthorDAO();
    	excursionDAO = new ExcursionDAO();
    	exhibitDAO = new ExhibitDAO();
    	hallDAO = new HallDAO();
    	scheduleDAO = new ScheduleDAO();
    	workersDAO = new WorkersDAO();    	
    }
    
    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }
    
    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }
    
    public ExcursionDAO getExcursionDAO() {
        return excursionDAO;
    }
    
    public ExhibitDAO getExhibitDAO() {
        return exhibitDAO;
    }
    
    public HallDAO getHallDAO() {
        return hallDAO;
    }
    
    public ScheduleDAO getScheduleDAO() {
        return scheduleDAO;
    }
    
    public WorkersDAO getWorkersDAO() {
        return workersDAO;
    }

}
