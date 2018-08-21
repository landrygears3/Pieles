package Vista.Permisos;

import Controlador.Permisos.AgregaPermiso;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Modifica extends VistasGenerales.Panel implements ActionListener {

//    JPanel p = new JPanel(new GridBagLayout());
//    JLabel lempleado, ltipo, lmotivo;
//    JComboBox empleado, tipo;
//    JTextField motivo;
//    JButton aceptar;
//    VistasGenerales.Tabla tab;
//    final String cols[] = {"Empleado", "Permiso", "Fecha", "Motivo"};
//    NPermiso npermiso = new NPermiso();
//    AgregaPermiso ap = new AgregaPermiso();
//
//    public Modifica() {
//        
//        
////        aceptar.addActionListener(this);
//        setLayout(new GridBagLayout());
//        crea();
//        agrega();
//        if (ap.vacio("permisos") > 0 && ap.vacio("usuarios") > 0) {
//            llenaPermiso();
//            llenaEmpleado();
//            llenaMotivo();
//            //llenaFecha();
//        }
//    }
//
//    private void crea() {
//        tab = new VistasGenerales.Tabla();
//        tab.setColum(cols);
//        lempleado = new JLabel("Empleado");
//        ltipo = new JLabel("Tipo de permiso");
//        lmotivo = new JLabel("Motivo");
//        empleado = new JComboBox();
//        tipo = new JComboBox();
//        motivo = new JTextField(15);
//        aceptar = new JButton("Modifica");
//        aceptar.setFocusable(false);
//        
//        
//    }
//    
//    private void llenaPermiso() {
//        Object o[] = npermiso.prov.getPermiso();
//        for (int i = 0; i < o.length; i++) {
//            tipo.addItem(o[i]);
//        }
//    }
//    
//    private void llenaEmpleado() {
//        Object O[] = ap.getName();
//        for (int i = 0; i < O.length; i++) {
//            empleado.addItem(O[i]);
//            int cba = Integer.parseInt(ap.getEstado(O[i].toString()));
//        if (cba < 1) {
//            empleado.removeItem(O[i]);
//        }
//        }
//    }
//    
//    private void llenaMotivo() {
//        String Nom = empleado.getSelectedItem().toString();
//        String cona = ap.getMotivo(Nom);
//        System.out.println(cona);
//        motivo.setText(cona);
//    }
//
//    private void agrega() {
//        JLabel v = new JLabel(" ");
//        //empelado
//        p.add(lempleado, estilo(0, 0, 1, 1, GridBagConstraints.BOTH));
//        p.add(empleado, estilo(0, 1, 1, 1, GridBagConstraints.BOTH));
//        //tipo
//        p.add(ltipo, estilo(0, 2, 1, 1, GridBagConstraints.BOTH));
//        p.add(tipo, estilo(0, 3, 1, 1, GridBagConstraints.BOTH));
//        //motivo
//        p.add(lmotivo, estilo(2, 2, 1, 1, GridBagConstraints.BOTH));
//        p.add(motivo, estilo(2, 3, 1, 1, GridBagConstraints.BOTH));
//        //separador
//        p.add(v, estilo(1, 6, 1, 1, GridBagConstraints.BOTH));
//        //boton
//        p.add(aceptar, estilo(1, 7, 1, 1, GridBagConstraints.BOTH));
//
//
//        add(p, estilo(0, 0, 1, 1, GridBagConstraints.CENTER));
//        add(tab, estilo(0, 1, 1, 1, GridBagConstraints.BOTH));
//    }
//
//    private GridBagConstraints estilo(int pox, int poy, int tax, int tay, int fill) {
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = pox;
//        gbc.gridy = poy;
//        gbc.gridwidth = tax;
//        gbc.gridheight = tay;
//        gbc.fill = fill;
//        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.weightx = 1.0;
//        gbc.weighty = 1.0;
//
//        return gbc;
//    }
//    
    @Override
    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource().equals(empleado)) {
//            llenaMotivo();
//        }
//        
//        
//        if (ae.getSource().equals(aceptar)) {
//            ap.elimina(TOOL_TIP_TEXT_KEY);
//        }
//        
    }
}
