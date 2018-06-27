package Vista.Permisos;

import com.toedter.calendar.JDateChooser;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class Agrega extends VistasGenerales.Panel {
    JPanel p=new JPanel(new GridBagLayout());
    JDateChooser fecha;

    public Agrega() {
        crea();
        agrega();
    }

    private void crea() {
        fecha = new JDateChooser();
    }

    private void agrega() {
        add(fecha);
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
}
