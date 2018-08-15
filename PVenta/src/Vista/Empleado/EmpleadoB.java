/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Empleado;

import VistasGenerales.Panel;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import Controlador.Empleado.AgregaEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author landr
 */
public class EmpleadoB extends VistasGenerales.Panel implements ActionListener {

    final String cols[] = {"Nombre", "Usuario", "Notas"};
    VistasGenerales.Tabla tab;
    JButton c, ca;
    JLabel u, no, v1, v2, v3, v4, v5, v6, va, vb, vc, vd, ve, vf, el;
    JComboBox n;
    public Panel Pb = new Panel();
    Container co2 = new Container();
    Container co = new Container();
    AgregaEmpleado ea = new AgregaEmpleado();

    public EmpleadoB() {
        crea();
        carga();
        if (ea.vacio("empleados") > 0) {
            
            llenaNombre();
            llenaUsuario();
            llenaNota();
        }
        n.addActionListener(this);
    }

    private void crea() {
        n = new JComboBox();
        u = new JLabel("Usuario");
        u.setHorizontalAlignment(JLabel.CENTER);
        no = new JLabel();
        no.setHorizontalAlignment(JLabel.CENTER);
        c = new JButton("Eliminar usuario");
        el = new JLabel(" ");
        ca = new JButton("Cancelar");

        v1 = new JLabel(" ");
        v2 = new JLabel(" ");
        v3 = new JLabel(" ");
        v4 = new JLabel(" ");
        v5 = new JLabel(" ");
        v6 = new JLabel(" ");
        va = new JLabel(" ");
        vb = new JLabel(" ");
        vc = new JLabel(" ");
        vd = new JLabel(" ");
        ve = new JLabel(" ");
        vf = new JLabel(" ");

        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);

        setLayout(new GridBagLayout());
        Pb.setLayout(new GridLayout(1, 2));
        co2.setLayout(new GridLayout(7, 1));
        co.setLayout(new GridLayout(5, 1));
    }

    private void llenaNombre() {
        Object O[] = ea.getName();
        for (int i = 0; i < O.length; i++) {
            n.addItem(O[i]);
        }
    }

    private void llenaUsuario() {
        String Nom = n.getSelectedItem().toString();
        String con = ea.getUsuario(Nom);
        u.setText(con);
    }

    private void llenaNota() {
        String Nom = n.getSelectedItem().toString();

        String con = ea.getNota(Nom);
        no.setText(con);
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

    private void carga() {
        co.add(v1);
        co.add(n);
        co.add(u);
        co.add(no);
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

        add(va, estilo(0, 0, 3, 1));
        add(vd, estilo(0, 1, 1, 1));
        add(Pb, estilo(1, 1, 1, 1));
        add(ve, estilo(2, 1, 1, 1));
        add(tab, estilo(0, 2, 3, 1));

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(n)) {
            if (ea.vacio("empleados") > 0) {
                llenaUsuario();
                llenaNota();
            }
        }

    }
}
