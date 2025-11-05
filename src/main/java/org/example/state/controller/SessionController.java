package org.example.state.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.getSession(true)
        HttpSession session = req.getSession(); // 있으면 가져오고 없으면 생성...
        // req.getSession(false)
        // HttpSession session = req.getSession(false); // 없으면 생성하지 않는다
        int counter = 0;
        // request attribute과 유사
        if (session.getAttribute("counter") != null) {
            counter = (Integer) session.getAttribute("counter"); // Object <- 모든 객체가 상속받은 Object
            // -> 해당 타입으로 변환.
            // cookie -> text(string) -> 변환해주기 위한 작업...
            // session -> 우리가 넣은 데이터 방식만 알고 있다면 바로 casting.
        }
        int visited = 0;
        if (session.getAttribute("visited") != null) {
            visited = (Integer) session.getAttribute("visited");
        }
        counter++;
        visited++;
        session.setAttribute("counter", counter);
        session.setAttribute("visited", visited);
        // session <- req를 통해 조회가 가능하다 (session 자체는 서버에 있는 개념)
        req.getRequestDispatcher("/WEB-INF/views/session.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 단순히 특정 attribute를 삭제
        HttpSession session = req.getSession();
//        session.removeAttribute("counter");
        session.invalidate(); // session 자체를 없게 만드는 것.
        resp.sendRedirect(req.getContextPath() + "/session");
    }
}