package secondaryFiles;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;


public class Graphics2DPanel extends JPanel{

    public Graphics2DPanel(){

        this.setPreferredSize(new Dimension(500,500));

    }

    public void paint(Graphics g ) {

        //cast Graphics to 2DGraphics
        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(Color.blue);
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(0, 0, 100, 500);  // draw line 

        g2D.setPaint(Color.orange);
        g2D.drawRect(0, 0, 100, 200);  // draw Rectangle
        g2D.fillRect(100, 0, 100, 200);

        g2D.setPaint(Color.green);
        g2D.drawOval(200, 100, 100, 100);
        g2D.fillOval(300, 100, 100, 100);

        g2D.setPaint(Color.red);
        g2D.drawArc(300, 300, 100, 100, 0, 180);

        // ....


    }
    
    
}
