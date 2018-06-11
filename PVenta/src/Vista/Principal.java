package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import Vista.PRoducto.ProductoA;
import Vista.Ventas.VentaA;
import Vista.Empleado.EmpleadoA;
import Vista.Proveedor.ProveedorA;
import Vista.Errores.ErrorA;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

    private Dimension dim;
    JMenuBar mb = new JMenuBar();
    VistasGenerales.Panel gral = new VistasGenerales.Panel();
    JMenu ve, inv, pro, cli, err, con, s, pi, mo, ti;
    JMenuItem vev, vec, ina, inb, inm, cs, sa, pra, prb, prm,
            cla, clb, clm, pia, pim, pib, moa, mom, mob, tia, tib, tim;
    ProductoA pa = new ProductoA();
    VentaA va = new VentaA();
    EmpleadoA ea = new EmpleadoA();
    ProveedorA ha = new ProveedorA();
    ErrorA ra = new ErrorA();

    public Principal() {
        super("ELEGANPIEL");
        dim = super.getToolkit().getScreenSize();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(dim);
        super.setUndecorated(true);
        super.setVisible(true);
        crea();
        agrega();
        boton b = new boton();

    }

    private void crea() {

        //Salir
        s = new JMenu("Salir");
        cs = new JMenuItem("Cerrar Sesión");
        sa = new JMenuItem("Salir");
        //Ventas
        ve = new JMenu("Ventas");
        vev = new JMenuItem("Vende");
        vec = new JMenuItem("Consulta");
        //Inventario
        inv = new JMenu("Inventario");
        ina = new JMenuItem("Agrega");
        inb = new JMenuItem("Eliminar");
        inm = new JMenuItem("Modificar");
        //Errores
        err = new JMenu("Errores");
        //Proveedores
        pro = new JMenu("Proveedores");
        pra = new JMenuItem("Agrega");
        prb = new JMenuItem("Eliminar");
        prm = new JMenuItem("Modificar");
        //Clientes
        cli = new JMenu("Clientes");
        cla = new JMenuItem("Agrega");
        clb = new JMenuItem("Eliminar");
        clm = new JMenuItem("Modificar");

        //Conceptos
        con = new JMenu("Conceptos");
        pi = new JMenu("Tipos de Piel");
        pia = new JMenuItem("Agrega");
        pib = new JMenuItem("Eliminar");
        pim = new JMenuItem("Modificar");
        mo = new JMenu("Modelos");
        moa = new JMenuItem("Agrega");
        mob = new JMenuItem("Eliminar");
        mom = new JMenuItem("Modificar");
        ti = new JMenu("Productos");
        tia = new JMenuItem("Agrega");
        tib = new JMenuItem("Eliminar");
        tim = new JMenuItem("Modificar");
    }

    private void agrega() {
        //Salir
        s.add(cs);
        s.add(sa);
        //Ventas
        ve.add(vev);
        ve.add(vec);
        //Inventario
        inv.add(ina);
        inv.add(inb);
        inv.add(inm);
        //Proveedores
        pro.add(pra);
        pro.add(prb);
        pro.add(prm);
        //Clientes
        cli.add(cla);
        cli.add(clb);
        cli.add(clm);
        cli.add(pro);
        //Conceptos
        con.add(pi);
        pi.add(pia);
        pi.add(pib);
        pi.add(pim);
        con.add(mo);
        mo.add(moa);
        mo.add(mob);
        mo.add(mom);
        con.add(ti);
        ti.add(tia);
        ti.add(tib);
        ti.add(tim);

        //MenuBar
        mb.add(ve);
        mb.add(inv);
        mb.add(err);
        mb.add(pro);
        mb.add(cli);
        mb.add(con);
        mb.add(Box.createHorizontalGlue());
        mb.add(s);
        setJMenuBar(mb);
        setContentPane(gral);
        validate();
    }

    private class boton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

}
