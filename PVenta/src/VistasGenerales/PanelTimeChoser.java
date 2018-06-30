package VistasGenerales;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
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
        AWTUtilities.setWindowOpaque(this, false);
        P.setLayout(new GridBagLayout());
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
        ImageIcon image;
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
        //Minuto ariba
        int tx = 50, ty = 25;
        mu = new JButton();
        image = new ImageIcon("Recursos\\Img\\arriba.png");
        image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
        mu.setIcon(image);
        image = new ImageIcon(image.getImage().getScaledInstance((int) (tx * .9), (int) (ty * .9), Image.SCALE_DEFAULT));
        mu.setPressedIcon(image);
        image = new ImageIcon("Recursos\\Img\\arribaB.png");
        image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
        mu.setRolloverIcon(image);
        mu.setBorder(null);
        mu.setBorderPainted(false);
        mu.setContentAreaFilled(false);
        mu.setFocusable(false);
        mu.setBackground(null);
        mu.setOpaque(true);
        //hora arriba
        hu = new JButton();
        hu.setHorizontalAlignment(JButton.CENTER);
        hu.setVerticalAlignment(JButton.CENTER);
        image = new ImageIcon("Recursos\\Img\\arriba.png");
        image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
        hu.setIcon(image);
        image = new ImageIcon(image.getImage().getScaledInstance((int) (tx * .9), (int) (ty * .9), Image.SCALE_DEFAULT));
        hu.setPressedIcon(image);
        image = new ImageIcon("Recursos\\Img\\arribaB.png");
        image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
        hu.setRolloverIcon(image);
        hu.setBorder(null);
        hu.setBorderPainted(false);
        hu.setContentAreaFilled(false);
        hu.setFocusable(false);
        hu.setBackground(null);
        mu.setOpaque(true);

        //Minuto abajo
        md = new JButton();
        image = new ImageIcon("Recursos\\Img\\abajo.png");
        image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
        md.setIcon(image);
        image = new ImageIcon(image.getImage().getScaledInstance((int) (tx * .9), (int) (ty * .9), Image.SCALE_DEFAULT));
        md.setPressedIcon(image);
        image = new ImageIcon("Recursos\\Img\\abajoB.png");
        image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
        md.setRolloverIcon(image);
        md.setBorder(null);
        md.setBorderPainted(false);
        md.setContentAreaFilled(false);
        md.setFocusable(false);
        md.setBackground(null);
        md.setOpaque(true);
        
        //Hora abajo
        hd = new JButton();
        image = new ImageIcon("Recursos\\Img\\abajo.png");
        image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
        hd.setIcon(image);
        image = new ImageIcon(image.getImage().getScaledInstance((int) (tx * .9), (int) (ty * .9), Image.SCALE_DEFAULT));
        hd.setPressedIcon(image);
        image = new ImageIcon("Recursos\\Img\\abajoB.png");
        image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
        hd.setRolloverIcon(image);
        hd.setBorder(null);
        hd.setBorderPainted(false);
        hd.setContentAreaFilled(false);
        hd.setFocusable(false);
        hd.setBackground(null);
        hd.setOpaque(true);

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

    public String getTime() {
        String aux = hora.tf.getText() + " : " + minuto.tf.getText();
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
            int aux = 0;
            if (!hora.tf.getText().equals("")) {
                aux = Integer.parseInt(hora.tf.getText());
            }
            if (aux < 24) {

            } else {
                hora.tf.setText(auxv);
            }
        }

        if (ke.getSource().equals(minuto.tf)) {
            int aux = 0;
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
