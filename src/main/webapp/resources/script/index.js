function showTable(){
    $.getJSON(contextPath+"/json/employeeList",function(data){
        var employees = [];
        employees = data["employeeList"];
        for(var i = 0;i<employees.length;i++){
            var employee = employees[i];
            var timeToJoin = (employee.timeToJoin);
            var date = new Date(parseInt(timeToJoin));
            var editElement = "edit"+i.toString();
            var deleteElement = "delete"+i.toString();
            var employeeId = employee.id;
            var trk = $("<tr>"+"<td id ='ids'>"+employee.id+"</td>"+"<td>"+employee.name+"</td>"+"<td>"+employee.account+"</td>"+"<td>"+employee.timeOnThisAccount+"</td>"+"<td>"+employee.rate+"</td>"+
                "<td>"+date+"</td>"+"<td>"+employee.totalWorkYear+"</td>"+"<td>"+employee.timeInTW+"</td>"+"<td>"+employee.graduate+"</td>"+"<td>"+employee.onceOut+"</td>"+"<td><button id ="+editElement+">edit</button><button id ="+deleteElement+">Delete</button></td>"+"</tr>");
            $("table").append(trk);
            $("#"+editElement).bind('click',editSelectedElement);
            $("#"+deleteElement).bind('click',deleteSelectedElement);
        }
    });
}

function insert(){
     var form = $(".forms").show();
}
function editSelectedElement(){
    var employeeId = $(this).parent().parent().find("#ids").text();
    console.log(employeeId);
}
function deleteSelectedElement(){
    var employeeId = $(this).parent().parent().find("#ids").text();
    jQuery.ajax({
        url: contextPath+ "/delete",
        type: 'POST',
        dataType: 'json',
        data: employeeId.toString(),
        contentType: 'application/json'
    });
}
