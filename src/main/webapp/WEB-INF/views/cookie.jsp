<%@ page import="org.example.state.util.CookieUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키</title>
</head>
<body>
<%
    //        String counter = "1";
    int counter = 1;
    String visited = "";
    Cookie visitedCookie = CookieUtil.findCookie(request.getCookies(), "visited");
    if (visitedCookie != null) {
        visited = visitedCookie.getValue();
    }
    Cookie counterCookie = CookieUtil.findCookie(request.getCookies(), "counter");
    if (counterCookie != null) {
        counter = Integer.parseInt(counterCookie.getValue());
    }
%>
<p>
    <%= counter %>번째 방문
</p>
<p>
    <%= visited %>
</p>
</body>
</html>