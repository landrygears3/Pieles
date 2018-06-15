package Vista.Proveedor;

/**
 *
 * @author landr
 */
import VistasGenerales.Panel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class ProveedorA extends VistasGenerales.Panel {

    public JLabel id, n, c, co, v1, v2, v3, v4, v5, v6, v7, v8;
    public JTextField ID, N, C;
    public JTextArea CO;
    public Panel P = new Panel();
    Panel P2 = new Panel();
    VistasGenerales.Tabla tab;
    VistasGenerales.Number cantidad;
    final String cols[] = {"ID", "Modelo"};

    public ProveedorA() {
        crea();
        agrega();
    }

    private void crea() {
        P.setLayout(new GridLayout(3, 3));
        P2.setLayout(new GridLayout(7, 2));
        id = new JLabel("Empresa");
        n = new JLabel("Nombre proveedor");
        c = new JLabel("Número o correo");
        co = new JLabel("Comentarios");
        
        v1 = new JLabel(" ");       v2 = new JLabel(" ");
        v3 = new JLabel(" ");       v4 = new JLabel(" ");
        v5 = new JLabel(" ");       v6 = new JLabel(" ");
        v7 = new JLabel(" ");       v8 = new JLabel(" ");

        ID = new JTextField(10);
        N = new JTextField(10);
        C = new JTextField(10);

        CO = new JTextArea();
        CO.setColumns(15);
        CO.setRows(10);
        CO.setBorder(new LineBorder(Color.BLACK));

    }
    
    private void agrega() {
        
        P2.add(id);
        P2.add(ID);
        P2.add(v1);
        P2.add(n);
        P2.add(N);
        P2.add(v2);
        P2.add(c);
        P2.add(C);
        P2.add(v3);
        P2.add(co);
        P2.add(CO);
        
        P.add(v1);
        P.add(v2);
        P.add(v3);
        P.add(v4);
        P.add(P2);
        P.add(v5);
        P.add(v6);
        P.add(v7);
        P.add(v8);
    }
}
