/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Empleado;

import VistasGenerales.Panel;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author landr
 */
public class NotasA extends VistasGenerales.Panel{
    JLabel u, n, v1, v2, v3, v4, v5, v6, v7, v8, va, vb, vc, vd, ve, vf;
    JTextArea N;
    JComboBox U;
    String[] us = {"Usuarios"};
    public Panel P = new Panel();
    Container c = new Container();
    Container co = new Container();
    Container co2 = new Container();
    JButton ag, bo;
    
    public NotasA(){
        crea();
        agrega();
        
    }
    
    private void crea(){
        u = new JLabel("Empleado");
        u.setHorizontalAlignment(JLabel.CENTER);
        n = new JLabel("Nota");
        n.setHorizontalAlignment(JLabel.CENTER);
        U = new JComboBox(us);
        N = new JTextArea();
        N.setRows(10);
        N.setColumns(10);
        N.setBorder(new LineBorder(Color.BLACK));
        P.setLayout(new GridLayout(3,3));
        c.setLayout(new GridBagLayout());
        co.setLayout(new GridLayout(5,1));
        co2.setLayout(new GridLayout(1,2));
        ag = new JButton("Guardar nota");
        bo = new JButton("Borrar nota");
        
        v2 = new JLabel();      v3 = new JLabel();      
        v4 = new JLabel();      v5 = new JLabel();
        v6 = new JLabel();      v1 = new JLabel();
        v7 = new JLabel();      v8 = new JLabel();
        va = new JLabel();      vd = new JLabel();      
        vb = new JLabel();      ve = new JLabel();
        vc = new JLabel();      vf = new JLabel();
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
    
    private void agrega(){
        
        co.add(va);
        co.add(ag);
        co.add(vb);
        co.add(bo);
        co.add(vc);
        
        c.add(u, estilo(1,0,1,1));
        c.add(U, estilo(1,1,1,1));
        c.add(n, estilo(1,2,1,1));
        c.add(v7, estilo(0,3,1,1));
        c.add(N, estilo(1,3,1,1));
        c.add(v8, estilo(2,3,1,1));
        
        co2.add(c);
        co2.add(co);
        
        P.add(v1);
        P.add(v2);
        P.add(v3);
        P.add(v4);
        P.add(co2);
        P.add(v5);
        P.add(v6);
    }
}
