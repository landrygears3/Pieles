package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
awardspace 	rldlandry55@gmail.com	-	ProyectosLP1
	phpmyadmin	2761856_elpiel	-	Proyecto1elpiel
 */
public class Conexion {

    Connection connection = null;

    public void connect() {
        String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3245955";
        String user = "sql3245955";
        String pass = "V9h6CwafcC";
        System.out.println("Conectando...");
        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado!!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void closed() {
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }

    public ResultSet getConsulta(String tabla, String campos, String condicion) {
        Statement s;
        ResultSet r = null;
        try {

            s = connection.createStatement();
            String query2 = "SELECT " + campos + " FROM `" + tabla + "`" + condicion;
            r = s.executeQuery(query2);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

}
