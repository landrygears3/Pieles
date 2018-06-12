package VistasGenerales;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class Number implements KeyListener {

    public JTextField tf = new JTextField(20);

    public Number() {
        tf.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(isNum(e.getKeyChar())){
        }else{
         e.consume();
        }
         
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==8){
        }else{
        e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        e.consume();

    }
    private boolean isNum(char d){
        boolean t= false;
    try{
     Integer.parseInt(Character.toString(d));
    t=true;
    }catch(Exception e){
    
    }
    return t;
    }
}
