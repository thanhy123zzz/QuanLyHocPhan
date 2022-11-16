const inputs = document.querySelectorAll(".input");


function addcl() {
	let parent = this.parentNode.parentNode;
	parent.classList.add("focus");
}

function remcl() {
	let parent = this.parentNode.parentNode;
	if (this.value == "") {
		parent.classList.remove("focus");
	}
}


inputs.forEach(input => {
	input.addEventListener("focus", addcl);
	input.addEventListener("blur", remcl);
});

// Get the modal
var modal = document.getElementById("myModal");
var modal2 = document.getElementById("myModal2");
var modal3 = document.getElementById("myModal3");
// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
// When the user clicks the button, open the modal 
btn.onclick = function () {
	modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
	modal.style.display = "none";
}
// When the user clicks anywhere outside of the modal, close it
// window.onclick = function (event) {
// 	if (event.target == modal || event.target == modal2 || event.target == modal3) {
// 		modal.style.display = "none";
// 		modal2.style.display = "none";
// 		modal3.style.display = "none";
// 	}
// }

var btn2 = document.getElementById("sendBtn");
var btnconfirm = document.getElementById("comfirmBtn");
var btncofirmPass = document.getElementById("btncofirmPass");
btncofirmPass.onclick = function () {
	var newpass = $("#newpass").val();
	var confirm = $("#confirmpass").val();
	if(newpass == confirm){
		changePass();
	}else{
	}
}
// check pass is same
function checkPassSame(){
	var newpass = $("#newpass").val();
	var confirm = $("#confirmpass").val();
	if(newpass == confirm){
		$("#btncofirmPass").prop("disabled", false);
		$("#newpass").css("color","black");
		$("#confirmpass").css("color","black");
	}else{
		$("#btncofirmPass").prop("disabled", true);
		$("#newpass").css("color","red");
		$("#confirmpass").css("color","red");
	}
}
btnconfirm.onclick = function () {
	var code = $("#codeSession").val();
	var x = $("#codefondirm").val();
	if(x == "" || x == null){
		alert("Mã xác nhận không được bỏ trống!")
		$("#codeSession").focus();
	}else{
		if(x == code){
			alert("Xác nhận thành công!\nMời bạn nhập mật khẩu mới")
			modal2.style.display = "none";
			modal3.style.display = "block";
		}else{
			alert("Mã xác nhận không chính xác")
			$("#codefondirm").focus();
		}
	}
	
}

btn2.onclick = function () {
	var x = $("#gmail").val();
	const isEmail = /^[0-9]{10}@sv.hcmunre.edu.vn$/i.test(x);
	if(x == "" || x == null){
		alert("Email không được bỏ trống!")
	}else{
		if (isEmail == true) {
			// $("#gmail").focus();
			$("#sendBtn").prop("disabled", true);
			alert("Đang gửi mã xác nhận vui lòng chờ trong giây lát!")
			sendMail();
		} else {
			// $("#sendBtn").prop("disabled", false);
			alert("Email Không hợp lệ vui lòng thử lại!")
		}
	}
	
}
function close_modal() {
	modal2.style.display = "none";
	modal3.style.display = "none";
}
// $(document).ready(function(){
//     $('#sendBtn').on('click', function() {
// 		$("#form1").valid();
// 	});
// });
function changePass() {
	setTimeout(200);
	var x = $("#newpass").val();
	$.ajax({
		type: "POST",
		url: "/changepass",
		data: "password=" + x,
		success: function (data) {
			alert("Đổi mật khẩu thành công!");
			modal3.style.display = "none";
		},
		error: function (e) {
			alert("Đổi mật khẩu thất bại!");
		}
	});
}

function sendMail() {
	setTimeout(200);
	var x = $("#gmail").val();
	$.ajax({
		type: "POST",
		url: "/sendMail",
		data: "gmail=" + x,
		success: function (data) {
			alert("Mã xác nhận đã được gửi đến mail: " + x);
			// $("#btn-search").prop("disabled", false);
			// location.reload(true);
			// // 
			// var modal2 = document.getElementById("myModal2");
			modal.style.display = "none";
			modal2.style.display = "block";
			$("#codeSession").replaceWith(data);
			
		},
		error: function (e) {
			alert("Gửi mail lỗi!")
		}
	});
}