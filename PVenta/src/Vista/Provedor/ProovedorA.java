package Vista.Provedor;

/**
 *
 * @author landr
 */
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class ProovedorA {
    public JLabel id, n, c, co;
    public JTextField ID, N, C;
    public JTextArea CO;
    
    public ProovedorA(){
        
        
        id = new JLabel ("Empresa");
        n = new JLabel ("Nombre proovedor");
        c = new JLabel("Número o correo");
        co = new JLabel ("Comentarios");
        
        ID = new JTextField(10);
        N = new JTextField (10);
        C = new JTextField (10);
        
        CO = new JTextArea ();
        CO.setColumns(15);
        CO.setRows(10);
        CO.setBorder(new LineBorder(Color.BLACK));
    }
}
