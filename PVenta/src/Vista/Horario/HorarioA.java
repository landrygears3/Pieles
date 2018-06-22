package Vista.Horario;

import VistasGenerales.TimeChoser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class HorarioA extends VistasGenerales.Panel {
    TimeChoser tc=new TimeChoser();
    JButton test;
    public HorarioA() {
        crea();
        agrega();
        test.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent a){
    
        tc.setVisible(true);
        }
        });
        
    }

    private void crea() {
        
        test=new JButton("prueba");
    }

    private void agrega() {
        add(test);
        add(tc);
    }
}
