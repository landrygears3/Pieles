package Vista.Horario;

import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author win 10
 */
public class HorarioA {
    JLabel i, f;
    Date d;
    
    public HorarioA(){
    d = new Date();
    d.setTime(999999999);
    
        System.out.println(d.getHours() + ":" + d.getMinutes());
            }
    
    
}
