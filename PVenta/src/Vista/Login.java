
package Vista;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
        super.setUndecorated(true);
        super.setVisible(true);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.P.setLayout(new GridBagLayout()); // Le ponemos el GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();

        JTextArea cajaTexto = new JTextArea("Area texto");
        constraints.gridx = 0; // Columna 0. No necesita estirarse, no ponemos weightx
        constraints.gridy = 0; // Fila 0. Necesita estirarse, hay que poner weighty
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        constraints.weighty = 1.0; // La fila 0 debe estirarse, le ponemos un 1.0
        P.add(cajaTexto, constraints);
        constraints.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes.

        JButton boton1 = new JButton("Boton 1");
        constraints.gridx = 2; // Columna 2. No necesita estirarse, no ponemos weightx
        constraints.gridy = 0; // Fila 0. Necesita estirarse, hay que poner weighty
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        /* La fila 0 debe estirarse, le ponemos un 1.0. Ya lo hicimos en el area de texto, pero aquí debemos ser coherentes y poner lo mismo.*/
        P.add(boton1, constraints);
        constraints.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes.

        JButton boton2 = new JButton("Boton 2");
        constraints.gridx = 2; // Columna 2, no necesita estirarse, no ponemos weigthx
        constraints.gridy = 1; // Fila 1, necesita estirarse, hay que poner weigthy
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0; // La fila 1 debe estirarse, le ponemos 1.0
        P.add(boton2, constraints);
        constraints.weighty = 0.0; // Restauramos el valor por defecto.

        JButton boton3 = new JButton("Boton 3");
        constraints.gridx = 0; // Columna 0, no necesita estirarse, no ponemos weigthx
        constraints.gridy = 2; // Fila 2, no necesita estirarse, no ponemos weigthy
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        P.add(boton3, constraints);

        JButton boton4 = new JButton("Boton 4");
        constraints.gridx = 2; // Columna 2, no necesita estirarse, no ponemos weightx
        constraints.gridy = 2; // Fila 2, no necesita estirarse, no ponemos weigthy
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        P.add(boton4, constraints);

        JTextField campoTexto = new JTextField("Campo texto");
        constraints.gridx = 1; // Columna 1, debe estirarse, le ponemos el weigthx
        constraints.gridy = 2; // Fila 2, no necesita estirarse, no ponemos weigthy
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0; // La columna 1 debe estirarse, ponemos el 1.0 en weigthx
        P.add(campoTexto, constraints);
        setContentPane(P);
        validate();

    }

    public static void main(String wil[]) {
        new Login();
    }
}