/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Empleado;

import VistasGenerales.Contrasena;
import VistasGenerales.Panel;
import com.toedter.calendar.JDateChooser;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author landr
 */
public class EmpleadoM extends VistasGenerales.Panel{
    
    final String cols[] = {"Nombre", "Usuario", "Notas"};
    final String ns[] = {"Nombre"};
    VistasGenerales.Tabla tab;
    JButton c, ca;
    public Contrasena C, CC;
    JLabel u, no, v1, v2, p, v3, v4, v5, v6, va, vb, vc, vd, ve, vf,
            el, vz, vy, vx, vw, vv, vu, v7, v8,cn,cc;
    JTextField U, NO, P;
    JComboBox n;
    Panel hora;
    Panel contrasenas;
    public Panel Pr = new Panel();
    public Panel Pb = new Panel();
    Container co2 = new Container();
    Container co = new Container();
    Container ti = new Container();
    Container cf = new Container();
    VistasGenerales.Number CAN;
    VistasGenerales.TimeChoser horae, horas;
    JDateChooser fecha;
    
    public EmpleadoM(){
        crea();
        carga();
        
    }
    
    private void crea(){
        n = new JComboBox (ns);
        u = new JLabel ("Usuario");
        u.setHorizontalAlignment(JLabel.CENTER);
        p = new JLabel ("Contraseña");
        p.setHorizontalAlignment(JLabel.CENTER);
        no = new JLabel ("Teléfono");
        no.setHorizontalAlignment(JLabel.CENTER);
        c = new JButton ("Modificar usuario");
        el = new JLabel (" ");
        ca = new JButton("Cancelar");
        cn = new JLabel("Nueva");
        cc = new JLabel("Confirmar");
        C = new Contrasena();
        CC = new Contrasena();
        
        U = new JTextField(10);
        CAN = new VistasGenerales.Number();
        P = new JTextField(10);
        
        
        horae = new VistasGenerales.TimeChoser();
        horas = new VistasGenerales.TimeChoser();
        fecha = new JDateChooser();
        
        
        
        v1 = new JLabel(" ");       v2 = new JLabel(" ");
        v3 = new JLabel(" ");       v4 = new JLabel(" ");
        v5 = new JLabel(" ");       v6 = new JLabel(" ");
        v7 = new JLabel(" ");       v8 = new JLabel(" ");
        va = new JLabel(" ");       vb = new JLabel(" ");
        vc = new JLabel(" ");       vd = new JLabel(" ");
        ve = new JLabel(" ");       vf = new JLabel(" ");
        vz = new JLabel(" ");       vy = new JLabel(" ");
        vu = new JLabel(" ");       vv = new JLabel(" ");
        vw = new JLabel(" ");       vx = new JLabel(" ");
        
        horae = new VistasGenerales.TimeChoser();
        horas = new VistasGenerales.TimeChoser();
        fecha = new JDateChooser();
        hora = new Panel();
        hora.setBorder(BorderFactory.createTitledBorder("Horario"));
        hora.setLayout(new GridBagLayout());
        contrasenas = new Panel();
        contrasenas.setBorder(BorderFactory.createTitledBorder("Contraseña"));
        contrasenas.setLayout(new GridBagLayout());
        
    tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        
        Pr.setLayout(new GridBagLayout());
        Pb.setLayout(new GridLayout(1,2));
        co2.setLayout(new GridLayout(7,1));
        co.setLayout(new GridLayout(8,1));
        cf.setLayout(new GridLayout(1,3));
        ti.setLayout(new GridBagLayout());
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
    
    
    private GridBagConstraints est2(int pox, int poy, int tax, int tay, int fill, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = pox;
        gbc.gridy = poy;
        gbc.gridwidth = tax;
        gbc.gridheight = tay;
        gbc.fill = fill;
        gbc.anchor = anchor;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        return gbc;
    }

    
    private void carga(){
        
        
        ti.add(vx, estilo(0,0,3,1));
        ti.add(vy, estilo(0,1,1,1));
        ti.add(fecha, estilo(1,1,1,1));
        ti.add(vz, estilo(0,2,3,1));
        ti.add(horae, estilo(1,3,1,1));
        ti.add(vu, estilo(0,4,3,1));
        ti.add(horas, estilo(1,5,1,1));
        ti.add(vv, estilo(0,6,3,1));
        
        co.add(n);
        co.add(u);
        co.add(U);
        co.add(p);
        co.add(P);
        co.add(no);
        co.add(CAN.tf);
        co.add(v1);
        
        co2.add(v2);
        co2.add(el);
        co2.add(v3);
        co2.add(c);
        co2.add(v4);
        co2.add(ca);
        co2.add(v5);
        
        v1 = new JLabel(" ");       v2 = new JLabel(" ");
        v3 = new JLabel(" ");       v4 = new JLabel(" ");
        v5 = new JLabel(" ");
        
        contrasenas.add(v1, est2(0, 0, 3, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(cn, est2(0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(v2, est2(0, 2, 3, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(C, est2(0, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(v3, est2(0, 4, 3, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(cc, est2(0, 5, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(v4, est2(0, 6, 3, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(CC, est2(0, 7, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(v5, est2(0, 8, 3, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        
        cf.add(v6);
        cf.add(co2);
        cf.add(v7);
        
        Pb.add(contrasenas);
        Pb.add(ti);
        
        Pr.add(co, estilo(0,1,1,1));
        Pr.add(Pb, estilo(1,1,1,1));
        Pr.add(cf, estilo(2,1,1,1));
        Pr.add(tab, estilo(0,2,3,1));
        
    }
}
