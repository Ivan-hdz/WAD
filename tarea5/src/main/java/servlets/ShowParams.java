package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ShowParams extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setHeader("Content-Type", "text/html; charset=UTF-8");
        doPost(req, res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setHeader("Content-Type", "text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        String paramName;
        Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()) {
            paramName = params.nextElement();
            out.println("<h3>");
            out.println(paramName + " = " + req.getParameter(paramName));
            out.println("</h3>");
            String[] valuesIfArray = req.getParameterValues(paramName);
            for(int i = 1; i<valuesIfArray.length; i++) {
                out.println("<h3>");
                out.println("* = " + valuesIfArray[i]);
                out.println("</h3>");
            }
            out.println("<hr>");
        }
    }

}
