package org.example.state.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.state.model.entity.Account;
import org.example.state.model.repository.AccountRepository;

import java.io.IOException;

@WebServlet("/join")
public class JoinController extends HttpServlet {
    private final AccountRepository accountRepository = AccountRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(req, resp);
    }

    // POST
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        if (accountRepository.findById(userId) != null) {
            // 이미 가입한 ID라는 이야기
            // redirect를 쓰면 'req' X
//            req.setAttribute("msg", "이미 존재하는 ID입니다");
            session.setAttribute("msg", "이미 존재하는 ID입니다");
        } else {
            // redirect를 쓰면 'req' X
            accountRepository.save(new Account(userId, password));
//            req.setAttribute("msg", "%s가 정상 저장 되었습니다".formatted(userId));
            session.setAttribute("msg", "%s가 정상 저장 되었습니다".formatted(userId));
            System.out.println(accountRepository.findById(userId));
        }
//        req.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/join");
    }
}