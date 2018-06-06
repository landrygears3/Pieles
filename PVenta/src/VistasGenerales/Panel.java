
package VistasGenerales;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private Image fondo;

    public void paintComponent(Graphics g) {
        int width = this.getSize().width;
        int height = this.getSize().height;

        if (this.fondo != null) {
            g.drawImage(this.fondo, 0, 0, width, height, null);
        }
        super.paintComponent(g);
       
    }

    public void setBackground(String ruta) {

        this.fondo = new ImageIcon(ruta).getImage();
        repaint();
    }

}
