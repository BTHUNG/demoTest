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
</head>
<body>
<form action="/demoTest_war_exploded/Chi_tietSP/update?id=${ctsp.id}" method="post">
    <div class="row mt-4">
        <div class="col-6">
            <label>Sản phẩm</label>
            <select class="form-select" name="idSP">
                <c:forEach items="${sp}" var="sanPham">
                    <option value="${sanPham.id}">${sanPham.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6">
            <label>Nhà sản xuất</label>
            <select class="form-select" name="idNSX">
                <c:forEach items="${nsx}" var="nsx">
                    <option value="${nsx.id}">${nsx.ten}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-6">
            <label>Màu sắc</label>
            <select class="form-select" name="idMauSac">
                <c:forEach items="${ms}" var="mauSac">
                    <option value="${mauSac.id}">${mauSac.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6">
            <label>Dòng sản phẩm</label>
            <select class="form-select" name="idDongSP">
                <c:forEach items="${dsp}" var="dongSP">
                    <option value="${dongSP.id}">${dongSP.ten}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-6">
            <label>Năm bảo hành</label>
            <input type="text" class="form-control" name="namBH" value="${ ctsp.namBH }"/>
        </div>
        <div class="col-6">
            <label>Mô tả</label>
            <input type="text" class="form-control" name="moTa" value="${ ctsp.moTa }"/>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-6">
            <label>Số lượng tồn</label>
            <input type="text" class="form-control" name="soLuongTon" value="${ ctsp.soLuongTon }"/>
        </div>
        <div class="col-6">
            <label>Giá nhập</label>
            <input type="text" class="form-control" name="giaNhap" value="${ ctsp.giaNhap }"/>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-6">
            <label>Giá bán</label>
            <input type="text" class="form-control" name="giaBan" value="${ ctsp.giaBan }"/>
        </div>
    </div>

    <div class="row mt-4" style="justify-content: center">
        <button class="btn btn-success col-1 m-3" type="submit">
            Add
        </button>
    </div>
</form>
</body>
</html>
