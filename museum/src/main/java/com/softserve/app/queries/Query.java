package com.softserve.app.queries;

import java.util.List;

public interface Query {
    public List executeQuery(SessionFactory factory,String ...args);
}
