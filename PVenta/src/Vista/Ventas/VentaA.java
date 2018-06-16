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
            im, ma, su, pi, PRO, IM, nc, cc, st;
    
    private JLabel v2, v3, v4, v5, v6, v7, v11, v13,
            v14, v1;
    public JTextField CAN, NC, CC;
    public String Pago[] = {"Tipo de pago"};
    public String Suc[] = {"Sucursal"};
    public JComboBox TP, SU, ID;
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
        v6 = new JLabel();      v7 = new JLabel();
        v11 = new JLabel();     v13 = new JLabel();
        v14 = new JLabel();      v1 = new JLabel();
        MA = new JCheckBox();
        id = new JLabel("ID");                  //id venta
        pv = new JLabel("Precio unitario");
        pv.setHorizontalAlignment(JLabel.CENTER);
        can = new JLabel("Cantidad");
        nc = new JLabel("Cliente");             //Nombre cliente
        cc = new JLabel("Contacto");            //forma de contacto
        im = new JLabel("(Insertar imagen)");
        pi = new JLabel("Tipo de piel");
        mo = new JLabel("Modelo");
        t = new JLabel("Tipo de piel");
        col = new JLabel("Color");
        st = new JLabel("Subtotal");
        im.setHorizontalAlignment(JLabel.CENTER);
        ma = new JLabel("Mayoreo");             //CheckBox
        ID = new JComboBox();
        CAN = new JTextField(10);
        NC = new JTextField(10);
        CC = new JTextField(10);
        TP = new JComboBox(Pago);
        SU = new JComboBox(Suc);
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

        P.add(nc, estilo(0,0,1,1));
        P.add(NC, estilo(1,0,1,1));
        P.add(cc, estilo(2,0,1,1));
        P.add(CC, estilo(3,0,1,1));
        P.add(v1, estilo(0,1,4,1));
        
        P.add(id, estilo(0,2,1,1));
        P.add(ID, estilo(1,2,1,1));
        P.add(can, estilo(2,2,1,1));
        P.add(CAN, estilo(3,2,1,1));
        P.add(v2, estilo(0,3,4,1));
        
        P.add(t, estilo(0,4,1,1));
        P.add(mo, estilo(1,4,1,1));
        P.add(pi, estilo(2,4,1,1));
        P.add(col, estilo(3,4,1,1));
        P.add(v3, estilo(0,4,4,1));
        
        Pb.add(v7, estilo(0,0,4,1));
        Pb.add(TP, estilo(0,1,1,1));
        Pb.add(pv, estilo(1,1,1,1));
        Pb.add(SU, estilo(2,1,1,1));
        Pb.add(v4, estilo(3,1,1,1));
        
        Pb.add(ma, estilo(0,2,1,1));
        Pb.add(MA, estilo(1,2,1,1));
        Pb.add(v5, estilo(2,2,2,1));
        Pb.add(v6, estilo(0,3,4,1));
        Pb.add(st, estilo(3,4,1,1));
        
        
        
        
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
