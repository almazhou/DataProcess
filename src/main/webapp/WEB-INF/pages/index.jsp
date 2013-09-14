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
<table summary ="This is the information about a company and it involves name, project <br> and the rate of somebody and their working years">
    <tr id ="tableHead">
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
</table>
</body>
</html>