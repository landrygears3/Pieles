package Vista.Inventario;

import Controlador.Inventario.InventarioV;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InventarioM extends VistasGenerales.Panel {

    final String cols[] = {"Inventario", "Producto", "Tipo", "Modelo",
        "Proveedor", "Color", "Piel", "Cantidad", "Precio",
        "Venta", "Mayoreo", "Sucursal"};
    final Object o[] = {"Inventario", "Producto", "Tipo", "Modelo",
        "Proveedor", "Color", "Piel", "Cantidad", "Precio",
        "Venta", "Sucursal"};

    JPanel P = new JPanel();
    JPanel inter1 = new JPanel();
    VistasGenerales.Tabla tab;
    JLabel tipobu1;
    JComboBox tipobu;
    JTextField Bus;
    InventarioV iv = new InventarioV();

    public InventarioM() {
        this.setLayout(new GridBagLayout());
        P.setLayout(new GridLayout(2, 2));
        inter1.setLayout(new GridBagLayout());
        crea();
        agrega();
        
        if (iv.respn("inventario", "productos", "tipos", "modelos", "piel", "proveedores", "sucursal")) {
            llena();
        }

    }

    private void crea() {
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);

        tipobu1 = new JLabel("Tipo de busqueda ");
        tipobu1.setHorizontalAlignment(JLabel.RIGHT);
        tipobu = new JComboBox(o);
        Bus = new JTextField();

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
        GridBagConstraints gbc;
        JLabel v1 = new JLabel("  ");
        gbc = estilo(0, 0, 1, 1, GridBagConstraints.BOTH);
        inter1.add(tipobu1, gbc);
        gbc = estilo(1, 0, 1, 1, GridBagConstraints.BOTH);
        inter1.add(tipobu, gbc);
        gbc = estilo(0, 1, 1, 1, GridBagConstraints.BOTH);
        inter1.add(v1, gbc);
        gbc = estilo(0, 2, 2, 1, GridBagConstraints.BOTH);
        inter1.add(Bus, gbc);
        P.add(inter1);

        gbc = estilo(0, 0, 4, 2, GridBagConstraints.PAGE_START);
        add(P, gbc);
        gbc = estilo(0, 2, 4, 4, GridBagConstraints.BOTH);
        add(tab, gbc);
    }
    
    private void llena() {
        tab.setRow(iv.getDatos());
    }
}
