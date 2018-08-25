package Controlador.Errores;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ErrorV {

    Conexion c = new Conexion();
    Object o[][] = null;

    public boolean resp(String t, String t2) {
        ResultSet r = c.getConsulta(t, "*", "");
        ResultSet r2 = c.getConsulta(t2, "*", "");
        ArrayList<ArrayList> arr = new ArrayList<ArrayList>();
        try {
            while (r.next() && r2.next()) {
                arr.add(new ArrayList());
                arr.get(arr.size() - 1).add(r2.getString(6));
                arr.get(arr.size() - 1).add(r.getString(2));
                arr.get(arr.size() - 1).add(r.getString(3));
                arr.get(arr.size() - 1).add(r.getString(4));
                

            }
        } catch (Exception e) {
        }
        o = new Object[arr.size()][4];
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

    
    public boolean respn(String t, String t2, String t3) {
        ResultSet r = c.getConsulta(t, "*", "");
        
        
        ArrayList<ArrayList> arr = new ArrayList<ArrayList>();
        try {
            
            while (r.next()) {
                ResultSet r3 = c.getConsulta(t2, "*", "where ID_Producto = " + r.getString(2));
            ResultSet r2 = c.getConsulta(t3, "*", "where ID_Proovedor = " + r.getString(5));
            
                
            while (r2.next() && r3.next()) {
                arr.add(new ArrayList());
                
                arr.get(arr.size() - 1).add(r3.getString(6));
                
                arr.get(arr.size() - 1).add(r.getString(4));
                arr.get(arr.size() - 1).add(r2.getString(2));
                arr.get(arr.size() - 1).add(r.getString(3));
            }
            

            }
        } catch (Exception e) {
        }
        o = new Object[arr.size()][4];
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
