<%--
  Created by IntelliJ IDEA.
  User: gauravsharma
  Date: 30/07/18
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacts</title>
    <link rel="stylesheet" href="WebContent/css/bootstrap.css">
</head>
<body>

    <div class="container">
        <h1 class="text-center">Contacts Application</h1>

        <hr>

        <div class="row">
            <div class="col-md-2">
                <a href="#" class="btn btn-info">Entry</a>
            </div>
            <div class="col-md-2">
                <a href="#" class="btn btn-primary">All Contacts</a>
            </div>
            <div class="col-md-2">
                <a href="/deleteContact" class="btn btn-warning">Delete Image</a>
            </div>
        </div>

        <hr>

        <div class="row">
            <div class="col-md-12">
                <form action="${pageContext.request.contextPath}/addContact" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="username">Name</label>
                        <input type="text" class="form-control" id="username" placeholder="Name" name="username">
                    </div>
                    <div class="form-group">
                        <label for="number">Mobile Number</label>
                        <input type="text" class="form-control" id="number" placeholder="Mobile Number" name="number">
                    </div>
                    <div class="form-group">
                        <label for="address">Address</label>
                        <input type="text" class="form-control" id="address" placeholder="Address" name="address">
                    </div>
                    <div class="form-group">
                        <label for="image">Upload Image</label>
                        <input type="file" id="image" name="image">
                    </div>
                    <button type="submit" class="btn btn-default btn-success">Submit</button>
                </form>
            </div>
        </div>
    </div>


</body>
</html>
