<html>
<head>
    <title>HTML Editor - Full Version</title>
</head>
<body>
<h1>Workers</h1>
<p><a title="Add new" href="localhost/addNew">add new </a></p>
<table border="1">
    <tbody>

    <%
        String tableContent = (String)request.getAttribute("tableContent");
        System.out.println(tableContent);
    %>
    </tbody>
</table>
<h1>&nbsp;</h1>
</body>
</html>