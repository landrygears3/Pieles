package Vista.PRoducto;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author landr
 */
public class ProductoA {
    public JLabel id, t, tp, mo, col, des, cc, pv, pro, can,
            im, su, pi, CC, PRO, IM;
    public JTextField ID, CAN, PV;
    public String Prod[] = {"Tipo de producto"};
    public String Pago[] = {"Tipo de pago"};
    public String Mod[] = {"Modelo"};
    public String Color[] = {"Color"};
    public String Des[] = {"Descripción"};
    public String Suc[] = {"Sucursal"};
    public String piel[] = {"Tipo de piel"};
    public JComboBox T, TP, MO, COL, DES, SU, PI;
    
    
    public ProductoA(){
        
        id = new JLabel("ID");
        cc = new JLabel("Costo Compra");
        pv = new JLabel("Precio de venta");
        pro = new JLabel("Proveedor");
        can = new JLabel("Cantidad");
        im = new JLabel("(Insertar imagen)");
        ID = new JTextField(10);
        CAN = new JTextField(10);
        PV = new JTextField(10);
        CC = new JLabel("$");
        PRO = new JLabel("NOMBRE DE LA EMPRESA");
        IM = new JLabel("");
        T = new JComboBox(Prod);
        TP = new JComboBox(Pago);
        MO = new JComboBox(Mod);
        COL = new JComboBox(Color);
        DES = new JComboBox(Des);
        SU = new JComboBox(Suc);
        PI = new JComboBox(piel);
        
        
        
    }
}
