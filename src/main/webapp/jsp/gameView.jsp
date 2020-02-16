<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<myTags:gameSearch/>
<head>
    <title>${model.name}</title>
</head>
<body>
<myTags:navPanel/>
<img src="${model.image}" width="300" height="300">
<h1>
    ${model.name}
</h1>
<ul class="list-group">
    <li class="list-group-item">Price: ${model.price}</li>
    <li class="list-group-item">Time to play: ${model.timeToPlay}</li>
    <li class="list-group-item">Number of players: ${model.playerNumber}</li>
    <li class="list-group-item">Language: ${model.language}</li>
    <li class="list-group-item">Publishing house:
        <a href="/publishingHouseView?name=${model.publishingHouse.name}">
            ${model.publishingHouse.name}
        </a>
    </li>
    <c:if test="${model.getCategories()} != null">
        <li class="list-group-item">
            Categories:
            <c:forEach var="category" items="${model.getCategories()}">
                <br>#${category.name}
            </c:forEach>
        </li>
    </c:if>
    <li class="list-group-item">Description: ${model.description}</li>
</ul>

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