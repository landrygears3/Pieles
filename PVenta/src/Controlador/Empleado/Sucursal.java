package Controlador.Empleado;

import Modelo.Conexion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Sucursal {

    Conexion con = new Conexion();
    ArrayList<ArrayList> arr;
    public boolean b;


    

    public boolean agrega(Object[] valores) {
        if (valida(valores)) {
            con.Alta("sucursal", "Nombre, Direccion, Telefono", "'" + valores[0]
                    + "','" + valores[1] + "','" + valores[2] + "'");
            return true;
        } else {
            return false;
        }
    }
    
    
    private boolean valida(Object o[]) {
        boolean aux = true;
        for (int i = 0; i < o.length-1; i++) {
            System.out.println(o[i]);
            if (o[i].toString().equals("")) {
                
                aux = false;
                JOptionPane.showMessageDialog(null, "Datos no válidos");
                break;
            }

        }
        if (!aux) {
            if (JOptionPane.showConfirmDialog(null, "Esta a punto de agregar los datos " + o[0] + ", " + o[1] + ", " + o[2] + ", " + "\n¿desea continuar?") == 0) {
                aux = true;
            } else {
                aux = false;
            }
        }
        return aux;
    }
}
