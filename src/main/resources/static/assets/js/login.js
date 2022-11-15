const inputs = document.querySelectorAll(".input");


function addcl(){
	let parent = this.parentNode.parentNode;
	parent.classList.add("focus");
}

function remcl(){
	let parent = this.parentNode.parentNode;
	if(this.value == ""){
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
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal || event.target == modal2 || event.target == modal3) {
    modal.style.display = "none";
	modal2.style.display = "none";
	modal3.style.display = "none";
  }
}

var btn2 = document.getElementById("sendBtn");
var btnconfirm = document.getElementById("comfirmBtn");

btnconfirm.onclick = function(){
	modal2.style.display = "none";
	modal3.style.display = "block";
}

btn2.onclick = function(){
	modal.style.display = "none";
	modal2.style.display = "block";
}
function close_modal(){
	modal2.style.display = "none";
	modal3.style.display = "none";
}
 