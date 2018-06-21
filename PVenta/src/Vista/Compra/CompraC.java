package Vista.Compra;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CompraC extends VistasGenerales.Panel {

    final String cols[] = {"Codigo", "Producto", "Cantidad",
        "Tipo", "Piel", "Modelo", "Color", "proveedor", "Descripción"};

    JPanel P = new JPanel();
    JPanel inter1 = new JPanel();
    VistasGenerales.Tabla tab;
    JLabel lproducto, lcantidad, ltipo, lpiel, lproveedor, lcolor,
            lmodelo, ldescripcion, imagen, lcosto;

    JComboBox producto, tipo, piel, proveedor, modelo;
    JTextField color, descripcion;
    JButton acepta, agrega, btipo, bpiel, bproveedor, bmodelo;
    JCheckBox nuevo;
    VistasGenerales.Number cantidad, costo;

    public CompraC() {
        this.setLayout(new GridBagLayout());
        inter1.setLayout(new GridBagLayout());
        crea();
        agrega();
        tooltip();

    }

    private void crea() {
        nuevo = new JCheckBox("Producto nuevo");
        nuevo.setFocusable(false);
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        producto = new JComboBox();
        tipo = new JComboBox();
        piel = new JComboBox();
        proveedor = new JComboBox();
        modelo = new JComboBox();
        color = new JTextField();
        descripcion = new JTextField();
        imagen = new JLabel();
        ltipo = new JLabel("Tipo  ");
        ltipo.setHorizontalAlignment(JLabel.RIGHT);
        lpiel = new JLabel("Piel  ");
        lpiel.setHorizontalAlignment(JLabel.RIGHT);
        lproveedor = new JLabel("Proveedor  ");
        lproveedor.setHorizontalAlignment(JLabel.RIGHT);
        lcolor = new JLabel("Color  ");
        lcolor.setHorizontalAlignment(JLabel.RIGHT);
        lmodelo = new JLabel("Modelo  ");
        lmodelo.setHorizontalAlignment(JLabel.RIGHT);
        ldescripcion = new JLabel("Descripción  ");
        ldescripcion.setHorizontalAlignment(JLabel.RIGHT);
        lproducto = new JLabel("Producto   ");
        lproducto.setHorizontalAlignment(JLabel.RIGHT);
        lcantidad = new JLabel("Cantidad   ");
        lcantidad.setHorizontalAlignment(JLabel.RIGHT);
        cantidad = new VistasGenerales.Number();
        acepta = new JButton("Compra");
        acepta.setFocusable(false);
        agrega = new JButton("Agrega");
        agrega.setFocusable(false);
        btipo = new JButton("+");
        btipo.setFocusable(false);
        bpiel = new JButton("+");
        bpiel.setFocusable(false);
        bproveedor = new JButton("+");
        bproveedor.setFocusable(false);
        bmodelo = new JButton("+");
        bmodelo.setFocusable(false);
    }

    private void tooltip() {
        color.setToolTipText("Color del\n producto");
        descripcion.setToolTipText("Especificación\n del producto");
        btipo.setToolTipText("Agrega un tipo\nde producto.");
        bpiel.setToolTipText("Agrega un tipo\nde piel.");
        bproveedor.setToolTipText("Agrega un\nproveedor");
        bmodelo.setToolTipText("Agrega un\nmodelo");
        nuevo.setToolTipText("Selecciona si el producto aun no existe.");
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
        JLabel v3 = new JLabel("  ");
        JLabel v4 = new JLabel("  ");
        JLabel v5 = new JLabel("  ");
        //imagen
        gbc = estilo(0, 0, 5, 8, GridBagConstraints.BOTH);
        inter1.add(imagen, gbc);
        ImageIcon image = new ImageIcon("Recursos\\Img\\Default.jpg");
        Dimension d = super.getToolkit().getScreenSize();
        image = new ImageIcon(image.getImage().getScaledInstance(((d.width / 12) * 2), ((d.width / 12) * 2), Image.SCALE_DEFAULT));
        imagen.setIcon(image);
        //Separador
        gbc = estilo(0, 7, 1, 1, GridBagConstraints.BOTH);
        inter1.add(v4, gbc);
        //Nuevo
        gbc = estilo(0, 8, 5, 1, GridBagConstraints.BOTH);
        inter1.add(nuevo, gbc);
        //Acepta
        gbc = estilo(0, 9, 5, 1, GridBagConstraints.BOTH);
        inter1.add(acepta, gbc);
        //Producto
        gbc = estilo(4, 0, 1, 1, GridBagConstraints.BOTH);
        inter1.add(lproducto, gbc);
        gbc = estilo(5, 0, 2, 1, GridBagConstraints.BOTH);
        inter1.add(producto, gbc);
        //cantidad
        gbc = estilo(7, 0, 1, 1, GridBagConstraints.BOTH);
        inter1.add(lcantidad, gbc);
        gbc = estilo(8, 0, 1, 1, GridBagConstraints.BOTH);
        inter1.add(cantidad.tf, gbc);
        //Tipo
        gbc = estilo(9, 0, 1, 1, GridBagConstraints.BOTH);
        inter1.add(ltipo, gbc);
        Container c1 = new Container();
        c1.setLayout(new BorderLayout());
        c1.add(tipo, BorderLayout.CENTER);
        c1.add(btipo, BorderLayout.EAST);
        gbc = estilo(10, 0, 2, 1, GridBagConstraints.BOTH);
        inter1.add(c1, gbc);
        //vacio
        gbc = estilo(12, 0, 1, 1, GridBagConstraints.BOTH);
        inter1.add(v5, gbc);
        //Separador
        gbc = estilo(4, 1, 1, 1, GridBagConstraints.BOTH);
        inter1.add(v1, gbc);
        //Piel
        gbc = estilo(4, 3, 1, 1, GridBagConstraints.BOTH);
        inter1.add(lpiel, gbc);
        Container c3 = new Container();
        c3.setLayout(new BorderLayout());
        c3.add(piel, BorderLayout.CENTER);
        c3.add(bpiel, BorderLayout.EAST);
        gbc = estilo(5, 3, 2, 1, GridBagConstraints.BOTH);
        inter1.add(c3, gbc);
        //modelo
        gbc = estilo(7, 3, 1, 1, GridBagConstraints.BOTH);
        inter1.add(lmodelo, gbc);
        Container c2 = new Container();
        c2.setLayout(new BorderLayout());
        c2.add(modelo, BorderLayout.CENTER);
        c2.add(bmodelo, BorderLayout.EAST);
        gbc = estilo(8, 3, 2, 1, GridBagConstraints.BOTH);
        inter1.add(c2, gbc);
        //color
        gbc = estilo(10, 3, 1, 1, GridBagConstraints.BOTH);
        inter1.add(lcolor, gbc);
        gbc = estilo(11, 3, 1, 1, GridBagConstraints.BOTH);
        inter1.add(color, gbc);
        //Separador
        gbc = estilo(4, 4, 1, 1, GridBagConstraints.BOTH);
        inter1.add(v3, gbc);
        //Proveedor
        gbc = estilo(4, 6, 1, 1, GridBagConstraints.BOTH);
        inter1.add(lproveedor, gbc);
        Container c4 = new Container();
        c4.setLayout(new BorderLayout());
        c4.add(proveedor, BorderLayout.CENTER);
        c4.add(bproveedor, BorderLayout.EAST);
        gbc = estilo(5, 6, 2, 1, GridBagConstraints.BOTH);
        inter1.add(c4, gbc);

        gbc = estilo(7, 6, 1, 1, GridBagConstraints.BOTH);
        inter1.add(ldescripcion, gbc);
        gbc = estilo(8, 6, 2, 1, GridBagConstraints.BOTH);
        inter1.add(descripcion, gbc);

        gbc = estilo(11, 6, 1, 1, GridBagConstraints.BOTH);
        inter1.add(agrega, gbc);

        gbc = estilo(0, 0, 5, 2, GridBagConstraints.BOTH);
        add(inter1, gbc);
        gbc = estilo(0, 2, 5, 4, GridBagConstraints.BOTH);
        add(tab, gbc);

    }
}
