package Vista.Compra;

import Controlador.Compra.ConGastos;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GastosA extends VistasGenerales.Panel implements ActionListener {

    private JPanel pi = new JPanel();
    private newServ ns = new newServ();
    private boolean dats;
    final String[] d = {"Servicio", "Otros"};
    JLabel ltipo, lconcepto, lcosto, lcantidad;
    JPanel i = new JPanel(new BorderLayout());
    ConGastos controler = new ConGastos();
    VistasGenerales.Number can, costo;
    JTextField Tconcepto;
    JComboBox Cconcepto, Ctipo;
    JButton agrega, mas;
    JCheckBox varios;
    private JLabel v1;
    private JLabel v2;
    private JLabel v3;
    private JLabel v4;
    private JLabel v5;
    private JLabel v6;

    public GastosA() {
        setLayout(new GridLayout(3, 3));
        pi.setLayout(new GridBagLayout());
        crea();
        agrega();
        inicializa();
        llena();
        varios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dats = !dats;
                can.tf.setEnabled(dats);
            }
        });
        mas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ns.setVisible(true);
            }
        });

        ns.aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ns.addDats();
                Cconcepto.removeAllItems();
                Object aux[] = ns.getDats();
                for (int j = 0; j < aux.length; j++) {
                    Cconcepto.addItem(aux[j]);

                }
            }
        });

        Ctipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (Ctipo.getSelectedIndex()) {
                    case 0:
                        Cconcepto.setVisible(true);
                        Tconcepto.setVisible(false);
                        break;
                    case 1:
                        Cconcepto.setVisible(false);
                        Tconcepto.setVisible(true);
                        break;
                }
            }
        });

        agrega.addActionListener(this);
    }

    private void inicializa() {
        dats = false;
        can.tf.setEnabled(dats);
        Tconcepto.setVisible(dats);
    }

    private void crea() {

        ltipo = new JLabel("Tipo");
        ltipo.setHorizontalAlignment(JLabel.CENTER);
        lconcepto = new JLabel("Concepto");
        lconcepto.setHorizontalAlignment(JLabel.CENTER);
        lcosto = new JLabel("Precio  ");
        lcosto.setHorizontalAlignment(JLabel.RIGHT);
        lcantidad = new JLabel("Cantidad  ");
        lcantidad.setHorizontalAlignment(JLabel.RIGHT);
        can = new VistasGenerales.Number();
        costo = new VistasGenerales.Number("D");
        Tconcepto = new JTextField();
        Cconcepto = new JComboBox();
        Cconcepto.setFocusable(false);
        Ctipo = new JComboBox(d);
        Ctipo.setFocusable(false);
        varios = new JCheckBox("Varios");
        varios.setFocusable(false);
        agrega = new JButton("Aceptar");
        mas = new JButton("+");
        mas.setFocusable(false);
        agrega.setFocusable(false);
        v1 = new JLabel();
        v2 = new JLabel();
        v3 = new JLabel();
        v4 = new JLabel();
        v5 = new JLabel();
        v6 = new JLabel();

    }

    private void agrega() {
        JLabel s1 = new JLabel();
        JLabel s2 = new JLabel();
        JLabel s3 = new JLabel();
        pi.add(ltipo, estilo(0, 0, 3, 1, GridBagConstraints.BOTH));
        pi.add(Ctipo, estilo(0, 1, 3, 1, GridBagConstraints.BOTH));
        pi.add(lconcepto, estilo(0, 2, 3, 1, GridBagConstraints.BOTH));
        pi.add(Tconcepto, estilo(0, 3, 3, 1, GridBagConstraints.BOTH));
        i.add(Cconcepto, BorderLayout.CENTER);
        i.add(mas, BorderLayout.EAST);
        pi.add(i, estilo(0, 3, 3, 1, GridBagConstraints.BOTH));
        pi.add(s3, estilo(0, 4, 3, 1, GridBagConstraints.BOTH));
        pi.add(lcosto, estilo(1, 5, 1, 1, GridBagConstraints.BOTH));
        pi.add(costo.tf, estilo(2, 5, 1, 1, GridBagConstraints.BOTH));
        pi.add(s1, estilo(0, 6, 1, 1, GridBagConstraints.BOTH));
        pi.add(varios, estilo(0, 5, 1, 3, GridBagConstraints.BOTH));
        pi.add(lcantidad, estilo(1, 7, 1, 1, GridBagConstraints.BOTH));
        pi.add(can.tf, estilo(2, 7, 1, 1, GridBagConstraints.BOTH));
        pi.add(s2, estilo(2, 8, 1, 1, GridBagConstraints.BOTH));
        pi.add(agrega, estilo(0, 9, 3, 1, GridBagConstraints.BOTH));
        add(v1);
        add(v2);
        add(v3);
        add(v4);
        add(pi);
        add(v5);
        add(v6);
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

    private void llena() {
        Object aux[] = ns.getDats();
        if (aux != null) {
            for (int j = 0; j < aux.length; j++) {
                Cconcepto.addItem(aux[j]);

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(agrega)) {
            if (!(Ctipo.getSelectedIndex() == 1 && Tconcepto.getText().equals(""))) {
                if (!(Ctipo.getSelectedIndex() == 1 && controler.Num(Tconcepto.getText())[1].toString().equals("true"))) {

                    if (controler.isDouble(costo.tf.getText())) {
                        int tipo = Ctipo.getSelectedIndex();
                        String concepto = "";
                        String aux = controler.Num((can.tf.getText()))[0].toString();
                        System.out.println(aux);
                        int cantidad = Integer.parseInt(aux);
                        double precio = Double.parseDouble(costo.tf.getText());
                        if (tipo == 0) {
                            concepto = ns.getID(Cconcepto.getSelectedIndex()) + "";
                        }
                        if (tipo == 1) {
                            concepto = Tconcepto.getText();

                        }

                        controler.Alta(tipo, concepto, cantidad, precio);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe insertar un costo.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El concepto no puede ser un numero");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe insertar un concepto.");
            }

        }
    }

}
