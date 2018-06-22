package Vista.Horario;

import VistasGenerales.TimeChoser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;

public class HorarioA extends VistasGenerales.Panel {
   TimeChoser tc=new TimeChoser();
   JButton time=new JButton("T");
   Date d;
    public HorarioA() {
       
        agrega();
        time.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
            d=tc.getTime();
                System.out.println(d.getHours()+" : "+d.getMinutes());
            }
        });
        
        
    }
    

   
    private void agrega() {
        add(tc);
        add(time);
    }
    
}
