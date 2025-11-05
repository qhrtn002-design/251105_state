<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
<a href="/join">회원가입</a>
<h3>로그인</h3>
<%-- 보안처리가 필요하면 무조건 post --%>
<%-- http : post로 요청하는 것도 맘만 먹으면 네트워크 상에서 탈취 가능 <- 오래된 사이트들은 post를 발송할 때도 암호화를 함
    vs https : 인증서 형태로 암호화되기 때문에 보안적으로 신경쓴 형태 --%>
<%--    <form method="get">--%>
<form method="post">
    <input type="text" name="userId"><br>
    <%--        <input type="text" name="password"><br>--%>
    <input type="password" name="password"><br>
    <button>로그인</button>
</form>
<p>
    <%= request.getAttribute("loginMessage") %>
</p>
<hr>
<%--  구분선을 만드는 태그 hr (horizon)  --%>
<h3>Parameter</h3>
<p>
    <%= request.getParameter("msg") %>
</p>
<h3>Attribute</h3>
<p>
    <%= request.getAttribute("msg") %><br>
    <%= request.getAttribute("key") %>
</p>
<%-- GET --%>
<%-- 현재 링크에 GET 요청 --%>
<form action="" method="get">
    <input name="msg" placeholder="아무거나 입력해보세요">
    <button>제출</button>
</form>
<%-- POST --%>
<%-- 현재 링크에 POST 요청 --%>
<%-- 주소창에 데이터 속성들이 노출되지 X --%>
<%-- REST API POST (application/json) vs Form POST (application/x-www-form-urlencoded) --%>
<%-- json: json body를 가지면서 + searchParam (주소창 데이터를 가질 수 있음) --%>
<%-- form: parameter만 가질 수 있음 (url 노출 되느냐 vs body로 들어가느냐) --%>
<form action="" method="post">
    <input name="msg" placeholder="아무거나 입력해보세요">
    <button>제출</button>
</form>
</body>
</html>