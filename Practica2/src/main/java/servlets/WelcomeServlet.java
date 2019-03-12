package servlets;



import utils.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setHeader("Content-Type", "text/html; charset=UTF-8");
        User u = new User(req.getParameter("username"),req.getParameter("password"));
        boolean isValid = u.login();
        if(isValid) {
            HttpSession s = req.getSession();
            s.setAttribute("isLogged", true);
            res.sendRedirect("TableServlet");
        } else {
            res.sendError(500);
        }
    }
    private void sendMsgToLoginForm(String msg, HttpServletResponse res) throws IOException {
        res.sendRedirect("index.jsp?txt_alert=" + msg);
    }
}
