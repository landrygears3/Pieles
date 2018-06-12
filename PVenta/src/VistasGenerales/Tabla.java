package VistasGenerales;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JScrollPane {

    DefaultTableModel md;
    JTable tab;

    public Tabla() {
        md = new DefaultTableModel();
        tab = new JTable();
        setViewportView(tab);
    }

    public void setColum(String[] cols) {
        for (int i = 0; i < cols.length; i++) {
            md.addColumn(cols[i]);
        }
        tab.setModel(md);
    }

    public void setRow(Object o[][]) {
        for (int i = 0; i < o.length; i++) {
            Object aux[] = new Object[o[i].length];
            for (int j = 0; j < aux.length; j++) {
                aux[j] = o[i][j];

            }
            md.addRow(aux);
        }
    }
}
