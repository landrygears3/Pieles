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
import javax.swing.JTextField;

/**
 *
 * @author landr
 */
public class Nproveedor extends JDialog implements ActionListener {
    Controlador.Compra.Proveedor prov=new Controlador.Compra.Proveedor();
    JLabel lnombre, lcorreos, ltelefonos;
    JTextField nombre, correos;
    VistasGenerales.Number telefonos;
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
        add(ltelefonos, estilo(1, 4, 2, 1, GridBagConstraints.CENTER));
        add(telefonos.tf, estilo(1, 5, 2, 1, GridBagConstraints.BOTH));
        add(v1, estilo(1, 6, 1, 1, GridBagConstraints.BOTH));
        add(lcorreos, estilo(1, 7, 2, 1, GridBagConstraints.CENTER));
        add(correos, estilo(1, 8, 2, 1, GridBagConstraints.BOTH));
        add(v2, estilo(1, 9, 2, 1, GridBagConstraints.CENTER));
        add(aceptar, estilo(1, 10, 1, 1, GridBagConstraints.CENTER));
        add(cancelar, estilo(2, 10, 1, 1, GridBagConstraints.CENTER));
    }

    public void limpia() {
        nombre.setText("");
        telefonos.tf.setText("");
        correos.setText("");

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
        

    }
}
