package Vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Principal extends JFrame {

    private String User = null;
    private Dimension dim;
    VistasGenerales.Panel gral;
    Vista.Menubar mb;
    Vista.Ventas.VentaAcceso venta;
    Vista.Compra.CompraAcceso compras;
    Vista.Inventario.InventarioM inventario;
    Vista.Errores.ErrorAcceso errores;
    Vista.Empleado.EmpleadoAcceso empleado;
    Vista.Permisos.PermisoAcceso permisos;

    public Principal(String User) {
        this.User = User;
        dim = super.getToolkit().getScreenSize();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(dim);
        super.setUndecorated(true);
        super.setVisible(true);
        crea();
        setJMenuBar(mb);
        setContentPane(gral);
        validate();
        boton b = new boton();
        mb.sa.addActionListener(b);
        mb.vev.addActionListener(b);
        mb.vec.addActionListener(b);
        mb.cmc.addActionListener(b);
        mb.cmv.addActionListener(b);
        mb.inm.addActionListener(b);
        mb.ema.addActionListener(b);
        mb.emb.addActionListener(b);
        mb.emm.addActionListener(b);
        mb.noa.addActionListener(b);
        mb.era.addActionListener(b);
        mb.erc.addActionListener(b);
        mb.ota.addActionListener(b);
        mb.otv.addActionListener(b);
        mb.pea.addActionListener(b);
        mb.peb.addActionListener(b);
        mb.peh.addActionListener(b);

    }

    private void crea() {
        gral = new VistasGenerales.Panel();
        mb = new Vista.Menubar(User);
        venta = new Vista.Ventas.VentaAcceso();
        compras = new Vista.Compra.CompraAcceso();
        inventario = new Vista.Inventario.InventarioM();
        errores = new Vista.Errores.ErrorAcceso();
        empleado = new Vista.Empleado.EmpleadoAcceso();
        permisos = new Vista.Permisos.PermisoAcceso();

    }

    private class boton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //salir
            if (e.getSource().equals(mb.sa)) {
                System.exit(0);
            }
            if (e.getSource().equals(mb.cs)) {

            }
            //ventas
            if (e.getSource().equals(mb.vev)) {
                setContentPane(venta.agrega);
                validate();
            }
            if (e.getSource().equals(mb.vec)) {
                setContentPane(venta.consulta);
            }
            //inventario

            if (e.getSource().equals(mb.inm)) {
                setContentPane(inventario);
            }
            //empleados
            if (e.getSource().equals(mb.noa)) {
                setContentPane(empleado.NotaA);
            }
            if (e.getSource().equals(mb.ema)) {
                setContentPane(empleado.agrega);
            }
            if (e.getSource().equals(mb.emb)) {
                setContentPane(empleado.elimina);
            }
            if (e.getSource().equals(mb.emm)) {
                setContentPane(empleado.modifica);
            }
            //Permisos
            if (e.getSource().equals(mb.pea)) {
                setContentPane(permisos.agrega);
            }
            if (e.getSource().equals(mb.peb)) {
                setContentPane(permisos.elimina);
            }
            if (e.getSource().equals(mb.peh)) {
                setContentPane(permisos.historial);
            }
            //Compras
            if (e.getSource().equals(mb.cmc)) {
                setContentPane(compras.comprar);
            }
            if (e.getSource().equals(mb.cmv)) {
                setContentPane(compras.vista);
            }
            if (e.getSource().equals(mb.ota)) {
                setContentPane(compras.gasto);
            }
            if (e.getSource().equals(mb.otv)) {
                setContentPane(compras.vistaG);
            }
            //Erroes
            if (e.getSource().equals(mb.era)) {
                setContentPane(errores.agrega);
            }
            if (e.getSource().equals(mb.erc)) {
                setContentPane(errores.consulta);
            }
            validate();
        }

    }

}
