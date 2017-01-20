package com.softserve.app.dao;

import com.softserve.app.entity.Author;

public class AuthorDAO extends ElementDAOImpl<Author> {
    public AuthorDAO() {
        super(Author.class);
    }
}
