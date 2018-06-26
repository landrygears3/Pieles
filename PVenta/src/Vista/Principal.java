package Vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Principal extends JFrame {

    private Dimension dim;
    VistasGenerales.Panel gral = new VistasGenerales.Panel();
    Vista.Menubar mb = new Vista.Menubar();
    Vista.Ventas.VentaAcceso venta = new Vista.Ventas.VentaAcceso();
    Vista.Compra.CompraAcceso compras = new Vista.Compra.CompraAcceso();
    Vista.Inventario.InventarioM inventario = new Vista.Inventario.InventarioM();
    Vista.Errores.ErrorAcceso errores = new Vista.Errores.ErrorAcceso();
    Vista.Empleado.EmpleadoAcceso empleado = new Vista.Empleado.EmpleadoAcceso();
    

    public Principal() {
        dim = super.getToolkit().getScreenSize();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(dim);
        //super.setUndecorated(true);
        super.setVisible(true);

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
        mb.nov.addActionListener(b);
        mb.era.addActionListener(b);
        mb.erc.addActionListener(b);
        mb.ota.addActionListener(b);
        mb.otv.addActionListener(b);

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
               setContentPane(venta.agrega.Pr);
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
                setContentPane(empleado.NotaA.P);
            }
            if (e.getSource().equals(mb.nov)) {
                setContentPane(empleado.NotaV);
            }
            if (e.getSource().equals(mb.ema)) {
                setContentPane(empleado.agrega.Pr);
            }
            if (e.getSource().equals(mb.emb)) {
                setContentPane(empleado.elimina.Pr);
            }
            if (e.getSource().equals(mb.emm)) {
                setContentPane(empleado.modifica.Pr);
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
                setContentPane(errores.agrega.Pr);
            }
            if (e.getSource().equals(mb.erc)) {
                setContentPane(errores.consulta);
            }
            validate();
        }

    }

}
