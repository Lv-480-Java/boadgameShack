<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>New user</title>
</head>

<body style="text-align: center">
<myTags:navPanel/>
<h1>Registration</h1>

<form style="width: 500px;
    display: inline-block;
    margin-left: auto;
    margin-right: auto;
    text-align: left;" action="/registration" method="post">
    <div class="form-group row">
        <label for="inputUser3" class="col-sm-2 col-form-label">Username</label>
        <div class="col-sm-10">
            <input type="text" name="name" class="form-control" id="inputUser3" placeholder="Username" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
            <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="inputRepeatPassword3" class="col-sm-2 col-form-label">Repeat password</label>
        <div class="col-sm-10">
            <input type="password" name="repeatPassword" class="form-control" id="inputRepeatPassword3" placeholder="Password" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10">
            <input type="email" name="email" class="form-control" id="inputEmail3" placeholder="Email" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="inputPhone3" class="col-sm-2 col-form-label">Phone number</label>
        <div class="col-sm-10">
            <input type="tel" name="phone" class="form-control" id="inputPhone3" placeholder="Phone">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-success">Register</button>
        </div>
    </div>
</form>
<script type="text/javascript">
    var Msg ='<%=(String)request.getAttribute("error-msg")%>';
    if (Msg!="null") {
        alert(Msg);
    }
</script>
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