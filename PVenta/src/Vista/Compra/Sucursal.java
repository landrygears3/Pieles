package Vista.Compra;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Sucursal extends JDialog implements ActionListener {

    Controlador.Compra.Sucursal sucu = new Controlador.Compra.Sucursal();
    JLabel sucl;
    JComboBox suc;
    JButton acepta, cancela;
    boolean resp=false;

    public Sucursal() {
        this.setTitle("Sucursal");
        this.setModal(true);
        this.setResizable(true);
        this.setSize(400, 200);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                
            }
        });
        crea();
        agrega();
        acepta.addActionListener(this);
        cancela.addActionListener(this);
    }

    private void crea() {
        sucl = new JLabel("Sucursal");
        suc = new JComboBox(sucu.getName());
        acepta = new JButton("Acepta");
        acepta.setFocusable(false);
        cancela = new JButton("Cancela");
        cancela.setFocusable(false);
    }

    private void agrega() {
        JLabel v = new JLabel("  ");
        JLabel v1 = new JLabel("  ");
        JLabel v2 = new JLabel("  ");

        add(v, estilo(0, 0, 1, 1, GridBagConstraints.BOTH));
        add(sucl, estilo(1, 1, 3, 1, GridBagConstraints.BOTH));
        add(suc, estilo(1, 2, 3, 1, GridBagConstraints.BOTH));
        add(v1, estilo(2, 3, 1, 1, GridBagConstraints.BOTH));
        add(acepta, estilo(1, 4, 1, 1, GridBagConstraints.BOTH));
        add(cancela, estilo(3, 4, 1, 1, GridBagConstraints.BOTH));
        add(v2, estilo(4, 5, 1, 1, GridBagConstraints.BOTH));

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

    public Object getSucursal() {
        return sucu.getID(suc.getSelectedIndex());
    }
    
    public boolean getVla(){
    return resp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(acepta)) {
            resp=true;
            this.dispose();
        }

        if (ae.getSource().equals(cancela)) {
            resp=false;
            this.dispose();
        }
    }

}
