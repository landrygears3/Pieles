package Controlador.Empleado;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author win 10
 */
public class AgregaEmpleado {

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

    public void agrega(Object datos[]) {
        con.Alta("empleados", "Nombre,Telefono,"
                + "Usuario,Contrasena,TipoU,Sucursal,Contratacion,Estado",
                "'" + datos[0].toString() + "','" + datos[1].toString() + "','"
                + datos[2].toString() + "','" + datos[3].toString() + "','"
                + datos[4].toString() + "','" + datos[5].toString() + "','"
                + datos[6].toString() + "',true");
    }

    public String emID(String Nom) {
        con4("ID_empleado", Nom);
        String P = pass;
        return P;
    }

    public void agNota(String Nota, String ID) {
        con.Alta("notase", "ID_Empleado,Nota",
                "'" + ID + "','" + Nota + "'");
    }

    public void mod(Object campo[], Object valor[], String usuario) {
        for (int i = 0; i < valor.length; i++) {

            con.Modifica("empleados", campo[i].toString(), valor[i].toString(), usuario);

        }

    }

    public void carga(Object datos[], String User) {
        con.getConsulta("empleados", "Telefono, Usuario,"
                + " Sucursal, Contratacion", "where Nombre = '" + User + "'");
    }

    public Object[] getName() {
        consulta("");
        Object name[] = new Object[datos.size()];
        for (int i = 0; i < name.length; i++) {
            name[i] = datos.get(i).get(1);
        }
        return name;
    }

    public String getTel(String Nom) {
        con4("Telefono", Nom);
        String P = pass;
        return P;
    }

    public String getPass(String Nom) {
        con4("Contrasena", Nom);
        String P = pass;
        return P;
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

    public String selSuc(String Nom) {
        con4("Sucursal", Nom);
        String P = pass;
        return P;
    }

    public String selUs(String Nom) {
        con4("TipoU", Nom);
        String P = pass;
        return P;
    }

    public String selNota(String Nom) {
        con5("Nota", Nom);
        String P = pass;
        return P;
    }

    public String getUsuario(String Nom) {
        con4("Usuario", Nom);
        String P = pass;
        return P;
    }

    public String getNota(String Nom) {
        Nom = emID(Nom);
        con5("Nota", Nom);
        String P = pass;
        return P;
    }

    public int vacio(String tabla) {
        int data = 0;
        try {
            ResultSet R = con.VerificaVacio(tabla);
            data = R.getInt(1);
            System.out.println(data);
        } catch (Exception e) {
        }
        return data;
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

    private String con4(String campo, String Nom) {

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

    private String con5(String campo, String Nom) {

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
