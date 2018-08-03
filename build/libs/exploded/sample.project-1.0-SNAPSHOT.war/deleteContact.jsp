<%--
  Created by IntelliJ IDEA.
  User: gauravsharma
  Date: 02/08/18
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="WebContent/css/bootstrap.css">
</head>
<body>

<div class="row">
    <div class="col-md-12">
        <form action="${pageContext.request.contextPath}/deleteContact" method="post">
            <div class="form-group">
                <label for="contactId">ContactID</label>
                <input type="text" class="form-control" id="contactId" placeholder="Name" name="contactId">
            </div>
            <button type="submit" class="btn btn-default btn-success">Submit</button>
        </form>
    </div>
</div>

</body>
</html>
