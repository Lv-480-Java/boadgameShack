package com.softserve.boardgameShack.service.validator;

import com.softserve.boardgameShack.dao.UserDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private final UserDao userDao = new UserDao();

    public void validate(final String email) throws IllegalArgumentException {
        final String emailString = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        final Pattern emailPattern = Pattern.compile(emailString);
        final Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.matches()) {
            throw new IllegalArgumentException("Email is not valid.");
        }
        exists(email);
    }

    private void exists(final String email) throws IllegalArgumentException {
        if (userDao.getByEmail(email) != null) {
            throw new IllegalArgumentException("This mail is already registered. Please type another.");
        }
    }

}
