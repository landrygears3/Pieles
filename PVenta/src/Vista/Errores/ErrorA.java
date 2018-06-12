package Vista.Errores;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ErrorA extends VistasGenerales.Panel{
    
    public JLabel id, p, d, c;
    public JTextField ID, P, C;
    public JTextArea D;
    
    public ErrorA(){
        crea();
        agrega();
        
    }
    private void crea(){
    id = new JLabel ("ID");
        p = new JLabel ("Proveedor");
        d = new JLabel ("Descripción del defecto");
        c = new JLabel ("Cantidad");
        
        ID = new JTextField (10);
        P = new JTextField (10);
        D = new JTextArea ();
        C = new JTextField (10);
        
        D.setColumns(15);
        D.setRows(10);
        D.setBorder(new LineBorder(Color.BLACK));
    }
    private void agrega(){
    add(id);
    add(p);
    add(d);
    add(c);
    add(ID);
    add(P);
    add(D);
    add(C);
    }
}
