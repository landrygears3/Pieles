package Controlador.General;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author win 10
 */
public class General {
    
    
    Conexion con = new Conexion();
    ArrayList<ArrayList> datos;
    String pass;

    
    public boolean valida(Object datos[]) {
        boolean b = false;
        for (int i = 0; i < datos.length; i++) {
            if (!datos[i].toString().trim().equals("")) {

                b = true;
                System.out.println("Válido");
            } else {

                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                break;
            }

        }

        if (b) {
            if (JOptionPane.showConfirmDialog(null, "Esta a punto de crear un nuevo usuario.\t\n¿Desea continuar?") == 1) {
                b = false;
            }
        }
        return b;
    }
    
    
    public Object[] getName() {
        consulta("");
        Object name[] = new Object[datos.size()];
        for (int i = 0; i < name.length; i++) {
            name[i] = datos.get(i).get(1);
        }
        return name;
    }
    
    public Object[] getProv() {
        conpv("");
        Object name[] = new Object[datos.size()];
        for (int i = 0; i < name.length; i++) {
            name[i] = datos.get(i).get(1);
        }
        return name;
    }
    
    public Object[] getProd() {
        conpd("");
        Object name[] = new Object[datos.size()];
        for (int i = 0; i < name.length; i++) {
            name[i] = datos.get(i).get(5);
        }
        return name;
    }
    
    public String getUsuario(String Nom) {
        con4("Usuario", Nom);
        String P = pass;
        return P;
    }
    
    
    public String emID(String Nom){
        con4("ID_empleado", Nom);
        String P = pass;
        return P;
    }
    
    
    public String getEstado(String Nom) {
        con4("Estado", Nom);
        String P = pass;
        return P;
    }
    
    public String getPass(String Nom) {
        con4("Contrasena", Nom);
        String P = pass;
        return P;
    }
    
    
    public String getTel(String Nom) {
        con4("Telefono", Nom);
        String P = pass;
        return P;
    }
    
    
    public String selSuc(String Nom){
        con4("Sucursal", Nom);
        String P = pass;
        return P;
    }
    
    public String selNota(String Nom){
        con5("Nota", Nom);
        String P = pass;
        return P;
    }
    
    public String getNota(String Nom) {
        Nom = emID(Nom);
        con5("Nota", Nom);
        String P = pass;
        return P;
    }
    
    public String selUs(String Nom){
        con4("TipoU", Nom);
        String P = pass;
        return P;
    }

    public int vacio(String tabla){
        int data = 0;
        try {
            ResultSet R = con.VerificaVacio(tabla);
            data = R.getInt(1);
            return data;
        } catch (Exception e) {
            return 0;
        }
    }
    
    
    private void consulta(String cons) {
        datos = new ArrayList<ArrayList>();
        try {
            ResultSet R = con.getConsulta("empleados", "*", cons);
            while (R.next()) {

                datos.add(new ArrayList());
                datos.get(datos.size() - 1).add(R.getString(1));
                datos.get(datos.size() - 1).add(R.getString(2));
                datos.get(datos.size() - 1).add(R.getString(3));
                datos.get(datos.size() - 1).add(R.getString(4));
                datos.get(datos.size() - 1).add(R.getString(5));
                datos.get(datos.size() - 1).add(R.getString(6));
                datos.get(datos.size() - 1).add(R.getString(7));
            }
        } catch (Exception e) {
        }
    }
    
    private void conpv(String cons) {
        datos = new ArrayList<ArrayList>();
        try {
            ResultSet R = con.getConsulta("proveedores", "*", cons);
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
    
    private void conpd(String cons) {
        datos = new ArrayList<ArrayList>();
        try {
            ResultSet R = con.getConsulta("productos", "*", cons);
            while (R.next()) {

                datos.add(new ArrayList());
                datos.get(datos.size() - 1).add(R.getString(1));
                datos.get(datos.size() - 1).add(R.getString(2));
                datos.get(datos.size() - 1).add(R.getString(3));
                datos.get(datos.size() - 1).add(R.getString(4));
                datos.get(datos.size() - 1).add(R.getString(5));
                datos.get(datos.size() - 1).add(R.getString(6));
                datos.get(datos.size() - 1).add(R.getString(7));
            }
        } catch (Exception e) {
        }
    }
    
    public String con4(String campo, String Nom){
        
        try {

            ResultSet R = con.getConsulta("empleados", campo, "where Nombre = '" + Nom + "'");
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
    
    private String con5(String campo, String Nom){
        
        try {

            ResultSet R = con.getConsulta("notase", campo, " where ID_Empleado = '" + Nom + "'");
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
