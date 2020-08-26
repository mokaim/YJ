

// const uploadBox2 = document.querySelector('#uploadBox');




// uploadBox2.onkeydown = function () {
// 	var kcode = event.keyCode;
// 	if (kcode == 8 || kcode == 116) event.returnValue = false;
// }




function toggleSidebar(){
    var main = document.getElementById("myMain");
    main.classList.toggle("collapseMain");
    var side = document.getElementById("mySidebar");
    side.classList.toggle("collapseSide");
}

var logIn = document.getElementById('id01');
var signUp = document.getElementById('signup');
var upLoad = document.getElementById('upload');
var write = document.getElementById('write');
var page = document.getElementById('pagination');
var write_upload = document.getElementById('write_upload');

// window.onclick = function(e) {
//         if (e.target != login){
//             e.style.display = "none";
//         }
//     }

function openLogin(){
    logIn.style.display = 'block';
}

function closeLogin(){
    logIn.style.display = 'none';
}

function openSignup(){
    signUp.style.display = 'block';
}

function closeSignup(){
    signUp.style.display = 'none';
}

function openUploadImg(){
    upLoad.style.display = 'block';
    page.style.display = 'none';
    
}

function closeUploadImg(){
    upLoad.style.display = 'none';
    page.style.display = 'block';
}

function openWrite(){
    write.style.display = 'block';
}

function closeWrite(){
    write.style.display = 'none';
}

const uploadBox = document.querySelector('.uploadBox');

function write_openUploadImg(){
	write_upload.style.display = 'block';
	uploadBox.classList.add("blockBox");
}





// ====================sign up / RegExp=======================


const signUpForm = document.getElementById('signUpForm');
const username = document.getElementById('username');
const email = document.getElementById('email');
const pw = document.getElementById('pw');
const pw2 = document.getElementById('pw2');

signUpForm.addEventListener('submit', e => {
	e.preventDefault();
	
	checkInputs();
});

function checkInputs() {
	// trim to remove the whitespaces
	const usernameValue = username.value.trim();
	const emailValue = email.value.trim();
	const pwValue = pw.value.trim();
	const pw2Value = pw2.value.trim();
	
	if(usernameValue === '') {
		setErrorFor(username, 'Username cannot be blank');
	} else {
		setSuccessFor(username);
	}
	
	if(emailValue === '') {
		setErrorFor(email, 'Email cannot be blank');
	} else if (!isEmail(emailValue)) {
		setErrorFor(email, 'Not a valid email');
	} else {
		setSuccessFor(email);
	}
	
	if(pwValue === '') {
		setErrorFor(pw, 'Password cannot be blank');
	} else if(pwValue.length <= 6) {
		setErrorFor(pw, 'Password must be longer than 6 characters')
	} else if(pwValue.length >= 20) {
		setErrorFor(pw, 'Password must be less than 20 characters')
	} else if(pwValue === 'password') {
		setErrorFor(pw, 'Password cannot be password')
	} else {
		setSuccessFor(pw);
	}
	
	if(pw2Value === '') {
		setErrorFor(pw2, 'Password cannot be blank');
	} else if(pwValue !== pw2Value) {
		setErrorFor(pw2, 'Passwords does not match');
	} else{
		setSuccessFor(pw2);
    }
    
}

function setErrorFor(input, message) {
	const formControl = input.parentElement;
	const small = formControl.querySelector('small');
	formControl.className = 'form-control error';
	small.innerText = message;
}

function setSuccessFor(input) {
	const formControl = input.parentElement;
	formControl.className = 'form-control success';
}
	
function isEmail(email) {
	return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}


