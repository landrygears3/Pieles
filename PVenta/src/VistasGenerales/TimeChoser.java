package VistasGenerales;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class TimeChoser extends JDesktopPane {
   JInternalFrame inf=new JInternalFrame();
   Panel P=new Panel();
    Number hora;
    Number minuto;
    public TimeChoser() {
        crea();
        agrega();
    }
    private void crea(){
    hora=new Number();
    minuto=new Number();
    }
    
    private void agrega(){
    P.add(hora.tf);
    P.add(minuto.tf);
    inf.add(P);
    inf.pack();
    add(inf);
    }
}
