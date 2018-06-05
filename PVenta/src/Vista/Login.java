package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author wilder
 */
public class Login extends JFrame {

    private Dimension dim;
    JPanel P = new JPanel();
    JButton a, ca;

    public Login() {
        //con esto obtienes en tamano en en x y y de tu monitor
        dim = super.getToolkit().getScreenSize();
        super.setSize(dim);
        super.setUndecorated(true);//Sin marco
        super.setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel pi = new JPanel();

        pi.setLayout(new GridBagLayout()); // Le ponemos el GridBagLayout
        JLabel n, p;
        JTextField u, c;

        a = new JButton();
        ca = new JButton();
        u = new JTextField();
        c = new JTextField();
        n = new JLabel("Usuario");
        n.setHorizontalAlignment(JLabel.CENTER);
        p = new JLabel("Contraseña");
        p.setHorizontalAlignment(JLabel.CENTER);
        P.setLayout(new java.awt.GridLayout(3, 3));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        pi.add(n, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        pi.add(u, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        pi.add(p, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        pi.add(c, gbc);

        JLabel vacio = new JLabel();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        pi.add(vacio, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        pi.add(a, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        pi.add(ca, gbc);

        JLabel v1 = new JLabel();
        JLabel v2 = new JLabel();
        JLabel v3 = new JLabel();
        JLabel v4 = new JLabel();
        JLabel v5 = new JLabel();
        JLabel v6 = new JLabel();
        P.add(v1);
        P.add(v2);
        P.add(v3);
        P.add(v4);
        P.add(pi);
        P.add(v5);
        P.add(v6);

        setContentPane(P);
        validate();

        boton b = new boton();
        ca.addActionListener(b);

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
