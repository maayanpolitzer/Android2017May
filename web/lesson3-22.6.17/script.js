var table;
var list;
var inputs;
var preview;
var color;
var canvas;
var context;
var drawing = false;
var x;
var y;
var lineWidth = 2;

function start(event){
	drawing = true;
	x = event.offsetX;
	y = event.offsetY;
}

function draw(event){
	if(drawing){
		context.beginPath();
		context.moveTo(x,y);
		x = event.offsetX;
		y = event.offsetY;
		context.lineTo(x,y);
		context.strokeStyle = "#ff0000";
		context.lineWidth = lineWidth;
		context.stroke();
	}
}

function stop(event){
	drawing = false;
}

function init() {
	table = document.getElementById("table");
	list = document.getElementById("list");
	inputs = document.getElementsByTagName("input");	// return array.
	preview = document.getElementById("preview");
	canvas = document.getElementsByTagName("canvas")[0];
	context = canvas.getContext("2d");
	canvas.width = 300;
	canvas.height = 300;
}

function tableDisplayToggle(){
	if(table.style.visibility == "visible"){
		table.style.visibility = "hidden";
	}else{
		table.style.visibility = "visible";
	}
}

function saveColor(){
	tableDisplayToggle();
	addColor();
}

function updatePreviewColor(){
	color = "rgb(" + inputs[0].value + "," + inputs[1].value + "," + inputs[2].value + ")";
	preview.style.backgroundColor = color;
}

function addColor(){
	var li = document.createElement("li");  // create element (li tag).
	li.style.backgroundColor = color;  		// change color.
	list.appendChild(li);					// insert the new element to the list.
}

function changeSelected(){
	console.log("change selected wow!!!");
}