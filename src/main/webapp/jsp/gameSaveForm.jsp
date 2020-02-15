<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<head>
    <title>Add new game</title>
</head>

<body>
<h1>Add game:</h1>
<form action="/admin/gameSave" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" required></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" name="price" min="0" required></td>
        </tr>
        <tr>
            <td>Time to play:</td>
            <td><input type="text" name="timeToPlay"></td>
        </tr>
        <tr>
            <td>Number of players:</td>
            <td><input type="text" name="playerNumber"></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>Language:</td>
            <td><input type="text" name="language"></td>
        </tr>
        <tr>
            <td>Publishing house:</td>
            <td><input type="text" name="publishingHouse"></td>
        </tr>
        <tr>
            <td>Image URL:</td>
            <td><input type="text" name="image"></td>
        </tr>
        <tr>
            <td>Categories:</td>
            <%--<div class="form-check">--%>
            <%--<c:forEach var="category" items="${categories}">--%>
                <%--<input class="form-check-input" type="checkbox" value="" name="categoryArray"--%>
                           <%--id="defaultCheck1">--%>
                <%--<label class="form-check-label" for="defaultCheck1">--%>
                        <%--${category.name}--%>
                <%--</label>--%>
            <%--</c:forEach>--%>
            <%--</div>--%>
            <c:forEach var = "category" items = "${categories}">
            <td><input type="checkbox" name="categoryArray" value="${category.name}"></td>
            <td>${category.name}</td>
            </c:forEach>
        </tr>
        <%--<div class="form-group row">--%>
            <%--<div class="col-sm-2">Categories</div>--%>
            <%--<div class="col-sm-10">--%>
                <%--<div class="form-check">--%>
                    <%--<input class="form-check-input" type="checkbox" id="gridCheck1">--%>
                    <%--<label class="form-check-label" for="gridCheck1">--%>
                        <%--Example checkbox--%>
                    <%--</label>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
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