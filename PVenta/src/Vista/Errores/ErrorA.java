package Vista.Errores;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ErrorA {
    
    public JLabel id, p, d, c;
    public JTextField ID, P, C;
    public JTextArea D;
    
    public ErrorA(){
        id = new JLabel ("ID");
        p = new JLabel ("Proovedor");
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
    
}
