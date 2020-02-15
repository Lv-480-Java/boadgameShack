<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="box" style="
  width: 100%;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
">
    <c:forEach var="category" items='${applicationScope["categories"]}'>
        <div class="card" style="width: 18rem; margin: 20px">
            <a href="/categoryView?name=${category.name}">
                <img src="${category.image}" class="card-img-top" alt="..." height="150" width="150">
            </a>
            <h5 class="card-title" align="center">${category.name}</h5>
            <div class="card-body">
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                    card's content.</p>
                <a href="/categoryView?name=${category.name}" class="btn btn-secondary">Go to "${category.name}"</a>
            </div>
        </div>
    </c:forEach>
</div>