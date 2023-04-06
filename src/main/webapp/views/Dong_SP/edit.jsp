<%--
  Created by IntelliJ IDEA.
  User: buiti
  Date: 17/03/2023
  Time: 12:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NSX</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
</head>
<body>
<div class="col-8 offset-2 bg-light">
    <form method="POST"
          action="/demoTest_war_exploded/Dong_SP/update?ma=${ms.ma}">
        <h1>Sửa dòng sản phẩm</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ms.ma}"/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${ms.ten}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary" type="submit">Cập nhật</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>

<script src="/IT17308_DEMO_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
