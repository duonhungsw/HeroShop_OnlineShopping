<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
        <style>
            input[type="submit"] {
                border: 1px solid black;
            }


            .btn-black:hover {
                background-color: orange;
                color: white;
            }


        </style>
    </head>
    <body>
        <div id="menu">
            <%@include file="menu.jsp" %>
        </div>

        <section class="contact section-padding order">

            <div class="untree_co-section ">
                <div class="container">

                    <div class="row">
                        <form action="order" method="post">
                            <div class="col-md-6">
                                <h1>Infomation bill</h1>
                                <<h2>${requestScope.error}</h2>
                                <h2 class="h3 mb-3 text-black" style="font-weight: bold">Billing Details</h2>
                                <div class="p-3 p-lg-5 border bg-white">
                                    <div class="form-group row">

                                        <div class="col-md-12">
                                            <label for="c_address" class="text-black">Name <span class="text-danger">*</span></label>
                                            <input type="text" class="form-control" id="c_address" name="name" placeholder="Detail address">
                                        </div>
                                        <div class="col-md-12">
                                            <label for="c_address" class="text-black">Phone <span class="text-danger">*</span></label>
                                            <input type="text" class="form-control" id="c_address" name="phone" placeholder="Phone Number">
                                        </div>
                                        <div class="col-md-12">
                                            <label for="c_address" class="text-black">Address <span class="text-danger">*</span></label>
                                            <input type="text" class="form-control" id="c_address" name="address" placeholder="Phone Number">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="c_order_notes" class="text-black">Order Notes</label>
                                        <textarea name="note" id="c_order_notes" cols="30" rows="5" class="form-control" placeholder="Write your notes here..."></textarea>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-12">

                                <div class="row mb-5">
                                    <div class="col-md-12">
                                        <h2 class="h3 mb-3 text-black" style="font-weight: bold;">Your Order</h2>
                                        <div class="p-3 p-lg-5 border bg-white">

                                            <table class="table site-block-order-table mb-5">
                                                <thead>
                                                <th>Product</th>
                                                <th>Total</th>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="c" items="${requestScope.listCP}">
                                                        <tr>
                                                            <td>
                                                                <strong>${c.product.title}</strong>
                                                                <span style="font-size: 14px;color: grey;">${c.size}</span>
                                                                <strong class="mx-2">x</strong> ${c.quantity}
                                                            </td>
                                                            <td>${c.total_money}</td>
                                                        </tr>

                                                    </c:forEach>
                                                    <tr style="background: grey;">
                                                        <td class="text-black font-weight-bold"><strong style="color: red;">Order Total</strong></td>
                                                        <td class="text-black font-weight-bold"><strong>${requestScope.total}</strong></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <input class="btn btn-black btn-lg py-3 btn-block" type="submit" value="Place Order"/>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
