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
    JButton aceptar;
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

    }

    private void crea() {
        lnombre = new JLabel("Nombre del " + Name);
        nombre = new JTextField(25);
        aceptar = new JButton("Agregar");
    }

    private void agrega() {
        JLabel v = new JLabel("  ");
        add(lnombre, estilo(0, 0, 1, 1, GridBagConstraints.CENTER));
        add(nombre, estilo(0, 1, 1, 1, GridBagConstraints.BOTH));
        add(v, estilo(0, 2, 1, 1, GridBagConstraints.CENTER));
        add(aceptar, estilo(0, 3, 1, 1, GridBagConstraints.CENTER));
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
        this.dispose();
    }

}
