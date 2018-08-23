package Controlador.Compra;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConGastos {

    Conexion c = new Conexion();

    public void Alta(int tipo, String concepto, int cantidad, double precio) {

        SimpleDateFormat d = new SimpleDateFormat("YYYY-dd-MM");
        Date date = new Date();
        String dat = d.format(date);

        String aux = "'" + tipo + "','" + concepto + "','" + cantidad + "','" + precio + "','" + dat + "'";
        c.Alta("gastos", "tipo, concepto, cantidad, precio, fecha", aux);

    }

    public Object[] Num(String val) {
        Object[] r = new Object[2];
        try {
            r[0] = Integer.parseInt(val);
            r[1] = true;
        } catch (Exception e) {
            r[0] = 1;
            r[1] = false;
        }
        return r;
    }

    public Object[][] getConsulta() {
        ResultSet r = c.getConsulta("gastos", "*", "");
        ArrayList<ArrayList> arr = new ArrayList<ArrayList>();

        try {
            arr.add(new ArrayList());
            while (r.next()) {
                arr.get(arr.size() - 1).add(r.getString(2));
                arr.get(arr.size() - 1).add(r.getString(3));
                arr.get(arr.size() - 1).add(r.getString(4));
                arr.get(arr.size() - 1).add(r.getString(5));
                arr.get(arr.size() - 1).add(r.getString(6));
            }
        } catch (Exception e) {
        }
        Object o[][] = new Object[arr.size()][5];
        for (int i = 0; i < o.length; i++) {
            for (int j = 0; j < o.length; j++) {
                o[i][j] = arr.get(i).get(j);
            }
        }
        if (o.length > 0) {
            return o;
        } else {
            return null;
        }
    }

    public boolean isDouble(String s) {
        boolean f;
        try {
            Double.parseDouble(s);
            f = true;
        } catch (Exception e) {
            f = false;
        }
        return f;
    }
}
