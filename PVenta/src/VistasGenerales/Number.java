package VistasGenerales;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class Number implements KeyListener {

    public JTextField tf = new JTextField();
    private String Tipo;

    public Number(String Tipo) {
        tf.addKeyListener(this);
        this.Tipo = Tipo;
    }
    
    public Number() {
        tf.addKeyListener(this);
        this.Tipo = "";
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (Tipo) {
            case "C":
                if ((isNum(e.getKeyChar()))) {
                }else{
                e.consume();
                }
                break;
            case "D":
                String d = e.getKeyChar() + "";
                if ((isNum(e.getKeyChar())) || d.equals(".")) {

                    if (!(isNum(e.getKeyChar()))) {
                        if (punto()) {
                            e.consume();
                        }
                    }
                } else {
                    e.consume();
                }
                break;
            default:
                 if ((isNum(e.getKeyChar()))) {
                }else{
                e.consume();
                }
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == 8)) {
        } else {
            e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        e.consume();

    }

    private boolean isNum(char d) {
        boolean t = false;
        try {
            Integer.parseInt(Character.toString(d));
            t = true;
        } catch (Exception e) {

        }
        return t;
    }

    private boolean punto() {
        boolean f = false;
        char[] d = tf.getText().toCharArray();
        for (int i = 0; i < d.length; i++) {
            if ((d[i] + "").equals(".")) {
                f = true;
                break;
            }
        }
        return f;
    }
}
