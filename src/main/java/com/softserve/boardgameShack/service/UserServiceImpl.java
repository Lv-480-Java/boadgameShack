package com.softserve.boardgameShack.service;

import com.softserve.boardgameShack.dao.UserDao;
import com.softserve.boardgameShack.entity.User;
import com.softserve.boardgameShack.service.validator.EmailValidator;
import com.softserve.boardgameShack.service.validator.PasswordValidator;
import com.softserve.boardgameShack.service.validator.UsernameValidator;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao dao = new UserDao();
    private final EmailValidator emailValidator = new EmailValidator();
    private final PasswordValidator passwordValidator = new PasswordValidator();
    private final UsernameValidator usernameValidator = new UsernameValidator();

    @Override
    public List<User> getByName(final String name) {
        return dao.getByName(name);
    }

    @Override
    public User getById(final long id) {
        return dao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(final User model, final String repeatPassword) throws IllegalArgumentException {
        passwordValidator.validate(model.getPassword(), repeatPassword);
        usernameValidator.validate(model.getName());
        emailValidator.validate(model.getEmail());
        dao.add(model);
    }

    @Override
    public void delete(final User user) {
        dao.delete(user);
    }
}
