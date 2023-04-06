<%--
  Created by IntelliJ IDEA.
  User: buiti
  Date: 14/03/2023
  Time: 9:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="container">
    <c:if test="${f:length(danhSach)==0}">
        <h3>Không có dữ liệu</h3>
    </c:if>
    <c:if test="${f:length(danhSach)!=0}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Tên đệm</th>
                <th scope="col">Họ</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">SDT</th>
                <th scope="col">mat_khau</th>
                <th scope="col">IdCH</th>
                <th scope="col">IdCV</th>
                <th scope="col">IdGuiBC</th>
                <th scope="col">Trạng thái</th>
                <th scope="col">Function</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${danhSach}" var="nv">
                <tr>
                    <td>${nv.ma}</td>
                    <td>${nv.ten}</td>
                    <td>${nv.tenDem}</td>
                    <td>${nv.ho}</td>
                    <td>${nv.gioiTinh}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.sdt}</td>
                    <td>${nv.matKhau}</td>
                    <td>${nv.ch.ten}</td>
                    <td>${nv.cv.ten}</td>
                    <td>${nv.idGuiBC}</td>
                    <td>${nv.trangThai}</td>
                    <td>
                        <a href="/demoTest_war_exploded/Nhan_vien/edit?ma=${nv.ma}" class="btn btn-primary">Cập nhật</a>
                    </td>
                    <td>
                        <a href="/demoTest_war_exploded/Nhan_vien/delete?ma=${nv.ma}" class="btn btn-danger" >Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <a href="/demoTest_war_exploded/Nhan_vien/create" class="btn btn-outline-success">Thêm sản phẩm</a>
</div>
