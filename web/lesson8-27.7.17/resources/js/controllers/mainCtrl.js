app.controller("mainCtrl", ["$scope","usersService", function($scope, usersService){
	$scope.name = "Maayan";
	
	$scope.userClick = function(name){
		console.log(name);
	};
	
	$scope.deleteUser = function(user){
		$scope.users.splice($scope.users.indexOf(user), 1);
	};
	
	$scope.getUsers = function(){
		$scope.users = usersService.getUsers();
	};
	
}]);