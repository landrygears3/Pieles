package Controlador.Inventario;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inventario {

    Conexion con = new Conexion();
    ArrayList<ArrayList> arr;
    ArrayList<ArrayList> prepara = new ArrayList<ArrayList>();

    public Inventario() {
        Inv();
    }

    public Object[] getDat(String t) {
        Object[] o = null;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).get(1).equals(t)) {
                o = new Object[arr.get(i).size()];
                for (int j = 0; j < o.length; j++) {
                    o[j] = arr.get(i).get(j);

                }
                break;

            }
        }
        return o;
    }

    private void Inv() {
        ResultSet r = con.getConsulta("inventario", "*", "");
        arr = new ArrayList<ArrayList>();
        try {
            arr.add(new ArrayList());
            arr.get(arr.size() - 1).add(r.getString(1));
            arr.get(arr.size() - 1).add(r.getString(2));
            arr.get(arr.size() - 1).add(r.getString(3));
            arr.get(arr.size() - 1).add(r.getString(4));
            arr.get(arr.size() - 1).add(r.getString(5));
            arr.get(arr.size() - 1).add(r.getString(6));
            arr.get(arr.size() - 1).add(r.getString(7));

            while (r.next()) {
            }
        } catch (Exception e) {
        }
    }

    public void alta(Object suc) {
        String aux = "";
        //al final limpiar array prepara
        for (int i = 0; i < prepara.size(); i++) {
            aux = "";
            aux += suc;
            if (prepara.get(i).get(5).equals("N")) {
                for (int j = 0; j < prepara.get(i).size() - 1; j++) {
                    aux += prepara.get(i).get(j) + ",";

                }
                con.Alta("inventario", "ID_Producto,Cantidad,Precio,PrecioU,PrecioM,Sucursal", aux);
            }

            if (prepara.get(i).get(5).equals("E")) {
                ArrayList<ArrayList> da = new ArrayList<ArrayList>();
                ResultSet r = null;

                r = con.getConsulta("inventario", "*", "where `ID_Producto` = '"
                        + prepara.get(i).get(0) + "' and `Sucursal`='"
                        + suc + "'");

                try {
                    while (r.next()) {
                        da.add(new ArrayList());
                        da.get(da.size() - 1).add(r.getInt(3));

                    }
                } catch (SQLException ex) {
                    System.out.println("nel prro");
                }

                if (da.size() > 0) {
                    int cant = Integer.parseInt(prepara.get(i).get(1).toString())
                            + Integer.parseInt(da.get(0).get(0).toString());
                    System.out.println(Integer.parseInt(prepara.get(i).get(1).toString())+" + "+Integer.parseInt(da.get(0).get(0).toString()));

                    con.Modifica("inventario",
                            "Cantidad='" + cant + "',Precio='"
                            + prepara.get(i).get(2) + "',PrecioU='" + prepara.get(i).get(3)
                            + "',PrecioM='" + prepara.get(i).get(4) + "'",
                            "where ID_Producto = '" + prepara.get(i).get(0) + "' and Sucursal='"
                            + suc + "'");
                }

                if (da.isEmpty()) {
                    prepara.get(i).remove(5);
                    prepara.get(i).add("N");
                    alta(suc);
                }
            }

        }
        prepara = new ArrayList<ArrayList>();
    }

    public void setDatos(Object O[]) {
        prepara.add(new ArrayList());
        for (int i = 0; i < O.length; i++) {
            prepara.get(prepara.size() - 1).add(O[i]);
        }
    }

    public void elimina(int index) {
        ArrayList<ArrayList> aux = new ArrayList<ArrayList>();
        for (int i = 0; i < prepara.size(); i++) {
            if (i != index) {
                aux.add(new ArrayList());
                for (int j = 0; j < prepara.get(i).size(); j++) {
                    aux.get(aux.size() - 1).add(prepara.get(i).get(j));

                }
            }

        }
        prepara = aux;

    }

}
