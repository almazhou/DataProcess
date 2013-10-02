var orderedItem =["idClass","nameClass","accountClass","timeOnThisAccountClass","rateClass","timeToJoinClass","totalWorkYearClass","timeInTWClass","graduateClass","onceOutClass"];

function initialise() {
    $.getJSON(contextPath + "/json/employeeList", function (data) {
        employees = data["employeeList"];
        for (var i = 0; i < employees.length; i++) {
            var employee = employees[i];
            var date = new Date(parseInt(employee.timeToJoin));
            var timeToJoin = parseSpecificDate(date);
            var editElement = "edit" + employee.id.toString();
            var deleteElement = "delete" + employee.id.toString();
            var saveElement = "save" + employee.id.toString();
            var trk = $("<tr>" + "<td id ='ids' class='idClass'>" + employee.id + "</td>" + "<td class='nameClass'>" + employee.name + "</td>" + "<td class='accountClass'>" + employee.account + "</td>" + "<td class='timeOnThisAccountClass'>" + employee.timeOnThisAccount + "</td>" + "<td class='rateClass'>" + employee.rate + "</td>" +
                "<td class='timeToJoinClass'>" + timeToJoin + "</td>" + "<td class='totalWorkYearClass'>" + employee.totalWorkYear + "</td>" + "<td class='timeInTWClass'>" + employee.timeInTW + "</td>" + "<td class='graduateClass'>" + employee.graduate + "</td>" + "<td class='onceOutClass'>" + employee.onceOut + "</td>" + "<td><button id =" + editElement + ">edit</button><button id =" + saveElement + ">Save</button><button id =" + deleteElement + ">Delete</button></td>" + "</tr>");
            $("#allList").append(trk);
            $("#" + editElement).bind('click', editSelectedElement);
            $("#" + deleteElement).bind('click', deleteSelectedElement);
            $("#" + saveElement).bind("click", saveSelectedElement);
            $("#" + saveElement).hide();
            buildOptions(trk);
        }

        $("#calDate").datepicker();
    });
    initialButtons();
    $("#searchBtn").bind("click", searchThings);
}

function buildOptions(tableElement){
  var tableEntries = $(tableElement).find("td[class]");
    $(tableEntries).each(function(){
        var selectName = $(this).attr("class");
        var tableContent = $(this).text();
        var option = $("<option></option>").attr("value",selectName).text(tableContent);
        var appendSelect = selectName.substring(0,selectName.length-5);
        var select = $("select[name="+appendSelect+"]");
        if(selectNotContains(select,tableContent)){
            $(select).append(option);
        }
        var element = select;
        $(element).unbind("change");
        $(element).change(function(element){
            renderItems();
        });
    });
}
function showOrHide(selected,showColumn){
    var showElements = $("." + showColumn+":visible");
    if(showElements){
    $(showElements).each(function(){
        if($(this).text()!==selected){
            $(this).parent().hide();
        }else{
            $(this).parent().show();
        }
    });
    }
}
function sortTable(){
    var sorters = $("button[id$='Sort']");

    if(sorters.hasClass("hideSort")){
        sorters.removeClass("hideSort");
    }else{
        sorters.addClass("hideSort");
    }
}
function renderItems(){

    var checkedValues = $("select:visible option:selected");
    if(checkedValues.length===0){
        location.reload();
        return;
    }
    for(var item in orderedItem){
        var selectedItem = $("select:visible option[value="+orderedItem[item]+"]:selected");
        if(selectedItem.text()==="--"){
            $(selectedItem).parent().parent().addClass("hideSelect");
            $("td[class]").parent().show();
            renderItems();
            return;
        }
        if(selectedItem.length!==0&&selectedItem.text()!=="--"){
            showOrHide($(selectedItem).text(),selectedItem.val());
        }
    }
}
function selectNotContains(select,content){
    var options = $(select).find("option");
    var flag = true;
    $(options).each(function(){
        if($(this).text()===content){
           flag = false;
        }
    });
    return flag;
}
function initialButtons(){
    var heads = $("#tableHead th[id !='edit']");

    $(heads).each(function(head){
        if($(this).find("div").hasClass("selectDivClass")){
            $(".selectDivClass").remove();
        }
        var selectName = $(this).attr("id");
        var filterBtn = $("<button>filter</button>").attr("id",selectName+"Filter").addClass("hideFilter");

        $(filterBtn).bind('click',showFilterSelect);

        $(this).find(".title").append(filterBtn);
        var option = $("<option></option>").attr("value",selectName+"Class").text("--");
        var addedSelect=$("<select></select>").attr("name",selectName+"Filter");
        addedSelect.append(option);
        $(addedSelect).addClass("hideSelect");
        var selectDiv = $("<div></div>").addClass("selectDivClass");
        $(selectDiv).append(addedSelect);
        $(this).append(selectDiv);
        var sortBtn = $("<button>sort</button>").attr("id",selectName+"Sort").addClass("hideSort");
        $(sortBtn).bind("click",showSortSelect);
        $(this).find(".title").append(sortBtn);

        var sortSelect = createSortSelect(selectName);

        $(sortSelect).change(function(){
           var columnStr = $(this).attr("name");
           var columnName = columnStr.substr(0,columnStr.length-4)+"Class";
           var changeTarget = $(this).find("option:selected").val();
            if(changeTarget!==undefined && changeTarget!=="--"){
               if(changeTarget==="increase"){
                  showIncrease(columnName);
               }else if(changeTarget==="decrease"){
                  showDecrease(columnName);
               }
            }
        });

        var sortDiv = $("<div></div>").addClass("sortDivClass");
        $(sortDiv).append(sortSelect);
        $(this).append(sortDiv);


    });

}

function showIncrease(columnName){
    var columns = $("." + columnName);
    var tbody = $(columns).parent().empty();

}

function showDecrease(columnName){
    var columns = $("." + columnName);
    var tbody = $(columns).parent().empty();
}

function showFilterSelect(){
    var select = $(this).parent().parent().find("select[name$='Filter']");
    if($(select).hasClass("hideSelect")){
        $(select).removeClass("hideSelect");
    }else{
        $(select).addClass("hideSelect");
    }
}
function createSortSelect(selectName){
    var nonSelect = $("<option></option>").attr("value","none").text("--");
    var increase = $("<option></option>").attr("value","increase").text("up");
    var decrease = $("<option></option>").attr("value","decrease").text("down");
    var sortSelect=$("<select></select>").attr("name",selectName+"Sort");
    $(sortSelect).append(nonSelect);
    $(sortSelect).append(increase);
    $(sortSelect).append(decrease);
    $(sortSelect).addClass("hideSelect");
    return sortSelect;
}
function showSortSelect(){
        var tempSort = $(this).parent().parent().find("select[name$='Sort']");
        if($(tempSort).hasClass("hideSelect")){
            $(tempSort).removeClass("hideSelect");
        }else{
            $(tempSort).addClass("hideSelect");
        }
}

function filter(){
   var filters = $("button[id$='Filter']");

    if(filters.hasClass("hideFilter")){
        filters.removeClass("hideFilter");
    }else{
        filters.addClass("hideFilter");
    }

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
        var date = new Date(parseInt(employee.timeToJoin));
        var timeToJoin = parseSpecificDate(date);
        var trk = $("<tr>" + "<td>" + employee.id + "</td>" + "<td>" + employee.name + "</td>" + "<td>" + employee.account + "</td>" + "<td>" + employee.timeOnThisAccount + "</td>" + "<td>" + employee.rate + "</td>" +
            "<td>" + timeToJoin + "</td>" + "<td>" + employee.totalWorkYear + "</td>" + "<td>" + employee.timeInTW + "</td>" + "<td>" + employee.graduate + "</td>" + "<td>" + employee.onceOut + "</td>" + "</tr>");
        $(trk).addClass("addedResult");
        $("#searchResult").append(trk);
    }
    $("#searchDiv").show();


}
function insert() {
    var forms = $(".forms");
    if($(forms).is(":visible")){
        forms.hide();
    }else{
        clearForm();
        forms.show();
    }
}
function clearForm(){
   $("#insertForm")[0].reset();
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
