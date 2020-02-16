package com.softserve.boardgameShack.servlet.admin;

import com.softserve.boardgameShack.entity.User;
import com.softserve.boardgameShack.service.UserService;
import com.softserve.boardgameShack.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/userList")
public class UserListServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final List<User> users;
        users = userService.getAll();
        req.setAttribute("users", users);
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/userList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
