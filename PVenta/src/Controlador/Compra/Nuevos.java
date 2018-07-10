package Controlador.Compra;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Nuevos {

    Conexion con = new Conexion();
    ArrayList<ArrayList> datos;

    public boolean agrega(String name, Object o) {
        boolean da = false;
        if (name.equals("Piel")) {
            if (valida(o.toString())) {
                piel(o);
                da = true;
            } else {
                da = false;
            }
        }
        if (name.equals("Modelo")) {
            if (valida(o.toString())) {
                modelo(o);
                da = true;
            } else {
                da = false;
            }
        }
        if (name.equals("Tipo")) {
            if (valida(o.toString())) {
                tipo(o);
                da = true;
            } else {
                da = false;
            }
        }
        return da;
    }

    public Object getID(int index) {
        return datos.get(index).get(0);
    }
    public Object getName(int index) {
        return datos.get(index).get(1);
    }
    public Object getName(String con) {
        Object dat=null;
        for (int i = 0; i < datos.size(); i++) {
            if(datos.get(i).get(0).toString().equals(con)){
            dat=datos.get(i).get(1);
            }
            
        }
        return dat;
    }

    private boolean valida(String dat) {

        if (dat.trim().equals("") || dat.equals(null)) {
            JOptionPane.showMessageDialog(null, "Datos invalidos");
            return false;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Esta a punto de agregar " + dat + "\n¿desea continuar?") == 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    private void piel(Object O) {
        //ID_Piel Descripción

        con.Alta("piel", "Descripcion", "'" + O.toString() + "'");

    }

    public Object[] getPieles() {
        datos = new ArrayList<ArrayList>();

        try {
            ResultSet aux = con.getConsulta("piel", "*", "");
            while (aux.next()) {
                datos.add(new ArrayList());
                datos.get(datos.size() - 1).add(aux.getString(1));
                datos.get(datos.size() - 1).add(aux.getString(2));
            }
        } catch (Exception e) {
        }
        Object datos[] = new Object[this.datos.size()];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = this.datos.get(i).get(1);
        }
        return datos;
    }

    public Object[] getModelos() {
        datos = new ArrayList<ArrayList>();
        try {
            ResultSet aux = con.getConsulta("modelos", "*", "");
            while (aux.next()) {
                datos.add(new ArrayList());
                datos.get(datos.size() - 1).add(aux.getString(1));
                datos.get(datos.size() - 1).add(aux.getString(2));
            }
        } catch (Exception e) {
        }
        Object datos[] = new Object[this.datos.size()];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = this.datos.get(i).get(1);
        }
        return datos;
    }

    public Object[] getTipos() {
        datos = new ArrayList<ArrayList>();
        try {
            ResultSet aux = con.getConsulta("tipos", "*", "");
            while (aux.next()) {
                datos.add(new ArrayList());
                datos.get(datos.size() - 1).add(aux.getString(1));
                datos.get(datos.size() - 1).add(aux.getString(2));
            }
        } catch (Exception e) {
        }
        Object datos[] = new Object[this.datos.size()];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = this.datos.get(i).get(1);
        }
        return datos;
    }

    private void modelo(Object O) {
        //ID_Modelo, Descripcion
        con.Alta("modelos", "Descripcion", "'" + O.toString() + "'");
    }

    private void tipo(Object O) {
        //    ID_Tipo, Descripcion
        con.Alta("tipos", "Descripcion", "'" + O.toString() + "'");
    }
}
