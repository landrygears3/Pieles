/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Ventas;

import VistasGenerales.Panel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author win 10
 */
public class VentaA extends VistasGenerales.Panel {

    public JLabel id, col, pv, can, mo, pi,
            im, ma, su,  pro, cc, st;
    
    private JLabel v2, v3, v4, v5, v6, v7, v1;
    public JTextField CC;
    public String Pago[] = {"Tipo de pago"};
    public String Suc[] = {"Sucursal"};
    private String Tpi[] = {"Tipo de piel"};
    private String MO[] = {"Modelo"};
    private String c[] = {"Cliente"};
    public JComboBox TP, SU, ID, nc;
    JComboBox idproducto;
    public Panel P = new Panel();
    public Panel Pr = new Panel();
    public Panel Pb = new Panel();
    JButton acepta,agrega, btp, bpi, bcl, bmo;
    Container c3, c5;
    
    final String cols[] = {"ID", "Tipo de producto", "Modelo", "Tipo de piel",
        "Color", "Descripción", "Precio de venta", "Tipo de pago", "Cantidad",
        "Cliente", "Num. Cliente", "Mayoreo", "Sucursal"};
    VistasGenerales.Tabla tab;
    VistasGenerales.Number CAN;

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
        v1 = new JLabel();
        MA = new JCheckBox();
        id = new JLabel("Producto");                  //id venta
        id.setHorizontalAlignment(JLabel.CENTER);
        pv = new JLabel("Precio unitario");
        pv.setHorizontalAlignment(JLabel.CENTER);
        can = new JLabel("Cantidad");
        can.setHorizontalAlignment(JLabel.CENTER);
        nc = new JComboBox(c);             //Nombre cliente
        cc = new JLabel("Contacto");            //forma de contacto
        cc.setHorizontalAlignment(JLabel.CENTER);
        im = new JLabel();
        pi = new JLabel("Tipo de piel");
        pi.setHorizontalAlignment(JLabel.CENTER);
        mo = new JLabel("Modelo");
        mo.setHorizontalAlignment(JLabel.CENTER);
        pro = new JLabel("Proovedor");
        pro.setHorizontalAlignment(JLabel.CENTER);
        col = new JLabel("Color");
        col.setHorizontalAlignment(JLabel.CENTER);
        st = new JLabel("Subtotal");
        im.setHorizontalAlignment(JLabel.CENTER);
        ma = new JLabel("Mayoreo");             //CheckBox
        ID = new JComboBox();
        CAN = new VistasGenerales.Number();
        CC = new JTextField(10);
        TP = new JComboBox(Pago);
        SU = new JComboBox(Suc);
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        idproducto=new JComboBox();
        
        acepta = new JButton("Compra");
        acepta.setFocusable(false);
        agrega = new JButton("Agrega");
        agrega.setFocusable(false);
        bcl = new JButton("+");
        bcl.setFocusable(false);
        
        
        c3 = new Container();
        c3.setLayout(new BorderLayout());
        
        c5 = new Container();
        c5.setLayout(new BorderLayout());
        
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
        
        ImageIcon image = new ImageIcon("Recursos\\Img\\Default.jpg");
        Dimension d = super.getToolkit().getScreenSize();
        image = new ImageIcon(image.getImage().getScaledInstance(((d.width / 12) * 2), ((d.width / 12) * 2), Image.SCALE_DEFAULT));
        im.setIcon(image);
        
        c3.add(nc, BorderLayout.CENTER);
        c3.add(bcl, BorderLayout.EAST);
        
        c5.add(ma, BorderLayout.CENTER);
        c5.add(MA, BorderLayout.EAST);

        P.add(c3, estilo(0,0,1,1));
        P.add(id, estilo(1,0,1,1));
        P.add(ID, estilo(2,0,1,1));
        P.add(pro, estilo(3,0,1,1));
        P.add(v1, estilo(0,1,4,1));
        
        P.add(pi, estilo(0,2,1,1));
        P.add(mo, estilo(1,2,1,1));
        P.add(can, estilo(2,2,1,1));
        P.add(CAN.tf, estilo(3,2,1,1));
        P.add(v2, estilo(0,3,4,1));
        
        P.add(TP, estilo(0,4,1,1));
        P.add(col, estilo(1,4,1,1));
        P.add(c5, estilo(2,4,1,1));
        P.add(pv, estilo(3,4,1,1));
        P.add(v3, estilo(0,4,4,1));
        
        Pb.add(v7, estilo(0,0,4,1));
        Pb.add(v4, estilo(0,1,1,1));
        
        Pb.add(v5, estilo(2,2,2,1));
        Pb.add(v6, estilo(0,3,4,1));
        Pb.add(st, estilo(3,4,1,1));
        
        
        Pr.add(im, estilo (0, 0, 1, 1));
        Pr.add(P, estilo(2, 0, 1, 1));
        Pr.add(v5, estilo(0, 1, 1, 1));
        Pr.add(Pb, estilo(2, 1, 1, 1));
        Pr.add(tab, estilo(0, 2, 3, 1));
        validate();
        
        
    }
}
