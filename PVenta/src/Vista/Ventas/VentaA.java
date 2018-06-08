/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Ventas;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author win 10
 */

public class VentaA {

    public JLabel id, t, tp, mo, col, des, pv, can,
            im, ma, su, pi, PRO, IM, nc, cc;
    public JTextField ID, CAN, PV, NC, CC;
    public String Prod[] = {"Tipo de producto"};
    public String Pago[] = {"Tipo de pago"};
    public String Mod[] = {"Modelo"};
    public String Color[] = {"Color"};
    public String Des[] = {"Descripción"};
    public String Suc[] = {"Sucursal"};
    public String piel[] = {"Tipo de piel"};
    public JComboBox T, TP, MO, COL, DES, SU, PI;

    public JCheckBox MA;

    public VentaA() {
        MA = new JCheckBox();

        id = new JLabel("ID");                  //id venta
        pv = new JLabel("Precio de venta");     
        can = new JLabel("Cantidad");           
        nc = new JLabel("Cliente");             //Nombre cliente
        cc = new JLabel("Contacto");            //forma de contacto
        im = new JLabel("(Insertar imagen)");
        ma = new JLabel("Mayoreo");             //CheckBox
        ID = new JTextField(10);
        CAN = new JTextField(10);
        PV = new JTextField(10);
        NC = new JTextField(10);
        CC = new JTextField(10);
        IM = new JLabel("");
        T = new JComboBox(Prod);
        TP = new JComboBox(Pago);
        MO = new JComboBox(Mod);
        COL = new JComboBox(Color);
        DES = new JComboBox(Des);
        SU = new JComboBox(Suc);
        PI = new JComboBox(piel);

    }
}
