package Vista;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author wilder
 */
public class Login extends JFrame {

    private Dimension dim;
    JPanel P = new JPanel();

    public Login() {
        //con esto obtienes en tamano en en x y y de tu monitor
        dim = super.getToolkit().getScreenSize();
        super.setSize(dim);
        //super.setUndecorated(true);//Sin marco
        super.setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.P.setLayout(new GridBagLayout()); // Le ponemos el GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        JTextField nombre = new JTextField();
        P.add(nombre, gbc);

        setContentPane(P);
        validate();

    }

}
