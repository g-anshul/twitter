function GetTimeLine(){

    $.ajax({
    url:'http://localhost:8080/api/1.0/twitter/timeline',
    type:"GET",
       dataType: 'json',
       success: function(response){
       console.log("Inside function")
       console.log(response);
       var timeline = response.timeLineSet;
                   console.log(timeline);

        var timeLineResponse = '';
        timeLineResponse += '<thead>';
        timeLineResponse += '<tr>';
        timeLineResponse += '<th>' + "Date" + '</th>';
        timeLineResponse += '<th>' + "ID" + '</th>';
        timeLineResponse += '<th>' + "ProfileImageUrl" + '</th>';
        timeLineResponse += '<th>' + "TimeLine Tweet Message" + '</th>';
        timeLineResponse += '<th>' + "Profile URL" + '</th>';
        timeLineResponse += '</tr>';
        timeLineResponse += '</thead>';

        $.each(timeline, function(key,value){
        timeLineResponse += '<div id = >' + value.timeLineResponseId ;
        timeLineResponse += '<tr>';
        timeLineResponse += '<td>' + Unix_timestamp(value.timelineResponseDate) + '</td>';
        timeLineResponse += '<td>' + value.timeLineResponseId + '</td>';
        timeLineResponse += '<td>' + "<img src='"+value.timeLineProfileImageUrl+"' />"  + '</td>';
        //timeLineResponse += "<td onclick='openNewTab(\""+ value.timeLineProfileImageUrl + "\")'>" + '<a href=>' + value.timeLineProfileImageUrl + '</a>' + '</td>';
        timeLineResponse += '<td>' + value.timelineResponse + '</td>';
        timeLineResponse += '<td>' + value.url + '</td>';
        timeLineResponse += '</tr>';
        timeLineResponse += '</div>';
        });

        $('#content').append(timeLineResponse);
        },
        error: function (textStatus,errorThrown){
        console.log(textStatus);
        console.log(errorThrown);
       }
    })
}

function openNewTab(url) {
    var win = window.open(url, '_blank');
    win.focus();
}


function Unix_timestamp(UNIX_timestamp) {
  var a = new Date(UNIX_timestamp * 1000);
  var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
  var year = a.getFullYear();
  var month = months[a.getMonth()];
  var date = a.getDate();
  var hour = a.getHours();
  var min = a.getMinutes();
  var sec = a.getSeconds();
  var time = date + ' ' + month + ' ' + ' ' + hour + ':' + min + ':' + sec ;
 return time;
}