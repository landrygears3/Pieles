package Vista.Compra;

import Controlador.Compra.CompraN;
import Controlador.Inventario.Inventario;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CompraC extends VistasGenerales.Panel implements ActionListener {

    CompraN comprar = new CompraN();
    Inventario inv = new Inventario();
    Vista.Compra.Sucursal suc = new Vista.Compra.Sucursal();
    //tipo, modelo, piel, proveedor, nombre, color, descripción, imagen
    final String cols[] = {"Tipo", "Modelo",
        "Piel", "Proveedor", "Nombre", "Color", "Descripción", "Cantidad", "Costo", "Mayoreo", "Venta"};

    JPanel P = new JPanel();
    JPanel costos = new JPanel();
    JPanel inter1 = new JPanel();
    VistasGenerales.Tabla tab;
    JLabel lproducto, lcantidad, ltipo, lpiel, lproveedor, lcolor,
            lmodelo, ldescripcion, imagen, lcosto, lcostov, lcostom;

    JComboBox producto, tipo, piel, proveedor, modelo;
    JTextField color, descripcion, productot;
    JButton acepta, agrega, btipo, bpiel, bproveedor, bmodelo;
    Nuevos ntipo, npiel, nmodelo;
    Nproveedor nproveedor;
    JCheckBox nuevo;
    VistasGenerales.Number cantidad, costo, costov, costom;

    public CompraC() {
        this.setLayout(new GridBagLayout());
        inter1.setLayout(new GridBagLayout());
        crea();
        agrega();
        tooltip();
        vista(false);
        btipo.addActionListener(this);
        bmodelo.addActionListener(this);
        bpiel.addActionListener(this);
        bproveedor.addActionListener(this);
        nuevo.addActionListener(this);
        npiel.aceptar.addActionListener(this);
        nmodelo.aceptar.addActionListener(this);
        ntipo.aceptar.addActionListener(this);
        nproveedor.aceptar.addActionListener(this);
        this.agrega.addActionListener(this);
        this.producto.addActionListener(this);
        this.acepta.addActionListener(this);
        inicia();
        llena();
    }

    private void inicia() {
        llenaPiel();
        llenaModelo();
        llenaTipo();
        llenaProveedor();
        llenaProdictos();
    }

    private void llena() {

        Object o[] = comprar.getDatos(producto.getSelectedIndex());

        if (o != null) {
            tipo.setSelectedItem(ntipo.nuevo.getName(o[0].toString()));
            modelo.setSelectedItem(nmodelo.nuevo.getName(o[1].toString()));
            piel.setSelectedItem(npiel.nuevo.getName(o[2].toString()));
            proveedor.setSelectedItem(nproveedor.prov.getName(o[3].toString()));
            color.setText(o[5].toString());
            descripcion.setText(o[6].toString());
        }

    }

    private void crea() {
        nuevo = new JCheckBox("Producto nuevo");
        nuevo.setFocusable(false);
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        producto = new JComboBox();
        productot = new JTextField();
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
        lcosto = new JLabel("Compra  ");
        lcosto.setHorizontalAlignment(JLabel.RIGHT);
        lcostov = new JLabel("Venta  ");
        lcostov.setHorizontalAlignment(JLabel.RIGHT);
        lcostom = new JLabel("Mayoreo  ");
        lcostom.setHorizontalAlignment(JLabel.RIGHT);
        costo = new VistasGenerales.Number("D");
        costov = new VistasGenerales.Number("D");
        costom = new VistasGenerales.Number("D");
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
        ntipo = new Nuevos("Tipo");
        npiel = new Nuevos("Piel");
        nmodelo = new Nuevos("Modelo");
        nproveedor = new Nproveedor();

    }

    private void tooltip() {
        color.setToolTipText("Color del producto");
        descripcion.setToolTipText("Especificación del producto");
        btipo.setToolTipText("Agrega un tipo de producto.");
        bpiel.setToolTipText("Agrega un tipo de piel.");
        bproveedor.setToolTipText("Agrega un proveedor");
        bmodelo.setToolTipText("Agrega un modelo");
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
        inter1.add(productot, gbc);
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
        //Agrega
        gbc = estilo(10, 9, 2, 1, GridBagConstraints.BOTH);
        inter1.add(agrega, gbc);

        //costo
        costos.setBorder(BorderFactory.createTitledBorder("Costos"));
        costos.setLayout(new GridBagLayout());
        gbc = estilo(0, 0, 1, 1, GridBagConstraints.BOTH);
        costos.add(lcosto, gbc);
        gbc = estilo(1, 0, 1, 1, GridBagConstraints.BOTH);
        costos.add(costo.tf, gbc);
        gbc = estilo(0, 1, 1, 1, GridBagConstraints.BOTH);
        costos.add(lcostov, gbc);
        gbc = estilo(1, 1, 1, 1, GridBagConstraints.BOTH);
        costos.add(costov.tf, gbc);
        gbc = estilo(0, 2, 1, 1, GridBagConstraints.BOTH);
        costos.add(lcostom, gbc);
        gbc = estilo(1, 2, 1, 1, GridBagConstraints.BOTH);
        costos.add(costom.tf, gbc);

        gbc = estilo(11, 6, 1, 2, GridBagConstraints.BOTH);
        inter1.add(costos, gbc);

        gbc = estilo(0, 0, 5, 2, GridBagConstraints.BOTH);
        add(inter1, gbc);
        gbc = estilo(0, 2, 5, 4, GridBagConstraints.BOTH);
        add(tab, gbc);

    }

    private void limpia() {
        productot.setText("");
        color.setText("");
        descripcion.setText("");
        cantidad.tf.setText("");
        costo.tf.setText("");
        costov.tf.setText("");
        costom.tf.setText("");
    }

    private void vista(boolean b) {
        producto.setVisible(!b);
        productot.setVisible(b);
        bmodelo.setVisible(b);
        bproveedor.setVisible(b);
        bpiel.setVisible(b);
        btipo.setVisible(b);
        modelo.setEnabled(b);
        proveedor.setEnabled(b);
        piel.setEnabled(b);
        tipo.setEnabled(b);
        color.setEnabled(b);
        descripcion.setEnabled(b);

    }

    private void llenaPiel() {
        Object o[] = npiel.nuevo.getPieles();
        for (int i = 0; i < o.length; i++) {
            piel.addItem(o[i]);
        }
    }

    private void llenaTipo() {
        Object o[] = ntipo.nuevo.getTipos();
        for (int i = 0; i < o.length; i++) {
            tipo.addItem(o[i]);
        }
    }

    private void llenaProdictos() {
        producto.removeAllItems();
        Object O[] = comprar.getName();
        for (int i = 0; i < O.length; i++) {
            producto.addItem(O[i]);
        }

    }

    private void llenaModelo() {
        Object o[] = nmodelo.nuevo.getModelos();
        for (int i = 0; i < o.length; i++) {
            modelo.addItem(o[i]);
        }
    }

    private void llenaProveedor() {
        Object o[] = nproveedor.prov.getProveedor();
        for (int i = 0; i < o.length; i++) {
            proveedor.addItem(o[i]);
        }
    }

    private boolean validaCant() {
        boolean ca;
        if (cantidad.tf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingrear una cantidad.");
            return false;
        } else {
            if (cantidad.getNum() == 0) {
                JOptionPane.showMessageDialog(null, "Debe ingrear una cantidad mayor a 0.");
                return false;
            } else {
                ca = true;
            }
        }

        if (costo.tf.getText().equals("") || costov.tf.getText().equals("") || costom.tf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingrear un costo.");
            return false;
        } else {
            if (costo.getNum() == 0 || costov.getNum() == 0 || costom.getNum() == 0) {
                JOptionPane.showMessageDialog(null, "Debe ingrear un costo mayor a 0.");
                return false;
            } else {
                ca = true;
            }
        }
        return ca;
    }

    private void limpiaCant() {
        cantidad.tf.setText("");
        costo.tf.setText("");
        costov.tf.setText("");
        costom.tf.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(acepta)) {
            suc.setVisible(true);
            inv.alta(suc.getSucursal());
            tab.limpa();
        }

        if (ae.getSource().equals(this.producto)) {
            if (producto.getItemCount() != 0) {

                llena();
            }
        }
        if (ae.getSource().equals(btipo)) {
            ntipo.setVisible(true);
        }

        if (ae.getSource().equals(bmodelo)) {
            nmodelo.setVisible(true);
        }

        if (ae.getSource().equals(bpiel)) {
            npiel.setVisible(true);
        }
        if (ae.getSource().equals(bproveedor)) {
            nproveedor.setVisible(true);
        }
        if (ae.getSource().equals(nuevo)) {

            vista(nuevo.isSelected());
            limpia();

        }

        if (ae.getSource().equals(npiel.aceptar)) {
            npiel.b = npiel.nuevo.agrega(npiel.Name, npiel.nombre.getText());
            if (npiel.b) {

                npiel.dispose();
            }

            if (npiel.getVal()) {
                piel.removeAllItems();
                llenaPiel();
            }
        }
        if (ae.getSource().equals(nmodelo.aceptar)) {
            nmodelo.b = nmodelo.nuevo.agrega(nmodelo.Name, nmodelo.nombre.getText());
            if (nmodelo.b) {

                nmodelo.dispose();
            }

            if (nmodelo.getVal()) {
                modelo.removeAllItems();
                llenaModelo();
            }
        }

        if (ae.getSource().equals(ntipo.aceptar)) {
            ntipo.b = ntipo.nuevo.agrega(ntipo.Name, ntipo.nombre.getText());
            if (ntipo.b) {

                ntipo.dispose();
            }

            if (ntipo.getVal()) {
                tipo.removeAllItems();
                llenaTipo();
            }
        }

        if (ae.getSource().equals(nproveedor.aceptar)) {
            Object O[] = new Object[3];
            O[0] = nproveedor.nombre.getText();
            O[1] = nproveedor.telefonos.tf.getText();
            O[2] = nproveedor.correos.getText();
            nproveedor.prov.b = nproveedor.prov.agrega(O);
            if (nproveedor.prov.b) {
                nproveedor.dispose();
                nproveedor.limpia();
                proveedor.removeAllItems();
                llenaProveedor();

            }

        }

        if (ae.getSource().equals(this.agrega)) {

            if (nuevo.isSelected()) {
                if (validaCant()) {
                    Object O[] = {color.getText(), descripcion.getText(),
                        productot.getText(), cantidad.tf.getText(), costo.tf.getText()};
                    if (comprar.valida(O)) {
//                    "ID_Tipo,ID_Modelo,ID_Piel,"
//                + "ID_Proveedor,Nombre,Color,Descripcion"

                        Object o[] = {ntipo.nuevo.getID(tipo.getSelectedIndex()),
                            nmodelo.nuevo.getID(modelo.getSelectedIndex()),
                            npiel.nuevo.getID(piel.getSelectedIndex()),
                            nproveedor.prov.getID(proveedor.getSelectedIndex()),
                            productot.getText(), color.getText(), descripcion.getText()};

                        comprar.agrega(o);
                            Object aux[] = {comprar.getLastID(), cantidad.tf.getText(), costov.tf.getText(), costo.tf.getText(), costom.tf.getText(),"N"};
                        inv.setDatos(aux);
                        Object da[] = {tipo.getSelectedItem(), modelo.getSelectedItem(),
                            piel.getSelectedItem(), proveedor.getSelectedItem(),
                            productot.getText(), color.getText(), descripcion.getText(),
                            cantidad.tf.getText(), costov.tf.getText(), costo.tf.getText(), costom.tf.getText()};
                        tab.setRow(da);
                        vista(false);
                        nuevo.setSelected(false);
                        llenaProdictos();
                        limpiaCant();
                    }
                }
            } else {
                if (validaCant()) {
                    Object aux[] = {comprar.getId(producto.getSelectedIndex()), cantidad.tf.getText(), costov.tf.getText(), costo.tf.getText(), costom.tf.getText(),"E"};
                    inv.setDatos(aux);
                    Object da[] = {tipo.getSelectedItem(), modelo.getSelectedItem(),
                        piel.getSelectedItem(), proveedor.getSelectedItem(),
                        producto.getSelectedItem(), color.getText(), descripcion.getText(),
                        cantidad.tf.getText(), costov.tf.getText(), costo.tf.getText(), costom.tf.getText()};
                    tab.setRow(da);
                    limpiaCant();
                   
                }
            }

        }
    }
}
