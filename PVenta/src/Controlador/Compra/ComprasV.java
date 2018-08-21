package Controlador.Compra;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ComprasV {

    Conexion c = new Conexion();
    Object o[][] = null;

    public boolean resp() {
        ResultSet r = c.getConsulta("compras", "*", "");
        ArrayList<ArrayList> arr = new ArrayList<ArrayList>();
        try {
            while (r.next()) {
                arr.add(new ArrayList());
                arr.get(arr.size() - 1).add(r.getString(1));
                arr.get(arr.size() - 1).add(r.getString(2));
                arr.get(arr.size() - 1).add(r.getString(3));
                arr.get(arr.size() - 1).add(r.getString(4));
                arr.get(arr.size() - 1).add(r.getString(5));

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
