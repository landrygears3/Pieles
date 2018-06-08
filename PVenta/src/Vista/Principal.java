package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import Vista.PRoducto.ProductoA;
import Vista.Ventas.VentaA;
import Vista.Empleado.EmpleadoA;
import Vista.Proveedor.ProveedorA;
import Vista.Errores.ErrorA;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Principal extends JFrame {

    private Dimension dim;
    JMenu ar, s;
    JMenuItem m, m1, m2, m3, m4, m5, m6;
    JButton a, ca;
    JPanel inv;
    JMenuBar mb;
    ProductoA pa = new ProductoA();
    VentaA va = new VentaA();
    EmpleadoA ea = new EmpleadoA();
    ProveedorA ha = new ProveedorA();
    ErrorA ra = new ErrorA();

    public Principal() {
        super("ELEGANPIEL");
        dim = super.getToolkit().getScreenSize();
        super.setSize(dim);
        super.setUndecorated(true);
        super.setVisible(true);

        inv = new JPanel();
        mb = new JMenuBar();

        JMenuBar mb = new JMenuBar();
        mb.setLayout(new BorderLayout());
        ar = new JMenu("Acciones");
        s = new JMenu("Salir");
        m = new JMenuItem("Vender");
        m1 = new JMenuItem("Producto");
        m2 = new JMenuItem("Empleados");
        m5 = new JMenuItem("Proovedores");
        m6 = new JMenuItem("Devoluciones y defectos");
        m4 = new JMenuItem("Cerrar sesión");
        m3 = new JMenuItem("Salir");

        a = new JButton();
        ca = new JButton();

        ar.add(m);
        ar.add(m1);
        ar.add(m2);
        ar.add(m5);
        ar.add(m6);
        s.add(m4);
        s.add(m3);
        mb.add(ar);

        mb.add(s, BorderLayout.LINE_END);
        setJMenuBar(mb);
        setContentPane(inv);
        validate();

        boton b = new boton();
        m.addActionListener(b);
        m1.addActionListener(b);
        m2.addActionListener(b);
        m3.addActionListener(b);
        m4.addActionListener(b);
        m5.addActionListener(b);
        m6.addActionListener(b);
    }

    private class boton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(m)) {
                inv.removeAll();
                inv.repaint();
                inv.add(va.id);
                inv.add(va.ID);
                inv.add(va.T);
                inv.add(va.TP);
                inv.add(va.MO);
                inv.add(va.COL);
                inv.add(va.PI);
                inv.add(va.pv);
                inv.add(va.PV);
                inv.add(va.can);
                inv.add(va.CAN);
                inv.add(va.im);
                inv.add(va.IM);
                inv.add(va.ma);
                inv.add(va.MA);
                inv.add(va.SU);
                inv.add(va.nc);
                inv.add(va.NC);
                inv.add(va.cc);
                inv.add(va.CC);
                validate();
            } else if (e.getSource().equals(m1)) {
                inv.removeAll();
                inv.repaint();
                inv.add(pa.id);
                inv.add(pa.ID);
                inv.add(pa.T);
                inv.add(pa.TP);
                inv.add(pa.MO);
                inv.add(pa.COL);
                inv.add(pa.PI);
                inv.add(pa.pv);
                inv.add(pa.PV);
                inv.add(pa.can);
                inv.add(pa.CAN);
                inv.add(pa.cc);
                inv.add(pa.CC);
                inv.add(pa.im);
                inv.add(pa.IM);
                inv.add(pa.SU);
                inv.add(pa.pro);
                inv.add(pa.PRO);
                validate();
            } else if (e.getSource().equals(m2)) {
                inv.removeAll();
                inv.repaint();
                inv.add(ea.n);
                inv.add(ea.N);
                inv.add(ea.t);
                inv.add(ea.T);
                inv.add(ea.u);
                inv.add(ea.U);
                inv.add(ea.c);
                inv.add(ea.C);
                inv.add(ea.TU);
                inv.add(ea.S);
                validate();
            } else if (e.getSource().equals(m3)) {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.exit(0);
            } else if (e.getSource().equals(m4)) {
                new Login();
                Principal.super.hide();
                validate();
            }else if (e.getSource().equals(m5)) {
                inv.removeAll();
                inv.repaint();
                inv.add(ha.id);
                inv.add(ha.ID);
                inv.add(ha.n);
                inv.add(ha.N);
                inv.add(ha.c);
                inv.add(ha.C);
                inv.add(ha.co);
                inv.add(ha.CO);
                validate();
            }else if (e.getSource().equals(m6)) {
                inv.removeAll();
                inv.repaint();
                inv.add(ra.id);
                inv.add(ra.ID);
                inv.add(ra.p);
                inv.add(ra.P);
                inv.add(ra.c);
                inv.add(ra.C);
                inv.add(ra.d);
                inv.add(ra.D);
                validate();
            }

        }

    }

}
