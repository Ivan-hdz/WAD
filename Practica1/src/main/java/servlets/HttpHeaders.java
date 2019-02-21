package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class HttpHeaders extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String headerName;
        Enumeration<String> headersName = req.getHeaderNames();

        while (headersName.hasMoreElements()){
            headerName = headersName.nextElement();
            out.println("<h1>");
            out.println(headerName + " = " + req.getHeader(headerName));
            out.println("</h1>");
        }

    }
}
