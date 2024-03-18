<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Purchase</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <link rel="stylesheet" href="css/purchase.css">
    </head>
    <body >
        <div id="menu">
            <%@include file="menu.jsp" %>
        </div>
        <section id="cart" class="section-p1">
            <div class="cart-actions">
                <a href="purchaseProduct?sid=${0}">ALL</a>
                <c:forEach items="${requestScope.listStatus}" var="s">
                    <a href="purchaseProduct?sid=${s.id}">${s.name}</a>
                </c:forEach>
            </div>
            <div>
                <c:set value="${requestScope.listOrderDetails}" var="list"/>
                <c:if test="${((list == null) || (list.size() == 0))}">
                    <h3>No product</h3>
                </c:if>
                <c:if test="${((list != null) && (list.size() > 0))}">
                    <table width="100%">
                        <thead>
                            <tr>
                                <td>Image</td>
                                <td>Product</td>
                                <td>Size</td>
                                <td>Quantity</td>
                                <td>Subtotal</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${list}" >
                                <tr >
                                    <td><img src="${p.product_id.thumbnail}" alt=""></td>
                                    <td>${p.product_id.title}</td>
                                    <td>${p.size}</td>
                                    <td>${p.quantity}</td>
                                    <td>${p.total_money} $</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </section>
        <div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
