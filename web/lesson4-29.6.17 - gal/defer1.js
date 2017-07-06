//the script is defined defer (in html file), it will run only after DOM is rendered

var feed = document.getElementById("feed");
feed.textContent = 'hello world';

//var - is function scoped
//let - is block scoped
//const - is non-mutable value, and block scoped

//scope example
function scope(){
	{
		const one = true;
		var two = one;
		let three = two;
		
	}
	
	//console.log(one);
	console.log(two);
	console.log(three);
	
	one // doesn't exists
	two // does exists
	three // doesn't exists
}

//questions------------------------------------------------
//what is the output?
function a() {
	for(var i = 0; i < 10; i++){
		//some code
	}
	
	console.log(i); //will print 10 in console, because i is function scoped
}

//what is the output?
function b(){
	for(let i = 0; i < 4; i += 2){
		i--;
	}
	
	for(let i = 0; i < 4; i += 2){
		i--;
	}
	console.log(i); //will print error (Reference error) because i is block scoped
}

//what is the output?
function c(){
	console.log(x);//		undefined
	console.log(foo());// 	2
	var x = 1;
	function foo(){
		return 2;
	}
}

//interact with DOM---------------------------------------
function doc(){
	var group = document.getElementById('group');//get element group from DOM
	
	var elements = group.children;//get all the child elements from group
	console.log(elements.length) //print number of elements (3)
	var btn = document.createElement("button"); //create new element
	group.appendChild(btn);//add the new element to group (now there are 4 elements)
	console.log(elements.length) //print number of element(4, because children is live collection from DOM)
}


//collection----------------------------------------------

//1)arrays
const arr1 = [1, 2, 3];
arr1.push("hi"); // [1, 2, 3, "hi"]
arr1.pop(); // returns "hi", [1, 2, 3]
arr1.shift(); //returns 1 [2, 3]
arr1.unshift(1,2) //returns length(4) [1, 2, 2, 3]
arr1.slice(1, 2) // return 2 (will not change the array) [1, 2, 3]

const arr2 = [1,5,4,6,2,7,3];
arr2.sort() //[1,2,3,4,5,6,7]

const set1 = new Set();
set1.add("bubu");
set1.add("groot");
set1.add("nevoa");
set1.add("nevoa");
set1.add("groot");
set1.add({});

const map1 = new Map();
//map1.set(key, value);
map1.set(0, "zero");
map1.set(1, "one");
map1.set(2, "two");
map1.set(3, "three");
map1.set(4, "four");
map1.set(5, "five");

function printNum(number){
	if(isNaN(number)) return;
	let result=[];
	for(; number > 0; number=Math.floor(number/10)){
		switch(number % 10){
			case 0:
				result.push( "zero,");
			break;
			case 1:
				result.push( "one,");
			break;
			case 2:
				result.push( "two,");
			break;
			case 3:
				result.push( "three,");
			break;
			case 4:
				result.push( "four,");
			break;
			case 5:
				result.push( "five,");
			break;
			case 6:
				result.push( "six,");
			break;
			case 7:
				result.push( "seven,");
			break;
			case 8:
				result.push( "eight,");
			break;
			case 9:
				result.push( "nine,");
			break;
		}
	}
	return result;
}
console.log(printNum(123).reverse())

//print an number by it digits 123
function printNum(number){
	if(isNaN(number)) { return; }
	if(number == 0) { return ["zero"]; }
	
	var arr = [];
	for(;number > 0; number = Math.floor(number/10)){
		let digit = number % 10;
		arr.unshift(map1.get(digit));
		
	}
	
	return arr;
}

console.log(set1);
console.log(printNum(1023));

/*for loop structure
for(init(optional);exit condition(must);progress(optional)){

}
//*/

//conversion
function conversion(){
	const s1 = new Set(); //new set
	const array1 = ["Ido", "Sarel", "Orin", "Gidon", "Gidon", "Sarel"]; //new array
	const s2 = new Set(array1); // set from array values
	const array2 = [...s2] //array from set values - equivalent to Array.from(s2)
}


//interval--------------------------------------------
//---syntax---
//let inter = setInterval(function(){},#####) //create & start interval
//clearInterval(inter) //stop interval

var count = 0;
const inter = setInterval(function(){
	console.log("doing after 1 second");
	if(++count>10) clearInterval(inter); 
},1000);

//timing (delay)
//---syntax---
//setTimeout(function{},#####)  //wait the time then do function

setTimeout(function(){
	console.log("Doing after 2.5 sec delay");
},2500);









