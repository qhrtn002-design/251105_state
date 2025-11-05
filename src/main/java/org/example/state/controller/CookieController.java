package org.example.state.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.state.util.CookieUtil;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[Cookie]");
        System.out.println(req.getHeader("cookie"));
        Cookie[] cookies = req.getCookies(); // ";" -> 나눠준다음에 '=' Key, Value
        int counterValue = 1;
        Cookie counterCookie = CookieUtil.findCookie(cookies, "counter");
        if (counterCookie != null) {
            counterValue = Integer.parseInt(counterCookie.getValue());
        }
        Cookie newCounterCookie = CookieUtil.createCookie("counter", Integer.toString(counterValue + 1), 86400);
        // 쿠키를 추가한다
        Cookie visitedCookie = CookieUtil.createCookie("visited", "최근방문함", 60 * 60 * 24);
        resp.addCookie(visitedCookie);
//        resp.addCookie(newCounterCookie);
        // 쿠키 삭제를 원할 경우 삭제용 쿠키를 덮어씌움
        resp.addCookie(CookieUtil.deleteCookie("counter"));
        req.getRequestDispatcher("/WEB-INF/views/cookie.jsp").forward(req, resp);
    }
}