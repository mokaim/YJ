<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Team Project Board</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/variables.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

    </head>
    
    <body>

        <!--===============Start wrapper ================-->
        <div class="wrapper">
            <!--==============Start header menu============== -->
            <div class="header">
                <div class="header-menu">
                    <div class="header-text"><a href="#" class="title-text">Awesome People</a></div>
                    <div class="openbtn" onclick="toggleSidebar()">
                        <i class="fas fa-th-list"></i>
                    </div>
                    <ul>
                        <li><a class="button" style="width:auto;" onclick="openLogin()">Log In</a></li>
                            <div id="id01" class="login">
                                <form action="#" method="post" class="login-content animate">
                                    <div class="imgcontainer">
                                        <span><a class="close" onclick="closeLogin()">x</a></span>
                                        <img src="${pageContext.request.contextPath}/resources/image/person.jpg" alt="Avatar" class="avatar" ></img>
                                    </div>
                                    <div class="container">
                                        <label for="uname"><b>Username</b></label>
                                        <input type="text" placeholder="Enter Username" name="uname" required></input>
                                        <label for="psw"><b>Password</b></label>
                                        <input type="password" placeholder="Enter Password" name="psw" required></input>
                                        <button class="loginbtn" type="submit">Login</button>
                                        <label>
                                            <input type="checkbox" checked="checked" name="remember"> Remember me</input>
                                        </label>
                                        <span class="psw">Forgot <a href="#" class="forgotPsw">password? <i class="fas fa-key"></i></a></span>
                                    </div>
                                </form>
                            </div>
                        <li><a href="#" class="button" style="width:auto;" onclick="openSignup()">Sign Up</a></li>
                            <div id="signup" class="signup">
                                <div action="#" method="post" class="signup-content animate">
                                    <div class="welcomecontainer">
                                        <span><a class="close" onclick="closeSignup()">x</a></span>
                                        <div>Be one of our <p class="">Awesome People!</p></div>
                                    </div>
                                    <form class="container" id="signUpForm">
                                        <div class="form-control">
                                            <label for="username"><b>Username</b></label>
                                            <input type="text" placeholder="Enter Username" name="username" id="username" required></input>
                                            <i class="fas fa-check-circle"></i>
                                            <i class="fas fa-exclamation-circle"></i>
                                            <small>Error message</small>
                                        </div>

                                        <div class="form-control">
                                            <label for="email"><b>Email</b></label>
                                            <input type="text" placeholder="Enter Email" name="email" id="email" required></input>
                                            <i class="fas fa-check-circle"></i>
                                            <i class="fas fa-exclamation-circle"></i>
                                            <small>Error message</small>
                                        </div>

                                        <div class="form-control">
                                            <label for="psw"><b>Password</b></label>
                                            <input type="password" placeholder="Enter Password" name="pw" id="pw" required></input>
                                            <i class="fas fa-check-circle"></i>
                                            <i class="fas fa-exclamation-circle"></i>
                                            <small>Error message</small>
                                        </div>

                                        <div class="form-control">
                                            <label for="repeatPsw"><b>Repeat Password</b></label>
                                            <input type="password" placeholder="Enter Password again" name="pw2" id="pw2" required></input>
                                            <i class="fas fa-check-circle"></i>
                                            <i class="fas fa-exclamation-circle"></i>
                                            <small>Error message</small>
                                        </div>

                                        <button class="signUpBtn" type="submit">Sign Up</button>
                                        <p>or</p>
                                        <button class="signUpBtn signUpWith" type="submit"><i class="fab fa-google"></i> Sign Up with Google</button>
                                        <button class="signUpBtn signUpWith" type="submit"><i class="fab fa-facebook-f"></i> Sign Up with Facebook</button>
                                        <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
                                    </form>
                                </div>
                            </div>
                        <li><a href="#" class="dark-mode"><i class="fas fa-moon"></i></a></li>
                    </ul>
                </div>
            </div>
            <!--============== End header menu============== -->
            <!--============== Start side bar ============== -->
            <div class="sidebar" id="mySidebar">
                <div class="sidebar-menu">
                    <a href="javascript:void(0)" class="closebtn" onclick="toggleSidebar()">x</a>
                    <div class="profile">
                        <img src="${pageContext.request.contextPath}/resources/image/person.jpg" alt="">
                        <p>USER</p>
                    </div>
                    <ul>
                        <li class="item">
                            <a href="#sub-menu1" class="menu-btn" onclick="dropdown()">
                                <i class="fas fa-user"></i><span>Profile</span><i class="fas fa-chevron-down drop-down" id="down"></i>
                            </a>
                            <div class="sub-menu" id="sub-menu1">
                                <a href="#" onclick="openUploadImg()"><i class="fas fa-camera"></i><span>Photo</span></a>
                                    <div id="upload" class="upload">
                                        <div class="upload-content animate">
                                            <span><a class="close" onclick="closeUploadImg()">x</a></span>
                                            <div class="uploadContainer">
                                                <div class="imgcontainer">
                                                    <img class="uploadImg" src="" alt="">
                                                </div>
                                                <div class="content">
                                                    <div class="icon"><i class="fas fa-file-image"></i></div>
                                                    <div class="text">No file chosen yet.</div>
                                                </div>
                                                <div class="close uploadClose">x</div>
                                                <div class="file-name">File name here</div>
                                            </div>
                                            <div class="uploadBtn">
                                                <button onclick="chooseImg()" class="chooseImg">Choose a file</button>
                                                <input class="openFileBtn" type="file" hidden>
                                                <button class="uploadFinalBtn" type="submit">upload</button>
                                            </div>
                                        </div>
                                    </div>
                                <a href="#"><i class="fas fa-signature"></i><span>Name</span></a>
                            </div>
                        </li>
                       
                        <li class="item">
                            <a href="#sub-menu2" class="menu-btn" onclick="dropdown()">
                                <i class="fas fa-envelope"></i><span>Message</span><i class="fas fa-chevron-down drop-down" id="down"></i>
                            </a>
                            <div class="sub-menu" id="sub-menu2">
                                <a href="#"><i class="fas fa-envelope-open"></i><span>New</span></a>
                                <a href="#"><i class="far fa-envelope-open"></i><span>Sent</span></a>
                                <a href="#"><i class="fas fa-exclamation-triangle"></i><span>Spam</span></a>
                            </div>
                        </li>
                        <li class="item">
                            <a href="#sub-menu3" class="menu-btn" onclick="dropdown()">
                                <i class="fas fa-cog"></i><span>Setting</span><i class="fas fa-chevron-down drop-down" id="down"></i>
                            </a>
                            <div class="sub-menu" id="sub-menu3">
                                <a href="#"><i class="fas fa-lock"></i><span>Password</span></a>
                                <a href="#"><i class="fas fa-globe-asia"></i><span>Language</span></a>
                            </div>
                        </li>
                        <li class="item">
                            <a href="#" class="menu-btn">
                                <i class="fas fa-exclamation-circle"></i></i><span>About</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <!--==================End side bar ===================-->

            <!--===============Start main container ================-->
            <div class="main-container" id="myMain">
                <div class="main-top">
                    <div class="main-top2">
                        <button class="mainTop-btn">All</button>
                        <button class="mainTop-btn">Notice</button>
                    </div>
                    <div class="main-top2">
                        <div class="search">
                            <input type="text" class="searchTerm" placeholder="Search here!:)">
                            <button type="submit" class="searchButton">
                            <i class="fa fa-search"></i></button>
                        </div>
                        <button class="mainTop-btn" onclick="openWrite()">Write</button>
                            <div id="write" class="write">
                                <form action="#" method="post" class="write-content animate">
                                    <div class="writeContainer">
                                        <span><a class="close" onclick="closeWrite()">x</a></span>
                                        <img src="${pageContext.request.contextPath}/resources/image/writeBG.jpg" alt="writeImg" class="writeImg"></img>                                     
                                        
                                        <p>Share your thoughts</p>
                                    </div>
                                    <div class="container">
                                        <label for="title"><b>Title</b></label>
                                        <input type="text" name="title" required></input>
                                        <br>
                                        <label for="content"><b>Content</b></label>
                                        <textarea name="content" class="content" required></textarea>
                                        <button class="writeBtn" type="submit">Post</button>
                                    </div>
                                </form>
                            </div> 
                    </div>
                </div>
                <table>
                    <thead>
                      <tr>
                        <th scope="col" class="col-no">No</th>
                        <th scope="col" class="col-title">Title</th>
                        <th scope="col" class="col-writer">Writer</th>
                        <th scope="col" class="col-date">Date</th>
                        <th scope="col" class="col-views">Views</th>
                        <th scope="col" class="col-like">Like</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello bye byebyebyebyebyebyebyebyebyebyebye</td>
                        <td class="tbl-writer">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello byebyebyebyebyebyebyebyebye bye</td>
                        <td class="tbl-writer">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello bye byebyebyebyebyebyebyebyebyebyebyebyebyebye</td>
                        <td class="tbl-writer">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello byebyebyebyebyebyebyebyebyebyebye bye</td>
                        <td class="tbl-writer">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello bye byebyebyebyebyebyebyebyebyebyebyebyebye</td>
                        <td class="tbl-writer">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello byebyebyebyebyebyebyebyebyebyebyebye bye</td>
                        <td class="tbl-writer">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello bye bye</td>
                        <td class="tbl-writer">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello bye bye</td>
                        <td class="tbl-writer">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                    </tbody>
                  </table>

                  <div class="pagination">
                    <a href="#">&laquo;</a>
                    <a href="#" class="activePage">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">6</a>
                    <a href="#">&raquo;</a>
                  </div>
            </div>




            <!--===============End main container ================-->
        </div>
        <!--===============End wrapper ================-->

  



        <script>
        
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

        // window.onclick = function(e) {
//                 if (e.target != login){
//                     e.style.display = "none";
//                 }
//             }

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
        
        
        
        
        
        
        
            const uploadContainer = document.querySelector('.uploadContainer');
            const fileName = document.querySelector('.file-name');
            const openFileBtn = document.querySelector('.openFileBtn');
            const uploadClose = document.querySelector('.uploadClose');
            const uploadImg = document.querySelector('.uploadImg');
            let regExp = /[0-9a-zA-Z\^\&\'\@\{\}\[\]\,\$\=\!\-\#\(\)\.\%\+\~\_ ]+$/;

            function chooseImg(){
                openFileBtn.click();
            }

            openFileBtn.addEventListener("change", function(){
                const file = this.files[0];

                if(file){
                const reader = new FileReader();

                reader.onload = function(){
                    const result = reader.result;
                    uploadImg.src = result;
                    uploadContainer.classList.add("active");
                }

                uploadClose.addEventListener("click", function(){
                    uploadImg.src = "";
                    uploadContainer.classList.remove("active");
                })

                reader.readAsDataURL(file);
                }

                if(this.value){
                let valueStore = this.value.match(regExp);
                fileName.textContent = valueStore;
                }
            });
       </script>
    </body>
</html>



