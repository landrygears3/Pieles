package Vista;

import java.util.Date;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menubar extends JMenuBar {

    private String User = null;
    JMenu ve, inv, err, s, emp, not, com, dat, gas, otr, per;
    JMenuItem vev, vec, inm, cs, sa, ema, emb, emm, noa,
            cmc, cmv, era, ota, otv, pea, peb;

    public Menubar(String User) {
        this.User = User;
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
        vec = new JMenuItem("Historial");
        //gastos
        gas = new JMenu("Gastos");
        com = new JMenu("Compras");
        cmc = new JMenuItem("Comprar");
        cmv = new JMenuItem("Historial");
        otr = new JMenu("Otros");
        ota = new JMenuItem("Comprar");
        otv = new JMenuItem("Historial");

        //Inventario
        inv = new JMenu("Inventario");
        inm = new JMenuItem("Consultas");

        //Errores
        err = new JMenu("Errores");
        era = new JMenuItem("Alta");

        //Empleados
        emp = new JMenu("Empleados");
        ema = new JMenuItem("Agrega");
        emb = new JMenuItem("Eliminar");
        emm = new JMenuItem("Modificar");
        not = new JMenu("Notas");
        noa = new JMenuItem("Agregar");
        //Permisos
        per = new JMenu("Permisos");
        pea = new JMenuItem("Agrega");
        peb = new JMenuItem("Eliminar");

        //date
        Date d = new Date();
        dat = new JMenu(d.getDate() + "/" + d.getMonth() + "/" + (d.getYear()%100));
        dat.setEnabled(false);

    }

    private void agrega() {
        //Salir
        s.add(cs);
        s.add(sa);
        //Ventas
        ve.add(vev);
        ve.add(vec);
        //Gastos
        com.add(cmc);
        com.add(cmv);
        otr.add(ota);
        otr.add(otv);
        gas.add(com);
        gas.add(otr);
        //Inventario
        inv.add(inm);

        //Errores
        err.add(era);

        //MenuBar
        add(ve);
        add(gas);
        add(inv);
        add(err);
        if (User.equals("Admin")) {
            //Empleados
            not.add(noa);
            emp.add(not);
            emp.add(ema);
            emp.add(emb);
            emp.add(emm);
            //Permisos
            per.add(pea);
            per.add(peb);
            add(emp);
            add(per);
        }
        add(Box.createHorizontalGlue());
        add(dat);
        add(s);
    }
}
