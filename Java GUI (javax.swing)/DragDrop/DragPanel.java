package DragDrop;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Point;

import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

public class DragPanel extends JPanel {

    private ImageIcon image = new ImageIcon("./images/drag.png");
    //private final int WIDTH = image.getIconWidth();
    //private final int HEIGHT = image.getIconHeight();
    private Point imageCorner;
    private Point prevPoint;

    public DragPanel(){
        imageCorner = new Point(0, 0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();

        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());

        
    }

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            prevPoint = e.getPoint();
        }

    }


    private class DragListener extends MouseMotionAdapter {

        public void mouseDragged(MouseEvent e) {

            Point currentPoint = e.getPoint();

            imageCorner.translate(
                (int)(currentPoint.getX()-prevPoint.getX()),
                (int)(currentPoint.getY()-prevPoint.getY())

            );

            prevPoint = currentPoint;
            repaint();
        }

    }
    
}
