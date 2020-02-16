<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table" border="2">
    <thead class="thead-dark">
    <tr>
        <th>Game</th>
        <th>Image</th>
        <th>Loan price(UAH/day)</th>
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
            <td>
                <a href="/publishingHouseView?name=${game.publishingHouse.name}">
                        ${game.publishingHouse.name}
                </a>
            </td>
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