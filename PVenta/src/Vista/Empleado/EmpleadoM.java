package Vista.Empleado;

import VistasGenerales.*;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import Controlador.Empleado.AgregaEmpleado;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import Controlador.General.General;

public final class EmpleadoM extends VistasGenerales.Panel implements ActionListener {

    Admin ad = new Admin();
    private JLabel n, t, c, cc, u, l, a, s, tu, v1, v2, v3, v4, v5;
    public JTextField U;
    public JComboBox TU, S, N;
    public Contrasena C, CC;
    private Panel P = new Panel();
    Panel contrasenas, con;
    VistasGenerales.Number tel;
    JButton ag, adm, b;
    VistasGenerales.Tabla tab;
    JPasswordField cona;
    final String cols[] = {"Empleado", "Teléfono", "Usuario", "Contraseña"};
    JCheckBox contra = new JCheckBox();
    AgregaEmpleado ea = new AgregaEmpleado();
    General g = new General();

    public EmpleadoM() {
        this.setLayout(new GridBagLayout());
        crea();
        agrega();
        validate();
        if (g.vacio("empleados")>0){
            llenaNombre();
            
        }
        adm.addActionListener(this);
        ad.ac.addActionListener(this);
        N.addActionListener(this);
        contra.addActionListener(this);
        ag.addActionListener(this);
        }

    private void crea() {
        con = new Panel();
        con.setLayout(new BorderLayout());
        contrasenas = new Panel();
        contrasenas.setBorder(BorderFactory.createTitledBorder("Contraseña"));
        contrasenas.setLayout(new GridBagLayout());
        n = new JLabel("Nombre");
        t = new JLabel("Teléfono");
        c = new JLabel("Nueva");
        cc = new JLabel("Contraseña");
        u = new JLabel("Usuario");
        N = new JComboBox();
        tel = new VistasGenerales.Number();
        C = new Contrasena();
        C.pf.setEditable(false);
        CC = new Contrasena();
        CC.pf.setEditable(false);
        U = new JTextField();
        TU = new JComboBox();
        S = new JComboBox();
        cona = new JPasswordField();
        l = new JLabel(" ");
        l.setHorizontalAlignment(JLabel.CENTER);
        P.setLayout(new GridBagLayout());
        ag = new JButton("Editar usuario");
        ag.setFocusable(false);
        b = new JButton("Dar de baja usuario");
        b.setFocusable(false);
        adm = new JButton();
        adm.setFocusable(false);
        a = new JLabel("Contraseña anterior");
        s = new JLabel("Sucursal");
        v1 = new JLabel(" ");
        v2 = new JLabel(" ");
        v3 = new JLabel(" ");
        v4 = new JLabel(" ");
        v5 = new JLabel(" ");
        tu = new JLabel("Tipo de usuario");

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

    final public void llenaNombre() {
        if (N.getItemCount()>0){
            N.removeAllItems();
        }
        Object O[] = g.getName();
        for (int i = 0; i < O.length; i++) {
            N.addItem(O[i]);
            int cba = Integer.parseInt(g.getEstado(O[i].toString()));
        if (cba < 1) {
            N.removeItem(O[i]);
        }
            
        }
    }

    final public void llenaTel() {
        String Nom = N.getSelectedItem().toString();
        String eab = g.getTel(Nom);
        tel.tf.setText(eab);
    }

    final public void llenaUsuario() {
        String Nom = N.getSelectedItem().toString();
        String eab = g.getUsuario(Nom);
        U.setText(eab);
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
            TU.setSelectedIndex(i);
        }
    }

    final public void llenaPass() {
        String Nom = N.getSelectedItem().toString();
        String eab = g.getPass(Nom);
        cona.setText(eab);
    }

    private void selectSuc() {
        String Nom = N.getSelectedItem().toString();
        S.setSelectedItem(g.selSuc(Nom));

    }

    private void selectTU() {
        String Nom = N.getSelectedItem().toString();
        TU.setSelectedItem(g.selUs(Nom));

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

    private void agrega() {
        P.add(n, estilo(1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(N, estilo(1, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(a, estilo(1, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        con.add(cona, BorderLayout.CENTER);
        con.add(adm, BorderLayout.EAST);
        P.add(con, estilo(1, 5, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(c, estilo(0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(C, estilo(0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(cc, estilo(0, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(CC, estilo(0, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        contrasenas.add(contra, estilo(0, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(contrasenas, estilo(1, 6, 1, 4, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(v1, estilo(2, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(t, estilo(3, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(tel.tf, estilo(3, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(u, estilo(3, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(U, estilo(3, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(s, estilo(3, 5, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(S, estilo(3, 6, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(tu, estilo(3, 7, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(TU, estilo(3, 8, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(v2, estilo(4, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(ag, estilo(5, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        P.add(v3, estilo(0, 10, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(v4, estilo(8, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        add(l, estilo(0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        add(P, estilo(0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        add(v5, estilo(0, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(adm)) {
            ad.setVisible(true);
        }
        if (ae.getSource().equals(ad.ac)) {
            if (ad.Validate()) {
                cona.setEchoChar((char) 0);
                cona.setEditable(false);
                cona.setHorizontalAlignment(JPasswordField.CENTER);
                cona.setText("VALIDADO");
                adm.setEnabled(false);
                N.setEnabled(false);
            }
        }
        if (ae.getSource().equals(ag)) {
            if (validaCant()) {

                if (contra.isSelected()) {
                    if (C.pf.getText().equals(CC.pf.getText())) {
                        Object O[] = {tel.tf.getText(),
                            U.getText(), cona.getText(), C.pf.getText()};
                        if (g.valida(O)) {
                            String campos[] = {"Telefono", "Usuario", "Contrasena", "TipoU", "Sucursal"};
                            Object o[] = {tel.tf.getText(),
                                U.getText(), C.pf.getText(), TU.getSelectedItem(), S.getSelectedItem().toString()};
                            ea.mod(campos, o, N.getSelectedItem().toString());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas deben coincidir");
                    }
                } else {
                    Object O[] = {tel.tf.getText(),
                        U.getText(), cona.getText()};
                    if (g.valida(O)) {
                        String campos[] = {"Telefono", "Usuario", "TipoU", "Sucursal"};
                        Object o[] = {tel.tf.getText(), U.getText(),
                            TU.getSelectedItem(), S.getSelectedItem()};
                        
                        ea.mod(campos, o, N.getSelectedItem().toString());

                    }
                }
            }
        }
        if (ae.getSource().equals(N)) {
            if(N.getItemCount()>0){
            llenaUsuario();
            llenaPass();
            llenaTel();
            llenaUsuario();
            selectSuc();
            selectTU();
            }
        }
        if (ae.getSource().equals(contra)) {
            if (contra.isSelected()) {
                CC.pf.setEditable(true);
                C.pf.setEditable(true);
            } else {
                CC.pf.setEditable(false);
                C.pf.setEditable(false);
            }
        }

//        if (ae.getSource().equals(bor.c)) {
//            N.removeItem(M.Nombre);
//            M.fm(false);
//        }
    }
}
