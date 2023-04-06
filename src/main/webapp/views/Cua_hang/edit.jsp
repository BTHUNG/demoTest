<%--
  Created by IntelliJ IDEA.
  User: buiti
  Date: 19/03/2023
  Time: 11:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-8 offset-2 bg-light">
    <form method="POST"
          action="/demoTest_war_exploded/Cua_hang/update?ma=${ch.ma}">
        <h1> Sửa cửa hàng</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" class="form-control" value="${ch.ma}" disabled/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${ch.ten}"/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" value="${ch.diaChi}"/>
            </div>
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="Việt Nam" ${ch.quocGia=="Việt Nam"?"selected":""}>Việt Nam</option>
                    <option value="Anh" ${ch.quocGia=="Anh"?"selected":""}>Anh</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">

            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option value="Hà Nội" ${ch.thanhPho=="Hà Nội"?"selected":""}>Hà Nội</option>
                    <option value="london" ${ch.thanhPho=="london"?"selected":""}>London</option>
                </select>
            </div>
        </div><div class="row mt-3">
        <div class="col-6">
            <button class="btn btn-primary">Thêm mới</button>
        </div>
        <div class="col-6"></div>
    </div>
    </form>
</div>

