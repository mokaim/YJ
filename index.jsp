<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Team Project Board</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">

        <link rel="stylesheet" href="./resources/css/style.css">
        <link rel="stylesheet" href="./resources/css/responsive.css">
        <link rel="stylesheet" href="./resources/css/global.css">

        
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&family=Russo+One&display=swap" rel="stylesheet">
        
        
        <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
        

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
                    
					<c:set var="user" value="${session}" />


					<c:if test="${user eq null}">

    					<li><a class="button" style="width:auto;" onclick="openLogin()">Log In</a></li>
                            
                            
                            <div id="id01" class="login">
                                <form action="/master/login" method="post" class="login-content animate">
                                    <div class="imgcontainer">
                                        <span><a class="close" onclick="closeLogin()">x</a></span>
                                        <img src="./resources/image/person.jpg" alt="Avatar" class="avatar" ></img>
                                    </div>
                                    <div class="container">
                                        <label for="uname"><b>Username</b></label>
                                        <input type="text" placeholder="Enter Username" name="username" required></input>
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
                                <div class="signup-content animate">
                                    <div class="welcomecontainer">
                                        <span><a class="close" onclick="closeSignup()">x</a></span>
                                        <div>Be one of our <p class="">Awesome People!</p></div>
                                    </div>
                                    <form class="container" id="signUpForm" method="post" action="/master/signup">
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

                                        <input type="submit" class="signUpBtn">
                                        <p>or</p>
                                        <button class="signUpBtn signUpWith" type="submit"><i class="fab fa-google"></i> Sign Up with Google</button>
                                        <button class="signUpBtn signUpWith" type="submit"><i class="fab fa-facebook-f"></i> Sign Up with Facebook</button>
                                        <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
                                    </form>
                                </div>
                            </div>

					</c:if>


                        <!-- <li><a href="#" class="dark-mode"><i class="fas fa-moon"></i></a></li> -->
                    </ul>
                </div>
            </div>
            <!--============== End header menu============== -->
            <!--============== Start side bar ============== -->
            <div class="sidebar" id="mySidebar">
                <div class="sidebar-menu">
                    <a href="javascript:void(0)" class="closebtn" onclick="toggleSidebar()">×</a>
                    <div class="profile">
                        <img src="./resources/image/person.jpg" alt="">
                        <p>USER</p>
                    </div>
                    <!-- <ul>
                        <li class="item">
                            <a href="#" class="menu-btn">
                                <i class="fas fa-desktop"></i><span>Board</span>
                            </a>
                        </li>
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
                    </ul>  -->
                </div>
            </div>
            <!--==================End side bar ===================-->

            <!--===============Start main container ================-->
            <div class="main-container" id="myMain">
                <div class="main-top">
                    <!-- <div class="main-top2">
                        <button class="mainTop-btn">All</button>
                        <button class="mainTop-btn">Notice</button>
                    </div> -->
                    <div class="main-top2">
                        <div class="search">
                            <input type="text" class="searchTerm" placeholder="Search here!:)">
                            <button type="submit" class="searchButton">
                            <i class="fa fa-search"></i></button>
                        </div>
                        
                        <c:if test="${user != null}">
							<button class="mainTop-btn" onclick="openWrite()">Write</button>
                            <div id="write" class="write">
                                <form action="/master/writer" method="post" class="write-content animate">
                                    <div class="writeContainer">
                                        <span><a class="close" onclick="closeWrite()">x</a></span>
                                        <img src="./image/writeBG.jpg" alt="writeImg" class="writeImg" ></img>
                                        <p>Share your thoughts</p>
                                    </div>
                                    <div class="container">
                                        <label for="title"><b>Title</b></label>
                                        <input type="text" name="title" required placeholder="Title here"></input>
                                        <br>
                                        <label for="content"><b>Content</b></label>
                                        <textarea type="textarea" name="content" class="content" required> </textarea>
                                        <br>
                                        <label for="image"><b>Attach Image</b></label>
                                        <br>
                                        <input type="file" name="uploadFile" class="inputImg">
                                            <div class="write_imgcontainer">
                                                <img class="write_uploadImg" src="" alt="" width="100%" height="auto">
                                            </div>         
                                        
                                        <button class="writeBtn" type="submit">Post</button>
                                    </div>
                                </form>
                            </div>
                        </c:if>
                        

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
                    
                    <c:forEach var="writeDTO" items="${list}">
                       <tr>
                        <th scope="row">${writeDTO.postNumber}</th>
                        <td id="view${writeDTO.postNumber}" class="tbl-title" onclick="openContent('${writeDTO.postNumber}')">${writeDTO.title}</td>
                        <td class="tbl-writer">${writeDTO.writer}</td>
                        <td>${writeDTO.posted_date}</td>
                        <td>${writeDTO.visit}</td>
                        <td>${writeDTO.likes}</td>
                      </tr>
                    
                    </c:forEach>
                    

                      
                    </tbody>
                  </table>
                  
                  
                <c:set var="currentPage" value="${currentPage}"></c:set>
                <c:set var="totalPage" value="${totalPage}"></c:set>
                
                
                  
                <div class="pagination" id="pagination">
                
                  <c:choose>
                  	<c:when test="${currentPage <= 1}">
                  		<a href="/master/?page=1">&laquo;</a>
                  	</c:when>
                  	
                  	<c:otherwise>
                  		<a href="/master/?page=${currentPage - 1}">&laquo;</a>
                  	</c:otherwise>
                  	
                  </c:choose>
                  
                  
                  <c:forEach var="paging" items="${pagingNumber}">

					<c:choose>
					
					  <c:when test="${currentPage eq paging}">
					  	<a href="/master/?page=${paging}" class="activePage">${paging}</a>
					  </c:when>
					  
					  <c:otherwise>	
					  	<a href="/master/?page=${paging}" class="">${paging}</a>
					  </c:otherwise>
					  
					</c:choose>

                  </c:forEach>
                  
                  
                  <c:choose>
                  	<c:when test="${currentPage >= totalPage}">
                  		<a href="/master/?page=${totalPage}">&raquo;</a>
                  	</c:when>
                  	
                  	<c:otherwise>
                  		<a href="/master/?page=${currentPage + 1}">&raquo;</a>
                  	</c:otherwise>
                  	
                  </c:choose>

                </div>
                

                
                <div class="detailPage">
                        <div class="detailContainer">
                            <p id="dPageTxt">see what others think</p>
                        </div>
                        <form class="container" name="detailPageForm">
                            <label for="title"><b>Title</b></label>
                            <textarea class="title" readonly name="dPageTitle" id="targetTitle"></textarea>
                            <br>
                            <label for="content"><b>Content</b></label>
                            <textarea class="content" readonly name="dPageContent" id="targetContent"></textarea>
                            <br>
                            <label for="image"><b>Image</b></label>
                            <div class="img"></div>
                            <br>
                            <button class="writeBtn" onclick="backToList()">Back</button>
                        </form>
                </div>
                

                
                
                
                
            </div>



            <!--===============End main container ================-->
        </div>
        <!--===============End wrapper ================-->

        <script type="text/javascript" src="./resources/JS/main.js"></script>
        
        <script>
            const uploadContainer = document.querySelector('.uploadContainer');
            const fileName = document.querySelector('.file-name');
            const openFileBtn = document.querySelector('.openFileBtn');
            const uploadClose = document.querySelector('.uploadClose');
            const uploadImg = document.querySelector('.uploadImg');

	        const write_imgcontainer = document.querySelector('.write_imgcontainer');
            const inputImg = document.querySelector('.inputImg');
            const write_uploadImg = document.querySelector('.write_uploadImg');

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


            inputImg.addEventListener("change", function(){
                const file = this.files[0];

                if(file){
                const reader = new FileReader();

                reader.onload = function(){
                    const result = reader.result;
                    write_uploadImg.src = result;
                    write_imgcontainer.classList.add("active");
                }

                reader.readAsDataURL(file);
                }
            });



			function openContent(queryString){

				//var myNum = "<c:out value='${totalPage}'/>";
				
				var html = [];
				
				mainTop.style.display = 'none';
				table.style.display = 'none';
				pagination.style.display = 'none';
				detailPage.style.display = 'block';


				var ajaxGet = '/master/index/view?viewId=' + queryString;
				var title;
				var content;



				

				$.ajax({

					type : 'get',
					url : ajaxGet,
					success : (result) => {

						document.getElementById('targetTitle').value = result[0].title;
						document.getElementById('targetContent').value = result[0].content;
						
						for(i=0; i<result.length; i++){
							console.log(result[i].title);
						}

						
					},error : (request,status,err) => {

						alert('실패함..;;' + status);
					}
					

				});
				
			}
						
			

            
       </script>
    </body>
</html>
