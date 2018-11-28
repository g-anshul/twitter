function GetTimeLine(){

    $.ajax({
    url:'http://localhost:8080/api/1.0/twitter/timeline',
    type:"GET",
       dataType: 'JSON',
       success: function(response){
       console.log(response);
       }
    })
console.log("hello")
}