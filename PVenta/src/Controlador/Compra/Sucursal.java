package Controlador.Compra;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sucursal {

    Conexion con = new Conexion();
    private ArrayList<ArrayList> arr;

    public Sucursal() {
        arr = new ArrayList<ArrayList>();

        ResultSet r = con.getConsulta("sucursal", "*", "");
        try {
            while (r.next()) {
                arr.add(new ArrayList());
                arr.get(arr.size() - 1).add(r.getString(1));
                arr.get(arr.size() - 1).add(r.getString(2));
            }
        } catch (SQLException e) {

        }
    }

    public Object[] getName() {
        Object O[] = new Object[arr.size()];
        for (int i = 0; i < O.length; i++) {
            O[i] = arr.get(i).get(1);
        }
        return O;
    }

    public Object getID(int index) {
        return arr.get(index).get(0);
    }

}
