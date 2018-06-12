package Vista.Compra;

import javax.swing.JComboBox;

public class CompraC extends VistasGenerales.Panel {

    final String cols[] = {"Dato 1", "Dato 2", "Dato 3"};
    VistasGenerales.Tabla tab;
    JComboBox idproducto;
    VistasGenerales.Number cantidad;

    public CompraC() {
        crea();
        agrega();

    }

    private void crea() {
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        cantidad = new VistasGenerales.Number();
    }

    private void agrega() {
        add(cantidad.tf);
        add(tab);
    }
}
