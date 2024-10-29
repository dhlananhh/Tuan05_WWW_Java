<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Thêm sản phẩm mới</title>
	
	<!-- CSS StyleSheet -->
	<!-- <link rel="stylesheet" type="text/css" href="<c:url value='/assets/styles/DienThoaiForm.css'/>"> -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	
	<!-- Include jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Include jQuery Validation Plugin -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
</head>
<body>
    <div class="container mt-4">
        <a href="javascript:history.back()" class="btn btn-primary mb-3">Back</a>

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
            <h1>Thêm sản phẩm mới</h1>
        </div>

        <!-- <div id="errorMessage" class="alert alert-danger" role="alert"></div> -->

        <form action="DienThoaiForm?action=insert" method="post" enctype="multipart/form-data" id="phoneForm">
            <c:if test="${ not empty errors }">
                <div class="alert alert-danger" role="alert">
                    <c:out value="${ errors }" escapeXml="false" class="text-danger" />
                </div>
            </c:if>

            <div class="form-group">
                <c:if test="${ dienThoai != null }">
                    <input type="hidden" id="maDienThoai" name="maDienThoai" value="<c:out value='${ dienThoai.maDienThoai }' />" />
                </c:if>
                <label for="tenDienThoai">Tên ĐT:</label>
                <input type="text" class="form-control" id="tenDienThoai" name="tenDienThoai" maxlength="255" value="<c:out value='${ dienThoai.tenDienThoai }' />" required title="Nhập tên điện thoại" />
                <span class="text-danger errTenDT">*</span>
            </div>

            <div class="form-group">
                <label for="namSanXuat">Năm SX:</label>
                <input type="number" class="form-control" id="namSanXuat" name="namSanXuat" value="<c:out value='${ dienThoai.namSanXuat }' />" required title="Nhập năm sản xuất" />
                <span class="text-danger errNamSanXuat">*</span>
            </div>

            <div class="form-group">
                <label for="cauHinh">Cấu hình:</label>
                <input type="text" class="form-control" id="cauHinh" name="cauHinh" maxlength="255" value="<c:out value='${ dienThoai.cauHinh }' />" required title="Nhập cấu hình điện thoại" />
                <span class="text-danger errCauHinh">*</span>
            </div>

            <div class="form-group">
                <label for="hinhAnh">Hình ảnh:</label>
                <input type="file" class="form-control-file" id="hinhAnh" name="hinhAnh" accept=".png, .jpg, .jpeg" required title="Chỉ chấp nhận các file hình ảnh có đuôi là: .png, .jpg, .jpeg" />
                <span class="text-danger errHinhAnh">*</span>
            </div>

            <div class="form-group">
                <label for="maNhaCungCap">Thông tin NCC:</label>
                <select id="maNhaCungCap" name="maNhaCungCap" class="form-control">
                    <c:forEach items="${ DanhSachNhaCungCap }" var="nhaCungCap">
                        <option value="<c:out value='${ nhaCungCap.maNhaCungCap }' />">
                            <c:out value="${ nhaCungCap.tenNhaCungCap }" />
                        </option>
                    </c:forEach>
                </select>
                <span class="text-danger errNCC">*</span>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-success">Save</button>
            </div>
        </form>
    </div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
    
    <!-- JQuery Validate Form -->
    <script type="text/javascript">
        $(document).ready(function() {
            $.validator.addMethod("checkFile", function(value, element) {
                return element.files.length > 0;
            }, "Chưa chọn file hình ảnh.");

            $("#phoneForm").validate({
                rules: {
                    tenDienThoai: {
                        required: true,
                        maxlength: 255
                    },
                    cauHinh: {
                        required: true,
                        maxlength: 255
                    },
                    namSanXuat: {
                        required: true
                    },
                    hinhAnh: {
                        required: true,
                        accept: "image/*"
                    },
                    maNhaCungCap: {
                        required: true
                    }
                },
                messages: {
                    tenDienThoai: {
                        required: "Tên điện thoại không được để trống.",
                        maxlength: "Tên điện thoại không được quá 255 ký tự."
                    },
                    cauHinh: {
                        required: "Cấu hình không được để trống.",
                        maxlength: "Cấu hình không được quá 255 ký tự."
                    },
                    namSanXuat: {
                        required: "Năm sản xuất không được để trống."
                    },
                    hinhAnh: {
                        required: "Chưa chọn file hình ảnh.",
                        accept: "Chỉ chấp nhận các file hình ảnh có đuôi là: .png, .jpg, .jpeg"
                    },
                    maNhaCungCap: {
                        required: "Thông tin nhà cung cấp không được để trống."
                    }
                },
                errorPlacement: function(error, element) {
                    if (element.attr("name") == "tenDienThoai") {
                        error.appendTo(".errTenDT");
                    } else if (element.attr("name") == "cauHinh") {
                        error.appendTo(".errCauHinh");
                    } else if (element.attr("name") == "namSanXuat") {
                        error.appendTo(".errNamSanXuat");
                    } else if (element.attr("name") == "hinhAnh") {
                        error.appendTo(".errHinhAnh");
                    } else if (element.attr("name") == "maNhaCungCap") {
                        error.appendTo(".errNCC");
                    }
                },
                success: function(label) {
                    label.text("*").addClass("valid");
                }
            });

            $("#hinhAnh").on("change", function() {
                if (this.files.length > 0) {
                    $(".errHinhAnh").text("*").addClass("valid");
                } else {
                    $(".errHinhAnh").text("Chưa chọn file hình ảnh.").removeClass("valid");
                }
                $(this).valid();
            });
        });
    </script>
</body>
</html>