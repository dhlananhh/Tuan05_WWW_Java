<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách điện thoại</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link rel="stylesheet" type="text/css" href="<c:url value='/assets/styles/DanhSachDienThoai.css'/>"> -->
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
            <h1>Danh sách điện thoại</h1>
        </div>
        
        <form method="get" enctype="multipart/form-data">
            <table class="table table-striped table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>Thông tin NCC</th>
                        <th>Mã ĐT</th>
                        <th>Tên ĐT</th>
                        <th>Năm SX</th>
                        <th>Cấu hình</th>
                        <th>Hình ảnh</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ DanhSachDienThoai }" var="dienThoai">
                        <tr>
                            <td> <c:out value="${ dienThoai.nhaCungCap.tenNhaCungCap }" /> </td>
                            <td> <c:out value="${ dienThoai.maDienThoai }" /> </td>
                            <td> <c:out value="${ dienThoai.tenDienThoai }" /> </td>
                            <td> <c:out value="${ dienThoai.namSanXuat }" /> </td>
                            <td> <c:out value="${ dienThoai.cauHinh }" /> </td>
                            <td>
                                <img src="${ pageContext.request.contextPath }/assets/images/${ dienThoai.hinhAnh }" class="img-thumbnail" width="200px" height="200px">
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
