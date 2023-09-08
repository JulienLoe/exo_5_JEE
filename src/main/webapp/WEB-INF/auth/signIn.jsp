<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file ="../bootStrapImport.html"%>
    <title>Title</title>
</head>
<body>
    <main class="container">
        <div class="my-3 row">
            <div class="col-8 offset-2 p-3 rounded text-bg-dark">
        <h1 class="fw-light">-<%= mode.substring(0, 1).toUpperCase() + mode.substring(1).toLowerCase() %></h1>
        <form action="<%= mode.equals("registration") ? "registration" : "" %>" method="post">
            <div>
                <label for="username" class="form-label">Username:</label>
                <input class="form-control" type="text" name="username" id="username" required>
                <label class="form-label" for="password">Password:</label>
                <input class="form-control" type="password" name="password" id="password" required>
            </div>
            <hr>
            <button>Submit</button>

        </form>
            <% if (mode.equals("Login")) { %>
        <button><a href="registration">Registration</a></button>
<% }%>;

            </div>
            </div>
    </main>
</body>
</html>
