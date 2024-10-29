<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
    <header class="container-fluid p-0 mb-4 d-flex justify-content-center align-items-center">
        <img alt="logo" src="assets/images/fongo-internet-logo.png" class="img-fluid">
    </header>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
        <div class="navbar-nav mx-auto">
            <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/">Trang chủ</a>
            <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/DanhSachDienThoai">Danh sách điện thoại</a>
            <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/DanhSachNhaCungCap">Danh sách NCC</a>
            <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/DienThoaiForm">Thêm sản phẩm mới</a>
            <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/QuanLyForm">Chức năng quản lý</a>
            <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/TimKiemNCC">Tìm kiếm NCC</a>
        </div>
    </nav>

    <div class="content container bg-light p-4">
        <!-- Your content goes here -->
    </div>

    <hr class="my-4">

    <footer class="footer bg-light mt-4 py-3">
        <div class="container text-center">
            <h4 class="text-muted">Dương Hoàng Lan Anh - 21087481 - DHKTPM17BTT</h4>
        </div>
    </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
