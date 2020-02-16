<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="/homepage">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/gameList">All games</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Categories
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <c:forEach var="category" items='${applicationScope["categories"]}'>
                        <a class="dropdown-item" href="categoryView?name=${category.name}">${category.name}</a>
                    </c:forEach>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/aboutUs">About Us</a>
            </li>
            <li class="nav-item">
                <c:if test="${sessionScope.user == null}">
                <a class="nav-link" href="/loginForm">Login</a>
                </c:if>
            </li>
            <li class="nav-item">
                <c:if test="${sessionScope.user != null}">
                <a class="nav-link" href="/logout">Logout</a>
                </c:if>
            </li>
            <li class="nav-item">
                <c:if test="${sessionScope.user == null}">
                <a class="nav-link" href="/registration">Register</a>
                </c:if>
            </li>
            <li>
                <c:if test="${sessionScope.user.userRole.name() == 'ADMIN'}">
                    <a class="nav-link" href="/admin/adminPage">Admin panel</a>
                </c:if>
            </li>
        </ul>
        <form action="/search" method="get">
            <input type="text" name="name" placeholder="Search">
            <input type="submit" value="Search">
        </form>
    </div>
</nav>