/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Empleado;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Controlador.Empleado.Sucursal;

/**
 *
 * @author landr
 */
public class NSucursal extends JDialog implements ActionListener {
     Sucursal prov=new Sucursal();
    JLabel descripcion, Permiso, Tel;
    JTextField Nombre, Direccion;
    JButton aceptar, cancelar;
    VistasGenerales.Number Telefono;

    public NSucursal() {
        this.setTitle("Sucursales");
        this.setModal(true);
        this.setResizable(true);
        this.setSize(600, 400);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        crea();
        agrega();
        cancelar.addActionListener(this);
        aceptar.addActionListener(this);
    }

    private void crea() {
        Permiso = new JLabel("Nombre de la sucursal");
        Nombre = new JTextField();
        Nombre.setToolTipText("Aquí va el nombre de la sucursal que desea agregar");
        descripcion = new JLabel("Dirección");
        Direccion = new JTextField();
        Direccion.setToolTipText("Dirección de la sucursal");
        Tel = new JLabel("Telefono");
        Telefono = new VistasGenerales.Number();
        Telefono.tf.setToolTipText("Los números telefónicos tienen 10"
                + " dígitos sin separaciones ni espacios.");
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
        add(Permiso, estilo(1, 1, 2, 1, GridBagConstraints.CENTER));
        add(Nombre, estilo(1, 2, 2, 1, GridBagConstraints.BOTH));
        add(v3, estilo(1, 3, 2, 1, GridBagConstraints.BOTH));
        add(descripcion, estilo(1, 4, 2, 1, GridBagConstraints.CENTER));
        add(Direccion, estilo(1, 5, 2, 1, GridBagConstraints.BOTH));
        add(v1, estilo(1, 6, 1, 1, GridBagConstraints.BOTH));
        add(Tel, estilo(1, 7, 2, 1, GridBagConstraints.CENTER));
        add(Telefono.tf, estilo(1, 8, 2, 1, GridBagConstraints.BOTH));
        add(v2, estilo(1, 9, 2, 1, GridBagConstraints.CENTER));
        add(aceptar, estilo(1, 10, 1, 1, GridBagConstraints.CENTER));
        add(cancelar, estilo(2, 10, 1, 1, GridBagConstraints.CENTER));
    }

    public void limpia() {
        Nombre.setText("");
        Direccion.setText("");
        Telefono.tf.setText("");

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
