package Vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author wilder
 */
public class Login extends JFrame {

    private JPanel P = new JPanel();
    private JPanel pi = new JPanel();
    private Dimension dim;
    private JButton a, ca;
    private JLabel v1;
    private JLabel v2;
    private JLabel v3;
    private JLabel v4;
    private JLabel v5;
    private JLabel v6;
    private JLabel vacio;
    private JLabel n, p;
    private JTextField u;
    private JPasswordField c;

    public Login() {
        dim = super.getToolkit().getScreenSize();
        super.setSize(dim);
        super.setUndecorated(true);//Sin marco
        super.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crea();
        estiliza();
        agrega();
        setContentPane(P);
        validate();
        boton b = new boton();
        ca.addActionListener(b);

    }

    private void crea() {
        a = new JButton("Ingresar");
        ca = new JButton("Cancelar");
        u = new JTextField();
        c = new JPasswordField();
        n = new JLabel("Usuario");
        p = new JLabel("Contraseña");
        v1 = new JLabel();
        v2 = new JLabel();
        v3 = new JLabel();
        v4 = new JLabel();
        v5 = new JLabel();
        v6 = new JLabel();
        vacio = new JLabel();
        n.setHorizontalAlignment(JLabel.CENTER);
        p.setHorizontalAlignment(JLabel.CENTER);
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

    private void estiliza() {
        pi.setLayout(new GridBagLayout());
        P.setLayout(new java.awt.GridLayout(3, 3));
        Dimension d = this.getSize();
        ImageIcon imagen = new ImageIcon("Recursos\\Img\\Logo.jpg");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(d.width / 3, d.height / 3, Image.SCALE_DEFAULT));
        v2.setIcon(imagen);
        double t = d.getWidth() / 20;
        int ft = (int) ((t * 12) / 20);
        System.out.println();
        Font fuente = new Font("Arial", Font.BOLD, ft);
        n.setFont(fuente);
        u.setFont(fuente);
        p.setFont(fuente);
        c.setFont(fuente);
    }

    private void agrega() {
        pi.add(n, estilo(0, 0, 2, 1));
        pi.add(u, estilo(0, 1, 2, 1));
        pi.add(p, estilo(0, 2, 2, 1));
        pi.add(c, estilo(0, 3, 2, 1));
        pi.add(vacio, estilo(0, 4, 1, 1));
        pi.add(a, estilo(0, 5, 1, 1));
        pi.add(ca, estilo(1, 5, 1, 1));
        P.add(v1);
        P.add(v2);
        P.add(v3);
        P.add(v4);
        P.add(pi);
        P.add(v5);
        P.add(v6);
    }

    private class boton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(ca)) {
                System.exit(0);
            }

        }

    }

}
