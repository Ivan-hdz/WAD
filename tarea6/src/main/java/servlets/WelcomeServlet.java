package servlets;

import utils.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setHeader("Content-Type", "text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        User u = new User(req.getParameter("username"),req.getParameter("password"));
        boolean isValid = u.login();
        if(isValid) {
            out.println("<h1>Welcome</h1>");
            out.println("<h3>");
            out.println(u.getpApellido());
            out.println(u.getsApellido());
            out.println(u.getNombre());
            out.println("</h3>");
            out.println("<h3>");
            out.println(u.getRole());
            out.println("</h3>");
        } else {
            sendMsgToLoginForm("Username and / or password are incorrect", res);
        }
    }
    private void sendMsgToLoginForm(String msg, HttpServletResponse res) throws IOException {
        res.sendRedirect("index.jsp?txt_alert=" + msg);
    }
}
