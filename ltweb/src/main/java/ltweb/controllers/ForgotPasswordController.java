package ltweb.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ltweb.services.impl.UserService;
import ltweb.models.UserModel;

@WebServlet(urlPatterns = {"/forgot-password"})
public class ForgotPasswordController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Hiển thị form quên mật khẩu
        req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String newPassword = req.getParameter("newPassword");

        UserService service = new UserService();
        String alertMsg;

        // Kiểm tra xem người dùng có tồn tại không
        UserModel user = service.FindByUserName(username);
        if (user == null) {
            alertMsg = "Tên đăng nhập không tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
            return;
        }

        // Cập nhật mật khẩu mới
        user.setPassWord(newPassword);
        service.updatePassword(user);

        alertMsg = "Mật khẩu đã được cập nhật thành công!";
        req.setAttribute("alert", alertMsg);
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }
}
