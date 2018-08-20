package Controlador.Empleado;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author win 10
 */
public class AgregaEmpleado {

    Conexion con = new Conexion();
    ArrayList<ArrayList> datos;
    String pass;
    
    
    public void agrega(Object datos[]) {
        con.Alta("empleados", "Nombre,Telefono,"
                + "Usuario,Contrasena,TipoU,Sucursal,Contratacion,Estado",
                "'" + datos[0].toString() + "','" + datos[1].toString() + "','"
                + datos[2].toString() + "','" + datos[3].toString() + "','"
                + datos[4].toString() + "','" + datos[5].toString() + "','"
                + datos[6].toString() + "',true");
    }
    
    
    public void agNota(String Nota, String ID) {
        con.Alta("notase", "ID_Empleado,Nota",
                "'" + ID + "','" + Nota + "'");
    }
    
    public Object[] getTipo() {
        con3("");
        Object name[] = new Object[datos.size()];
        for (int i = 0; i < name.length; i++) {
            name[i] = datos.get(i).get(1);
        }
        return name;
    }

    public Object[] getSuc() {
        con2("");
        Object name[] = new Object[datos.size()];
        for (int i = 0; i < name.length; i++) {
            name[i] = datos.get(i).get(1);
        }
        return name;
        
    }

    private void con2(String cons) {
        datos = new ArrayList<ArrayList>();
        try {
            ResultSet R = con.getConsulta("sucursal", "*", cons);
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

    private void con3(String cons) {
        datos = new ArrayList<ArrayList>();
        try {
            ResultSet R = con.getConsulta("usuarios", "*", cons);
            while (R.next()) {

                datos.add(new ArrayList());
                datos.get(datos.size() - 1).add(R.getString(1));
                datos.get(datos.size() - 1).add(R.getString(2));
            }
        } catch (Exception e) {
        }
    }
    
    

    
    
    public void mod(Object campo[], Object valor[], String usuario) {
        for (int i = 0; i < valor.length; i++) {
            
            con.Modifica2("empleados", campo[i].toString(), valor[i].toString(), usuario, "");

        }

    }

    public void carga(Object datos[], String User) {
        con.getConsulta("empleados", "Telefono, Usuario,"
                + " Sucursal, Contratacion", "where Nombre = '" + User + "'");
    }
    
    public void elimina(String campo, String valor, String usuario, String nom) {
            
            con.Modifica2("empleados", campo, valor, usuario, "and Usuario = '" + nom + "'");


    }
   
}
