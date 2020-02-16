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
import java.util.List;

@WebServlet("/admin/publishingHouseList")
public class PublishingHouseListServlet extends HttpServlet {

    private final PublishingHouseService phService = new PublishingHouseServiceImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final List<PublishingHouse> publishingHouses;
        publishingHouses = phService.getAll();
        req.setAttribute("publishingHouses", publishingHouses);
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/publishingHouseList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
