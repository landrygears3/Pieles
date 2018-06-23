package Vista.Empleado;

/**
 *
 * @author landr
 */
import VistasGenerales.Panel;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class EmpleadoA extends VistasGenerales.Panel {

    public JLabel n, t, c, u, l, v1, v2, v3, v4, v5, v6, v7,
            v8, v9, v10, v11, v12, va, vb, vc, vd, ve, vf, vg, vh;
    public JTextField N, T, U;
    public JComboBox TU, S;
    public JPasswordField C;
    String Tu[] = {"Tipo de usuario"};
    String Su[] = {"Sucursal"};
    public Panel P = new Panel();
    public Panel Pr = new Panel();
    public Panel Pb = new Panel();
    VistasGenerales.Number CAN;
    Container con = new Container();
    JButton ag, ca;

    public EmpleadoA() {

        crea();
        agrega();
        validate();

    }

    private void crea() {
        n = new JLabel("Nombre");
        n.setHorizontalAlignment(JLabel.CENTER);
        t = new JLabel("Teléfono");
        t.setHorizontalAlignment(JLabel.CENTER);
        c = new JLabel("Contraseña");
        c.setHorizontalAlignment(JLabel.CENTER);
        u = new JLabel("Usuario");
        u.setHorizontalAlignment(JLabel.CENTER);
        N = new JTextField();
        CAN = new VistasGenerales.Number();
        C = new JPasswordField();
        U = new JTextField();
        TU = new JComboBox(Tu);
        S = new JComboBox(Su);
        
        l = new JLabel ("Información del empleado");
        l.setHorizontalAlignment(JLabel.CENTER);
        con.setLayout(new GridBagLayout());
        P.setLayout(new GridBagLayout());
        Pr.setLayout(new GridLayout(3,3));
        Pb.setLayout(new GridBagLayout());
        ag = new JButton("Crear usuario");
        ca = new JButton("Cancelar");
        
        v1 = new JLabel(" ");       v2 = new JLabel(" ");
        v3 = new JLabel(" ");       v4 = new JLabel(" ");
        v5 = new JLabel(" ");       v6 = new JLabel(" ");
        v7 = new JLabel(" ");       v8 = new JLabel(" ");
        v9 = new JLabel(" ");       v10 = new JLabel(" ");
        v11 = new JLabel(" ");       v12 = new JLabel(" ");
        va = new JLabel(" ");       vb = new JLabel(" ");
        vc = new JLabel(" ");       vd = new JLabel(" ");
        ve = new JLabel(" ");       vf = new JLabel(" ");
        vg = new JLabel(" ");       vh = new JLabel();
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

    private void agrega() {
        
        con.add(l, estilo(0,1,2,1));
        con.add(v8, estilo(0,2,2,1));
        con.add(n, estilo(0,3,1,1));
        con.add(N, estilo(1,3,1,1));
        con.add(v2, estilo(0,4,2,1));
        con.add(t, estilo(0,5,1,1));
        con.add(CAN.tf, estilo(1,5,1,1));
        con.add(v7, estilo(0,6,2,1));
        
        P.add(u, estilo(0,1,1,1));
        P.add(U, estilo(1,1,1,1));
        P.add(v9, estilo(0,2,2,1));
        P.add(c, estilo(0,3,1,1));
        P.add(C, estilo(1,3,1,1));
        P.add(v10, estilo(0,4,2,1));
        P.add(TU, estilo(0,5,1,1));
        P.add(S, estilo(1,5,1,1));
        P.add(v11, estilo(0,6,2,1));
        
        Pb.add(va, estilo(0,0,3,1));
        Pb.add(vb, estilo(0,1,3,1));
        Pb.add(vc, estilo(0,2,1,1));
        Pb.add(ag, estilo(1,2,1,1));
        Pb.add(ve, estilo(2,2,1,1));
        Pb.add(vg, estilo(0,3,3,1));
        Pb.add(vd, estilo(0,4,1,1));
        Pb.add(ca, estilo(1,4,1,1));
        Pb.add(vf, estilo(0,4,3,1));
        Pb.add(vh, estilo(0,5,3,1));
        
        
        Pr.add(v1);
        Pr.add(con);
        Pr.add(v3);
        Pr.add(v4);
        Pr.add(P);
        Pr.add(Pb);
        Pr.add(v6);
    }
}
