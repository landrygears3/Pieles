package Vista.Compra;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompraC extends VistasGenerales.Panel {

    final String cols[] = {"Codigo", "Producto", "Cantidad", "Descripción"};

    JPanel P = new JPanel();
    JPanel inter1 = new JPanel();
    VistasGenerales.Tabla tab;
    JLabel lproducto;
    JLabel lcantidad;
    JComboBox producto;
    JButton acepta;
    JButton agrega;
    VistasGenerales.Number cantidad;

    public CompraC() {
        this.setLayout(new GridBagLayout());
        P.setLayout(new GridLayout(2, 2));
        inter1.setLayout(new GridLayout(5, 2));
        crea();
        agrega();

    }

    private void crea() {
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);

        lproducto = new JLabel("Producto   ");
        lproducto.setHorizontalAlignment(JLabel.RIGHT);
        lcantidad = new JLabel("Cantidad   ");
        lcantidad.setHorizontalAlignment(JLabel.RIGHT);
        producto = new JComboBox();
        cantidad = new VistasGenerales.Number();
        acepta = new JButton("Compra");
        acepta.setFocusable(false);
        agrega = new JButton("Agrega");
        agrega.setFocusable(false);
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

    private void agrega() {
        JLabel v1 = new JLabel();
        JLabel v2 = new JLabel();
         JLabel v3 = new JLabel();
        JLabel v4 = new JLabel();
        inter1.add(lproducto);
        inter1.add(producto);
        inter1.add(v1);
        inter1.add(v2);
        inter1.add(lcantidad);
        inter1.add(cantidad.tf);
        inter1.add(v3);
        inter1.add(v4);
        inter1.add(agrega);
        inter1.add(acepta);
        P.add(inter1);
        

        GridBagConstraints gbc;
        gbc = estilo(0, 0, 4, 2,GridBagConstraints.PAGE_START);
        add(P, gbc);
        gbc = estilo(0, 2, 4, 4, GridBagConstraints.BOTH);
        add(tab, gbc);
    }
}
