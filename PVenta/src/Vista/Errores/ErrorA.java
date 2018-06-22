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
    
    public JLabel id, p, d, c, v1, v2, v3, v4, v5, va, vb, vc, vd, ve, vf, vg;
    public JComboBox ID, P;
    public JTextArea D;
    public Panel Pa = new Panel();
    public Panel Pr = new Panel();
    public Panel Pb = new Panel();
    Container co = new Container();
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
    id.setHorizontalAlignment(JLabel.RIGHT);
        p = new JLabel ("Proveedor");
        d = new JLabel ("Descripción del defecto");
        d.setHorizontalAlignment(JLabel.RIGHT);
        c = new JLabel ("Cantidad");
        c.setHorizontalAlignment(JLabel.RIGHT);
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
        
        D.setColumns(15);
        D.setRows(10);
        D.setBorder(new LineBorder(Color.BLACK));
        
        ag = new JButton("Guardar defecto");
        ca = new JButton("Cancelar");
        
        Pr.setLayout(new GridBagLayout());
        Pa.setLayout(new GridBagLayout());
        Pb.setLayout(new GridBagLayout());
        co.setLayout(new GridLayout(1,2));
        
        
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
        
        co.add(d);
        co.add(D);
        
        Pa.add(v3, estilo(0,0,6,4));
        Pa.add(v4, estilo(0,4,6,4));
        Pa.add(id, estilo(1,8,1,1));
        Pa.add(ID, estilo(2,8,1,1));
        Pa.add(c, estilo(4,8,1,1));
        Pa.add(CAN.tf, estilo(5,8,1,1));
        Pa.add(P, estilo(6,8,1,1));
        Pa.add(v2, estilo(0,9,6,5));
        Pa.add(v5, estilo(0,14,6,4));
        
        Pb.add(va, estilo(0,0,3,1));
        Pb.add(vb, estilo(0,1,3,1));
        Pb.add(vc, estilo(0,2,1,1));
        Pb.add(ag, estilo(1,2,1,1));
        Pb.add(ve, estilo(2,2,1,1));
        Pb.add(vg, estilo(0,3,3,1));
        Pb.add(vd, estilo(0,4,1,1));
        Pb.add(ca, estilo(1,4,1,1));
        Pb.add(vf, estilo(2,4,1,1));
        
        
        
        Pr.add(Pa, estilo(0,0,1,1));
        Pr.add(co, estilo(1,0,1,1));
        Pr.add(Pb, estilo(2,0,1,1));
        Pr.add(v1, estilo(0,1,3,1));
        Pr.add(tab, estilo(0,2,3,1));
    }
}
