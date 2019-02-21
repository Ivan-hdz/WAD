package servlets;

import utils.PostgresSQL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class TableServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setHeader("Content-Type", "text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<table>");
        out.println("<tr>");
        out.println("<td> <h2>First Name <br> (job title)</h2></td>");
        out.println("<td><h2>Last name</h2></td>");
        out.println("<td><h2>Second last name</h2></td>");
        out.println("<td><h2>CURP</h2></td>");
        out.println("<td><h2>Birth day</h2></td>");
        out.println("<td><h2>Nickname</h2></td>");
        out.println("</tr>");
        PostgresSQL.printSelectStatement(out);
        out.println("</table>");
        out.println("<br>");
        out.println("<button onclick=\"window.location.href=\'TableServlet/\'\">New</button>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setHeader("Content-Type", "text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        String paramName;
        Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()) {
            paramName = params.nextElement();
            out.println("<h1>");
            out.println(paramName + " = " + req.getParameter(paramName));
            out.println("</h1>");
        }
    }
}
