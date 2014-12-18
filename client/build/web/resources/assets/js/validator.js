/**
 * @author Ahmad Shahab
 * Fungsi untuk validasi email
 */

function validateEmail(email){
//    var atpos = email.indexOf("@");
//    var dotpos = email.indexOf(".");
//    if(atpos < 1 || dotpos < atpos+2 || dotpos + 2 >= email.length){
//        alert("Email yang dimasukkan tidak valid !");
//        return false;
//    }
//    else{
//        return true;
//    }
    regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!regex.test(email)) {
        alert("Email yang dimasukkan salah!");
        return false;
    }
    else {
        return true;
    }
}
Date.prototype.lessThan = function (b) {
	if (this.getFullYear() != b.getFullYear()) {
		return this.getFullYear() < b.getFullYear();
	}
	if (this.getMonth() != b.getMonth()) {
		return this.getMonth() < b.getMonth();
	}
	return this.getDate() < b.getDate();
}
function validateDate(inputDate){
//    inputDate = inputDate + "-";
////    var inputDate = document.getElementById("_post-form:tanggal").value + "-";
//    var inputYear=""; var inputMonth=""; var inputDay="";
//    var i = 0;
//
//    while(inputDate.charAt(i) !=='-'){
//        inputYear = inputYear + inputDate.charAt(i);
//        i++;
//    }
//    i++;
//    while(inputDate.charAt(i) !=='-'){
//        inputMonth = inputMonth + inputDate.charAt(i);
//        i++;
//    }
//    i++;
//    while(inputDate.charAt(i) !=='-'){
//        inputDay = inputDay + inputDate.charAt(i);
//        i++;
//    }
    var formDate = new Date(inputDate);
//    formDate.setFullYear(inputYear,inputMonth-1,inputDay);
    //formDate.setHours(23);
    //formDate.setMinutes(59);
    //formDate.setSeconds(59);
    var cekDate = new Date();
    if (formDate.lessThan(cekDate)){
        alert("Tanggal post tidak boleh lebih kecil dari hari ini");
        return false;
    }
}
