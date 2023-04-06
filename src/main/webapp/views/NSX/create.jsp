<%--
  Created by IntelliJ IDEA.
  User: buiti
  Date: 13/03/2023
  Time: 1:42 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-8 offset-2 bg-light">
    <form method="POST"
          action="/demoTest_war_exploded/NSX/store">
        <h1>Thêm NSX</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary" type="submit">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
