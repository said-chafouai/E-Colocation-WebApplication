<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<title>Page de connexion</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="presentation/yassine/image/png" href="presentation/yassine/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="presentation/yassine/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="presentation/yassine/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="presentation/yassine/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="presentation/yassine/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="presentation/yassine/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="presentation/yassine/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="presentation/yassine/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="presentation/yassine/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="presentation/yassine/css/util.css">
	<link rel="stylesheet" type="text/css" href="presentation/yassine/css/main.css">
<!--===============================================================================================-->
<link rel="images" type="image/jpg" href="presentation/yassine/images/bg-01.jpg"/>
<!--===============================================================================================-->



</head>
<body>

<body style="background-color: #666666;">
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="Connexion" method="post">
					<span class="login100-form-title p-b-43">
						Connectez vous pour continuer sur E-Colocation
					</span>
					
					<c:if test="${ !empty connexionEchoue}">
						<span>
							<font color="red">Mot de passe ou login incorrect Merci de ressayez</font>
						</span>
						<br>
					</c:if>
					
					<c:if test="${ !empty inscription}">
						<span>
							<font color="green">Votre inscription est reussit<br> vous devez attendre la validation de l'admin</font>
						</span>
						<br>
					</c:if>
					
					Login
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="login">
					</div>
					
					Password
					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="mdp">
					</div>

					<div class="flex-sb-m w-full p-t-3 p-b-32">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Remember me
							</label>
						</div>

						<div>
							<a href="#" class="txt1">
								Forgot Password?
							</a>
						</div>
					</div>
			

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Login
						</button>
					</div>
					
					<div class="text-center p-t-46 p-b-20">
						<span class="txt2">
							or sign up using
						</span>
					</div>

					<div class="login100-form-social flex-c-m">
						<a href="#" class="login100-form-social-item flex-c-m bg1 m-r-5">
							<i class="fa fa-facebook-f" aria-hidden="true"></i>
						</a>

						<a href="#" class="login100-form-social-item flex-c-m bg2 m-r-5">
							<i class="fa fa-twitter" aria-hidden="true"></i>
						</a>
					</div>
				</form>

				<div class="login100-more" style="background-image: url('presentation/yassine/images/bg-01.jpg');">
				</div>
			</div>
		</div>
	</div>
	
	

	
	
<!--===============================================================================================-->
	<script src="presentation/yassine/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="presentation/yassine/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="presentation/yassine/vendor/bootstrap/js/popper.js"></script>
	<script src="presentation/yassine/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="presentation/yassine/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="presentation/yassine/vendor/daterangepicker/moment.min.js"></script>
	<script src="presentation/yassine/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="presentation/yassine/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="presentation/yassine/js/main.js"></script>
	
	
</body>
</html>