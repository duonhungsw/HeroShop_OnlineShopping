<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <link rel="stylesheet" href="css/cart.css">
    </head>
    <body>
        <div id="menu">
            <%@include file="menu.jsp" %>
        </div>
        <div id="banner">
            <div class="box-left">
                <h2>#cart</h2>
            </div>
        </div>
        <form action="updateQuantityCart" method="post">
            <section id="cart" class="section-p1">
                <table width="100%">
                    <thead>
                        <tr>
                            <td>Image</td>
                            <td>Product</td>
                            <td>Size</td>
                            <td>Quantity</td>
                            <td>Subtotal</td>
                            <td>Remove</td>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="listCart" items="${requestScope.list}">
                            <tr id="productRow-${listCart.id}">
                                <td><img src="${listCart.product.thumbnail}" alt=""></td>
                                <td>${listCart.product.title}</td>
                                <td>${listCart.size}</td>
                                <td>
                                    <input name="quantity_${listCart.id}" type="number" value="${listCart.quantity}" class="centered-input"
                                           data-price="${listCart.price}" onchange="updateTotalPrice(this)">

                                </td>
                                <td class="totalPrice">${listCart.quantity * listCart.price} $</td>

                                <td><a href="#" onclick="deleteProduct(${listCart.id}, event)"><i
                                            class="far fa-times-circle"></i></a></td>
                            </tr>

                        </c:forEach>

                    </tbody>
                </table>
            </section>

            <section id="cart-add" class="section-p1">
                <div id="coupon">
                    <h3>Apply Coupon</h3>
                    <div>
                        <input type="text" placeholder="Enter Your Coupon">
                        <button class="normal apply-btn">Apply</button>
                    </div>
                </div>

                <div id="subtotal">
                    <h3>Cart Totals</h3>
                    <table>
                        <tr>
                            <td>Cart Subtotal</td>
                            <td id="cartSubtotal">${requestScope.total} $</td>
                        </tr>
                        <tr>
                            <td>Shipping</td>
                            <td>Free</td>
                        </tr>
                        <tr>
                            <td>Total</td>
                            <td id="total">${requestScope.total} $</td>
                        </tr>
                    </table>
                    <input class="normal checkout-btn" type="submit" value="Update to the Cart"/>
                    <a href="checkOut" class="normal checkout-btn">Proceed to checkout</a>
                </div>

            </section>
        </form>
        <div id="footer">
            <%@include file="footer.jsp" %>
        </div>
        <script src="js/Jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>

        <script>
                                    function updateTotalPrice(input) {
                                        // Lấy giá trị số lượng từ input
                                        var quantity = parseInt(input.value);

                                        // Lấy giá tiền của sản phẩm từ thuộc tính data-price
                                        var price = parseInt(input.dataset.price);

                                        // Tính toán tổng giá tiền cho sản phẩm
                                        var totalPrice = quantity * price;

                                        // Lấy thẻ <td> chứa giá tiền tương ứng với input
                                        var totalPriceCell = input.parentElement.nextElementSibling;

                                        // Cập nhật giá tiền cho sản phẩm tương ứng
                                        totalPriceCell.innerHTML = totalPrice;

                                        // Cập nhật lại tổng giá trị
                                        updateTotalCart();
                                    }

                                    function deleteProduct(productId, event) {
                                        event.preventDefault(); // Ngăn chặn hành vi mặc định của thẻ <a>
                                        $.ajax({
                                            url: "deleteProductCart?id=" + productId,
                                            type: "GET",
                                            success: function (response) {
                                                // Xóa hàng chứa sản phẩm khỏi DOM
                                                $("#productRow-" + productId).remove();
                                                console.log("Sản phẩm đã được xóa khỏi giỏ hàng.");

                                                // Cập nhật lại tổng giá trị
                                                updateTotalCart();
                                            },
                                            error: function (xhr, status, error) {
                                                console.error("Đã xảy ra lỗi khi xóa sản phẩm khỏi giỏ hàng: " + error);
                                            }
                                        });
                                    }

                                    function updateTotalCart() {
                                        var total = 0;
                                        $(".totalPrice").each(function () {
                                            total += parseFloat($(this).text());
                                        });
                                        $("#cartSubtotal, #total").text(total.toFixed(2) + " $");
                                    }

        </script>

    </body>
</html>
