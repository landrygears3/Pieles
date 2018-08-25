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
import Controlador.General.General;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controlador.Errores.ControlError;
import Controlador.Errores.ErrorV;
import javax.swing.JOptionPane;

public class ErrorA extends VistasGenerales.Panel implements ActionListener{
    
    public JLabel id, d, c, v1, v2, v3, v4, v5, va, vb, vc, vd, ve, vf, vg;
    public JComboBox ID, P;
    public JTextArea D;
    public Panel Pa = new Panel();
    public Panel Pb = new Panel();
    Container co = new Container();
    Container co2 = new Container();
    final String cols[] = {"Producto", "Cantidad", "Proveedor", "Descripción"};
    VistasGenerales.Tabla tab;
    VistasGenerales.Number CAN;
    JButton ag, ca;
    General g = new General();
    ControlError e = new ControlError();
    ErrorV ev = new ErrorV();
    
    public ErrorA(){
        crea();
        agrega();
        if (g.vacio("productos")>0 && g.vacio("proveedores")>0){
            llenaProducto();
            llenaProveedor();
        if (ev.respn("defectos", "productos", "proveedores")) {
            llena();
        }
        }
        
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
        
        
        ID = new JComboBox ();
        P = new JComboBox ();
        D = new JTextArea ();
        CAN = new VistasGenerales.Number();
        
        D.setColumns(10);
        D.setRows(6);
        D.setBorder(new LineBorder(Color.BLACK));
        
        ag = new JButton("Guardar defecto");
        ca = new JButton("Borrar");
        
        setLayout(new GridBagLayout());
        Pa.setLayout(new GridBagLayout());
        Pb.setLayout(new GridBagLayout());
        co.setLayout(new GridBagLayout());
        co2.setLayout(new GridLayout(5,1));
        
        
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        
        ag.addActionListener(this);
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
        
        
        add(v3, estilo(0,0,1,1));
        add(co, estilo(1,0,1,1));
        add(Pb, estilo(2,0,1,1));
        add(tab, estilo(0,2,3,1));
    }
    
    private void llena() {
        tab.setRow(ev.getDatos());
    }
    
    public boolean valida(Object datos[]) {
        boolean b = false;
        for (int i = 0; i < datos.length; i++) {
            if (!datos[i].toString().trim().equals("")) {

                b = true;
                System.out.println("Válido");
            } else {

                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                break;
            }

        }

        if (b) {
            if (JOptionPane.showConfirmDialog(null, "Esta a punto de crear un nuevo usuario.\t\n¿Desea continuar?") == 1) {
                b = false;
            }
        }
        return b;
    }
        
    
    private void llenaProducto() {
        Object O[] = g.getProd();
        for (int i = 0; i < O.length; i++) {
            ID.addItem(O[i]);
        }
    }
    
    private void llenaProveedor() {
        Object O[] = g.getProv();
        for (int i = 0; i < O.length; i++) {
            P.addItem(O[i]);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(ag)) {
            Object O[] = {e.getId(ID.getSelectedIndex()), D.getText(),
                CAN.tf.getText(), e.getId(P.getSelectedIndex())};
            if (g.valida(O)){
                e.agrega(O);
            }
        }
    }
    
}
