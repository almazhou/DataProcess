<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Company Staff Information</title>
    <script>contextPath = "<%=request.getContextPath()%>"</script>
    <link type="text/css" rel="stylesheet" media="screen,projection"
          href="<%= request.getContextPath()%>/resources/css/table.css"/>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/script/index.js"></script>
</head>
<body onload="showTable()">
<h1>Company Staff Information</h1>

<div>
    <span class = "search"><button id = "searchBtn">Search</button> <input type="text" name="search"></span><button type="button" id="insert" onclick="insert()">Insert</button></span>
</div>
<table summary="This is the information about a company and it involves name, project <br> and the rate of somebody and their working years">
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
                <input type="text" name="id">
            </td>
            <td><input type="text" name="name"></td>
            <td><input type="text" name="account"></td>
            <td><input type="text" name="timeOnThisAccount"></td>
            <td><input type="text" name="rate"></td>
            <td><input type="text" name="timeToJoin"></td>
            <td><input type="text" name="totalWorkYear"></td>
            <td><input type="text" name="timeInTW"></td>
            <td><input type="text" name="graduate"></td>
            <td><input type="text" name="onceOut"></td>
            <td>
            <input type="submit" value="save" class="forms" style="display: none"/>
            </td>
        </form>
    </tr>

</table>

</body>
</html>