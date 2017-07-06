var r = document.getElementById('Red');
var y = document.getElementById('Yellow');
var g = document.querySelector('#Green');

green();

function red(){
	r.style.background = "#ff0000";
	y.style.background = "transparent";
	setTimeout(function(){
		yellow();
	}, 4500);
}
function yellow(dir){
	y.style.background = "#ffff00";
	g.style.background = "transparent";
	
	setTimeout(function(){
		if(dir == "up") red();
		else green();
	}, 1500);
}
function green(){
	g.style.background="#00ff00";
	r.style.background = "transparent";
	y.style.background = "transparent";
	
	setTimeout(function(){
		yellow("up");
	}, 3500);
}
