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

    private void ver(int d) {
        boolean dat[] = new boolean[32];
        for (int i = 0; i < dat.length; i++) {
            dat[i] = false;
        }
        dat[d] = true;
        venta.agrega.setVisible(dat[0]);
        venta.consulta.setVisible(dat[1]);
        inventario.agrega.setVisible(dat[2]);
        inventario.modifica.setVisible(dat[3]);
        inventario.elimina.setVisible(dat[4]);
        producto.agrega.setVisible(dat[5]);
        producto.elimina.setVisible(dat[6]);
        producto.modifica.setVisible(dat[7]);
        proveedor.agrega.setVisible(dat[8]);
        proveedor.elimina.setVisible(dat[9]);
        proveedor.modifica.setVisible(dat[10]);
        cliente.agrega.setVisible(dat[11]);
        cliente.elimina.setVisible(dat[12]);
        cliente.modifica.setVisible(dat[13]);
        piel.agrega.setVisible(dat[14]);
        piel.elimina.setVisible(dat[15]);
        piel.modifica.setVisible(dat[16]);
        modelo.agrega.setVisible(dat[17]);
        modelo.elimina.setVisible(dat[18]);
        modelo.modifica.setVisible(dat[19]);
        tipos.agrega.setVisible(dat[20]);
        tipos.elimina.setVisible(dat[21]);
        tipos.modifica.setVisible(dat[22]);
        empleado.NotaA.setVisible(dat[23]);
        empleado.NotaV.setVisible(dat[24]);
        empleado.agrega.setVisible(dat[25]);
        empleado.elimina.setVisible(dat[26]);
        empleado.modifica.setVisible(dat[27]);
        compras.comprar.setVisible(dat[28]);
        compras.vista.setVisible(dat[29]);
        errores.agrega.setVisible(dat[30]);
        errores.consulta.setVisible(dat[31]);
        validate();

    }

    private class boton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //salir
            if (e.getSource().equals(mb.sa)) {
                System.exit(0);
            }
            //ventas
            if (e.getSource().equals(mb.vev)) {
                ver(0);
            }
            if (e.getSource().equals(mb.vec)) {
                ver(1);
            }
            //inventario
            if (e.getSource().equals(mb.ina)) {
                ver(2);
            }
            if (e.getSource().equals(mb.inm)) {
                ver(3);
            }
            if (e.getSource().equals(mb.inb)) {
                ver(4);
            }
            //productos
            if (e.getSource().equals(mb.pda)) {
                ver(5);
            }
            if (e.getSource().equals(mb.pdb)) {
                ver(6);
            }
            if (e.getSource().equals(mb.pdm)) {
                ver(7);
            }
            //proveedor
            if (e.getSource().equals(mb.pra)) {
                ver(8);
            }
            if (e.getSource().equals(mb.prb)) {
                ver(9);
            }
            if (e.getSource().equals(mb.prm)) {
                ver(10);
            }
            //Cliente
            if (e.getSource().equals(mb.cla)) {
                ver(11);
            }
            if (e.getSource().equals(mb.clb)) {
                ver(12);
            }
            if (e.getSource().equals(mb.clm)) {
                ver(13);
            }
            //Piel
            if (e.getSource().equals(mb.pia)) {
                ver(14);
            }
            if (e.getSource().equals(mb.pib)) {
                ver(15);
            }
            if (e.getSource().equals(mb.pim)) {
                ver(16);
            }
            //Modelo
            if (e.getSource().equals(mb.moa)) {
                ver(17);
            }
            if (e.getSource().equals(mb.mob)) {
                ver(18);
            }
            if (e.getSource().equals(mb.mom)) {
                ver(19);
            }
            //productos
            if (e.getSource().equals(mb.tia)) {
                ver(20);
            }
            if (e.getSource().equals(mb.tib)) {
                ver(21);
            }
            if (e.getSource().equals(mb.tim)) {
                ver(22);
            }
            //empleados
            if (e.getSource().equals(mb.noa)) {
                ver(23);
            }
            if (e.getSource().equals(mb.nov)) {
                ver(24);
            }
            if (e.getSource().equals(mb.ema)) {
                ver(25);
            }
            if (e.getSource().equals(mb.emb)) {
                ver(26);
            }
            if (e.getSource().equals(mb.emm)) {
                ver(27);
            }
            //Compras
            if (e.getSource().equals(mb.cmc)) {
                ver(28);
            }
            if (e.getSource().equals(mb.cmv)) {
                ver(29);
            }
             //Erroes
            if (e.getSource().equals(mb.era)) {
                ver(30);
            }
            if (e.getSource().equals(mb.erc)) {
                ver(31);
            }

        }

    }

}
