package com.softserve.boardgameShack.service.validator;

import com.softserve.boardgameShack.dao.UserDao;

public class UsernameValidator {

    private final UserDao userDao = new UserDao();

    public void validate(final String username) throws IllegalArgumentException {
        if (userDao.getByName(username).size() != 0) {
            throw new IllegalArgumentException("\"" + username + "\"" +
                    " username already exist. Please choose another");
        }
    }
}
