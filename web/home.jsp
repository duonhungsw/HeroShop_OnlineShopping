<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
        <link rel="stylesheet" href="css/home.css"> 

    </head>
    <body>
        <div id="menu">
            <%@include file="menu.jsp" %>
        </div>
        <div class="clr"></div>
        <div id="banner">
            <div class="box-left">
                <h2>
                    <span>QUẦN ÁO</span>
                    <br>
                    <span>THỜI THƯỢNG</span>
                </h2>
                <p>Chào mừng đến với shop quần áo của chúng tôi, 
                    nơi bạn có thể tìm thấy những sản phẩm thời trang
                    chất lượng và phong cách độc đáo!</p>

                <a href="Shop.html">
                    <a href="#">
                        <button>Mua ngay</button>
                    </a>
                </a>
            </div>
            <div class="box-right">
                <img src="images/img_1.png" alt="">
                <img src="images/img_2.png" alt="">
                <img src="images/img_3.png" alt="">
            </div>
        </div>
        <section id="product_1" class="section-p1"> 
            <h2>Sản phẩm nổi bật</h2>
            <p>Áo bóng đá bản Player đương đại</p>        
            <div class="container">
                
                <c:forEach var="c" items="${listP}">
                    <div class="pro">
                        <a href="detail?pid=${c.id}">
                            <img src="${c.thumbnail}" alt="">
                        </a>
                        <div class="des">
                            <h5><a style="color: black" href="detail?pid=${c.id}">${c.title}</a></h5>

                            <div class="star" style="display: flex; margin:0px auto; margin-top:17px;">
                                <span>
                                    <img src="images/star.png" alt="">
                                </span>
                                <span>
                                    <img src="images/star.png" alt="">
                                </span>
                                <span>
                                    <img src="images/star.png" alt="">
                                </span>
                                <span>
                                    <img src="images/star.png" alt="">
                                </span>
                                <span>
                                    <img src="images/star.png" alt="">
                                </span>
                            </div>
                            <h4>${c.price} $</h4>
                        </div>
                        
                    </div>
                </c:forEach>
            </div> 
            <div id="load-more">Load More</div>
        </section>

        <div>
            <%@include file="footer.jsp" %>
        </div>
        <script src="js/Jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
    let loadMoreBtn = document.querySelector('#load-more');
    let currentItem = 8;
    
    loadMoreBtn.onclick = () => {
        let boxes = document.querySelectorAll('.container .pro');
        for (let i = currentItem; i < currentItem + 8; i++) {
            if (boxes[i]) {
                boxes[i].style.display = 'inline-block';
            }
        }
        currentItem += 8;
        
        if (currentItem >= boxes.length) {
            loadMoreBtn.style.display = 'none';
        }
    };
</script>

        

    </body>
    <style>

        .section-p1{
            text-align: center;
        }

        .container{
            display: flex;
            justify-content: space-between;
            padding-top: 20px;
            flex-wrap: wrap;
        }
        .container .pro{
            display: none;
        }
        .container .pro:nth-child(1),
        .container .pro:nth-child(2),
        .container .pro:nth-child(3),
        .container .pro:nth-child(4),
        .container .pro:nth-child(5),
        .container .pro:nth-child(6),
        .container .pro:nth-child(7),
        .container .pro:nth-child(8){
           display: inline-block 
        }

        .section-p1 .pro{
            width: 23%;
            min-width: 250px;
            padding: 10px 12px;
            border: 1px solid #cce7d0;
            border-radius: 25px;
            cursor: pointer;
            box-shadow: 20px 20px 30px rgba(0,0,0,0.02);
            margin: 15px 0;
            transition: 0.2 ease;
            position: relative;
        }

        .section-p1 .pro:hover{
            box-shadow: 20px 20px 30px rgba(0,0,0, 0.06);
        }
        .section-p1 .pro img{
            width: 100%;
            border-radius: 20px;
        }

        .section-p1 .pro .des{
            text-align: start;
            padding: 10px 0;
        }

        .section-p1 .pro .des span{
            color:chocolate;
            font-size: 12px;
        }

        .section-p1 .pro .des h5{
            padding-top: 7px;
            color: #1a1a1a;
            font-size: 14px;
        }

        .section-p1 .pro .des i{
            font-size: 12px;
            color:darksalmon ;
        }

        .section-p1.pro .des h4{
            padding-top: 7px;
            font-size: 15px;
            font-weight: 700;
            color: #088178;
        }

        .section-p1 .pro .cart{
            width: 40px;
            height: 40px;
            line-height: 40px;
            border-radius: 50px;
            background-color: #e8f6ea;
            font-weight: 500;
            color: #088178;
            border: 1px solid #cce7d0;
            position: absolute;
            bottom: 20px;
            right: 10px;
        }
        #load-more{
            display: inline-block;
            padding: 13px 30px;
            border: 1px solid #334;
            font-size: 16px;
            background-color: #FFF;
            cursor: pointer;
        }
        #load-more:hover{
            background-color: var(--green);
            border-color: var(--green);
            color: #fff;
        }
    </style>
    
</html>
