<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="username" type="java.lang.String" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file ="./bootStrapImport.html"%>
    <title>Omar salut</title>
</head>
<body>
    <p><%=username%> mérite le salut éternel !</p>
</body>
</html>
