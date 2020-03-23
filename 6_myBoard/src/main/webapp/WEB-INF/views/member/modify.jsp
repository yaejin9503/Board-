<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Signup</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="resources/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="resources/vendor/jquery-ui/jquery-ui.min.css">
    <!-- Main css -->
    <link rel="stylesheet" href="resources/css/signup.css">
</head>
<body>
    <div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <form action = "modify" method="POST" id="signup-form" class="signup-form">
                    <h2>modify</h2>
                        <div class="form-group">
                            <label for=userid></label>
                            <input type="hidden" class="form-input" name="userid" id="userid" value = "${sessionScope.loginId}" />
                        </div>
            			<div class="form-row">
                            <div class="form-group">
                                <label for="userpwd">Password</label>
                                <input type="password" class="form-input" name="userpwd" id="userpwd"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for=username>이름</label>
                            <input type="text" class="form-input" name="username" id="username" />
                        </div>
                        <div class=""form-group"">
                            <div class="form-radio">
                                <label for="gender">Gender</label>
                                <div class="form-flex">
                                    <input type="radio" name="gender" value="male" id="male" checked="checked" />
                                    <label for="male">Male</label>           
    
                                    <input type="radio" name="gender" value="female" id="female" />
                                    <label for="female">Female</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone number</label>
                            <input type="number" class="form-input" name="phone" id="phone" />
                        </div>
           
                        <div class="form-text">
                            <a href="#" class="add-info-link"><i class="zmdi zmdi-chevron-right"></i>Additional info</a>
                            <div class="add_info">
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-input" name="email" id="email"/>
                                </div>
                                <div class="form-group">
                                    <label for="address">Address</label>
                  						<input type="text" class="form-input" name="address" id="address"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                        	 <font color="red">${message}</font>
                         	<input type="submit" name="submit" id="submit" class="form-submit" value="수정하기"/>
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