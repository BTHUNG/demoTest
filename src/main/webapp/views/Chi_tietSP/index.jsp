<%--
  Created by IntelliJ IDEA.
  User: buiti
  Date: 05/04/2023
  Time: 12:17 SA
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: LAPTOP-ASUS
  Date: 4/5/2023
  Time: 3:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />

</head>
<body>
<div class="container">
    <br>
    <h4 class="text-center">Quản lý Chi Tiết Sản Phâm</h4>
    <div class="col-8 offset-2 mt-5 table-responsive">
        <div class="row">
            <div class="col-6">
                <a href="/demoTest_war_exploded/Chi_tietSP/create" class="btn btn-success">Thêm mới</a>
            </div>
        </div>

        <c:if test="${ f:length(ctsp) == 0 }">
            <h3>Không có dữ liệu</h3>
        </c:if>
        <c:if test="${ f:length(ctsp) != 0 }">
            <table class="table table-striped mt-3">
                <thead class="table-primary">
                <tr>
                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Tên nhà sản xuất</th>
                    <th scope="col">Tên màu sắc</th>
                    <th scope="col">Tên dòng sản phẩm</th>
                    <th scope="col">Năm bảo hành</th>
                    <th scope="col">Mô tả</th>
                    <th scope="col">Số lượng tồn</th>
                    <th scope="col">Giá nhập</th>
                    <th scope="col">Giá bán</th>
                    <th colspan="2"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ ctsp }" var="ctsp">
                    <tr>
                        <td>${ctsp.sanPham.ten}</td>
                        <td>${ctsp.nsx.ten}</td>
                        <td>${ctsp.mauSac.ten}</td>
                        <td>${ctsp.dongSP.ten}</td>
                        <td>${ctsp.namBH}</td>
                        <td>${ctsp.moTa}</td>
                        <td>${ctsp.soLuongTon}</td>
                        <td>${ctsp.giaNhap}</td>
                        <td>${ctsp.giaBan}</td>
                        <td>
                            <a href="/demoTest_war_exploded/Chi_tietSP/edit?id=${ctsp.id}" class="btn btn-primary">Cập nhật</a>
                        </td>
                        <td>
                            <a href="/demoTest_war_exploded/Chi_tietSP/delete?id=${ctsp.id}" class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>


    </div>
</div>
</body>
</html>

