<%--
  Created by IntelliJ IDEA.
  User: buiti
  Date: 17/03/2023
  Time: 1:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Dựa án mẫu</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/demoTest_war_exploded/khach_hang/index">Khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/demoTest_war_exploded/Nhan_vien/index">Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/demoTest_war_exploded/Cua_hang/index">Cửa Hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/demoTest_war_exploded/Mau_sac/index">Màu sắc</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/demoTest_war_exploded/NSX/index">NSX</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/demoTest_war_exploded/Dong_SP/index">Dòng sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/demoTest_war_exploded/Mau_sac/index">Màu sắc</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="row mt-3" style="min-height: 600px">
    <div class="bg-warning col-2">
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Regular link</a></li>
            <li><a class="dropdown-item active" href="#" aria-current="true">Active link</a></li>
            <li><a class="dropdown-item" href="#">Another link</a></li>
        </ul>
    </div>
    <div class="bg-light col-10">
        <jsp:include page="${view}"/>
    </div>
</div>
<div class="row mt-3 bg-dark ms-o">Footer</div>
</body>
</html>
