function initialise() {
    $.getJSON(contextPath + "/json/employeeList", function (data) {
        var employees = [];
        employees = data["employeeList"];
        for (var i = 0; i < employees.length; i++) {
            var employee = employees[i];
            var date = new Date(parseInt(employee.timeToJoin));
            var timeToJoin = parseSpecificDate(date);
            var editElement = "edit" + employee.id.toString();
            var deleteElement = "delete" + employee.id.toString();
            var saveElement = "save" + employee.id.toString();
            var employeeId = employee.id;
            var trk = $("<tr>" + "<td id ='ids'>" + employee.id + "</td>" + "<td>" + employee.name + "</td>" + "<td>" + employee.account + "</td>" + "<td>" + employee.timeOnThisAccount + "</td>" + "<td>" + employee.rate + "</td>" +
                "<td>" + timeToJoin + "</td>" + "<td>" + employee.totalWorkYear + "</td>" + "<td>" + employee.timeInTW + "</td>" + "<td>" + employee.graduate + "</td>" + "<td>" + employee.onceOut + "</td>" + "<td><button id =" + editElement + ">edit</button><button id =" + saveElement + ">Save</button><button id =" + deleteElement + ">Delete</button></td>" + "</tr>");
            $("#allList").append(trk);
            $("#" + editElement).bind('click', editSelectedElement);
            $("#" + deleteElement).bind('click', deleteSelectedElement);
            $("#" + saveElement).bind("click", saveSelectedElement);
            $("#" + saveElement).hide();
        }
        $("#calDate").datepicker();
    });
    $("#searchBtn").bind("click", searchThings);
}
function parseSpecificDate(date){
  var dateStr = padStr(1+date.getMonth())+"/"+padStr(1+date.getDay())+"/"+ padStr(date.getFullYear());
  return dateStr;
}

function padStr(i){
    return (i < 10) ? "0" + i : "" + i;
}
function submitForm() {
    var inputs = $("#insertForms input");
    var flag = true;
    for (var i = 0; i < inputs.length; i++) {
        var input = inputs[i];
        var value = $(input).val();
        if (value.trim().length === 0) {
            flag = flag && false;
        } else {
            flag = flag && checkFormat(input);
        }
    }
    if (!flag) {
        alert("invalid input");
    }
    return flag;
}
function checkFormat(input) {
    var inputStr = $(input).val().toLowerCase();
    var name = input.name.toLowerCase();
    if (name === "id") {
        return !isNaN(inputStr) && inputStr * 1 % 1 === 0;

    } else if (name === "graduate" || name === "onceOut".toLowerCase()) {
        if (inputStr === "yes" || inputStr === "true" || inputStr === "no" || inputStr === "false") {
            return true;
        }
        console.log("stop" + inputStr);
        return false;
    } else if (name === "name" || name === "account" || name === "timeToJoin".toLowerCase()) {
        return true;
    } else {
        if (!isNaN(inputStr)) {
            return true;
        }
        console.log(inputStr);
        return false;
    }
}
function searchThings() {
    var find = $("input[name='search']").val();
    $.ajax({
        url: contextPath + "/searchThis",
        type: 'POST',
        dataType: 'json',
        data: find,
        contentType: 'application/json',
        success: function (data) {
            showSearchResult(data);
        },
        error: function () {
            alert("Sorry,We cannot offer you the result");
        }
    });

}
function showSearchResult(data) {
    var employees = data["searchResult"];
    $(".addedResult").remove();
    for (var i = 0; i < employees.length; i++) {
        var employee = employees[i];
        var timeToJoin = (employee.timeToJoin);
        var date = new Date(parseInt(timeToJoin));
        var trk = $("<tr>" + "<td>" + employee.id + "</td>" + "<td>" + employee.name + "</td>" + "<td>" + employee.account + "</td>" + "<td>" + employee.timeOnThisAccount + "</td>" + "<td>" + employee.rate + "</td>" +
            "<td>" + date + "</td>" + "<td>" + employee.totalWorkYear + "</td>" + "<td>" + employee.timeInTW + "</td>" + "<td>" + employee.graduate + "</td>" + "<td>" + employee.onceOut + "</td>" + "</tr>");
        $(trk).addClass("addedResult");
        $("#searchResult").append(trk);
    }
    $("#searchDiv").show();


}
function insert() {
    var form = $(".forms").show();
}
function editSelectedElement() {
    var employeeId = $(this).parent().parent().find("#ids").text();
    var saveElement = "#save" + employeeId.toString();
    $(saveElement).show();
    $(this).hide();
    var tds = $(this).parent().parent().find("td");
    for (var i = 1; i < tds.length - 1; i++) {
        var element = tds[i];
        var OriginalContent = $(element).text();
        $(element).addClass("tempEdit");
        if (i === 5) {
            $(element).html("<input type='text' class='editCal' value='" + OriginalContent + "' />");
            $(".editCal").datepicker();
        } else {
            $(element).html("<input type='text' value='" + OriginalContent + "' />");
        }
    }

}

function saveSelectedElement() {
    var employeeId = $(this).parent().parent().find("#ids").text();
    var editElement = "#edit" + employeeId.toString();
    $(this).hide();
    $(editElement).show();
    var tds = $(".tempEdit :input");
    var employeeInfo = [];
    for (var i = 0; i < tds.length; i++) {
        var element = tds[i];
        employeeInfo.push($(element).val());
    }
    var employee = {
        id: employeeId * 1,
        name: employeeInfo[0],
        account: employeeInfo[1],
        timeOnThisAccount: employeeInfo[2] * 1,
        rate: employeeInfo[3] * 1,
        timeToJoin: new Date(employeeInfo[4]),
        totalWorkYear: employeeInfo[5] * 1,
        timeInTW: employeeInfo[6] * 1,
        graduate: Boolean(employeeInfo[7]),
        onceOut: Boolean(employeeInfo[8])
    };
    $.ajax({
        url: contextPath + "/edit",
        type: 'POST',
        dataType: 'json',
        data: employee,
        contentType: 'application/json',
        error: function () {
            location.reload();
        }
    });
}

function deleteSelectedElement() {
    var employeeId = $(this).parent().parent().find("#ids").text();
    jQuery.ajax({
        url: contextPath + "/delete",
        type: 'POST',
        dataType: 'json',
        data: employeeId.toString(),
        contentType: 'application/json',
        success: function () {
            console.log("!!!!!!!!!!!!!!!");
        },
        error: function (data) {
            location.reload();
        }
    });
}
