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

public class EmpleadoM extends VistasGenerales.Panel implements ActionListener {
    
    Admin ad=new Admin();
    private JLabel n, t, c, cc, u, l, a, he, hs, s, tu, v1, v2, v3, v4, v5;
    private JTextField U;
    private JComboBox TU, S, N;
    private Contrasena C, CC;
    String Tu[] = {"Tipo de usuario"};
    String Su[] = {"Sucursal"};
    private Panel P = new Panel();
    Panel hora;
    Panel contrasenas, con;
    VistasGenerales.Number tel;
    JButton ag, ca, adm;
    VistasGenerales.Tabla tab;
    VistasGenerales.TimeChoser horae, horas;
    JPasswordField cona;
    final String cols[] = {"Empleado", "Teléfono", "Usuario", "Contraseña"};

    public EmpleadoM() {
        this.setLayout(new GridBagLayout());
        crea();
        agrega();
        validate();
        adm.addActionListener(this);

    }

    private void crea() {
        hora = new Panel();
        con = new Panel();
        con.setLayout(new BorderLayout());
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
        N = new JComboBox();
        tel = new VistasGenerales.Number();
        C = new Contrasena();
        CC = new Contrasena();
        U = new JTextField();
        TU = new JComboBox(Tu);
        S = new JComboBox(Su);
        horae = new VistasGenerales.TimeChoser();
        horas = new VistasGenerales.TimeChoser();
        cona = new JPasswordField();
        l = new JLabel(" ");
        l.setHorizontalAlignment(JLabel.CENTER);
        P.setLayout(new GridBagLayout());
        ag = new JButton("Editar usuario");
        ag.setFocusable(false);
        ca = new JButton("Borrar");
        ca.setFocusable(false);
        adm = new JButton();
        adm.setFocusable(false);
        a = new JLabel("Contraseña anterior");
        he = new JLabel("Entrada");
        hs = new JLabel("Salida");
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
        hora.add(he, estilo(0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        hora.add(horae, estilo(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        hora.add(hs, estilo(0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        hora.add(horas, estilo(0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        P.add(hora, estilo(5, 1, 1, 4, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(ag, estilo(5, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        P.add(ca, estilo(5, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        P.add(v3, estilo(0, 10, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(v4, estilo(8, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        add(l, estilo(0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        add(P, estilo(0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        add(v5, estilo(0, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(adm)){
        ad.setVisible(true);
        }
    }
}
