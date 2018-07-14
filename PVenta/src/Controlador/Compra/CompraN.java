package Controlador.Compra;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CompraN {

    Conexion con = new Conexion();
    ArrayList<ArrayList> datos;
//tipo, modelo, piel, proveedor, nombre, color, descripción, imagen

    public boolean valida(Object datos[]) {
        boolean b = false;
        for (int i = 0; i < datos.length; i++) {
            if (!datos[i].toString().trim().equals("")) {

                b = true;

            } else {

                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                break;
            }

        }

        if (b) {
            if (JOptionPane.showConfirmDialog(null, "Esta a punto de agregar un producto nuevo.\t\n¿desea continuar?") == 1) {
                b = false;
            }
        }
        return b;
    }

    public void agrega(Object datos[]) {
        con.Alta("productos", "ID_Tipo,ID_Modelo,ID_Piel,"
                + "ID_Proveedor,Nombre,Color,Descripcion,Imagen",
                "'" + datos[0].toString() + "','" + datos[1].toString() + "','"
                + datos[2].toString() + "','" + datos[3].toString() + "','"
                + datos[4].toString() + "','" + datos[5].toString() + "','"
                + datos[6].toString() + "',' '");
    }

    public Object[] getName() {
        consulta("");
        Object name[] = new Object[datos.size()];
        for (int i = 0; i < name.length; i++) {
            name[i] = datos.get(i).get(5);
        }
        return name;
    }

    public Object getLastID() {
        consulta("");

        return datos.get(datos.size() - 1).get(0);
    }

    private void consulta(String cons) {
        datos = new ArrayList<ArrayList>();
        try {
            ResultSet R = con.getConsulta("productos", "*", cons);
            while (R.next()) {

                datos.add(new ArrayList());
                datos.get(datos.size() - 1).add(R.getString(1));
                datos.get(datos.size() - 1).add(R.getString(2));
                datos.get(datos.size() - 1).add(R.getString(3));
                datos.get(datos.size() - 1).add(R.getString(4));
                datos.get(datos.size() - 1).add(R.getString(5));
                datos.get(datos.size() - 1).add(R.getString(6));
                datos.get(datos.size() - 1).add(R.getString(7));
                datos.get(datos.size() - 1).add(R.getString(8));
                datos.get(datos.size() - 1).add(R.getString(9));
            }
        } catch (Exception e) {
        }
    }

    public Object[] getDatos(int index) {
        Object aux[] = null;
        consulta("");
        if (!datos.isEmpty()) {
            consulta("WHERE ID_Producto='" + datos.get(index).get(0) + "'");
            aux = new Object[datos.get(0).size() - 2];
            aux[0] = datos.get(0).get(1);
            aux[1] = datos.get(0).get(2);
            aux[2] = datos.get(0).get(3);
            aux[3] = datos.get(0).get(4);
            aux[4] = datos.get(0).get(5);
            aux[5] = datos.get(0).get(6);
            aux[6] = datos.get(0).get(7);
        }

        return aux;

    }

    public Object getId(int index) {
        return datos.get(index).get(0);
    }

}
