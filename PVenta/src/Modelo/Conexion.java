package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
awardspace 	rldlandry55@gmail.com	-	ProyectosLP1
	phpmyadmin	2761856_elpiel	-	Proyecto1elpiel
 */
public class Conexion {

    Connection connection = null;

    private void connect() {
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

    private void closed() {
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }

    public ResultSet getConsulta(String tabla, String campos, String condicion) {
        Statement s;
        ResultSet r = null;
        try {
            this.connect();
            s = connection.createStatement();
            String query2 = "SELECT " + campos + " FROM `" + tabla + "`" + condicion;
            r = s.executeQuery(query2);
           
            return r;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        
        
    }

    public void Alta(String tabla, String campos, String valores) {

        try {
            this.connect();
            String agregado = "INSERT INTO " + tabla + "(" + campos + ") values (" + valores + ")";
            Statement comando = connection.createStatement();
            comando.executeUpdate(agregado);
            this.closed();

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
    }
}
