 var LoginPage = 
{
    doLogin : function ()
    {
    	console.log("do login before");

        var user = document.getElementById("userName").value;
        var password = document.getElementById("password").value;

    	console.log(user + password);

        var doc = "User="+ user + "&Password=" +password ;
       // document.getElementById('processingDiv').style.display = 'block';
        E1AJAX.sendXMLReq("POST", null, "/dologin", LoginPage.processLogin, doc);
    },
    
    processLogin : function(containerId, responseText){
    	//var loginResponse = JSON.parse(responseText);
    	console.log("process login "+ responseText);
    },
    
    createUser : function(){
    	console.log("do login before");
        var user = document.getElementById("userName").value;
        var password = document.getElementById("password").value;
        var name = document.getElementById("name").value;

    	//console.log(user+ name + password);

        var doc = "User="+ user + "&Password=" +password + "&Name=" +name;
        E1AJAX.sendXMLReq("POST", null, "/addNewUser", LoginPage.processUser, doc);
    },
    processUser : function(containerId, responseText){
    	//var loginResponse = JSON.parse(responseText);
    	console.log("process login "+ responseText);
    }
}