<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<myTags:navPanel/>
<head>
    <title>Game list</title>
</head>

<body>
<table class="table" border="2">
    <thead class="thead-dark">
    <tr>
        <th>Game</th>
        <th>Image</th>
        <th>Price</th>
        <th>Time to play</th>
        <th>Players</th>
        <th>Description</th>
        <th>Language</th>
        <th>Publishing house</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="game" items="${games}">
        <tr>
            <td>
                <a href="/gameView?id=${game.id}">
                        ${game.name}
                </a>
            </td>
            <td><img src="${game.image}" alt="${game.name}" width="70" height="70"></td>
            <td>${game.price}</td>
            <td>${game.timeToPlay}</td>
            <td>${game.playerNumber}</td>
            <td>${game.description}</td>
            <td>${game.language}</td>
            <td>${game.publishingHouse.name}</td>
            <c:if test="${sessionScope.user.userRole.name() == 'ADMIN'}">
                <td>
                    <form action="/admin/gameUpdate" method="get">
                        <input type="hidden" name="id" value="${game.id}">
                        <input type="submit" value="Edit">
                    </form>
                    <form action="/admin/gameDelete" method="get">
                        <input type="hidden" name="id" value="${game.id}">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>