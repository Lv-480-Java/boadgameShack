<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>
        Admin panel
    </title>
</head>
<body>
<myTags:navPanel/>
    <h1>Welcome, ${sessionScope.user.name}</h1>
    <div class="row">
        <div class="col-3">
            <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <a class="nav-link active" id="v-pills-games-tab" data-toggle="pill" href="#v-pills-games" role="tab" aria-controls="v-pills-games" aria-selected="true">Games</a>
                <a class="nav-link" id="v-pills-users-tab" data-toggle="pill" href="#v-pills-users" role="tab" aria-controls="v-pills-users" aria-selected="false">Users</a>
                <a class="nav-link" id="v-pills-categories-tab" data-toggle="pill" href="#v-pills-categories" role="tab" aria-controls="v-pills-categories" aria-selected="false">Categories</a>
                <a class="nav-link" id="v-pills-publishing_houses-tab" data-toggle="pill" href="#v-pills-publishing_houses" role="tab" aria-controls="v-pills-publishing_houses" aria-selected="false">Publishing houses</a>
            </div>
        </div>
        <div class="col-9">
            <div class="tab-content" id="v-pills-tabContent">
                <div class="tab-pane fade show active" id="v-pills-games" role="tabpanel" aria-labelledby="v-pills-games-tab">
                    <a href="/gameList" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">All games</a>
                    <a href="/admin/gameSave" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add game</a>
                </div>
                <div class="tab-pane fade" id="v-pills-users" role="tabpanel" aria-labelledby="v-pills-users-tab">
                    <nav class="navbar navbar-light bg-light">
                        <form class="form-inline" action="/admin/userSearch" method="get">
                            <input class="form-control mr-sm-2" type="search" name="userName" placeholder="Search user" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                        <a href="/admin/userList" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">All users</a>
                    </nav>
                </div>
                <div class="tab-pane fade" id="v-pills-categories" role="tabpanel" aria-labelledby="v-pills-categories-tab">
                    <a href="/admin/categorySave" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add category</a>
                    <myTags:categoriesCards/>
                </div>
                <div class="tab-pane fade" id="v-pills-publishing_houses" role="tabpanel" aria-labelledby="v-pills-publishing_houses-tab">
                    <a href="/admin/publishingHouseList" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">All PH</a>
                    <a href="/admin/publishingHouseSave" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add PH</a>
                </div>
            </div>
        </div>
    </div>
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