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

    public Connection connection = null;

    public void connect() {
        String url = "jdbc:mysql://localhost:3306/elpiel";
        String user = "root";
        String pass = "";
        try {
            connection = DriverManager.getConnection(url, user, pass);

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

    /*
    getConsultas regresa una variable tipo resulset como parametrso
    de entrada nececita la tabla a la que será consultado, los campos que se
    deben consultar (en caso de ser todos el parametro de campos es "*"
    la condición s emanda "" vacia si no hay. Si hay se pone el where o la condición ocupada
    
    para manejar el metodo se manda a llmanar de la siguente manera
    
    Lista de listas
    ArrayList<ArrayList> array=new ArrayList<ArrayList>();
    
    try{
    ResultSet variable= Conexion.getConsulta("tabla","*",""); 
    while(variable.next()){
    array.add(new ArrayList());
    
    los numeros que van en el add depende de la cantidad de columnas que se pidieron
    array.get(array.size()-1).add(variable.getString(1));
    array.get(array.size()-1).add(variable.getString(2));
    
    }
    }catch(Exception e){
    
    }
    
     */
    public ResultSet getConsulta(String tabla, String campos, String condicion) {
        Statement s;
        ResultSet r = null;
        try {
            this.connect();
            s = connection.createStatement();
            String query2 = "SELECT " + campos + " FROM `" + tabla + "` " + condicion;
            r = s.executeQuery(query2);
            return r;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    /*
    Alta se manda a llamar con el mismo objeto de conexion recibe de parametros la tabla 
    igual que getConsulta. los campos se mandan separados por comas "campo1, campo2, campo3"
    los valores igual "valor1, valor2, valor3"
    
    Conexion.Alta("tabla","campo1, campo2, campo3","valor1, valor2, valor3"); 
    
     */
    public void Alta(String tabla, String campos, String valores) {

        try {
            this.connect();
            String agregado = "INSERT INTO " + tabla + " (" + campos + ") values (" + valores + ")";
            Statement comando = connection.createStatement();
            comando.executeUpdate(agregado);
            this.closed();

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }

    public void Modifica(String tabla, String datos, String condicional) {

        try {
            this.connect();
            String agregado = "update " + tabla + " set " + datos + condicional;
            Statement comando = connection.createStatement();
            comando.executeUpdate(agregado);
            this.closed();

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

    }
	
	public void Modifica2(String tabla, String campo, String valor, String usuario, String cond2) {

        try {
            this.connect();
            String agregado = "update " + tabla + " set " + campo + " = '"
                    + valor + "' where Nombre = '" + usuario +"'" + cond2;
            Statement comando = connection.createStatement();
            comando.executeUpdate(agregado);
            this.closed();

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        
        
    }

    public ResultSet VerificaVacio(String tabla) {
        Statement s;
        ResultSet r = null;
        try {
            this.connect();
            s = connection.createStatement();
            String query2 = "SELECT COUNT(*) FROM " + tabla + " ";
            r = s.executeQuery(query2);
            r.beforeFirst();
            r.next();

        } catch (SQLException ex) {

        }
        return r;
    }
    
    public void Elimina(String tabla, String campo, String usuario) {

        try {
            this.connect();
            String agregado = "delete from " + tabla + " where "+campo + " = '" + usuario +"'";
            Statement comando = connection.createStatement();
            comando.executeUpdate(agregado);
            this.closed();

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        
        
    }

}
