<html>
<head>
<title>Login</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="container">

		<div >
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="text" class="form-control" id="userName"
					aria-describedby="emailHelp" placeholder="Enter email"> <small
					id="userNameText" class="form-text text-muted">We'll never
					share your email with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" id="password"
					placeholder="Password">
			</div>

			<button type="Login" onclick="LoginPage.doLogin();" class="btn btn-primary">Login</button>
			 <a  href="/createUser" class="btn btn-primary">Create User</a>
	
		</div>
		
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="js/login.js"></script>
		 <script src="js/utils.js"></script>
		
	</div>
</body>
</html>
