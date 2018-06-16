/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Ventas;

import VistasGenerales.Panel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author win 10
 */
public class VentaA extends VistasGenerales.Panel {

    public JLabel id, t, tp, mo, col, des, pv, can,
            im, ma, su, pi, PRO, IM, nc, cc;
    
    private JLabel v2, v3, v4, v5, v6, v10, v11, v13,
            v14, v15, v16, v17, v18, v19, v20, v21, v22;
    public JTextField CAN, PV, NC, CC;
    public String Prod[] = {"Tipo de producto"};
    public String Pago[] = {"Tipo de pago"};
    public String Mod[] = {"Modelo"};
    public String Color[] = {"Color"};
    public String Des[] = {"Descripción"};
    public String Suc[] = {"Sucursal"};
    public String piel[] = {"Tipo de piel"};
    public JComboBox T, TP, MO, COL, DES, SU, PI, ID;
    JComboBox idproducto;
    public Panel P = new Panel();
    public Panel Pr = new Panel();
    public Panel Pb = new Panel();
    
    final String cols[] = {"ID", "Tipo de producto", "Modelo", "Tipo de piel",
        "Color", "Descripción", "Precio de venta", "Tipo de pago", "Cantidad", "Cliente",
        "Num. Cliente", "Mayoreo", "Sucursal"};
    VistasGenerales.Tabla tab;
    VistasGenerales.Number cantidad;

    public JCheckBox MA;

    public VentaA() {
        crea();
        agrega();
        validate();
    }

    private void crea() {
        P.setLayout(new java.awt.GridBagLayout());
        Pb.setLayout(new java.awt.GridBagLayout());
        Pb.setAlignmentX(CENTER_ALIGNMENT);
        Pr.setLayout(new GridBagLayout());
        v2 = new JLabel();      v3 = new JLabel();      
        v4 = new JLabel();      v5 = new JLabel();
        v6 = new JLabel();      v10 = new JLabel();
        v11 = new JLabel();      
        v13 = new JLabel();      v14 = new JLabel();
        v15 = new JLabel();      v16 = new JLabel();
        v17 = new JLabel();      v18 = new JLabel();
        v19 = new JLabel();      v20 = new JLabel();
        v21 = new JLabel();      v22 = new JLabel();
        MA = new JCheckBox();
        id = new JLabel("ID");                  //id venta
        pv = new JLabel("Precio de venta");
        can = new JLabel("Cantidad");
        nc = new JLabel("Cliente");             //Nombre cliente
        cc = new JLabel("Contacto");            //forma de contacto
        im = new JLabel("(Insertar imagen)");
        im.setHorizontalAlignment(JLabel.CENTER);
        ma = new JLabel("Mayoreo");             //CheckBox
        ID = new JComboBox();
        CAN = new JTextField(10);
        PV = new JTextField(10);
        NC = new JTextField(10);
        CC = new JTextField(10);
        T = new JComboBox(Prod);
        TP = new JComboBox(Pago);
        MO = new JComboBox(Mod);
        COL = new JComboBox(Color);
        DES = new JComboBox(Des);
        SU = new JComboBox(Suc);
        PI = new JComboBox(piel);
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        idproducto=new JComboBox();
        cantidad = new VistasGenerales.Number();
    }
    
    private GridBagConstraints estilo(int pox, int poy, int tax, int tay) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = pox;
        gbc.gridy = poy;
        gbc.gridwidth = tax;
        gbc.gridheight = tay;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        return gbc;
    }
    
    

    private void agrega() {

        
        P.add(id, estilo(0,0,1,1));
        P.add(ID, estilo(1,0,1,1));
        P.add(pv, estilo(2,0,1,1));
        P.add(PV, estilo(3,0,1,1));
        P.add(v3, estilo(0,1,4,1));
        P.add(can, estilo(0,2,1,1));
        P.add(CAN, estilo(1,2,1,1));
        P.add(nc, estilo(2,2,1,1));
        P.add(NC, estilo(3,2,1,1));
        P.add(v4, estilo(0,3,4,1));
        P.add(cc, estilo(0,4,1,1));
        P.add(CC, estilo(1,4,1,1));
        P.add(ma, estilo(2,4,1,1));
        P.add(MA, estilo(3,4,1,1));
        P.add(v11, estilo (0,5,4,1));
        Pb.add(T);
        Pb.add(TP);
        Pb.add(MO);
        Pb.add(v13);
        Pb.add(COL);
        Pb.add(DES);
        Pb.add(SU);
        Pb.add(v14);
        Pb.add(PI);
        
        
        
        //Pr.add(v6, estilo(0, 0, 1, 1));
        Pr.add(P, estilo (0, 0, 1, 1));
        Pr.add(im, estilo(2, 0, 1, 1));
        //Pr.add(v3, estilo(0, 1, 1, 1));
        Pr.add(Pb, estilo(0, 1, 1, 1));
        Pr.add(v5, estilo(2, 1, 1, 1));
        Pr.add(tab, estilo(0, 2, 3, 1));
        validate();
        
        
    }
}
