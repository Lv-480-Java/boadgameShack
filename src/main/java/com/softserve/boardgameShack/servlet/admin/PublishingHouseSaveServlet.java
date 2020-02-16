package com.softserve.boardgameShack.servlet.admin;

import com.softserve.boardgameShack.entity.PublishingHouse;
import com.softserve.boardgameShack.service.PublishingHouseService;
import com.softserve.boardgameShack.service.PublishingHouseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/publishingHouseSave")
public class PublishingHouseSaveServlet extends HttpServlet {

    private final PublishingHouseService phService = new PublishingHouseServiceImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/publishingHouseSaveForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setName(req.getParameter("name"));
        phService.add(publishingHouse);
        resp.sendRedirect("/admin/adminPage");
    }
}
