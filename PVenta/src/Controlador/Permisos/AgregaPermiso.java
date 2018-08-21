/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Permisos;
import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author win 10
 */
public class AgregaPermiso {
    
    Conexion con = new Conexion();
    ArrayList<ArrayList> datos;
    String pass;

    public String getMotivo(String Nom) {
        con2("motivo", Nom);
        String P = pass;
        return P;
    }
    
    
    public String PeID(String Nom){
        con3("ID_TipoPermiso", Nom);
        String P = pass;
        return P;
    }
    
    public Object[] getCode() {
        consulta1("");
        Object name[] = new Object[datos.size()];
        for (int i = 0; i < name.length; i++) {
            name[i] = datos.get(i).get(0);
        }
        return name;
    }
    
    public void agrega(Object datos[]) {
        con.Alta("permisos", "ID_Empleado,ID_TipoPermiso,"
                + "Fecha,Motivo",
                "'" + datos[0].toString() + "','" + datos[1].toString() + "','"
                + datos[2].toString() + "','" + datos[3].toString() + "'");
    }
    
    public void mod(Object campo[], Object valor[], String usuario) {
        for (int i = 0; i < valor.length; i++) {
            
            con.Modifica2("permisos", campo[i].toString(), valor[i].toString(), usuario, "");

        }

    }
    
    public void elimina(String usuario) {
            
            con.Elimina("permisos", "ID_Permiso",  usuario);

    }
    
    
    
    
    private void consulta1(String cons) {
        datos = new ArrayList<ArrayList>();
        try {
            ResultSet R = con.getConsulta("permisos", "*", cons);
            while (R.next()) {

                datos.add(new ArrayList());
                datos.get(datos.size() - 1).add(R.getString(1));
                datos.get(datos.size() - 1).add(R.getString(2));
                datos.get(datos.size() - 1).add(R.getString(3));
                datos.get(datos.size() - 1).add(R.getString(4));
            }
        } catch (Exception e) {
        }
    }
    
    
    
    private String con2(String campo, String Nom){
        
        try {

            ResultSet R = con.getConsulta("permisos", campo, "where ID_TipoPermiso = '" + Nom + "'");
            R.beforeFirst();
            R.next();
            if (!R.equals(null)) {
                pass = R.getString(1);
                return pass;
            } else {
                System.out.println("Nel");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    private String con3(String campo, String Nom){
        
        try {

            ResultSet R = con.getConsulta("tipo_permiso", campo, "where Permiso = '" + Nom + "'");
            R.beforeFirst();
            R.next();
            if (!R.equals(null)) {
                pass = R.getString(1);
                return pass;
            } else {
                System.out.println("Nel");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
