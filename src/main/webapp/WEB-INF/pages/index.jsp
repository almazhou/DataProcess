 <%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>                                                      √
<head>
    <title>Company Staff Information</title>
    <link type="text/css" rel="stylesheet" media="screen,projection"
          href="<%= request.getContextPath()%>/resources/css/table.css"/>
</head>
<body>
<h1>Company Staff Information</h1>
<table summary ="This is the information about a company and it involves name, project <br> and the rate of somebody and their working years">
    <tr>
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
    </tr>
    <c:forEach items='${employeeList}' var='employee'>
    <tr>
        <td>${employee.id}</td>
        <td>${employee.name}</td>
        <td>${employee.account}</td>
        <td>${employee.timeOnThisAccount}</td>
        <td>${employee.rate}</td>
        <td>${employee.timeToJoin}</td>
        <td>${employee.totalWorkYear}</td>
        <td>${employee.timeInTW}</td>
        <td>${employee.graduate}</td>
        <td>${employee.onceOut}</td>
    </tr>
    </c:forEach>

</table>
</body>
</html>