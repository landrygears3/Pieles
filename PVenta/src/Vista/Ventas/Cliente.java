package Vista.Ventas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cliente extends JDialog implements ActionListener {
    
    JLabel a, c, v1, v2, v3, v4;
    JTextField na;
    VistasGenerales.Number ca;
    public JButton ac;
    JButton can;
    
    public Cliente() {
        this.setTitle("Cliente nuevo");
        this.setSize(300, 200);
        this.setModal(true);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        crea();
        agrega();
        can.addActionListener(this);
        
    }
    
    private void crea() {
        v1 = new JLabel("   ");
        v2 = new JLabel("   ");
        v3 = new JLabel("   ");
        v4 = new JLabel("   ");
        a = new JLabel("Nombre");
        c = new JLabel("Numero");
        na = new JTextField();
        ca = new VistasGenerales.Number();
        ac = new JButton("Aceptar");
        ac.setFocusable(false);
        can = new JButton("Cancelar");
        can.setFocusable(false);
        
    }
    
    private void agrega() {
        
        add(v2, estilo(5, 1, 1, 1, GridBagConstraints.BOTH));
        add(a, estilo(1, 1, 3, 1, GridBagConstraints.BOTH));
        add(na, estilo(1, 2, 3, 1, GridBagConstraints.BOTH));
        add(c, estilo(1, 3, 3, 1, GridBagConstraints.BOTH));
        add(ca.tf, estilo(1, 4, 3, 1, GridBagConstraints.BOTH));
        add(v3, estilo(1, 5, 1, 1, GridBagConstraints.BOTH));
        add(ac, estilo(1, 6, 1, 1, GridBagConstraints.BOTH));
        add(can, estilo(3, 6, 1, 1, GridBagConstraints.BOTH));
        add(v1, estilo(2, 7, 1, 1, GridBagConstraints.BOTH));
        add(v4, estilo(0, 0, 1, 1, GridBagConstraints.BOTH));
        
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
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(can)) {
            this.dispose();
        }
        
    }
}
