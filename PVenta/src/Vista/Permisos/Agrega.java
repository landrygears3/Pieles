package Vista.Permisos;

import com.toedter.calendar.JDateChooser;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Agrega extends VistasGenerales.Panel {
    
    JPanel p = new JPanel(new GridBagLayout());
    JLabel lempleado, ltipo, lmotivo, lhoras, lhorae, lfecha;
    JComboBox empleado, tipo;
    JTextField motivo;
    VistasGenerales.TimeChoser horae, horas;
    JDateChooser fecha;
    JButton aceptar;
    
    public Agrega() {
        setLayout(new GridLayout(3, 3));
        crea();
        agrega();
    }
    
    private void crea() {
        lempleado = new JLabel("Empleado");
        ltipo = new JLabel("Tipo de permiso");
        lmotivo = new JLabel("Motivo");
        lhoras = new JLabel("Hora de entrada");
        lhorae = new JLabel("Hora de salida");
        lfecha = new JLabel("Fecha");
        empleado = new JComboBox();
        tipo = new JComboBox();
        motivo = new JTextField();
        horae = new VistasGenerales.TimeChoser();
        horas = new VistasGenerales.TimeChoser();
        fecha = new JDateChooser();
        aceptar = new JButton("Aceptar");
        aceptar.setFocusable(false);
        
    }
    
    private void agrega() {
        JLabel v = new JLabel(" ");
        //empelado
        p.add(lempleado, estilo(0, 0, 1, 1, GridBagConstraints.BOTH));
        p.add(empleado, estilo(0, 1, 1, 1, GridBagConstraints.BOTH));
        //fecha
        p.add(lfecha, estilo(2, 0, 1, 1, GridBagConstraints.BOTH));
        p.add(fecha, estilo(2, 1, 1, 1, GridBagConstraints.BOTH));
        //tipo
        p.add(ltipo, estilo(0, 2, 1, 1, GridBagConstraints.BOTH));
        p.add(tipo, estilo(0, 3, 1, 1, GridBagConstraints.BOTH));
        //motivo
        p.add(lmotivo, estilo(2, 2, 1, 1, GridBagConstraints.BOTH));
        p.add(motivo, estilo(2, 3, 1, 1, GridBagConstraints.BOTH));
        //hora entrada
        p.add(lhorae, estilo(0, 4, 1, 1, GridBagConstraints.BOTH));
        p.add(horae, estilo(0, 5, 1, 1, GridBagConstraints.BOTH));
        //hora salida
        p.add(lhoras, estilo(2, 4, 1, 1, GridBagConstraints.BOTH));
        p.add(horas, estilo(2, 5, 1, 1, GridBagConstraints.BOTH));
        //separador
        p.add(v, estilo(1, 6, 1, 1, GridBagConstraints.BOTH));
        //boton
        p.add(aceptar, estilo(1, 7, 1, 1, GridBagConstraints.BOTH));
        
        JLabel v1 = new JLabel(" ");
        JLabel v2 = new JLabel(" ");
        JLabel v3 = new JLabel(" ");
        JLabel v4 = new JLabel(" ");
        JLabel v5 = new JLabel(" ");
        JLabel v6 = new JLabel(" ");
        add(v1);
        add(v2);
        add(v3);
        add(v4);
        add(p);
        add(v5);
        add(v6);
    }
    
    private GridBagConstraints estilo(int pox, int poy, int tax, int tay, int fill) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = pox;
        gbc.gridy = poy;
        gbc.gridwidth = tax;
        gbc.gridheight = tay;
        gbc.fill = fill;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        return gbc;
    }
}