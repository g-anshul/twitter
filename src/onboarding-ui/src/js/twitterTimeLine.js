function GetTimeLine(){

    $.ajax({
    url:'http://localhost:8080/api/1.0/twitter/timeline',
    type:"GET",
       dataType: 'json',
       success: function(response){
       console.log("Inside function")
       console.log(response);
       var timeline = response.timeLineResponse;
                   console.log(timeline);

                  var ul = document.createElement("ul");
                  document.body.appendChild(ul);

                  for (var i =0; i < timeline.length; i++)
                  {
                      var li = document.createElement("li");
                      li.innerHTML = timeline[i];
                      ul.appendChild(li);
                  }
                  // $('#twitterDiv').html(timeline);
       },
        error: function (textStatus,errorThrown){
        console.log(textStatus);
        console.log(errorThrown);
       }
    })
}
