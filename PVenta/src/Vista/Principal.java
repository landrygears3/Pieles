package Vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal extends JFrame {

    private Dimension dim;
    JMenu ar, s;
    JMenuItem m, m1, m2, m3, m4;
    JButton a, ca;
    JPanel inv;
    JMenuBar mb;
    JLabel id, t, tp, mo, col, des, cc, pv, pro, can,
            im, ma, su, pi, CC, PRO, IM;
    JTextField ID, CAN, PV;
    String Prod[] = {"Tipo de producto"};
    String Pago[] = {"Tipo de pago"};
    String Mod[] = {"Modelo"};
    String Color[] = {"Color"};
    String Des[] = {"Descripción"};
    String Suc[] = {"Sucursal"};
    String piel[] = {"Tipo de piel"};
    JComboBox T, TP, MO, COL, DES, SU, PI;
    JCheckBox MA;

    public Principal() {
        super("ELEGANPIEL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dim = super.getToolkit().getScreenSize();
        super.setSize(dim);
        super.setUndecorated(true);
        super.setVisible(true);

        inv = new JPanel();
        mb = new JMenuBar();
        ar = new JMenu("Nuevo");
        s = new JMenu("Salir");
        m = new JMenuItem("Vender");
        m1 = new JMenuItem("Ver inventario");
        m2 = new JMenuItem("Devoluciones");
        m4 = new JMenuItem("Cerrar sesión");
        m3 = new JMenuItem("Salir");
        a = new JButton();
        ca = new JButton();
        id = new JLabel("ID");
        cc = new JLabel("Costo Compra");
        pv = new JLabel("Precio de venta");
        pro = new JLabel("Proveedor");
        can = new JLabel("Cantidad");
        im = new JLabel("(Insertar imagen)");
        ma = new JLabel("Mayoreo");
        ID = new JTextField(10);
        CAN = new JTextField(10);
        PV = new JTextField(10);
        MA = new JCheckBox();
        CC = new JLabel("$");
        PRO = new JLabel("");
        IM = new JLabel("");
        T = new JComboBox(Prod);
        TP = new JComboBox(Pago);
        MO = new JComboBox(Mod);
        COL = new JComboBox(Color);
        DES = new JComboBox(Des);
        SU = new JComboBox(Suc);
        PI = new JComboBox(piel);

        ar.add(m);
        ar.add(m1);
        ar.add(m2);
        s.add(m4);
        s.add(m3);
        mb.add(ar);
        mb.add(s);

        inv.add(id);
        inv.add(ID);
        inv.add(T);
        inv.add(TP);
        inv.add(MO);
        inv.add(COL);
        inv.add(PI);
        inv.add(cc);
        inv.add(CC);
        inv.add(pv);
        inv.add(PV);
        inv.add(pro);
        inv.add(PRO);
        inv.add(can);
        inv.add(CAN);
        inv.add(im);
        inv.add(IM);
        inv.add(ma);
        inv.add(MA);
        inv.add(SU);
        setContentPane(inv);
        setJMenuBar(mb);
        validate();
        
        
        boton b = new boton();
        m.addActionListener(b);
        m1.addActionListener(b);
        m2.addActionListener(b);
        m3.addActionListener(b);
    }

    private class boton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(m3)) {
                System.exit(0);
            } else if (e.getSource().equals(m4)) {
                
            }

        }

    }

}
