<html>
<head>
<title>Welcome</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="container">

		<div >
			<div class="form-group">
				<label for="emailLabel">Email address</label> <input
					type="text" class="form-control" id="userName"
					 placeholder="Enter email"> 
			</div>
			<div class="form-group">
				<label for="NameLabel">Name</label> <input
					type="text" class="form-control" id="name"
					 placeholder="Enter Name"> 
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" id="password"
					placeholder="Password">
			</div>
<!-- 			<div class="form-group form-check"> -->
<!-- 				<input type="checkbox" class="form-check-input" id="exampleCheck1"> -->
<!-- 				<label class="form-check-label" for="exampleCheck1">Check me -->
<!-- 					out</label> -->
<!-- 			</div> -->
		</div>
		    <button type="Button" onclick="LoginPage.createUser();"class="btn btn-primary">Create User</button>
		
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="js/login.js"></script>
		 <script src="js/utils.js"></script>
		
	</div>
</body>
</html>
