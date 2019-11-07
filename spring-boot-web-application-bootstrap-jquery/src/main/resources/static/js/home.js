var homePage = {

	searchMovie : function() {
		var movie = document.getElementById("movieName").value;
		var doc = "Movie=" + movie;
		console.log("i will search for " + movie);
		// document.getElementById('processingDiv').style.display = 'block';
		E1AJAX.sendXMLReq("POST", null, "/searchMovie", homePage.displayResult,
				doc);
	},
	displayResult : function(containerId, responseText) {
		// var loginResponse = JSON.parse(responseText);
		console.log("process login " + responseText);
		var loginResponse = JSON.parse(responseText);
		homePage.addCols(1, loginResponse);
	},

	addCols : function(num, loginResponse) {
		console.log(loginResponse.Title + " " + loginResponse.Director + " ");
		for (var i = 1; i <= num; i++) {

			//var myCol = $('<div class="col-sm-3 col-md-3 pb-2"></div>');
			// var myPanel = $('<div class="card card-outline-info" id="'
			// + i
			// + 'Panel"><div class="card-block"><div class="card-title"><span>'
			// + loginResponse.Title
			// + '</span><button type="button" class="close" data-target="#'
			// + i
			// + 'Panel" data-dismiss="alert"><span class="float-right"><i
			// class="fa fa-remove"></i></span></button></div><p>'
			// + loginResponse.Plot + ' </p><img src="'
			// + loginResponse.Poster
			// + '" class="rounded rounded-circle"></div></div>');

			var myPanel = $('<div class="card mb-3" style="max-width: 540px;"> <div class="row no-gutters"> <div class="col-md-4">'
					+ '<img src="'+loginResponse.Poster+'" class="card-img" height="180" width="180"> </div> <div class="col-md-8">' 
					+ '<div class="card-body"> <h5 class="card-title" >'+loginResponse.Title+'</h5>' 
					+ '<p class="card-text">'+loginResponse.Plot+'</p> <p class="card-text">'
					+ '<small class="text-muted">Last updated 3 mins ago</small></p>' 
					+ '</div> </div> </div> </div>');
			//myPanel.appendTo(myCol);
			myPanel.appendTo('#contentPanel');
		}

		$('.close').on('click', function(e) {
			e.stopPropagation();
			var $target = $(this).parents('.col-sm-3');
			$target.hide('slow', function() {
				$target.remove();
			});
		});
	}

}