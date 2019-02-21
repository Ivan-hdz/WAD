package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CounterOnGet extends HttpServlet {
    private int counter = 0;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        int servletProp = 0;
        out.println("<h1>");
        out.println("Service Method");
        out.println(counter++);
        out.println("</h1>");
        out.println("<h1>");
        out.println("Servlet Property");
        out.println(servletProp);
        out.println("</h1>");
    }
}
