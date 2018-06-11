package Vista.Empleado;

/**
 *
 * @author landr
 */
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class EmpleadoA extends VistasGenerales.Panel{
    public JLabel n, t, c, u;
    public JTextField N, T, U;
    public JComboBox TU, S;
    public JPasswordField C;
    String Tu[] = {"Tipo de usuario"};
    String Su[] = {"Sucursal"};
            
    
    public EmpleadoA(){
     
     n = new JLabel ("Nombre");
     t = new JLabel ("Teléfono");
     c = new JLabel ("Contraseña");
     u = new JLabel ("Usuario");
     N = new JTextField(10);
     T = new JTextField(10);
     C = new JPasswordField(10);
     U = new JTextField(10);
     TU = new JComboBox(Tu);
     S = new JComboBox(Su);
        
    }
}
