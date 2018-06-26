package Vista.Errores;

import VistasGenerales.Panel;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class ErrorA extends VistasGenerales.Panel{
    
    public JLabel id, d, c, v1, v2, v3, v4, v5, va, vb, vc, vd, ve, vf, vg;
    public JComboBox ID, P;
    public JTextArea D;
    public Panel Pa = new Panel();
    public Panel Pr = new Panel();
    public Panel Pb = new Panel();
    Container co = new Container();
    Container co2 = new Container();
    final String cols[] = {"Producto", "Cantidad", "Proveedor", "Descripción"};
    VistasGenerales.Tabla tab;
    VistasGenerales.Number CAN;
    String[] ids = {"Producto"};
    String[] ps = {"Proveedores"};
    JButton ag, ca;
    
    public ErrorA(){
        crea();
        agrega();
        
    }
    private void crea(){
    id = new JLabel ("ID");
    id.setHorizontalAlignment(JLabel.CENTER);
        d = new JLabel ("Descripción del defecto");
        d.setHorizontalAlignment(JLabel.CENTER);
        c = new JLabel ("Cantidad");
        c.setHorizontalAlignment(JLabel.CENTER);
        v1 = new JLabel(" ");       v2 = new JLabel(" ");
        v3 = new JLabel(" ");       v4 = new JLabel(" ");       
        v5 = new JLabel(" ");       vg = new JLabel(" ");
        va = new JLabel(" ");       vb = new JLabel(" ");
        vc = new JLabel(" ");       vd = new JLabel(" ");
        ve = new JLabel(" ");       vf = new JLabel(" ");
        
        
        ID = new JComboBox (ids);
        P = new JComboBox (ps);
        D = new JTextArea ();
        CAN = new VistasGenerales.Number();
        
        D.setColumns(10);
        D.setRows(6);
        D.setBorder(new LineBorder(Color.BLACK));
        
        ag = new JButton("Guardar defecto");
        ca = new JButton("Borrar");
        
        Pr.setLayout(new GridBagLayout());
        Pa.setLayout(new GridBagLayout());
        Pb.setLayout(new GridBagLayout());
        co.setLayout(new GridBagLayout());
        co2.setLayout(new GridLayout(5,1));
        
        
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        
        
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
        
        co2.add(c);
        co2.add(CAN.tf);
        co2.add(v1);
        co2.add(P);
        co2.add(v2);
        
        co.add(co2, estilo(0,0,1,3));
        co.add(id, estilo(1,0,1,1));
        co.add(ID, estilo(2,0,1,1));
        co.add(d, estilo(2,1,1,1));
        co.add(D, estilo(2,2,1,1));
        
        Pb.add(va, estilo(0,0,3,2));
        Pb.add(vb, estilo(0,2,1,1));
        Pb.add(ag, estilo(1,2,1,1));
        Pb.add(vc, estilo(2,2,1,1));
        Pb.add(vd, estilo(0,3,3,2));
        Pb.add(ca, estilo(1,5,1,1));
        Pb.add(ve, estilo(2,5,1,1));
        Pb.add(vf, estilo(0,6,3,2));
        Pb.add(vg, estilo(0,8,1,1));
        
        
        Pr.add(v3, estilo(0,0,1,1));
        Pr.add(co, estilo(1,0,1,1));
        Pr.add(Pb, estilo(2,0,1,1));
        Pr.add(tab, estilo(0,2,3,1));
    }
}
