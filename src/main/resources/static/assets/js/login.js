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
		alert("M?? x??c nh???n kh??ng ???????c b??? tr???ng!")
		$("#codeSession").focus();
	}else{
		if(x == code){
			alert("X??c nh???n th??nh c??ng!\nM???i b???n nh???p m???t kh???u m???i")
			modal2.style.display = "none";
			modal3.style.display = "block";
		}else{
			alert("M?? x??c nh???n kh??ng ch??nh x??c")
			$("#codefondirm").focus();
		}
	}
	
}

btn2.onclick = function () {
	var x = $("#gmail").val();
	const isEmail = /^[0-9]{10}@sv.hcmunre.edu.vn$/i.test(x);
	if(x == "" || x == null){
		alert("Email kh??ng ???????c b??? tr???ng!")
	}else{
		if (isEmail == true) {
			// $("#gmail").focus();
			$("#sendBtn").prop("disabled", true);
			alert("??ang g???i m?? x??c nh???n vui l??ng ch??? trong gi??y l??t!")
			sendMail();
		} else {
			// $("#sendBtn").prop("disabled", false);
			alert("Email Kh??ng h???p l??? vui l??ng th??? l???i!")
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
			alert("?????i m???t kh???u th??nh c??ng!");
			modal3.style.display = "none";
		},
		error: function (e) {
			alert("?????i m???t kh???u th???t b???i!");
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
			alert("M?? x??c nh???n ???? ???????c g???i ?????n mail: " + x);
			// $("#btn-search").prop("disabled", false);
			// location.reload(true);
			// // 
			// var modal2 = document.getElementById("myModal2");
			modal.style.display = "none";
			modal2.style.display = "block";
			$("#codeSession").replaceWith(data);
			
		},
		error: function (e) {
			alert("G???i mail l???i!")
		}
	});
}