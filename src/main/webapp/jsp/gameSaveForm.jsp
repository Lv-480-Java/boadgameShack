<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<head>
    <title>Add new game</title>
</head>

<body style="text-align: center">
<myTags:navPanel/>
<h1>Add game:</h1>
<form style="width: 600px;
    display: inline-block;
    margin-left: auto;
    margin-right: auto;
    text-align: left;" action="/admin/gameSave" method="post">
    <div class="form-group row">
        <label for="inputName3" class="col-sm-2 col-form-label">Name</label>
        <div class="col-sm-10">
            <input type="text" name="name" class="form-control" id="inputName3" placeholder="Name" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="inputPrice3" class="col-sm-2 col-form-label">Loan price</label>
        <div class="col-sm-10">
            <input type="number" name="price" class="form-control" id="inputPrice3" placeholder="Price" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="inputTime3" class="col-sm-2 col-form-label">Time to play</label>
        <div class="col-sm-10">
            <input type="text" name="timeToPlay" class="form-control" id="inputTime3" placeholder="Time">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputPlayers3" class="col-sm-2 col-form-label">Number of players</label>
        <div class="col-sm-10">
            <input type="text" name="playerNumber" class="form-control" id="inputPlayers3"
                   placeholder="Number of players">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputDescription3" class="col-sm-2 col-form-label">Description</label>
        <div class="col-sm-10">
            <input type="text" name="description" class="form-control" id="inputDescription3" placeholder="Description">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputLanguage3" class="col-sm-2 col-form-label">Language</label>
        <div class="col-sm-10">
            <input type="text" name="language" class="form-control" id="inputLanguage3" placeholder="Language">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputPH3" class="col-sm-2 col-form-label">Publishing house</label>
        <div class="col-sm-10">
            <input type="text" name="publishingHouse" class="form-control" id="inputPH3" placeholder="Publishing house">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputImage3" class="col-sm-2 col-form-label">Image URL</label>
        <div class="col-sm-10">
            <input type="text" name="image" class="form-control" id="inputImage3" placeholder="URL">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputCategory3" class="col-sm-2 col-form-label">Categories</label>
        <div class="col-sm-10">
            <c:forEach var="category" items="${categories}">
                <h6>${category.name}</h6>
                <input type="checkbox" name="categoryArray" class="form-control" id="inputCategory3"
                       value="${category.name}">
            </c:forEach>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </div>
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