
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>lslsl</title>
    <link type="text/css" rel="stylesheet" media="screen,projection"
          href="<%= request.getContextPath()%>/resources/css/table.css"/>



</head>
<body>
<img src ="<%= request.getContextPath()%>/resources/image/headMap.png">
<table summary ="This is the information about a company and it involves name, project <br> and the rate of somebody and their working years">
    <caption>Company Information</caption>
    <tr>
        <th>Name</th>
        <th>Account</th>
        <th>Rate</th>
        <th>Experience</th>
        <th>Working Year</th>
    </tr>
    <tr>
        <td>AlmaZhou</td>
        <td>MVC</td>
        <td>5</td>
        <td>5</td>
        <td>7</td>
    </tr>
</table>
</body>
</html>