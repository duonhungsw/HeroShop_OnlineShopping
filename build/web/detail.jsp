
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/detail.css"/>

    </head>
    <style>

    </style>
    <body>
        <div id="menu">
            <%@include file="menu.jsp" %>
        </div>

        <section id="prodetails" class="section-p1">
            <div class="single-pro-image">
                <img src="${requestScope.detail.thumbnail}" width="100%" id="MainImg" alt="">


            </div>
            <div class="single-pro-details">
                <form action="addToCart" method="get">
                    <h6>${requestScope.detail.category.name}</h6>
                    <h4>${requestScope.detail.title}</h4>
                    <h2>${requestScope.detail.price} $</h2>
                    <select id="sizeSelect" name="size">
                        <option value="" disabled selected hidden>Select Size</option>
                        <option>XXL</option>
                        <option>XL</option>
                        <option>L</option>
                        <option>M</option>
                    </select>
                    <input name="quantity" id="quantityInput" type="number" value="1" min="1">

                    <button name="id" value="${requestScope.detail.id}">Thêm vào giỏ hàng</button>
       
                    <h4 id="description">Chi tiết sản phẩm</h4>
                    <span>${detail.description}</span>
                </form>
            </div>
        </section>
        <div id="footer">
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
