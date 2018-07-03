package Vista.Compra;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Nuevos extends JDialog implements ActionListener {

    JLabel lnombre;
    JTextField nombre;
    JButton aceptar, cancelar;
    private String Name;

    public Nuevos(String Name) {
        this.Name = Name;
        this.setTitle(Name);
        this.setModal(true);
        this.setResizable(true);
        this.setSize(400, 200);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        crea();
        agrega();
        aceptar.addActionListener(this);
        cancelar.addActionListener(this);

    }

    private void crea() {
        lnombre = new JLabel("Nombre del " + Name);
        nombre = new JTextField(25);
        aceptar = new JButton("Agregar");
        cancelar = new JButton("Cancelar");
    }

    private void agrega() {
        JLabel v = new JLabel("  ");
        JLabel v1 = new JLabel("  ");
        JLabel v2 = new JLabel("  ");
        add(v1, estilo(0, 0, 1, 1, GridBagConstraints.CENTER));
        add(v2, estilo(5, 0, 1, 1, GridBagConstraints.CENTER));
        add(lnombre, estilo(1, 1, 3, 1, GridBagConstraints.CENTER));
        add(nombre, estilo(1, 2, 3, 1, GridBagConstraints.BOTH));
        add(v, estilo(1, 3, 3, 1, GridBagConstraints.CENTER));
        add(aceptar, estilo(1, 4, 1, 1, GridBagConstraints.CENTER));
        add(cancelar, estilo(3, 4, 1, 1, GridBagConstraints.CENTER));
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
        if (ae.getSource().equals(aceptar)) {
            this.dispose();
        }
        if (ae.getSource().equals(cancelar)) {
            this.dispose();
        }
    }

}
