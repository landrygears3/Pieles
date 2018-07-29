package VistasGenerales;

import java.awt.BorderLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimeChoser extends JPanel implements KeyListener {

    public JTextField time;
    private JButton despliega;
    private PanelTimeChoser select;
    private String TIME;
   
    public TimeChoser() {
        setLayout(new BorderLayout());
        crea();
        agrega();
        select.P.addKeyListener(this);
        select.hora.tf.addKeyListener(this);
        select.minuto.tf.addKeyListener(this);
        despliega.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                Point punto = MouseInfo.getPointerInfo().getLocation();
                select.setBounds((despliega.getLocationOnScreen().x-(200-despliega.getSize().width)), (despliega.getLocationOnScreen().y+(despliega.getSize().height)), 200, 100);
                select.setVisible(true);
            }
        });

    }

    private void crea() {
        time = new JTextField(8);
        time.setHorizontalAlignment(JTextField.CENTER);
        time.setEditable(false);
        despliega = new JButton();
        select = new PanelTimeChoser();
    }

    private void agrega() {
        add(time, BorderLayout.CENTER);
        add(despliega, BorderLayout.EAST);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == 10) {
            TIME = select.getTime();
            time.setText(TIME);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    
     public Date getTime(){
         Date date;
         try{
      DateFormat sdf = new SimpleDateFormat("hh:mm");
      date = sdf.parse(TIME.replace(" ","")); }
         
         catch(Exception e){
         date=null;
         }
         return date;
     }
    
}
