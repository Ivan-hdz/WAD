package utils;

import java.io.PrintWriter;
import java.sql.*;


public class PostgresSQL {
    public static void printSelectStatement(PrintWriter out) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/homework-6",
                            "postgres", "postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select p.tx_first_name, p.tx_last_name_a, p.tx_last_name_b, p.tx_curp, p.fh_birth, u.tx_login from person as p inner join users as u on u.id_user = p.id_person;" );
            while ( rs.next() ) {
                out.println("<tr>");
                out.println("<td>"+rs.getString(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("<td>"+rs.getString(4)+"</td>");
                out.println("<td>"+rs.getDate(5).toString()+"</td>");
                out.println("<td>"+rs.getString(6)+"</td>");
                out.println("</tr>");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}