<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
    <!-- Font Icon -->
    <link rel="stylesheet" href="resources/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="resources/vendor/jquery-ui/jquery-ui.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="resources/css/login.css">
	<script>
	$('.message a').click(function(){
		   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
		});
	</script>
</head>
<body>
    <div class="main">
        <section class="login">
            <div class="container">
                <div class="login-content">
                    <form action = "modifydelete" method="GET" id="login-form" class="login-form">
                     <h2>회원 비밀번호 확인</h2>
                        <div class="form-group">
                            <label for="userpwd">Password</label>
                            <input type ="hidden" name = "userid" id ="userid" value = "${sessionScope.loginId}" />
                            <input type="password" class="form-input" name="userpwd" id="userpwd" />

                        </div>
                        <font color="red">${message}</font>                        
                        <div class="form-group">	
                            <input type="submit" name="submit" id="submit" class="form-submit" value="확인"/>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </div>
    <!-- JS -->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/jquery-ui/jquery-ui.min.js"></script>
    <script src="resources/vendor/jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="resources/vendor/jquery-validation/dist/additional-methods.min.js"></script>
    <script src="resources/js/main.js"></script>
</body>
</html>