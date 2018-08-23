package Vista.Compra;

import Modelo.Conexion;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class newServ extends JDialog implements ActionListener {

    public boolean b = false;
    JLabel lnombre;
    JTextField nombre;
    JButton aceptar, cancelar;
    ArrayList<ArrayList> dats = new ArrayList<ArrayList>();
    Conexion c = new Conexion();

    public newServ() {
        this.setTitle("Servicio");
        this.setModal(true);
        this.setResizable(true);
        this.setSize(400, 200);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        crea();
        agrega();
        aceptar.addActionListener(this);
        cancelar.addActionListener(this);

    }

    private void crea() {
        lnombre = new JLabel("Nombre del servicio");
        nombre = new JTextField(25);
        aceptar = new JButton("Agregar");
        cancelar = new JButton("Cancelar");
    }

    private void agrega() {
        JLabel v = new JLabel("  ");
        JLabel v1 = new JLabel("  ");
        JLabel v2 = new JLabel("  ");
        add(v1, estilo(0, 0, 1, 1, GridBagConstraints.CENTER));
        add(v2, estilo(5, 0, 1, 1, GridBagConstraints.CENTER));
        add(lnombre, estilo(1, 1, 3, 1, GridBagConstraints.CENTER));
        add(nombre, estilo(1, 2, 3, 1, GridBagConstraints.BOTH));
        add(v, estilo(1, 3, 3, 1, GridBagConstraints.CENTER));
        add(aceptar, estilo(1, 4, 1, 1, GridBagConstraints.CENTER));
        add(cancelar, estilo(3, 4, 1, 1, GridBagConstraints.CENTER));
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

    public boolean getVal() {
        return b;
    }

    private void Dats() {
        ResultSet r = c.getConsulta("servicio", "*", "");
        try {
            while (r.next()) {
                dats.add(new ArrayList());
                dats.get(dats.size() - 1).add(r.getString(1));
                dats.get(dats.size() - 1).add(r.getString(2));
            }
        } catch (Exception e) {
        }
    }

    public Object[] getDats() {
        Dats();
        ResultSet R = c.VerificaVacio("servicio");
        int d = 0;
        try {
            d = R.getInt(1);
        } catch (Exception e) {
        }

        if (d > 0) {
            Object o[] = new Object[dats.size()];
            for (int i = 0; i < o.length; i++) {
                o[i] = dats.get(i).get(1);
            }
            return o;
        } else {
            return null;
        }
    }

    public String getID(int index) {
        return dats.get(index).get(0).toString();
    }

    public void addDats() {
        dats.get(dats.size() - 1).add(nombre.getText());
        String aux = nombre.getText();
        c.Alta("servicio", "Nombre", "'" + aux + "'");
    }

    public void alta(double costo, int cantidad, String nombre) {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("Y-MM-dd");
        String da = df.format(d);
        String o = "0, " + nombre + ", " + cantidad + ", " + costo + ", " + da;
        c.Alta("gastos", "", o);
    }

    public void alta(int index, double costo, int cantidad) {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("Y-MM-dd");
        String da = df.format(d);
        String o = "1, " + getID(index) + ", " + cantidad + ", "     + costo + ", " + da;           
        c.Alta("gastos", "", o);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(aceptar)) {

            nombre.setText("");
            this.dispose();
        }
        if (ae.getSource().equals(cancelar)) {
            this.dispose();
        }
    }

}
