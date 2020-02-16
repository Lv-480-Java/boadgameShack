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
<c:if test="${games.size() != 0}">
    <h2 style="text-align: center">Games: </h2>
    <myTags:gamesTable/>
</c:if>
<c:if test="${categories.size() != 0}">
    <h2 style="text-align: center">Categories: </h2>
    <ul class="list-group">
        <c:forEach var="category" items="${categories}">
            <li class="list-group-item">
                <a href="/categoryView?name=${category.name}">
                        ${category.name}
                </a>
            </li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${games.size() == 0 && categories.size() == 0}">
    <h2 style="text-align: center">No result found</h2>
</c:if>

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