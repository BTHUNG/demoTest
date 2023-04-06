<%--
  Created by IntelliJ IDEA.
  User: buiti
  Date: 17/03/2023
  Time: 1:34 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<div class="col-8 offset-2 bg-light">
    <form method="POST"
          action="/demoTest_war_exploded/Nhan_vien/update?ma=${nv.ma}">
        <h1>Sửa nhân viên</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" class="form-control" value="${nv.ma}"/>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" value="${nv.ho}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="ten_dem" class="form-control" value="${nv.tenDem}"/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${nv.ten}"/>
            </div>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault1"
                   value="nv" ${nv.gioiTinh=="Nam"?"checked":""}>
            <label class="form-check-label" for="flexRadioDefault1">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault2"
                   value="nv" ${nv.gioiTinh=="Nữ"?"checked":""}>
            <label class="form-check-label" for="flexRadioDefault2">
                Nữ
            </label>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" value="${nv.diaChi}"/>
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control"/>
            </div>
        </div>
        <div class="col-6">
            <label>Chức vụ</label>
            <select name="idCV" class="form-select">
                <c:forEach items="${listChucVu}" var="cv">
                    <option value="${cv.id}">${cv.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6">
            <label>Cửa hàng</label>
            <select name="idCH" class="form-select">

                <option value="CS01" ${nv.ch.ten=="SC01"?"selected":""}>CS01</option>
                <option value="CS02" ${nv.ch.ten=="CS02"?"selected":""}>SC02</option>
            </select>
        </div>
        <div class="col-6">
            <label>Trạng thái</label>
            <input type="password" name="trangThai" class="form-control"/>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary" type="submit">Cập nhật</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
