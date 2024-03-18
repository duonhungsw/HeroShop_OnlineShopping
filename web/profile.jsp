<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link rel="stylesheet" href="css/menu.css"/>
        <link rel="stylesheet" href="css/information.css"/>
    </head>
    <body>
        <div id="menu">
            <%@include file="menu.jsp" %>
        </div>

        <form action="updateUser" method="post">
            <div class="information">
                <div class="form-row">
                    <div class="form-group" style="display: none;">
                        <label for="inputAddress">ID</label>
                        <input style="text-transform: none;" type="text" class="form-control" name="id" value="${requestScope.account.id}">
                    </div>
                    <div class="form-group">
                        <label for="inputAddress">Fullname</label>
                        <input style="text-transform: none;" type="text" class="form-control" name="name" value="${requestScope.account.fullname}">
                    </div>
                    <div class="form-group">
                        <label for="inputAddress">Pass</label>
                        <input style="text-transform: none;" type="text" class="form-control" name="pass" value="${requestScope.account.password}">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Email</label>
                        <input style="text-transform: none;" type="email" readOnly class="form-control" name="email" value="${requestScope.account.email}" >
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Phone number</label>
                        <input style="text-transform: none;" type="number" class="form-control" name="phone" value="${requestScope.account.phone_number}">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="inputCity">Address</label>
                        <input type="text" class="form-control" name="Address" value="${requestScope.account.address}">
                    </div>

                </div>
                <input type="submit" class="btn btn-primary" value="Save"/>
        </form>
        <div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
