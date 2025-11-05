package org.example.state.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 서블릿을 통해서 현재 GET 요청 처리
        System.out.println(req.getMethod()); // 어떠한 HTTP 메서드(verb, 동사)로 입력했는지
        // req(request) <- 요청 객체
        // Spring MVC <- 요청 객체 중 원하는 부분만 따로 떼서 받게 됨
        System.out.println(req.getParameter("msg")); // key(msg) -> input. // !
        // form vs RESTful로 받느냐...
        // HTTP 요청 -> header(meta 데이터)
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }
        // !
        req.setAttribute("key", "value"); // servlet/jsp에서 이후에 전달하기 원하는 데이터 (<- model 쪽에서 뽑아오는 데이터나 중간 메시지...)
        req.setAttribute("msg", req.getParameter("msg") + "라고 입력하셨습니다");
        // main -> java, webapp, resources -> 최상단으로 각각 인식됨
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp); // !
        // 외부의 URL은 그대로인 상태에서 뒤에 리소스만 연결 (servlet, jsp)

        // 주소창에서는 변하는 게 X, request를 계속 사용할 수 있음
        // request 객체를 여전히 가지고 있다 -> 새로고침 재시도 -> 2번 이상 중복된 요청.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 서블릿을 통해서 현재 POST 요청 처리
        System.out.println(req.getMethod()); // 어떠한 HTTP 메서드(verb, 동사)로 입력했는지
        System.out.println(req.getParameter("msg"));
        req.setAttribute("key", "value");
        req.setAttribute("msg", req.getParameter("msg") + "라고 입력하셨습니다");

        // 로그인
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        if (userId.equals("myid") && password.equals("mypass")) {
            req.setAttribute("loginMessage", "로그인 성공");
        } else {
            req.setAttribute("loginMessage", "로그인 실패");
        }
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp); // !
    }
}