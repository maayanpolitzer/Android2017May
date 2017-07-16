function connectToServer(jsonObject, resultFunction){
	$.ajax({
		method: "POST",
		url: "http://104.199.43.149/whatsapp/server",
		data: JSON.stringify(jsonObject),
		dataType:"json",
		success: function(msg){
			resultFunction(msg); // callback.
		},
		error: function(e){
			console.log(e);
		}
	});
}