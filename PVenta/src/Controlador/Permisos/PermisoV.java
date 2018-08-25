package Controlador.Permisos;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PermisoV {

    Conexion c = new Conexion();
    Object o[][] = null;

    public boolean respn(String t, String t2, String t3) {
        ResultSet r = c.getConsulta(t, "*", "");
        
        
        ArrayList<ArrayList> arr = new ArrayList<ArrayList>();
        try {
            
            while (r.next()) {
                ResultSet r3 = c.getConsulta(t3, "*", "where ID_Empleado = " + r.getString(2));
            ResultSet r2 = c.getConsulta(t2, "*", "where ID_TipoPermiso = " + r.getString(3));
            
                
            while (r2.next() && r3.next()) {
                arr.add(new ArrayList());
                
                arr.get(arr.size() - 1).add(r.getString(1));
                arr.get(arr.size() - 1).add(r3.getString(2));
                arr.get(arr.size() - 1).add(r2.getString(2));
                arr.get(arr.size() - 1).add(r.getString(4));
                arr.get(arr.size() - 1).add(r.getString(5));
            }
            

            }
        } catch (Exception e) {
        }
        o = new Object[arr.size()][5];
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
