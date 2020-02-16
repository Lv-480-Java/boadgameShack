package com.softserve.boardgameShack.servlet.admin;

import com.softserve.boardgameShack.entity.Game;
import com.softserve.boardgameShack.service.GameService;
import com.softserve.boardgameShack.service.GameServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/admin/gameUpdate")
public class GameUpdateServlet extends HttpServlet {

    private final GameService gameService = new GameServiceImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final long id = Long.parseLong(req.getParameter("id"));
        final Game game = gameService.getById(id);
        req.setAttribute("game", game);
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/gameUpdateForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final Game game = gameService.getById(Long.valueOf(req.getParameter("id")));
        game.setName(req.getParameter("name"));
        game.setPrice(Double.valueOf(req.getParameter("price")));
        game.setTimeToPlay(req.getParameter("timeToPlay"));
        game.setPlayerNumber(req.getParameter("playerNumber"));
        game.setDescription(req.getParameter("description"));
        game.setLanguage(req.getParameter("language"));
        final String publishingHouse = req.getParameter("publishingHouse");
        final String[] categoryArray = req.getParameterValues("categoryArray");

        List<String> categoryNames = new ArrayList<>();

        if (categoryArray != null) {
            categoryNames = Arrays.asList(categoryArray);
        }

        gameService.update(game, publishingHouse, categoryNames);
        resp.sendRedirect("/homepage");
    }
}
