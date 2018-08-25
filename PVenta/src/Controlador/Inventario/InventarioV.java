package Controlador.Inventario;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InventarioV {

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

    
    public boolean respn(String t, String t2, String t3,String t4, String t5, String t6, String t7) {
        ResultSet r = c.getConsulta(t, "*", "");
        
        
        ArrayList<ArrayList> arr = new ArrayList<ArrayList>();
        try {
            
            while (r.next()) {
                ResultSet r3 = c.getConsulta(t2, "*", "where ID_Producto = " + r.getString(2));
                
                while(r3.next()){
            ResultSet r2 = c.getConsulta(t3, "*", "where ID_Tipo = " + r3.getString(2));
            ResultSet r4 = c.getConsulta(t4, "*", "where ID_Modelo = " + r3.getString(3));
            ResultSet r5 = c.getConsulta(t5, "*", "where ID_Piel = " + r3.getString(4));
            ResultSet r6 = c.getConsulta(t6, "*", "where ID_Proovedor = " + r3.getString(5));
            ResultSet r7 = c.getConsulta(t7, "*", "where ID_sucursal = " + r.getString(7));
            
                
            while (r2.next() && r4.next() && r5.next() && r6.next() && r7.next()) {
                arr.add(new ArrayList());
                arr.get(arr.size() - 1).add(r.getString(1));
                arr.get(arr.size() - 1).add(r3.getString(6));
                arr.get(arr.size() - 1).add(r2.getString(2));
                arr.get(arr.size() - 1).add(r4.getString(2));
                arr.get(arr.size() - 1).add(r6.getString(2));
                arr.get(arr.size() - 1).add(r3.getString(7));
                arr.get(arr.size() - 1).add(r5.getString(2));
                arr.get(arr.size() - 1).add(r.getString(3));
                arr.get(arr.size() - 1).add(r.getString(5));
                arr.get(arr.size() - 1).add(r.getString(4));
                arr.get(arr.size() - 1).add(r.getString(6));
                arr.get(arr.size() - 1).add(r7.getString(2));
            }
            
                }
            }
        } catch (Exception e) {
        }
        o = new Object[arr.size()][12];
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
