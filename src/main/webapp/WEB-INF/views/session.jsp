<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>세션</title>
</head>
<body>
<%-- 서버가 종료되면 삭제됨 (메모리에 존재하는 객체), 불러들이는 속도, 관리방법... 서버 부담 --%>
<p><%= session.getAttribute("counter") %></p>
<p><%= session.getAttribute("visited") %></p>
<form method="post">
    <button>세션 삭제</button>
</form>
</body>
</html>