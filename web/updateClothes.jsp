<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="components/adminHeadComponent.jsp" %>
    <title>Manage Account</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="sb-nav-fixed">
    <%@include file="components/adminNavBarComponent.jsp" %>
    <div id="layoutSidenav">
        <%@include file="components/adminSlideNavComponent.jsp" %>
        <div id="layoutSidenav_content" style="width: 80%">
            <form action="updateClothes" method="post" enctype="multipart/form-data" style="margin: 20px; padding: 20px;">
                <h1 style="color: red">UPDATE CLOTHES</h1>
                <div class="form-group" style="margin-bottom: 20px;">
                    <label>ID</label>
                    <input type="text" class="form-control" name="id" readonly aria-describedby="emailHelp" value="${requestScope.clothes.id}">
                </div>
                <div class="form-group" style="margin-bottom: 20px;">
                    <label>Name</label>
                    <input type="text" class="form-control" name="name" value="${requestScope.clothes.title}">
                </div>
                <div class="form-group" style="margin-bottom: 20px;">
                    <label>Image</label>
                    <input type="file" class="form-control" name="image">
                </div>
                <div class="form-group" style="margin-bottom: 20px;">
                    <label>Price</label>
                    <input type="text" class="form-control" name="price" value="${requestScope.clothes.price}">
                </div>
                <div class="form-group" style="margin-bottom: 20px;">
                    <label>Description</label>
                    <input type="text" class="form-control" name="description" value="${requestScope.clothes.description}">
                </div>
                <div class="form-group" style="margin-bottom: 20px;">
                    <label>Category</label>
                    <select name="categoryId" class="form-control">
                        <c:forEach items="${requestScope.listCategory}" var="category">
                            <option value="${category.id}" <c:if test="${category.id eq requestScope.clothes.category.id}">selected</c:if>>${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
            </form>
            <jsp:include page="components/adminFooter.jsp"></jsp:include>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="../js/datatables-simple-demo.js"></script>
</body>
</html>
