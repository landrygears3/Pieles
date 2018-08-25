package Controlador.Empleado;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpleadoV {

    Conexion c = new Conexion();
    Object o[][] = null;

    public boolean resp(String t) {
        ResultSet r = c.getConsulta(t, "*", "");
        ArrayList<ArrayList> arr = new ArrayList<ArrayList>();
        try {
            while (r.next()) {
                arr.add(new ArrayList());
                arr.get(arr.size() - 1).add(r.getString(2));
                arr.get(arr.size() - 1).add(r.getString(3));
                arr.get(arr.size() - 1).add(r.getString(4));
                arr.get(arr.size() - 1).add(r.getString(5));
                arr.get(arr.size() - 1).add(r.getString(6));
                arr.get(arr.size() - 1).add(r.getString(7));
                arr.get(arr.size() - 1).add(r.getString(8));

            }
        } catch (Exception e) {
        }
        o = new Object[arr.size()][7];
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                o[i][j] = arr.get(i).get(j);

            }
        }
        if (o.length != 0) {
            return true;
        } else {
            return false;
        }
    }

public boolean respn(String t, String t2) {
        ResultSet r = c.getConsulta(t, "*", "");
        
        
        ArrayList<ArrayList> arr = new ArrayList<ArrayList>();
        try {
            
            while (r.next()) {
            ResultSet r2 = c.getConsulta(t2, "*", "where ID_Empleado = " + r.getString(2));
                
            while (r2.next()) {
                arr.add(new ArrayList());
                
                arr.get(arr.size() - 1).add(r2.getString(2));
                arr.get(arr.size() - 1).add(r.getString(3));
            }
            

            }
        } catch (Exception e) {
        }
        o = new Object[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                o[i][j] = arr.get(i).get(j);

            }
        }
        if (o.length != 0) {
            return true;
        } else {
            return false;
        }
    }

    public Object[][] getDatos() {
        return o;
    }
}
