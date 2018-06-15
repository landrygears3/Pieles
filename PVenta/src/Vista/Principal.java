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
    Vista.Inventario.InventarioAcceso inventario = new Vista.Inventario.InventarioAcceso();
    Vista.PRoducto.ProductoAcceso producto = new Vista.PRoducto.ProductoAcceso();
    Vista.Errores.ErrorAcceso errores = new Vista.Errores.ErrorAcceso();
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
        agrega();
        boton b = new boton();
        mb.sa.addActionListener(b);
        mb.vev.addActionListener(b);
        mb.vec.addActionListener(b);
        mb.cmc.addActionListener(b);
        mb.cmv.addActionListener(b);
        mb.ina.addActionListener(b);
        mb.inb.addActionListener(b);
        mb.inm.addActionListener(b);
        mb.pda.addActionListener(b);
        mb.pdm.addActionListener(b);
        mb.pdb.addActionListener(b);
        mb.pra.addActionListener(b);
        mb.prb.addActionListener(b);
        mb.prm.addActionListener(b);
        mb.cla.addActionListener(b);
        mb.clb.addActionListener(b);
        mb.clm.addActionListener(b);
        mb.pia.addActionListener(b);
        mb.pib.addActionListener(b);
        mb.pim.addActionListener(b);
        mb.moa.addActionListener(b);
        mb.mob.addActionListener(b);
        mb.mom.addActionListener(b);
        mb.tia.addActionListener(b);
        mb.tib.addActionListener(b);
        mb.tim.addActionListener(b);
        mb.ema.addActionListener(b);
        mb.emb.addActionListener(b);
        mb.emm.addActionListener(b);
        mb.noa.addActionListener(b);
        mb.nov.addActionListener(b);
        mb.era.addActionListener(b);
        mb.erc.addActionListener(b);

    }

    private void agrega() {
        gral.add(venta.agrega);
        gral.add(venta.consulta);
        gral.add(inventario.agrega);
        gral.add(inventario.modifica);
        gral.add(inventario.elimina);
        gral.add(producto.agrega);
        gral.add(producto.elimina);
        gral.add(producto.modifica);
        gral.add(proveedor.agrega);
        gral.add(proveedor.elimina);
        gral.add(proveedor.modifica);
        gral.add(cliente.agrega);
        gral.add(cliente.elimina);
        gral.add(cliente.modifica);
        gral.add(piel.agrega);
        gral.add(piel.elimina);
        gral.add(piel.modifica);
        gral.add(modelo.agrega);
        gral.add(modelo.elimina);
        gral.add(modelo.modifica);
        gral.add(tipos.agrega);
        gral.add(tipos.elimina);
        gral.add(tipos.modifica);
        gral.add(empleado.NotaA);
        gral.add(empleado.NotaV);
        gral.add(empleado.agrega);
        gral.add(empleado.elimina);
        gral.add(empleado.modifica);
        gral.add(compras.comprar);
        gral.add(compras.vista);
        gral.add(errores.agrega);
        gral.add(errores.consulta);

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
            if (e.getSource().equals(mb.ina)) {
                setContentPane(inventario.agrega);
            }
            if (e.getSource().equals(mb.inm)) {
                setContentPane(inventario.modifica);
            }
            if (e.getSource().equals(mb.inb)) {
                setContentPane(inventario.elimina);
            }
            //productos
            if (e.getSource().equals(mb.pda)) {
                setContentPane(producto.agrega);
            }
            if (e.getSource().equals(mb.pdb)) {
                setContentPane(producto.elimina);
            }
            if (e.getSource().equals(mb.pdm)) {
                setContentPane(producto.modifica);
            }
            //proveedor
            if (e.getSource().equals(mb.pra)) {
                setContentPane(proveedor.agrega.P);
            }
            if (e.getSource().equals(mb.prb)) {
                setContentPane(proveedor.elimina);
            }
            if (e.getSource().equals(mb.prm)) {
                setContentPane(proveedor.modifica);
            }
            //Cliente
            if (e.getSource().equals(mb.cla)) {
               setContentPane(cliente.agrega);
            }
            if (e.getSource().equals(mb.clb)) {
                setContentPane(cliente.elimina);
            }
            if (e.getSource().equals(mb.clm)) {
                setContentPane(cliente.modifica);
            }
            //Piel
            if (e.getSource().equals(mb.pia)) {
                setContentPane(piel.agrega);
            }
            if (e.getSource().equals(mb.pib)) {
                setContentPane(piel.elimina);
            }
            if (e.getSource().equals(mb.pim)) {
                setContentPane(piel.modifica);
            }
            //Modelo
            if (e.getSource().equals(mb.moa)) {
                setContentPane(modelo.agrega.P);
            }
            if (e.getSource().equals(mb.mob)) {
                setContentPane(modelo.elimina);
            }
            if (e.getSource().equals(mb.mom)) {
               setContentPane(modelo.modifica);
            }
            //productos
            if (e.getSource().equals(mb.tia)) {
                setContentPane(producto.agrega);
            }
            if (e.getSource().equals(mb.tib)) {
               setContentPane(producto.elimina);
            }
            if (e.getSource().equals(mb.tim)) {
               setContentPane(producto.modifica);
            }
            //empleados
            if (e.getSource().equals(mb.noa)) {
                setContentPane(empleado.NotaA);
            }
            if (e.getSource().equals(mb.nov)) {
                setContentPane(empleado.NotaV);
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
            //Compras
            if (e.getSource().equals(mb.cmc)) {
                setContentPane(compras.comprar);
            }
            if (e.getSource().equals(mb.cmv)) {
               setContentPane(compras.vista);
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
