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
import Controlador.Empleado.EmpleadoV;
import Controlador.Empleado.Modificaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Controlador.General.General;

/**
 *
 * @author landr
 */
public class EmpleadoB extends VistasGenerales.Panel implements ActionListener {

    final String cols[] = {"Empleado", "Teléfono", "Usuario", "Contraseña", "Cargo", "Sucursal", "Contratación"};
    VistasGenerales.Tabla tab;
    JButton c, re;
    JLabel u, no, v1, v2, v3, v4, v5, v6, va, vb, vc, vd, ve, vf, el;
    JComboBox n;
    public Panel Pb = new Panel();
    Container co2 = new Container();
    Container co = new Container();
    AgregaEmpleado ea = new AgregaEmpleado();
    EmpleadoV ev = new EmpleadoV();
    Modificaciones M = new Modificaciones();
    General g = new General();

    public EmpleadoB() {
        
        crea();
        carga();
        if (g.vacio("empleados")>0){
        llenaNombre();
        if (ev.resp("empleados")) {
            llena();
        }
       }
        n.addActionListener(this);
        c.addActionListener(this);
        re.addActionListener(this);
    }

    private void crea() {
        n = new JComboBox();
        u = new JLabel("Usuario");
        u.setHorizontalAlignment(JLabel.CENTER);
        no = new JLabel();
        no.setHorizontalAlignment(JLabel.CENTER);
        c = new JButton("Eliminar usuario");
        re = new JButton("Recontratar usuario");
        el = new JLabel(" ");

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
    
    
    private void llena() {
        tab.setRow(ev.getDatos());
    }
    
    final public void llenaNombre() {
        if (n.getItemCount()>0){
            n.removeAllItems();
        }
        Object O[] = g.getName();
        for (int i = 0; i < O.length; i++) {
            n.addItem(O[i]);
        }
    }

    final public void llenaUsuario() {
        String Nom = n.getSelectedItem().toString();
        String con = g.getUsuario(Nom);
        u.setText(con);
    }

    private void llenaNota() {
        String Nom = n.getSelectedItem().toString();

        String con = g.getNota(Nom);
        g.getEstado(Nom);
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
        co2.add(re);
        co2.add(v4);
        co2.add(c);
        co2.add(v5);
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
            if(n.getItemCount()>0){
            llenaUsuario();
            llenaNota();
            }
        }
        
        if (ae.getSource().equals(c)) {
            String campos = "Estado";
            if (JOptionPane.showConfirmDialog(null, "Esta a punto de"
                    + " dar de baja al usuario." +
                    n.getSelectedItem().toString() + "\t\n¿Desea continuar?") == 0) {
                ea.elimina(campos, "0", n.getSelectedItem().toString(), u.getText());
            }
                            
            
        }
        if (ae.getSource().equals(re)) {
            String campos = "Estado";
            if (JOptionPane.showConfirmDialog(null, "Esta a punto de"
                    + " dar de Recuperar al usuario." +
                    n.getSelectedItem().toString() + "\t\n¿Desea continuar?") == 0) {
                ea.elimina(campos, "1", n.getSelectedItem().toString(), u.getText());
            }
                            
            
        }
    }
}
