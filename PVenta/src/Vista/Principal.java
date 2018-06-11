package Vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

;

public class Principal extends JFrame {

    private Dimension dim;
    VistasGenerales.Panel gral = new VistasGenerales.Panel();
    Vista.Menubar mb = new Vista.Menubar();
    Vista.Ventas.VentaAcceso venta = new Vista.Ventas.VentaAcceso();
    Vista.Inventario.InventarioAcceso inventario = new Vista.Inventario.InventarioAcceso();
    Vista.PRoducto.ProductoAcceso producto = new Vista.PRoducto.ProductoAcceso();
    //Errores pendiete
    Vista.Proveedor.ProvedorAcceso proveedor = new Vista.Proveedor.ProvedorAcceso();
    Vista.Cliente.ClienteAcceso cliente = new Vista.Cliente.ClienteAcceso();
    Vista.Mods.Piel piel = new Vista.Mods.Piel();
    Vista.Mods.Modelo modelo = new Vista.Mods.Modelo();
    Vista.Mods.Tipo tipos = new Vista.Mods.Tipo();
    Vista.Empleado.EmpleadoAcceso empleado = new Vista.Empleado.EmpleadoAcceso();

    public Principal() {
        dim = super.getToolkit().getScreenSize();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(dim);
        super.setUndecorated(true);
        super.setVisible(true);

        setJMenuBar(mb);
        setContentPane(gral);
        validate();
        boton b = new boton();
        mb.sa.addActionListener(b);

    }

    private class boton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(mb.sa)) {
                System.exit(0);
            }
        }

    }

}
