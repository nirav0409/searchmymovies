<html>
<head>
<title>Home</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h5 class="section-title h1">Movie Search Engine</h5>
		<div>
			<input type="text" class="form-control" id="movieName"
				aria-describedby="emailHelp" placeholder="Search For Movie">
			<button type="button" onclick="homePage.searchMovie();" class="btn btn-info" id="btnGen">Search</button>
		</div>
		<div class="row" id="contentPanel"></div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="js/home.js"></script>
		<script src="js/utils.js"></script>

	</div>
</body>
</html>
