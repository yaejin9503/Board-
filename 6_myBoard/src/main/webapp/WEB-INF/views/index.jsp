<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   <title>Board</title>
    <meta name="keywords" content="">
   <meta name="description" content="">
    <meta name="author" content="templatemo">
    
   <!-- Google Fonts -->
   <link href="http://fonts.googleapis.com/css?family=PT+Serif:400,700,400italic,700itali" rel="stylesheet">
   <link href="http://fonts.googleapis.com/css?family=Raleway:400,900,800,700,500,200,100,600" rel="stylesheet">

   <!-- Stylesheets -->
   <link rel="stylesheet" href="resources/bootstrap/bootstrap.css">
   <link rel="stylesheet" href="resources/css/misc.css">
   <link rel="stylesheet" href="resources/css/blue-scheme.css">
   
   <!-- JavaScripts -->
   <script src="resources/js/jquery-1.10.2.min.js"></script>
   <script src="resources/js/jquery-migrate-1.2.1.min.js"></script>

</head>
<body>
   <div class="responsive_menu">
        <ul class="main_menu">
            <li><a href="index.html">Home</a></li>
               <li><a href="signup">회원가입</a>
               <li><a href="login">로그인</a></li>
               <li><a href="signout"> ${sessionScope.loginName}님, 로그아웃</a></li>
               <li><a href="dropout">탈퇴</a></li>
                <li><a href="modify">개인정보</a></li>
        </ul> <!-- /.main_menu -->
    </div> <!-- /.responsive_menu -->

   <header class="site-header clearfix">
      <div class="container">
         <div class="row">
            <div class="col-md-12">
               <div class="pull-left logo">
                  <b style="font-size:1.5em;"></b>
                  
               </div>   <!-- /.logo -->

               <div class="main-navigation pull-right">

                  <nav class="main-nav visible-md visible-lg">
                     <ul class="sf-menu"><!-- 이 메뉴가 주요 메뉴 이거 쓸거임 -->
                        <li ><a href="/">Home</a></li>
                        <c:if test="${empty sessionScope.loginId}">
                              <li ><a href="signup">회원가입</a></li>
                              <li><a href="login">로그인</a></li>
                               </c:if>
                           <c:if test = "${not empty sessionScope.loginId}">
                              <li><a href="logout">${sessionScope.loginName}님, 로그아웃</a></li>
                              <li><a href="dropout">탈퇴</a></li>
                              <li><a href="modify">개인정보 수정</a></li>
                           </c:if>
                           <li><a href="boardList">게시판</a></li>
                     </ul> <!-- /.sf-menu -->
                  </nav> <!-- /.main-nav -->

                  <!-- This one in here is responsive menu for tablet and mobiles -->
                   <div class="responsive-navigation visible-sm visible-xs">
                       <a href="#nogo" class="menu-toggle-btn">
                           <i class="fa fa-bars"></i>
                       </a>
                   </div> <!-- /responsive_navigation -->

               </div> <!-- /.main-navigation -->

            </div> <!-- /.col-md-12 -->

         </div> <!-- /.row -->

      </div> <!-- /.container -->
   </header> <!-- /.site-header -->

   <section id="homeIntro" class="parallax first-widget">
       <div class="parallax-overlay">
          <div class="container home-intro-content">
              <div class="row">
                 <div class="col-md-12">
                    <h2>Welcome my Board</h2>
                    
                 </div> <!-- /.col-md-12 -->
              </div> <!-- /.row -->
          </div> <!-- /.container -->
       </div> <!-- /.parallax-overlay -->
   </section> <!-- /#homeIntro -->
   <footer class="site-footer">
      <div class="container">
         <div class="row">
            <div class="col-md-12">
               <nav class="footer-nav clearfix">
                  <ul class="footer-menu">
                     <li><a href="index.html">Home</a></li>
                     <li><a href="portfolio.html">Portfolio</a></li>
                     <li><a href="blog.html">Blog</a></li>
                     <li><a href="contact.html">Contact us</a></li>
                  </ul> <!-- /.footer-menu -->
               </nav> <!-- /.footer-nav -->
            </div> <!-- /.col-md-12 -->
         </div> <!-- /.row --> 
         <div class="row">
            <div class="col-md-12">
               <p class="copyright-text">Copyright &copy; 2019  My Company</p>
            </div> <!-- /.col-md-12 -->
         </div> <!-- /.row -->s
      </div> <!-- /.container -->
   </footer> <!-- /.site-footer -->

   <!-- Scripts -->
   <script src="resources/js/min/plugins.min.js"></script>
   <script src="resources/js/min/medigo-custom.min.js"></script>
</body>
</html>