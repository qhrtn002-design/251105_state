<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<form method="post">
    <input type="text" name="userId"><br>
    <input type="password" name="password"><br>
    <button>가입</button>
</form>
<p>
    <%--        <%= request.getAttribute("msg") %>--%>
    <%= session.getAttribute("msg") %>
</p>
</body>
</html>