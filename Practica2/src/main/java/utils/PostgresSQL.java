package utils;

import java.io.PrintWriter;
import java.sql.*;


public class PostgresSQL {
    public static int TECNICO = 1;
    public static int JUGADOR = 2;
    public static int ADMINISTRADOR = 3;
    private static String dbUsr = "postgres";
    private static String dbPwd = "postgres";
    private static String dbName = "homework-6";
    public static int insertCuenta(int id_role, int  id_user) {
        Connection c = null;
        Statement stmt = null;
        int id = -1;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/" + dbName,
                            dbUsr, dbPwd);
            PreparedStatement ps = c.prepareStatement("insert into account(id_role, id_user, fh_begin, fh_end) values (?, ?, to_date('01/01/2018','dd/MM/yyyy'), to_date('31/12/2028','dd/MM/yyyy'));");
            ps.setInt(1, id_role);
            ps.setInt(2, id_user);
            id = ps.executeUpdate();
            ps.close();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return id;
    }
    public static int insertUsuario(int id_user, String email, String pwd) {
        Connection c = null;
        Statement stmt = null;
        int id = -1;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/" + dbName,
                            dbUsr, dbPwd);
            PreparedStatement ps = c.prepareStatement("insert into users(id_user, tx_login, tx_password) values (?, ?, ?);");
            ps.setInt(1, id_user);
            ps.setString(2, email);
            ps.setString(3, pwd);
            id = ps.executeUpdate();
            ps.close();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return id;
    }
    private static int getPersonId(String firstName, String lastNameA, String lastNameB, String curp) {
        Connection c = null;
        int id = -1;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/" + dbName,
                            dbUsr, dbPwd);

            PreparedStatement ps1 = c.prepareStatement("select id_person from person where tx_first_name = ? and tx_last_name_a = ? and tx_last_name_b = ? and tx_curp = ?");
            ps1.setString(1, firstName);
            ps1.setString(2, lastNameA);
            ps1.setString(3, lastNameB);
            ps1.setString(4, curp);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            ps1.close();
            c.close();
        }catch ( Exception e ) {
            e.printStackTrace();
            id = -1;
        }
        return id;
    }
    public static int insertPerson(String firstName, String lastNameA, String lastNameB, String curp, String fechaNacimiento) {
        Connection c = null;
        Statement stmt = null;
        int id = -1;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/" + dbName,
                            dbUsr, dbPwd);
            PreparedStatement ps = c.prepareStatement("insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) values (?, ?, ?, ?, to_date(? ,'yyyy-MM-dd'));");
            ps.setString(1, firstName);
            ps.setString(2, lastNameA);
            ps.setString(3, lastNameB);
            ps.setString(4, curp);
            ps.setString(5, fechaNacimiento);
            ps.executeUpdate();

           id = getPersonId(firstName, lastNameA, lastNameB, curp);

            ps.close();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
            id = -1;
        }
        return id;
    }
    public static void printSelectStatement(PrintWriter out) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/" + dbName,
                            dbUsr, dbPwd);
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