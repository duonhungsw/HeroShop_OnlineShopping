<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="components/adminHeadComponent.jsp" %>
        <title>Manage Account</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body class="sb-nav-fixed">
        <!-- Admin navbar -->
        <%@include file="components/adminNavBarComponent.jsp" %>
        <div id="layoutSidenav">
            <!-- Admin Slidenav -->
            <%@include file="components/adminSlideNavComponent.jsp" %>
            <div id="layoutSidenav_content" style="width: 80%">
                <c:set var="c" value="${requestScope.account}"/>
                    <form action="updateAccount" method="post" style="margin: 20px; padding: 20px;">
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="exampleInputEmail1">ID</label>
                            <input type="text" class="form-control" name="accountId" readonly aria-describedby="emailHelp" value="${c.id}">
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="exampleInputEmail1">Name</label>
                            <input type="text" class="form-control" name="name" aria-describedby="emailHelp" value="${c.fullname}">
                        </div><!-- comment -->
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="exampleInputEmail1">Pass Word</label>
                            <input type="password" class="form-control" name="pass" aria-describedby="emailHelp" value="${c.password}">
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="exampleInputEmail1">Address</label>
                            <input type="text" class="form-control" name="address" aria-describedby="emailHelp" value="${c.address}">
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="exampleInputEmail1">Email</label>
                            <input type="email" class="form-control" name="email" aria-describedby="emailHelp" value="${c.email}">
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="exampleInputEmail1">Phone</label>
                            <input type="text" class="form-control" name="phone" aria-describedby="emailHelp" value="${c.phone_number}">
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="exampleInputEmail1">Role</label>
                            <select name="role" class="form-select form-select-lg" id="status3Example">
                                <option value="1">User</option>
                                <option value="0">Admin</option>
                            </select>                    
                        </div>
                        <button type="submit" class="btn btn-primary">Update</button>
                    </form>
                <!-- Footer -->
                <jsp:include page="components/adminFooter.jsp"></jsp:include>
            </div>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="../js/datatables-simple-demo.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>
</html>
