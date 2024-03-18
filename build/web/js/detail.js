var MainImg = document.getElementById("MainImg");
    var smallImgs = document.getElementsByName("small-img");

    // Lặp qua tất cả các hình ảnh nhỏ và thêm sự kiện click
    for (var i = 0; i < smallImgs.length; i++) {
        smallImgs[i].addEventListener("click", function(event) {
            MainImg.src = event.target.src; // Thay đổi hình ảnh lớn thành hình ảnh nhỏ mà bạn đã nhấp vào
        });
    }