package com.softserve.boardgameShack.servlet;

import com.softserve.boardgameShack.entity.Game;
import com.softserve.boardgameShack.entity.PublishingHouse;
import com.softserve.boardgameShack.service.GameService;
import com.softserve.boardgameShack.service.GameServiceImpl;
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

@WebServlet("/publishingHouseView")
public class GamesByPhServlet extends HttpServlet {

    private final PublishingHouseService phService = new PublishingHouseServiceImpl();
    private final GameService gameService = new GameServiceImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final PublishingHouse publishingHouse = phService.getByName(req.getParameter("name"));
        final List<Game> games = gameService.getByPublishingHouse(publishingHouse);
        req.setAttribute("games", games);
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/gameList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
