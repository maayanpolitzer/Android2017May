app.service("usersService", [function(){
	var users = ["Moshe","Yossi","Eli","Orin","Keren","Maayan", "gideon"];
	
	this.getUsers = function(){
		return users;
	}
	
}]);