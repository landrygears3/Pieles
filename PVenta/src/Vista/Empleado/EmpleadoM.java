/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Empleado;

import VistasGenerales.Panel;
import com.toedter.calendar.JDateChooser;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
    JLabel u, no, v1, v2, p, v3, v4, v5, v6, va, vb, vc, vd, ve, vf,
            el, vz, vy, vx, vw, vv, vu;
    JTextField U, NO, P;
    JComboBox n;
    public Panel Pr = new Panel();
    public Panel Pb = new Panel();
    Container co2 = new Container();
    Container co = new Container();
    Container ti = new Container();
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
        
        U = new JTextField(10);
        CAN = new VistasGenerales.Number();
        P = new JTextField(10);
        
        
        horae = new VistasGenerales.TimeChoser();
        horas = new VistasGenerales.TimeChoser();
        fecha = new JDateChooser();
        
        
        
        v1 = new JLabel(" ");       v2 = new JLabel(" ");
        v3 = new JLabel(" ");       v4 = new JLabel(" ");
        v5 = new JLabel(" ");       v6 = new JLabel(" ");
        va = new JLabel(" ");       vb = new JLabel(" ");
        vc = new JLabel(" ");       vd = new JLabel(" ");
        ve = new JLabel(" ");       vf = new JLabel(" ");
        vz = new JLabel(" ");       vy = new JLabel(" ");
        vu = new JLabel(" ");       vv = new JLabel(" ");
        vw = new JLabel(" ");       vx = new JLabel(" ");
        
    tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        
        Pr.setLayout(new GridBagLayout());
        Pb.setLayout(new GridLayout(1,2));
        co2.setLayout(new GridLayout(7,1));
        co.setLayout(new GridLayout(8,1));
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

    
    private void carga(){
        
        ti.add(vx, estilo(0,0,3,1));
        ti.add(vz, estilo(0,1,1,1));
        ti.add(fecha, estilo(1,1,1,1));
        ti.add(vw, estilo(0,2,3,1));
        ti.add(horae, estilo(1,3,1,1));
        ti.add(vy, estilo(2,3,1,1));
        ti.add(vv, estilo(0,4,3,1));
        ti.add(horas, estilo(1,5,1,1));
        ti.add(vu, estilo(0,6,3,1));
        
        co.add(n);
        co.add(u);
        co.add(U);
        co.add(p);
        co.add(P);
        co.add(no);
        co.add(CAN.tf);
        co.add(v2);
        
        co2.add(v3);
        co2.add(el);
        co2.add(v4);
        co2.add(c);
        co2.add(v5);
        co2.add(ca);
        co2.add(v6);
        
        Pb.add(co);
        Pb.add(co2);
        
        Pr.add(va, estilo(0,0,3,1));
        Pr.add(vd, estilo(0,1,1,1));
        Pr.add(Pb, estilo(1,1,1,1));
        Pr.add(ti, estilo(2,1,1,1));
        Pr.add(tab, estilo(0,2,3,1));
        
    }
}
