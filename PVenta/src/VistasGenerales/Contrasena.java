//Icon made by [https://creativecommons.org/licenses/by/3.0/] from www.flaticon.com 
package VistasGenerales;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Contrasena extends VistasGenerales.Panel implements ActionListener {

    char def;
    public JPasswordField pf;
    JButton b;
    private boolean status = false;

    public Contrasena() {
        this.setLayout(new BorderLayout());
       
        crea();
        agrega();
        vision();
         b.addActionListener(this);
    }

    private void crea() {
        pf = new JPasswordField();
        def = pf.getEchoChar();
        b = new JButton();
        b.setBorder(null);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setFocusable(false);
        b.setBackground(null);
        b.setOpaque(true);

    }
    public void setText(String string){
    pf.setText(string);
    }
    private void agrega() {
        add(pf,BorderLayout.CENTER);
        add(b,BorderLayout.EAST);
    }

    private void vision() {
        ImageIcon image;
        int tx = 25, ty = 25;

        if (status) {
            pf.setEchoChar((char) 0);
            image = new ImageIcon("Recursos\\Img\\PassB.png");
            image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
            b.setIcon(image);
            image = new ImageIcon(image.getImage().getScaledInstance((int) (tx * .9), (int) (ty * .9), Image.SCALE_DEFAULT));
            b.setPressedIcon(image);
            image = new ImageIcon("Recursos\\Img\\PassBS.png");
            image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
            b.setRolloverIcon(image);

        } else {
            pf.setEchoChar(def);
             image = new ImageIcon("Recursos\\Img\\Pass.png");
            image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
            b.setIcon(image);
            image = new ImageIcon(image.getImage().getScaledInstance((int) (tx * .9), (int) (ty * .9), Image.SCALE_DEFAULT));
            b.setPressedIcon(image);
            image = new ImageIcon("Recursos\\Img\\PassS.png");
            image = new ImageIcon(image.getImage().getScaledInstance(tx, ty, Image.SCALE_DEFAULT));
            b.setRolloverIcon(image);
        }
        status = !status;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        vision();
    }
}
