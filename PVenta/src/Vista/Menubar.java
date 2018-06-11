package Vista;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menubar extends JMenuBar {

    JMenu ve, inv, pro, cli, err, con, s, pi, mo, ti, emp, not, prd, com;
    JMenuItem vev, vec, ina, inb, inm, cs, sa, pra, prb, prm,
            cla, clb, clm, pia, pim, pib, moa, mom, mob, tia,
            tib, tim, ema, emb, emm, noa, nov, pda, pdm, pdb, cmc,cmv;

    public Menubar() {
        crea();
        agrega();
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
        //Compras
        com = new JMenu("Compras");
        cmc = new JMenuItem("Comprar");
        cmv = new JMenuItem("Consulta");
        //Inventario
        inv = new JMenu("Inventario");
        ina = new JMenuItem("Agrega");
        inb = new JMenuItem("Eliminar");
        inm = new JMenuItem("Modificar");
        //productos
        prd = new JMenu("Productos");
        pda = new JMenuItem("Agrega");
        pdb = new JMenuItem("Eliminar");
        pdm = new JMenuItem("Modificar");
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

        //Empleados
        emp = new JMenu("Empleados");
        ema = new JMenuItem("Agrega");
        emb = new JMenuItem("Eliminar");
        emm = new JMenuItem("Modificar");
        not = new JMenu("Notas");
        noa = new JMenuItem("Agregar");
        nov = new JMenuItem("Revisar");
    }

    private void agrega() {
        //Salir
        s.add(cs);
        s.add(sa);
        //Ventas
        ve.add(vev);
        ve.add(vec);
        //compras
        com.add(cmc);
        com.add(cmv);
        //Inventario
        inv.add(ina);
        inv.add(inb);
        inv.add(inm);
        //Producto
        prd.add(pda);
        prd.add(pdb);
        prd.add(pdm);
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
        //Empleados
        not.add(noa);
        not.add(nov);
        emp.add(not);
        emp.add(ema);
        emp.add(emb);
        emp.add(emm);
        //MenuBar
        add(ve);
        add(com);
        add(inv);
        add(prd);
        add(err);
        add(pro);
        add(cli);
        add(con);
        add(emp);
        add(Box.createHorizontalGlue());
        add(s);
    }
}
