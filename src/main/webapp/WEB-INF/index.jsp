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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/variables.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.css">
        
        <!-- <link rel="stylesheet" href="./css/bootstrap.min.css"> -->
     
    </head>
        
        <!--===============Start wrapper ================-->
        <div class="wrapper">
            <!--==============Start header menu============== -->
            <div class="header">
                <div class="header-menu">
                    <div class="title-text">Awesome People</div>
                    <div class="openbtn" onclick="toggleSidebar()">
                        <i class="fas fa-th-list"></i>
                    </div>
                    <ul>
                        <li><a class="button" style="width:auto;" onclick="openLogin()">Log In</a></li>
                            <div id="id01" class="login">
                                <form action="/action_page.php" method="post" class="login-content animate">
                                    <div class="imgcontainer">
                                        <span><a class="close" onclick="closeLogin()">x</a></span>
                                        <img src="/image/person.jpg" alt="Avatar" class="avatar" ></img>
                                    </div>
                                    <div class="container">
                                        <label for="uname"><b>Username</b></label>
                                        <input type="text" placeholder="Enter Username" name="uname" required></input>
                                        <label for="psw"><b>Password</b></label>
                                        <input type="password" placeholder="Enter Password" name="psw" required></input>
                                        <button class="loginbtn" type="submit">Login</button>
                                        <label>
                                            <input type="checkbox" checked="checked" name="remember">Remember me</input>
                                        </label>
                                        <span class="psw">Forgot <a href="#" class="forgotPsw">password? <i class="fas fa-key"></i></a></span>
                                    </div>
                                </form>
                            </div>
                        <li><a href="#" class="button">Sign Up</a></li>
                        <li><a href="#" class="dark-mode"><i class="fas fa-moon"></i></a></li>
                    </ul>
                </div>
            </div>
            <!--============== End header menu============== -->
            <!--============== Start side bar ============== -->
            <div class="sidebar" id="mySidebar">
                <div class="sidebar-menu">
                    <a href="javascript:void(0)" class="closebtn" onclick="toggleSidebar()">Ã</a>
                    <div class="profile">
                        <img src="./image/person.jpg" alt="">
                        <p>USER</p>
                    </div>
                    <ul>
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
                                <a href="#"><i class="fas fa-camera"></i><span>Photo</span></a>
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
                    <button class="mainTop-btn">All</button>
                    <button class="mainTop-btn">Notice</button>
                    <div class="search">
                        <input type="text" class="searchTerm" placeholder="Search here!:)">
                        <button type="submit" class="searchButton">
                          <i class="fa fa-search"></i>
                       </button>
                     </div>

                    <button class="mainTop-btn">Write</button>
                </div>
                <table class="table table-light">
                    <thead class="thead-light">
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
                        <td class="tbl-title">안녕 ㅋㅋㅋㅋ</td>
                        <td class="tbl-title">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello byebyebyebyebyebyebyebyebye bye</td>
                        <td class="tbl-title">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello bye byebyebyebyebyebyebyebyebyebyebyebyebyebye</td>
                        <td class="tbl-title">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello byebyebyebyebyebyebyebyebyebyebye bye</td>
                        <td class="tbl-title">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello bye byebyebyebyebyebyebyebyebyebyebyebyebye</td>
                        <td class="tbl-title">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello byebyebyebyebyebyebyebyebyebyebyebye bye</td>
                        <td class="tbl-title">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello bye bye</td>
                        <td class="tbl-title">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td class="tbl-title">hi hello bye bye</td>
                        <td class="tbl-title">writer</td>
                        <td>2020-08-04</td>
                        <td>50</td>
                        <td>5</td>
                      </tr>
                    </tbody>
                  </table>
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

            window.onclick = function(e) {
                    if (e.target == login){
                        e.style.display = "none";
                    }
                }

            function openLogin(){
                logIn.style.display = 'block';
            }

            function closeLogin(){
                var logIn = document.getElementById('id01');
                logIn.style.display = 'none';
            }

        //   onclick = "document.getElementById('id01').style.display='none'"
           


            
        </script>
    </body>
</html>