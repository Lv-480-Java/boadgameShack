package com.softserve.boardgameShack.service;

import com.softserve.boardgameShack.dao.LoginDao;
import com.softserve.boardgameShack.dao.LoginDaoimpl;

public class LoginServiceImpl implements LoginService {

    private final LoginDao loginDao = new LoginDaoimpl();

    @Override
    public boolean checkUserProperties(final String name, final String password) {
        return loginDao.checkUserProperties(name, password);
    }
}
