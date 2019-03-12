package utils;

import java.io.PrintWriter;
import java.sql.*;

public class User {
    private String username;
    private String password;
    private String pApellido;
    private String sApellido;
    private String nombre;
    private String role;
    private String select_dataStmnt = "select p.tx_last_name_a, p.tx_last_name_b, p.tx_first_name, r.nb_role from person\n" +
            "as p inner join users as u on u.id_user = p.id_person inner join account as a on a.id_user = u.id_user inner join role as r on r.id_role = a.id_role\n" +
            "where u.tx_login = ? and u.tx_password = ?;";
    public User(String usr, String pwd) {
        this.setUsername(usr);
        this.setPassword(pwd);
        this.role = "N/A";
    }
    public boolean login() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/homework-6",
                            "postgres", "postgres");
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement(select_dataStmnt);
            ps.setString(1, this.username);
            ps.setString(2, this.password);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                this.pApellido = rs.getString(1);
                this.sApellido = rs.getString(2);
                this.nombre = rs.getString(3);
                this.role = rs.getString(4);
            }
            rs.close();
            ps.close();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        if(this.role.equals("N/A")) {
            return false;
        } else {
            return true;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
