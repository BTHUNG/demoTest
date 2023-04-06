<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/03/2023
  Time: 11:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-8 offset-2 mt-5 table-responsive">
    <c:if test="${ f:length(danhSach) == 0 }">
        <h3>Không có dữ liệu</h3>
    </c:if>

    <c:if test="${ f:length(danhSach) != 0 }">
<h3>Bảng thông tin khách hàng</h3>
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>Mã</th>
                <th>Họ</th>
                <th>Đệm</th>
                <th>Tên</th>
                <th>Ngày sinh</th>
                <th>SDT</th>
                <th>Địa chỉ</th>
                <th>Mật khẩu</th>
                <th>Quốc gia</th>
                <th>Thành phố</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ danhSach }" var="kh">
                <tr>
                    <td>${ kh.ma }</td>
                    <td>${ kh.ho }</td>
                    <td>${ kh.tenDem }</td>
                    <td>${ kh.ten }</td>
                    <td>${ kh.ngaySinh}</td>
                    <td>${ kh.sdt}</td>
                    <td>${ kh.diaChi }</td>
                    <td>${ kh.matKhau }</td>
                    <td>${ kh.quocGia}</td>
                    <td>${ kh.thanhPho}</td>
                    <td>
                        <a href="/demoTest_war_exploded/khach_hang/edit?Ma=${kh.ma}" class="btn btn-primary">Cập nhật</a>
                    </td>
                    <td>
                        <a href="/demoTest_war_exploded/khach_hang/delete?Ma=${kh.ma}" class="btn btn-danger" >Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <a href="/demoTest_war_exploded/khach_hang/create" class="btn btn-primary">Cập nhật</a>


</div>

