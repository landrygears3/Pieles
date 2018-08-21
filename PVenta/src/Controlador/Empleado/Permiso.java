package Controlador.Empleado;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Permiso {

    Conexion con = new Conexion();
    ArrayList<ArrayList> arr;
    public boolean b;

    public Object getID(int index) {
        return arr.get(index).get(0);
    }

    public Object getName(int index) {
        return arr.get(index).get(1);
    }

    public Object getName(String con) {
        Object dat = null;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).get(0).toString().equals(con)) {
                dat = arr.get(i).get(1);
            }

        }
        return dat;
    }

    public Object[] getPermiso() {
        arr = new ArrayList<ArrayList>();

        try {
            ResultSet aux = con.getConsulta("tipo_permiso", "*", "");
            while (aux.next()) {
                arr.add(new ArrayList());
                arr.get(arr.size() - 1).add(aux.getString(1));
                arr.get(arr.size() - 1).add(aux.getString(2));
            }
            Object o[] = new Object[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                o[i] = arr.get(i).get(1);
            }
            return o;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean agrega(Object[] valores) {
        if (valida(valores)) {
            con.Alta("tipo_permiso", "Permiso, Descripcion", "'" + valores[0] + "','" + valores[1] + "'");
            return true;
        } else {
            return false;
        }
    }
    
    
    private boolean valida(Object o[]) {
        boolean aux = true;
        for (int i = 0; i < o.length; i++) {
            if (o[i].toString().equals("")) {
                
                aux = false;
                JOptionPane.showMessageDialog(null, "Datos no válidos");
                break;
            }

        }
        if (!aux) {
            if (JOptionPane.showConfirmDialog(null, "Esta a punto de agregar los datos " + o[0] + ", " + o[1] + ", " + o[2] + ", " + "\n¿desea continuar?") == 0) {
                aux = true;
            } else {
                aux = false;
            }
        }
        return aux;
    }
}
