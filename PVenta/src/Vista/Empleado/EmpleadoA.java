package Vista.Empleado;

/**
 *
 * @author landr
 */
import VistasGenerales.*;
import com.toedter.calendar.JDateChooser;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import Controlador.Empleado.AgregaEmpleado;
import static java.util.Calendar.DAY_OF_MONTH;
import Controlador.General.General;


public class EmpleadoA extends VistasGenerales.Panel implements ActionListener {

    JLabel n, t, c, cc, u, l, f, s, tu, v1, v2, v3, v4, v5;
    JTextField N, T, U;
    JComboBox TU, S;
    Contrasena C, CC;
    private Panel P = new Panel();
    Panel hora;
    Panel contrasenas;
    VistasGenerales.Number tel;
    JButton ag, ca, agsu, bosu;
    VistasGenerales.Tabla tab;
    JDateChooser fecha;
    AgregaEmpleado ea = new AgregaEmpleado();
    final String cols[] = {"Empleado", "Teléfono", "Usuario", "Contraseña"};
    NSucursal nsucursal = new NSucursal();
    EmpleadoM em = new EmpleadoM();
    EmpleadoB eb = new EmpleadoB();
    General g = new General();
    

    public EmpleadoA() {
        this.setLayout(new GridBagLayout());
        crea();
        agrega();
        validate();
        ca.addActionListener(this);
        ag.addActionListener(this);
        if (g.vacio("sucursal")>0 && g.vacio("usuarios")>0){
        llenaSuc();
        llenaTipo();
        }
        agsu.addActionListener(this);
        this.bosu.addActionListener(this);
        nsucursal.aceptar.addActionListener(this);
        

    }

    private void crea() {
        hora = new Panel();
        hora.setBorder(BorderFactory.createTitledBorder("Horario"));
        hora.setLayout(new GridBagLayout());
        contrasenas = new Panel();
        contrasenas.setBorder(BorderFactory.createTitledBorder("Contraseña"));
        contrasenas.setLayout(new GridBagLayout());
        n = new JLabel("Nombre");
        t = new JLabel("Teléfono");
        c = new JLabel("Nueva");
        cc = new JLabel("Contraseña");
        u = new JLabel("Usuario");
        N = new JTextField();
        N.setToolTipText("Puede tener nombre y apellido, no deben"
                + " ser más de 50 caractéres y deben ser nombres únicos");
        tel = new VistasGenerales.Number();
        tel.tf.setToolTipText("Los números telefónicos tienen 10"
                + " dígitos sin separaciones ni espacios.");
        C = new Contrasena();
        C.pf.setToolTipText("Las contraseñas son secretas");
        CC = new Contrasena();
        CC.pf.setToolTipText("Las contraseñas son secretas");
        U = new JTextField();
        U.setToolTipText("El empleado puede escoger su nombre de usuario,"
                + " con este va a iniciar sesión");
        TU = new JComboBox();
        TU.setToolTipText("Los usuarios serán vendedores o administradores,"
                + " esto garantiza privilegios de modificar el inventario,"
                + " empleados, y revisar la información importante");
        S = new JComboBox();
        S.setToolTipText("Esto indica la sucursal en la que trabaja este empleado");
        fecha = new JDateChooser();
        fecha.setToolTipText("La fecha es para indicar el día en que"
                + " el empleado ha sido contratado");
        l = new JLabel("Información del empleado");
        l.setHorizontalAlignment(JLabel.CENTER);
        P.setLayout(new GridBagLayout());
        ag = new JButton("Crear usuario");
        ca = new JButton("Borrar");
        f = new JLabel("Fecha");
        s = new JLabel("Sucursal");
        v1 = new JLabel(" ");
        v2 = new JLabel(" ");
        v3 = new JLabel(" ");
        v4 = new JLabel(" ");
        v5 = new JLabel(" ");
        tu = new JLabel("Tipo de usuario");
        
        agsu = new JButton("Nueva sucursal");
        agsu.setFocusable(false);
        agsu.setToolTipText("Agrega una sucursal");
        
        bosu = new JButton("Eliminar sucursal");
        bosu.setFocusable(false);
        bosu.setToolTipText("Elimina una sucursal");

        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
    }

    private GridBagConstraints estilo(int pox, int poy, int tax, int tay, int fill, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = pox;
        gbc.gridy = poy;
        gbc.gridwidth = tax;
        gbc.gridheight = tay;
        gbc.fill = fill;
        gbc.anchor = anchor;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        return gbc;
    }
    
    private void llenaSuc() {
        Object O[] = ea.getSuc();
        for (int i = 0; i < O.length; i++) {
            S.addItem(O[i]);
        }
    }
    
    private void llenaTipo() {
        Object O[] = ea.getTipo();
        for (int i = 0; i < O.length; i++) {
            TU.addItem(O[i]);
        }
    }

    private void agrega() {
        P.add(l, estilo(0, 0, 8, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(n, estilo(1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(N, estilo(1, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(u, estilo(1, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(U, estilo(1, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(c, estilo(0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(C, estilo(0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(cc, estilo(0, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(CC, estilo(0, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(contrasenas, estilo(1, 6, 1, 4, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(v1, estilo(2, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(t, estilo(3, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(tel.tf, estilo(3, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(f, estilo(3, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(fecha, estilo(3, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(s, estilo(3, 5, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(S, estilo(3, 6, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(tu, estilo(3, 7, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(TU, estilo(3, 8, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(v2, estilo(4, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(agsu, estilo(5, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        P.add(bosu, estilo(5, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        P.add(ag, estilo(5, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        P.add(ca, estilo(5, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        P.add(v3, estilo(0, 10, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(v4, estilo(8, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        add(P, estilo(0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        add(tab, estilo(0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
    }

    
    
    private boolean validaCant() {
        boolean ca;
        if (tel.tf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingrear un número válido.");
            return false;
        } else {
            if (tel.tf.getText().length() < 10 || tel.tf.getText().length() > 10) {
                JOptionPane.showMessageDialog(null, "Debe ingrear un número válido.");
                return false;
            } else {
                ca = true;
            }
            
        }
        return ca;
    }
    
    private boolean validatel() {
        boolean ca;
        if (nsucursal.Telefono.tf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingrear un número válido.");
            return false;
        } else {
            if (nsucursal.Telefono.tf.getText().length() < 10 || nsucursal.Telefono.tf.getText().length() > 10) {
                JOptionPane.showMessageDialog(null, "Debe ingrear un número válido.");
                return false;
            } else {
                ca = true;
            }
            
        }
        return ca;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(ca)) {
            N.setText("");
            C.setText("");
            CC.setText("");
            U.setText("");
            TU.setSelectedIndex(0);
            S.setSelectedIndex(0);
            tel.tf.setText("");

            fecha.repaint();

        }
        
        

        if (ae.getSource().equals(ag)) {
            if (validaCant()) {
                
                Object O[] = {N.getText(), tel.tf.getText(),
                    U.getText(), C.pf.getText(), fecha.getDate()};
                
                if (C.pf.getText().equals(CC.pf.getText())) {

                    if (g.valida(O)) {
                        String f = ("20" +fecha.getDate().getYear()%100)
                                + "-" + fecha.getDate().getMonth()
                                + "-" + fecha.getCalendar().get(DAY_OF_MONTH);
                        Object o[] = {N.getText(), tel.tf.getText(),
                            U.getText(), C.pf.getText(), TU.getSelectedItem(), S.getSelectedItem().toString(), f};
                        ea.agrega(o);
                        tab.setRow(o);
                        
                    }
                } else {
                    System.out.println("Contraseña no válida");

                }

            }
        }
        
        if (ae.getSource().equals(agsu)) {
            nsucursal.setVisible(true);
        }
        if (ae.getSource().equals(bosu)) {
            nsucursal.setVisible(true);
        }
        if (ae.getSource().equals(nsucursal.aceptar)) {
            
            Object O[] = new Object[4];
            O[0] = nsucursal.Nombre.getText();
            O[1] = nsucursal.Direccion.getText();
            O[2] = nsucursal.Telefono.tf.getText();
            if (validatel()){
            nsucursal.prov.b = nsucursal.prov.agrega(O);
            if (nsucursal.prov.b) {
                nsucursal.dispose();
                nsucursal.limpia();
                S.removeAllItems();
                llenaSuc();

            }
            }

        }
        
        
    }
}
