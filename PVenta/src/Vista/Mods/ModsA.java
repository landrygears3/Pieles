package Vista.Mods;

import VistasGenerales.Panel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author landr
 */
public class ModsA extends VistasGenerales.Panel{
    
    JLabel m, v1, v2, v3, v4, v5, v6, v7, v8;
    JTextField M;
    public Panel P = new Panel();
    Panel P2 = new Panel();
    VistasGenerales.Tabla tab;
    VistasGenerales.Number cantidad;
    final String cols[] = {"ID", "Modelo"};
    
    public ModsA(){
        crea();
        agrega();
    }
    
    private void crea(){
        P2.setLayout(new GridLayout(5, 1));
        P.setLayout(new GridBagLayout());
        m = new JLabel("Introduzca un modelo nuevo");
        M = new JTextField(10);
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        v1 = new JLabel(" ");       v2 = new JLabel(" ");
        v3 = new JLabel(" ");       v4 = new JLabel(" ");
        v5 = new JLabel(" ");       v6 = new JLabel(" ");
        v7 = new JLabel(" ");       v8 = new JLabel(" ");
    }
    
    private GridBagConstraints estilo(int pox, int poy, int tax, int tay) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = pox;
        gbc.gridy = poy;
        gbc.gridwidth = tax;
        gbc.gridheight = tay;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        return gbc;
    }
    
    
    private void agrega(){
        
        P2.add(v5);
        P2.add(m);
        P2.add(v6);
        P2.add(M);
        P2.add(v7);
        
        P.add(v1, estilo(0, 0, 5, 1));
        P.add(v2,  estilo(0, 1, 2, 1));
        P.add(P2, estilo(2, 1, 1, 1));
        P.add(v3, estilo(3, 1 , 2, 1));
        P.add(tab, estilo(0, 2, 5, 1));
    }
    
}
