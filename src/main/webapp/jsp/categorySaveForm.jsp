<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>New category</title>
</head>
<body style="text-align: center">
<myTags:navPanel/>
<h1>New Category</h1>
<form style="width: 500px;
    display: inline-block;
    margin-left: auto;
    margin-right: auto;
    text-align: left;" action="/admin/categorySave" method="post">
    <div class="form-group row">
        <label for="inputCategory3" class="col-sm-2 col-form-label">Category name</label>
        <div class="col-sm-10">
            <input type="text" name="name" class="form-control" id="inputCategory3" placeholder="Category" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="inputImage3" class="col-sm-2 col-form-label">Image URL</label>
        <div class="col-sm-10">
            <input type="text" name="image" class="form-control" id="inputImage3" placeholder="URL" required>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-success">Submit</button>
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