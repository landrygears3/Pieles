package Vista;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menubar extends JMenuBar {

    JMenu ve, inv, err, s, emp, not, com;
    JMenuItem vev, vec, inm, cs, sa, ema, emb, emm, noa, nov,
            cmc, cmv, era, erc;

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
        vec = new JMenuItem("Historial");
        //Compras
        com = new JMenu("Compras");
        cmc = new JMenuItem("Comprar");
        cmv = new JMenuItem("Historial");
        //Inventario
        inv = new JMenu("Inventario");
        inm = new JMenuItem("Consultas");
        
        //Errores
        err = new JMenu("Errores");
        era = new JMenuItem("Alta");
        erc = new JMenuItem("Historial");
        
        
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
        inv.add(inm);
       
        //Empleados
        not.add(noa);
        not.add(nov);
        emp.add(not);
        emp.add(ema);
        emp.add(emb);
        emp.add(emm);
        //Errores
        err.add(era);
        err.add(erc);
        //MenuBar
        add(ve);
        add(com);
        add(inv);
        add(err);
        add(emp);
        add(Box.createHorizontalGlue());
        add(s);
    }
}
