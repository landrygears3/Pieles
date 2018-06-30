package Vista.Empleado;

/**
 *
 * @author landr
 */
import VistasGenerales.*;
import com.toedter.calendar.JDateChooser;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class EmpleadoA extends VistasGenerales.Panel {

    public JLabel n, t, c, cc, u, l, f, he, hs, s, tu, v1, v2, v3, v4, v5;
    public JTextField N, T, U;
    public JComboBox TU, S;
    public Contrasena C, CC;
    String Tu[] = {"Tipo de usuario"};
    String Su[] = {"Sucursal"};
    private Panel P = new Panel();
    Panel hora;
    Panel contrasenas;
    VistasGenerales.Number tel;
    JButton ag, ca;
    VistasGenerales.Tabla tab;
    VistasGenerales.TimeChoser horae, horas;
    JDateChooser fecha;
    final String cols[] = {"Empleado", "Teléfono", "Usuario", "Contraseña"};

    public EmpleadoA() {
        this.setLayout(new GridBagLayout());
        crea();
        agrega();
        validate();

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
        tel = new VistasGenerales.Number();
        C = new Contrasena();
        CC = new Contrasena();
        U = new JTextField();
        TU = new JComboBox(Tu);
        S = new JComboBox(Su);
        horae = new VistasGenerales.TimeChoser();
        horas = new VistasGenerales.TimeChoser();
        fecha = new JDateChooser();
        l = new JLabel("Información del empleado");
        l.setHorizontalAlignment(JLabel.CENTER);
        P.setLayout(new GridBagLayout());
        ag = new JButton("Crear usuario");
        ca = new JButton("Borrar");
        f = new JLabel("Fecha");
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
        hora.add(he, estilo(0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        hora.add(horae, estilo(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        hora.add(hs, estilo(0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        hora.add(horas, estilo(0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        P.add(hora, estilo(5, 1, 1, 4, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(ag, estilo(5, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        P.add(ca, estilo(5, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER));
        P.add(v3, estilo(0, 10, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        P.add(v4, estilo(8, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        add(P, estilo(0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
        add(tab, estilo(0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER));
    }
}
