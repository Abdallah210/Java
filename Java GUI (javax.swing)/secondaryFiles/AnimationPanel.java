package secondaryFiles;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AnimationPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    Image enemy = new ImageIcon("./images/enemy.png").getImage();
    Image backGround = new ImageIcon("./images/space.png").getImage();

    Timer timer;

    private int xVelocity = 3;
    private int yVelocity = 2;
    private int x = 0;
    private int y = 0;

    public AnimationPanel(){

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.timer  = new Timer(1, this);
        timer.start();
        
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        super.paint(g);  // paint background

        g2D.drawImage(backGround, 0, 0, null);
        g2D.drawImage(enemy, x, y, null);
        
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (x+enemy.getWidth(null)>=this.PANEL_WIDTH || x<0 ) {
            xVelocity *= -1;
        }

        if (y+enemy.getHeight(null)>=this.PANEL_HEIGHT || y<0 ) {
            yVelocity *= -1;
        }

        x += xVelocity;
        y += yVelocity;
        repaint();   // after any update should call a method repaint()
        
    }
    
}
