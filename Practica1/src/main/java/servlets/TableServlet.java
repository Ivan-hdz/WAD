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
        String fName, lNameA, lNameB, curp, birthday, email, pwd, cPwd;
        fName = req.getParameter("firstName");
        lNameA = req.getParameter("lastName");
        lNameB = req.getParameter("secondLastName");
        curp = req.getParameter("curp");
        birthday = req.getParameter("birthday");
        email = req.getParameter("login");
        pwd = req.getParameter("password");
        cPwd = req.getParameter("confPassword");
        if(pwd.equals(cPwd)) {
            int id_user = PostgresSQL.insertPerson(fName, lNameA, lNameB, curp, birthday);
            if(id_user != -1) {
                int succ = PostgresSQL.insertUsuario(id_user, email, pwd);
                if(succ != -1) {
                    int succ2 = PostgresSQL.insertCuenta(PostgresSQL.ADMINISTRADOR, id_user);
                    if(succ2 != -1)
                        doGet(req, res);
                } else {
                    out.println("<h1>Algo ha salido mal en insertar usuario</h1>");
                }
            } else {
                out.println("<h1>Algo ha salido mal en insertar persona</h1>");
            }
        } else {
            out.println("<h1>Las contraseñas no coinciden </h1>");
        }
    }
}
