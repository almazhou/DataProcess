function showTable(){
    $.getJSON(contextPath+"/json/employeeList",function(data){
        var employees = [];
        employees = data["employeeList"];
        for(var i = 0;i<employees.length;i++){
            var employee = employees[i];
            var timeToJoin = (employee.timeToJoin);
            var date = new Date(parseInt(timeToJoin));
            var trk = $("<tr>"+"<td>"+employee.id+"</td>"+"<td>"+employee.name+"</td>"+"<td>"+employee.account+"</td>"+"<td>"+employee.timeOnThisAccount+"</td>"+"<td>"+employee.rate+"</td>"+
                "<td>"+date+"</td>"+"<td>"+employee.totalWorkYear+"</td>"+"<td>"+employee.timeInTW+"</td>"+"<td>"+employee.graduate+"</td>"+"<td>"+employee.onceOut+"</td>"+"</tr>");
            $("table").append(trk);
        }
    });
}

function insert(){
     var form = $(".forms").show();
}