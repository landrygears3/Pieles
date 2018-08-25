
package Vista.Permisos;


import Controlador.Permisos.AgregaPermiso;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Controlador.General.General;
import Controlador.Permisos.PermisoV;

public class Elimina extends VistasGenerales.Panel implements ActionListener{

    final String cols[] = {"Código", "Empleado", "Permiso", "Fecha", "Motivo"};

    JPanel P = new JPanel();
    JPanel inter1 = new JPanel();
    VistasGenerales.Tabla tab;
    JLabel tipobu1;
    JComboBox Bus;
    JButton elimina;
    AgregaPermiso ap = new AgregaPermiso();
    PermisoV pv = new PermisoV();
    General g = new General();

    public Elimina() {
        this.setLayout(new GridBagLayout());
        P.setLayout(new GridLayout(2, 2));
        inter1.setLayout(new GridBagLayout());
        crea();
        agrega();
        if (g.vacio("permisos") > 0 && g.vacio("usuarios") > 0) {
            llenaCodigo();
            if (pv.respn("permisos", "tipo_permiso", "empleados")) {
            llena();
        }
        }
        elimina.addActionListener(this);

    }

    private void crea() {
        tab = new VistasGenerales.Tabla();
        tab.setColum(cols);
        
        tipobu1 = new JLabel("Buscar por código de permiso");
        tipobu1.setHorizontalAlignment(JLabel.RIGHT);
        Bus = new JComboBox();
        elimina=new JButton("Elimina");

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
    
    private void llena() {
        tab.setRow(pv.getDatos());
    }
    
    private void llenaCodigo() {
        Object o[] = ap.getCode();
        for (int i = 0; i < o.length; i++) {
            Bus.addItem(o[i]);
        }
        
    }

    private void agrega() {
        
        GridBagConstraints gbc;
        JLabel v1 = new JLabel("  ");
        JLabel v2 = new JLabel("  ");
        gbc = estilo(0, 0, 2, 1, GridBagConstraints.BOTH);
        inter1.add(tipobu1,gbc);
        gbc = estilo(0, 1, 1, 1, GridBagConstraints.BOTH);
        inter1.add(v1,gbc);
        gbc = estilo(0, 2, 2, 1, GridBagConstraints.BOTH);
        inter1.add(Bus,gbc);
        gbc = estilo(0, 3, 1, 1, GridBagConstraints.BOTH);
        inter1.add(v2,gbc);
        gbc = estilo(0, 4, 2, 1, GridBagConstraints.BOTH);
        inter1.add(elimina,gbc);
        P.add(inter1);

        gbc = estilo(0, 0, 4, 2, GridBagConstraints.PAGE_START);
        add(P, gbc);
        gbc = estilo(0, 2, 4, 4, GridBagConstraints.BOTH);
        add(tab, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource().equals(elimina)) {
            if (JOptionPane.showConfirmDialog(null, "Esta a punto de eliminar un permiso.\t\n¿Desea continuar?") == 0) {
                ap.elimina(Bus.getSelectedItem().toString());
            }
            
        }
        
    }
    
    
}
