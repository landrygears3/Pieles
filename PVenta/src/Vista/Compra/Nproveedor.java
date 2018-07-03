/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Compra;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author landr
 */
public class Nproveedor extends JDialog implements ActionListener {

    JLabel lnombre, lcorreos, ltelefonos;
    JTextField nombre, correos;
    VistasGenerales.Number telefonos;
    VistasGenerales.Tabla tTelefono, Tcorreos;
    JButton aceptar, cancelar;

    public Nproveedor() {
        this.setTitle("Proveedor");
        this.setModal(true);
        this.setResizable(true);
        this.setSize(600, 400);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        crea();
        agrega();
        cancelar.addActionListener(this);
        aceptar.addActionListener(this);
        correos.addActionListener(this);
        telefonos.tf.addActionListener(this);

    }

    private void crea() {
        lnombre = new JLabel("Nombre del proveedor");
        nombre = new JTextField();
        lcorreos = new JLabel("Correo");
        correos = new JTextField();
        ltelefonos = new JLabel("Telefono");
        telefonos = new VistasGenerales.Number();
        aceptar = new JButton("Agregar");
        cancelar = new JButton("Cancelar");
        tTelefono = new VistasGenerales.Tabla();
        String t[] = {"Telefono"};
        tTelefono.setColum(t);
        Tcorreos = new VistasGenerales.Tabla();
        String c[] = {"Correos"};
        Tcorreos.setColum(c);

    }

    private void agrega() {
        JLabel v1 = new JLabel(" ");
        JLabel v2 = new JLabel(" ");
        JLabel v3 = new JLabel(" ");
        JLabel v4 = new JLabel(" ");
        JLabel v5 = new JLabel(" ");
        add(v4, estilo(0, 0, 1, 1, GridBagConstraints.CENTER));
        add(v5, estilo(6, 0, 1, 1, GridBagConstraints.CENTER));
        add(lnombre, estilo(1, 1, 2, 1, GridBagConstraints.CENTER));
        add(nombre, estilo(1, 2, 2, 1, GridBagConstraints.BOTH));
        add(v3, estilo(1, 3, 2, 1, GridBagConstraints.BOTH));
        add(ltelefonos, estilo(1, 4, 1, 1, GridBagConstraints.CENTER));
        add(telefonos.tf, estilo(1, 5, 1, 1, GridBagConstraints.BOTH));
        add(tTelefono, estilo(2, 4, 1, 3, GridBagConstraints.BOTH));
        add(v1, estilo(1, 6, 1, 1, GridBagConstraints.BOTH));
        add(lcorreos, estilo(1, 7, 1, 1, GridBagConstraints.CENTER));
        add(correos, estilo(1, 8, 1, 1, GridBagConstraints.BOTH));
        add(Tcorreos, estilo(2, 7, 1, 3, GridBagConstraints.BOTH));
        add(v2, estilo(1, 9, 1, 1, GridBagConstraints.CENTER));
        add(aceptar, estilo(1, 10, 1, 1, GridBagConstraints.CENTER));
        add(cancelar, estilo(2, 10, 1, 1, GridBagConstraints.CENTER));
    }

    private void limpia() {
        nombre.setText("");
        telefonos.tf.setText("");
        correos.setText("");
        Tcorreos.limpa();
        tTelefono.limpa();

    }

    private GridBagConstraints estilo(int pox, int poy, int tax, int tay, int fill) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = pox;
        gbc.gridy = poy;
        gbc.gridwidth = tax;
        gbc.gridheight = tay;
        gbc.fill = fill;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        return gbc;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(cancelar)) {
            limpia();
            this.dispose();
        }
        if (ae.getSource().equals(aceptar)) {
            this.dispose();
        }

        if (ae.getSource().equals(correos)) {
            if (!correos.getText().equals("")) {
                boolean d = true;
                Object aux[][] = Tcorreos.getD();
                for (int i = 0; i < Tcorreos.DatosC(); i++) {
                    if (correos.getText().equals(aux[i][0].toString())) {
                        d = false;
                        JOptionPane.showMessageDialog(null, "Ya ah ingresado ese coreo");
                        break;
                    }
                }
                if (d) {
                    
                    Object o[][] = new Object[1][1];
                    o[0][0] = correos.getText();
                    correos.setText("");
                    Tcorreos.setRow(o);
                }
            }
        }

        if (ae.getSource().equals(telefonos.tf)) {
            if (!telefonos.tf.getText().equals("")) {
                boolean d = true;
                Object aux[][] = tTelefono.getD();
                for (int i = 0; i < tTelefono.DatosC(); i++) {
                    if (telefonos.tf.getText().equals(aux[i][0].toString())) {
                        d = false;
                        JOptionPane.showMessageDialog(null, "Ya ah ingresado ese coreo");
                        break;
                    }
                }
                if (d) {
                    Object o[][] = new Object[1][1];
                    o[0][0] = telefonos.tf.getText();
                    telefonos.tf.setText("");
                    tTelefono.setRow(o);
                }
            }
        }

    }
}
