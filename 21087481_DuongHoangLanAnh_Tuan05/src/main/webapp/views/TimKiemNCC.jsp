<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm Kiếm Nhà Cung Cấp</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <a href="javascript:history.back()" class="btn btn-primary mb-3">
            Back
        </a>
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
            <div class="navbar-nav">
                <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/">Trang chủ</a>
                <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/DanhSachDienThoai">Danh sách điện thoại</a>
                <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/DanhSachNhaCungCap">Danh sách NCC</a>
                <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/DienThoaiForm">Thêm sản phẩm mới</a>
                <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/QuanLyForm">Chức năng quản lý</a>
                <a class="nav-item nav-link mx-3" href="${pageContext.request.contextPath}/TimKiemNCC">Tìm kiếm NCC</a>
            </div>
        </nav>
        
        <div class="text-center mb-4">
            <h1>Tìm kiếm NCC</h1>
        </div>
        
        <form method="get" enctype="multipart/form-data" class="mb-4">
            <div class="form-group">
                <label for="keyword">Từ khóa:</label>
                <input type="text" class="form-control" id="keyword" name="keyword" required>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success">Tìm Kiếm</button>
            </div>
        </form>
        
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Mã NCC</th>
                    <th>Tên NCC</th>
                    <th>Địa chỉ</th>
                    <th>SĐT</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ listSuppliers }" var="nhaCungCap">
                    <tr>
                        <td> <c:out value="${ nhaCungCap.maNhaCungCap }" /> </td>
                        <td> <c:out value="${ nhaCungCap.tenNhaCungCap }" /> </td>
                        <td> <c:out value="${ nhaCungCap.diaChi }" /> </td>
                        <td> <c:out value="${ nhaCungCap.soDienThoai }" /> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
