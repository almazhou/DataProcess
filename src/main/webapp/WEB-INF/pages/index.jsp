<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Company Staff Information</title>
    <script>contextPath = "<%=request.getContextPath()%>"</script>
    <link type="text/css" rel="stylesheet" media="screen,projection"
          href="<%= request.getContextPath()%>/resources/css/table.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/bootstrap/css/bootstrap-responsive.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/bootstrap/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <script src="<%=request.getContextPath()%>/resources/script/index.js"></script>
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.js"></script>
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body onload="initialise()">
<h1>Company Staff Information</h1>

<div>
</div>
<div class="btn-group nav navs">
    <button type="button" id="insert" class="btn btn-info" onclick="insert()">Insert</button>
    <button id = "searchBtn" class="btn btn-info">Search</button>
</div>
<span>
    <input type="text" name="search" class="input-medium search-query">
</span>
<table id = "allList" class="table .table-striped" summary="This is the information about a company and it involves name, project <br> and the rate of somebody and their working years">
    <tr id="tableHead">
        <th>id</th>
        <th>name</th>
        <th>Account</th>
        <th>Time on this account</th>
        <th>Rate</th>
        <th>Time to Join</th>
        <th>Total work year</th>
        <th>Time in TW</th>
        <th>Graduate</th>
        <th>Once Went Abroad</th>
        <th>edit</th>
    </tr>

    <tr id="insertForms" class="forms" style="display: none">
        <form action="<%=request.getContextPath()%>/saveForm" method="POST">
            <td>
                <input type="text" name="id" placeholder="0">
            </td>
            <td><input type="text" name="name" placeholder="name"></td>
            <td><input type="text" name="account" placeholder="account"></td>
            <td><input type="text" name="timeOnThisAccount" placeholder="0"></td>
            <td><input type="text" name="rate" placeholder="0"></td>
            <td><input type="text" name="timeToJoin" id="calDate" placeholder="2011/09/03"></td>
            <td><input type="text" name="totalWorkYear" placeholder="0"></td>
            <td><input type="text" name="timeInTW" placeholder="0"></td>
            <td><input type="text" name="graduate" placeholder="no"></td>
            <td><input type="text" name="onceOut"placeholder="no"></td>
            <td>
            <button id = "submitBtn" class="forms" style="display: none" onclick="return submitForm()"/>Save </button>
            </td>
        </form>
    </tr>

</table>
<div id = "searchResultDiv">
    <jsp:include page="search.jsp"></jsp:include>
</div>
</body>
</html>