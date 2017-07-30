var counter = 0;

this.addEventListener("message", function(data){
    setInterval(function(){
        this.postMessage(counter++);
    }, 2000);
    
});


