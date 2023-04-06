<%--
  Created by IntelliJ IDEA.
  User: buiti
  Date: 16/03/2023
  Time: 11:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-8 offset-2 bg-light">
    <form method="POST"
          action="/demoTest_war_exploded/khach_hang/update?ma=${kh.ma}">
        <h1>Cập nhập Khách hàng</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text"  class="form-control" value="${kh.ma}" disabled/>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" value="${kh.ho}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="ten_dem" class="form-control"  value="${kh.tenDem}"/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${kh.ten}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngay_sinh" class="form-control" value="${kh.ngaySinh}" />
            </div>
            <div class="col-6">
                <label>Số điện thoại</label>
                <input type="tel" name="sdt" class="form-control" value="${kh.sdt}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${kh.diaChi}"/>
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="matKhau" name="matKhau" class="form-control" value="${kh.matKhau}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="vn" ${kh.quocGia=="vn"?"selected":""}>Việt Nam</option>
                    <option value="en" ${kh.quocGia=="en"?"selected":""}>Anh</option>
                </select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option value="hanoi" ${kh.thanhPho=="hanoi"?"select":""}>Hà Nội</option>
                    <option value="london" ${kh.thanhPho=="london"?"select":""}>London</option>
                </select>
            </div>
        </div><div class="row mt-3">
        <div class="col-6">
            <button class="btn btn-primary">Cập nhật</button>
        </div>
        <div class="col-6"></div>
    </div>
    </form>
</div>
