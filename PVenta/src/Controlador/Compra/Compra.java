//producto tipo piel modelo proveedor
package Controlador.Compra;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Compra {

    ArrayList<ArrayList> productos = null;
    Conexion con = new Conexion();
    ResultSet r = null;
    int can = 0;

    private void prod() {
        con.connect();
        r = con.getConsulta("productos", "*", "");
        con.closed();
        try {
            while (r.next()) {
                productos.add(new ArrayList());
                for (int i = 1; i < 9; i++) {
                    productos.get(can).add(r.getString(i));
                }
                can++;
            }
        } catch (Exception e) {
        }
    }

    public Object[] getProducto() {
        prod();
        Object o[] = new Object[productos.size()];
        for (int i = 0; i < productos.size(); i++) {
            productos.get(i).get(6);
        }
        return o;
    }

}
