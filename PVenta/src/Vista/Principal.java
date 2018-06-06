
package Vista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class Principal extends JFrame{
    private Dimension dim;
    JMenu ar, s;
    JMenuItem m, m1, m2, m3, m4;
    
    public Principal(){
        super("ELEGANPIEL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dim = super.getToolkit().getScreenSize();
        super.setSize(dim);
        super.setUndecorated(true);//Sin marco
        super.setVisible(true);
        
        
        JPanel p = new JPanel();
        JMenuBar mb = new JMenuBar();
        mb.setLayout(new BorderLayout());
        ar = new JMenu("Nuevo");
        s = new JMenu("Salir");
        m = new JMenuItem("Vender");
        m1 = new JMenuItem("Ver inventario");
        m2 = new JMenuItem("Devoluciones");
        m4 = new JMenuItem("Cerrar sesión");
        m3 = new JMenuItem("Salir");
       
        ar.add(m);
        ar.add(m1);
        ar.add(m2);
        s.add(m4);
        s.add(m3);
        mb.add(ar);
        mb.add(s,BorderLayout.LINE_END);
        p.add(mb);
        
        mb.setVisible(true);
        
        setContentPane(p);
        setJMenuBar(mb);
        
        boton b = new boton();
        m.addActionListener(b);
        m1.addActionListener(b);
        m2.addActionListener(b);
        m3.addActionListener(b);
        validate();
        
    }
    
    private class boton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(m3)) {
                System.exit(0);
            }
           
            else if (e.getSource().equals(m4)) {
                new Login();
                //System.class.
            }

        }

    }
    
    
}