
package Vista.Empleado;

import java.awt.GridBagLayout;


/**
 *
 * @author landr
 */


public class NotasV extends VistasGenerales.Panel{
    VistasGenerales.Tabla tab;
    final String cols[] = {"Empleado", "Nota"};
    
    public NotasV() {
        this.setLayout(new GridBagLayout());
        crea();
        agrega();
    }
    
    private void crea(){
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
    }
    
    private void agrega(){
        
    }
}
