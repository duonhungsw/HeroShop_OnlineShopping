<%@page import="java.util.ArrayList"%>
<%@page import="model.CartProduct"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="dal.CartDAO" %>
<%@page import="model.User" %>
<%@page import="model.Cart" %>

<%
    CartDAO cartDAO = new CartDAO();
    User user = (User) session.getAttribute("account");
    List<CartProduct> list = new ArrayList<CartProduct>();
    if (user != null) {
        Cart c = cartDAO.get_Cart_By_Id(user.getId());
        list = cartDAO.get_CartProduct_By_Cid(c);
    }

%>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shop</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/menu.css">
        <link rel="stylesheet" href="css/optionCategoty.css">
    </head>
    <body>
        <header>
            <a href="home" class="logo"><i class="fas fa-utensils"></i>HeroShop.</a>
            <nav class="navbar">
                <a href="home">home</a>
                <div class="dropdown">
                    <button class="dropbtn">Ready to Wear</button>
                    <div class="dropdown-option">
                        <c:forEach var="c" items="${sessionScope.listC}">
                            <a href="categories?category=${c.id}" onclick="closeDropdown()">${c.name}</a>
                        </c:forEach>
                    </div>
                </div>

                <a href="feedback">feedback</a>
                <div style="margin-left: 0px" class="menuu">
                    <c:if test="${sessionScope.account==null}">
                        <a id="dropdownButton">Welcome</a>
                        <div style="margin-left: 60px" class="dropdown-content">
                            <a href="login"><i class="fas fa-eye"></i>Đăng Nhập</a>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.account!=null}">
                        <a id="dropdownButton">Welcome ${sessionScope.account.fullname} <i class="fa-solid fa-caret-down"></i></a>
                        <div class="dropdown-content">
                            <a href="profile"><i class="fas fa-eye"></i>Trang cá nhân</a>
                            <a href="purchase"><i class="fa-solid fa-truck-fast"></i>Đơn Hàng</a>
                            <a href="logout"><i class="fas fa-sign-out-alt"></i>Đăng xuất</a>
                        </div>
                    </c:if>
                </div>
            </nav>
            <form action="search?index=1" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input name="txtSearch" type="text" class="form-control" aria-label="Search" aria-describedby="search-addon" value="${save}">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            Search
                        </button>
                    </div>
                </div>
            </form>

            <div class="icons">
                <i class="fas fa-bars" id="menu-bars"></i>
                <!--                                <i class="fas fa-search" id="search-icon"></i>-->
                <a href="#" class="fas fa-heart"></a>

                <% if (list != null) {%>
                <a href="cart" class="fas fa-shopping-cart">

                    <span style="
                          position: relative;
                          top: -10px;
                          height: 20px;
                          width: 20px; /* Đảm bảo chiều rộng và chiều cao là như nhau để tạo thành hình tròn */
                          background-color: red;
                          color: white; /* Màu chữ là màu trắng */
                          border-radius: 50%; /* Bo tròn hộp */
                          text-align: center; /* Căn giữa nội dung */
                          line-height: 20px; /* Đảm bảo chữ nằm giữa hộp */
                          font-size: 20px;
                          padding: 3px /* Cỡ chữ */"><%= list.size()%>
                    </span>
                </a>
                <% } else { %>
                <span>ád</span>
                <%}%>
            </div>
        </header>    
        <script>
            function handleClick() {
                closeDropdown();
            }
        </script>
        <script>
            var navLinks = document.querySelectorAll(".navbar a");
            var currentUrl = window.location.href;

            navLinks.forEach(function (navLink) {
                if (navLink.href === currentUrl) {
                    navLink.classList.add("active");
                }

            })
        </script>
        <script src="js/menu.js"></script> 
        <script src="js/categoty.js"></script>  

    </body>
</html>
