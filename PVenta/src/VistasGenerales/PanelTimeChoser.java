package VistasGenerales;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelTimeChoser extends JDialog implements KeyListener, ActionListener {

    Number hora, minuto;
    JLabel puntos;
    JButton mu, md, hu, hd;
    JPanel P = new JPanel();
    int horav = 0, minutov = 0;
    String auxv;

    public PanelTimeChoser() {
        this.setModal(true);
        this.setResizable(false);
        this.setUndecorated(true);

        P.setLayout(new GridBagLayout());
        P.setBackground(Color.BLACK);
        P.setFocusable(true);
        crea();
        agrega();
        this.pack();
        P.addKeyListener(this);
        hora.tf.addKeyListener(this);
        minuto.tf.addKeyListener(this);
        hu.addActionListener(this);
        hd.addActionListener(this);
        mu.addActionListener(this);
        md.addActionListener(this);
    }

    private void crea() {
        hora = new Number("T");
        hora.tf.setBorder(null);
        hora.tf.setHorizontalAlignment(JTextField.CENTER);
        hora.tf.setText("00");
        minuto = new Number("T");
        minuto.tf.setHorizontalAlignment(JTextField.CENTER);
        minuto.tf.setBorder(null);
        minuto.tf.setText("00");
        puntos = new JLabel(":");
        puntos.setBackground(Color.white);
        puntos.setOpaque(true);
        puntos.setHorizontalAlignment(JLabel.CENTER);
        mu = new JButton();
        mu.setFocusable(false);
        md = new JButton();
        md.setFocusable(false);
        hu = new JButton();
        hu.setFocusable(false);
        hd = new JButton();
        hd.setFocusable(false);
    }

    private void agrega() {

        P.add(hu, estilo(0, 0, 1, 1, GridBagConstraints.BOTH));
        P.add(mu, estilo(2, 0, 1, 1, GridBagConstraints.BOTH));
        P.add(hora.tf, estilo(0, 1, 1, 1, GridBagConstraints.BOTH));
        P.add(puntos, estilo(1, 1, 1, 1, GridBagConstraints.BOTH));
        P.add(minuto.tf, estilo(2, 1, 1, 1, GridBagConstraints.BOTH));
        P.add(hd, estilo(0, 2, 1, 1, GridBagConstraints.BOTH));
        P.add(md, estilo(2, 2, 1, 1, GridBagConstraints.BOTH));
        this.setContentPane(P);

    }

    private void aumenta(String tiempo) {
        if (tiempo.endsWith("h")) {
            horav = Integer.parseInt(hora.tf.getText());
            if (horav < 23) {
                horav++;
            } else {
                horav = 0;
            }

            int r = horav / 10;
            if (r < 1) {
                hora.tf.setText("0" + horav);
            } else {
                hora.tf.setText(horav + "");
            }
        }

        if (tiempo.endsWith("m")) {
            minutov = Integer.parseInt(minuto.tf.getText());
            if (minutov < 59) {
                minutov++;
            } else {
                minutov = 0;
            }

            int r = minutov / 10;
            if (r < 1) {
                minuto.tf.setText("0" + minutov);
            } else {
                minuto.tf.setText(minutov + "");
            }
        }
    }

    private void decrementa(String tiempo) {
        if (tiempo.equals("h")) {
            if (horav > 0) {
                horav--;
            } else {
                horav = 23;
            }

            int r = horav / 10;
            if (r < 1) {
                hora.tf.setText("0" + horav);
            } else {
                hora.tf.setText(horav + "");
            }
        }

        if (tiempo.equals("m")) {
            if (minutov > 0) {
                minutov--;
            } else {
                minutov = 59;
            }

            int r = minutov / 10;
            if (r < 1) {
                minuto.tf.setText("0" + minutov);
            } else {
                minuto.tf.setText(minutov + "");
            }
        }
    }
    public String getTime(){
    String aux=hora.tf.getText()+" : "+minuto.tf.getText();
    return aux;
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
    public void keyTyped(KeyEvent ke) {

        if (ke.getSource().equals(hora.tf)) {
            auxv = hora.tf.getText();
        }
        if (ke.getSource().equals(minuto.tf)) {
            auxv = minuto.tf.getText();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == 10) {
            this.dispose();
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {

        if (ke.getSource().equals(hora.tf)) {
            int aux=0;
            if (!hora.tf.getText().equals("")) {
                aux = Integer.parseInt(hora.tf.getText());
            }
            if (aux < 24) {

            } else {
                hora.tf.setText(auxv);
            }
        }
        
        if (ke.getSource().equals(minuto.tf)) {
            int aux=0;
            if (!minuto.tf.getText().equals("")) {
                aux = Integer.parseInt(minuto.tf.getText());
            }
            if (aux < 60) {

            } else {
                minuto.tf.setText(auxv);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(hu)) {
            aumenta("h");
        }
        if (ae.getSource().equals(mu)) {
            aumenta("m");
        }
        if (ae.getSource().equals(hd)) {
            decrementa("h");
        }
        if (ae.getSource().equals(md)) {
            decrementa("m");
        }

    }

}
