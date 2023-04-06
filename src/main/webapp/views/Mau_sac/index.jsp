<%--
  Created by IntelliJ IDEA.
  User: buiti
  Date: 15/03/2023
  Time: 10:20 SA
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
        <th scope="col">Function</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSach}" var="ms">
    <tr>
        <td>${ms.ma}</td>
        <td>${ms.ten}</td>
        <td>
            <a href="/demoTest_war_exploded/Mau_sac/edit?ma=${ms.ma}" class="btn btn-primary">Cập nhật</a>
        </td>
        <td>
            <a href="/demoTest_war_exploded/Mau_sac/delete?ma=${ms.ma}" class="btn btn-danger" >Xóa</a>
        </td>
    </tr>
    </tbody></c:forEach>
</table> </c:if></div>
