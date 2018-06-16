package Vista.Compra;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompraC extends VistasGenerales.Panel {

    final String cols[] = {"Codigo","Producto", "Cantidad", "Descripción"};

    JPanel P = new JPanel();
    VistasGenerales.Tabla tab;
    JLabel lproducto;
    JLabel lcantidad;
    JComboBox producto;
    JButton acepta;
    JButton agrega;
    VistasGenerales.Number cantidad;

    public CompraC() {
        this.setLayout(new GridLayout(2, 1));
        P.setLayout(new GridLayout(2, 2));
        crea();
        agrega();

    }

    private void crea() {
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);

        lproducto = new JLabel("Producto");
        lcantidad = new JLabel("Cantidad");
        producto = new JComboBox();
        cantidad = new VistasGenerales.Number();
        acepta=new JButton("Compra");
        agrega =new JButton("Agrega");
    }

    private void agrega() {
        JPanel inter1=new JPanel();
        inter1.setLayout(new GridLayout(1,2));
        inter1.add(lproducto);
        inter1.add(producto);
        JPanel inter2=new JPanel();
        inter2.setLayout(new GridLayout(1,2));
        inter2.add(lcantidad);
        inter2.add(cantidad.tf);
       
        P.add(inter2);
        P.add(inter1);
        P.add(agrega);
        P.add(acepta);
        add(P);
        add(tab);
    }
}
