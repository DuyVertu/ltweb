package ltweb.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    if (session == null || session.getAttribute("currentUser") == null) {
        // Chuyển hướng về trang đăng nhập nếu người dùng chưa đăng nhập
        resp.sendRedirect(req.getContextPath() + "/login");
        return;
    }

        if (session != null) {
            session.invalidate(); // Hủy session
        }
        
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
