<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Email</title>
    <style>
        body {
            background-color: #f5f5f5; 
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%; 
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd; 
            border-radius: 5px; 
            box-shadow: 0 0 10px rgba(0,0,0,0.1); 
        }
        h1, h2, h3, h4, h5 {
            color: #333;
        }
        .important {
            color: #ff0000; 
        }
        .no-reply {
            background-color: #000; 
            color: #fff; 
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <c:set var="c" value="${requestScope.order}"/>
        <div class="no-reply">
            <h1>Đây là email tự động, Quý khách vui lòng không trả lời email này</h1>
        </div>
        <h1>HeroShop</h1>
        <h1>Chào bạn ${c.user.fullname}</h1>
        <h1>Bạn hoặc ai đó đã đăng ký dịch vụ của shop với thông tin sau:</h1>
        <h2 class="important">Thông tin đơn hàng</h2>
        <h2>Mã đơn hàng: ${c.id}</h2>
        <h3>Mã khuyến mãi áp dụng: Không có</h3>
        <h3>Phí vận chuyển: 0 đồng</h3>
        <h3>Dịch vụ: Đặt hàng trực tuyến</h3>
        <h1>Thông tin người nhận</h1>
        <h2>Địa chỉ nhận hàng:${c.address}</h2>
        <h2>Số điện thoại:${c.phone_number}</h2>
        <h3>Ghi chú đơn hàng: ${c.note}</h3>
        <h3>Hình thức thanh toán: Khi nhận hàng</h3>
        <h4>Sản phẩm đã đặt</h4>
        <table>
            <tr>
                <th>San pham</th>
                <th>Gía tien</th>
                <th>So luong dat</th>
                <th>Thanh tien</th>
            </tr>
            <c:forEach var="bill" items="${requestScope.list}">
                <tr>
                    <td>${bill.product_id.title}</td>
                    <td>${bill.price}</td>
                    <td>${bill.quantity}</td>
                    <td>${bill.total_money}</td>
                </tr>
            </c:forEach>
        </table>
        <h5>Tổng tiền thanh toán: ${c.total_money} $</h5>
    </div>
</body>
</html>
