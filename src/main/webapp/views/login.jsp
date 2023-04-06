<%--
  Created by IntelliJ IDEA.
  User: buiti
  Date: 03/04/2023
  Time: 1:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"%>

<c:if test="${ not empty errorMessage }">
    <div class="alert alert-danger">${ errorMessage }</div>
</c:if>

<form method="post" action="/demoTest_war_exploded/login">
    <div class="mt-3">
        <label>Mã NV</label>
        <input type="text" name="maNv" class="form-control" />
    </div>
    <div class="mt-3">
        <label>Password</label>
        <input type="password" name="matKhau" class="form-control" />
    </div>

    <div class="mt-3">
        <button class="btn btn-primary">Đăng nhập</button>
    </div>
</form>

