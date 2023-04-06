function validate() {
    var ten = document.myform.ten.value;
    var ho = document.myform.ho.value;
    var ten_dem = document.myform.ten_dem.value;
    var sdt = document.myform.sdt.value;
    var dia_chi = document.myform.dia_chi.value;
    var ma = document.myform.ma.value;
    var mat_khau = document.myform.mat_khau.value;
    var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;

    if (ma == "") {
        alert("Vui lòng nhập mã");
        return false;
    }
    if (ten == "") {
        alert("Vui lòng nhập tên");
        return false;
    } else if (ho == "") {
        alert("Vui lòng nhập họ");
        return false;
    }
    if (ten_dem == "") {
        alert("Vui lòng nhập tên đệm");
        return false;
    }
    if (sdt == "") {
        alert("Vui lòng nhập số điện thoại");
        return false;
    }
    if (dia_chi == "") {
        alert("Vui lòng nhập địa chỉ");
        return false;
    }
    if (mat_khau == "") {
        alert("Vui lòng nhập mật khẩu");
        return false;
    }
    if (vnf_regex.test(sdt) == false) {
        alert('Số điện thoại của bạn không đúng định dạng!');
        return false;
    } else {
        return true;
    }


}