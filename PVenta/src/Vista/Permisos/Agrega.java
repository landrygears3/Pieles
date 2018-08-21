package Vista.Permisos;

import com.toedter.calendar.JDateChooser;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controlador.Permisos.AgregaPermiso;
import static java.util.Calendar.DAY_OF_MONTH;
import Controlador.General.General;

public class Agrega extends VistasGenerales.Panel implements ActionListener {

    JPanel p = new JPanel(new GridBagLayout());
    JLabel lempleado, ltipo, lmotivo, lfecha;
    JComboBox empleado, tipo;
    JTextField motivo;
    JDateChooser fecha;
    JButton aceptar, bpermiso;
    AgregaPermiso ap = new AgregaPermiso();
    NPermiso npermiso = new NPermiso();
    General g = new General();

    public Agrega() {

        setLayout(new GridLayout(3, 3));
        crea();
        agrega();
        if (g.vacio("tipo_permiso") > 0 && g.vacio("usuarios") > 0) {
            llenaPermiso();
            llenaEmpleado();
        }

        bpermiso.addActionListener(this);
        npermiso.aceptar.addActionListener(this);
        aceptar.addActionListener(this);
    }

    private void llenaPermiso() {
        Object o[] = npermiso.prov.getPermiso();
        for (int i = 0; i < o.length; i++) {
            tipo.addItem(o[i]);
        }
    }

    private void crea() {
        lempleado = new JLabel("Empleado");
        ltipo = new JLabel("Tipo de permiso");
        lmotivo = new JLabel("Motivo");
        lfecha = new JLabel("Fecha");
        empleado = new JComboBox();
        tipo = new JComboBox();
        motivo = new JTextField();
        bpermiso = new JButton("Nuevo permiso");
        bpermiso.setFocusable(false);
        bpermiso.setToolTipText("Agrega un proveedor");
        fecha = new JDateChooser();
        aceptar = new JButton("Aceptar");
        aceptar.setFocusable(false);

    }

    private void llenaEmpleado() {
        Object O[] = g.getName();
        for (int i = 0; i < O.length; i++) {
            empleado.addItem(O[i]);
            int cba = Integer.parseInt(g.getEstado(O[i].toString()));
        if (cba < 1) {
            empleado.removeItem(O[i]);
        }
        }
        
    }

    private void agrega() {
        JLabel v = new JLabel(" ");
        JLabel va = new JLabel(" ");
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
        //separador
        p.add(v, estilo(1, 6, 1, 1, GridBagConstraints.BOTH));
        //boton
        p.add(aceptar, estilo(0, 7, 1, 1, GridBagConstraints.BOTH));
        p.add(bpermiso, estilo(2, 7, 1, 1, GridBagConstraints.BOTH));
        p.add(va, estilo(1, 7, 1, 1, GridBagConstraints.BOTH));

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

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(npermiso.aceptar)) {
            Object O[] = new Object[3];
            O[0] = npermiso.Perm.getText();
            O[1] = npermiso.Desc.getText();
            npermiso.prov.b = npermiso.prov.agrega(O);
            if (npermiso.prov.b) {
                npermiso.dispose();
                npermiso.limpia();
                tipo.removeAllItems();
                llenaPermiso();

            }

        }

        if (ae.getSource().equals(aceptar)) {

            Object O[] = {empleado.getSelectedItem(), tipo.getSelectedItem(),
                fecha.getDate(), motivo.getText()};
            String ID = g.emID(empleado.getSelectedItem().toString());
            String PE = ap.PeID(tipo.getSelectedItem().toString());

                if (g.valida(O)) {
                    String f = ("20" + fecha.getDate().getYear() % 100)
                            + "-" + fecha.getDate().getMonth()
                            + "-" + fecha.getCalendar().get(DAY_OF_MONTH);
                    
                    Object o[] = {ID, PE,
                f, motivo.getText()};

                    ap.agrega(o);
                }

        }

        if (ae.getSource().equals(bpermiso)) {
            npermiso.setVisible(true);
        }
    }
}
