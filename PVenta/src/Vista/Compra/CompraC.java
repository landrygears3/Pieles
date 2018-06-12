package Vista.Compra;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CompraC extends VistasGenerales.Panel {

    final String cols[] = {"Dato 1", "Dato 2", "Dato 3"};
    VistasGenerales.Tabla tab;
    JComboBox idproducto;
    JPanel P=new JPanel();
    VistasGenerales.Number cantidad;

    public CompraC() {
        this.setLayout(new GridLayout(2,1));
        P.setLayout(new GridLayout(2,3));
        crea();
        agrega();

    }

    private void crea() {
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        idproducto=new JComboBox();
        cantidad = new VistasGenerales.Number();
    }

    private void agrega() {
        P.add(idproducto);
        P.add(cantidad.tf);
        add(P);
        add(tab);
    }
}
