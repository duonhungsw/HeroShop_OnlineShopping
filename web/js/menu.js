document.addEventListener('DOMContentLoaded', function () {
    const dropdownButton = document.getElementById('dropdownButton');
    const dropdownContent = document.querySelector('.dropdown-content');

    // Thêm sự kiện click vào nút
    dropdownButton.addEventListener('click', function (event) {
        // Ngăn chặn sự kiện click lan ra bên ngoài dropdown
        event.stopPropagation();

        // Toggle class 'active' để hiển thị hoặc ẩn dropdown
        dropdownContent.classList.toggle('active');
    });

    // Đóng dropdown khi bấm bất kỳ đâu ngoài dropdown
    document.addEventListener('click', function (event) {
        if (!dropdownButton.contains(event.target) && !dropdownContent.contains(event.target)) {
            dropdownContent.classList.remove('active');
        }
    });

    // Đóng dropdown khi người dùng nhấp vào một liên kết trong dropdown
    dropdownContent.addEventListener('click', function () {
        dropdownContent.classList.remove('active');
    });

    // Hover effect on Welcome link
    dropdownButton.addEventListener('mouseenter', function () {
        dropdownButton.style.backgroundColor = '#2ecc71';
    });

    dropdownButton.addEventListener('mouseleave', function () {
        dropdownButton.style.backgroundColor = '#fff';
    });

});