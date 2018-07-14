package Controlador.Inventario;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        System.out.println(suc);
        //al final limpiar array prepara
    }

    public void setDatos(Object O[]) {
        prepara.add(new ArrayList());
        for (int i = 0; i < O.length; i++) {
            prepara.get(prepara.size() - 1).add(O[i]);
            System.out.print(O[i]+"---");
        }
        System.out.println("");
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
