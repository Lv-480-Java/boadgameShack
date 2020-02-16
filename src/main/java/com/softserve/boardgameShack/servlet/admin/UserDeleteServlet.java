package com.softserve.boardgameShack.servlet.admin;

import com.softserve.boardgameShack.entity.User;
import com.softserve.boardgameShack.service.UserService;
import com.softserve.boardgameShack.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/userDelete")
public class UserDeleteServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final long id = Long.parseLong(req.getParameter("id"));
        final User user = userService.getById(id);
        req.setAttribute("user", user);
        userService.delete(user);
        resp.sendRedirect("/admin/userList");
    }
}
