package Game.board.util;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;

public class MySlider extends JSlider{

    public MySlider(int begin, int end, int init) {
        super(begin, end, init);
        this.setFont(new Font("MV Boli", Font.PLAIN, 25));
        this.setPaintTrack(true);
        this.setUI(new BasicSliderUI(this) { 
           /*Sets the size of the Handler, should be the same as the OVAL size*/
           @Override
           protected Dimension getThumbSize() {
               return new Dimension(25,25);
           }
   
           /*Painting the THUMB as a OVAL in the x and y positions of thumbRect (The Handle)*/
           @Override
           public void paintThumb(Graphics g) {
               Graphics2D g2d = (Graphics2D) g;
               g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
               Rectangle t = thumbRect;
               g2d.setColor(new Color(0x455565));
               g2d.fillOval(t.x, t.y, 20, 20);
           }
       });

   }

   public static void main(String[] args) {
    
    JFrame frame = new JFrame("Slider");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    MySlider slider = new MySlider(0, 100, 50);  

    /* 
    this.slider.setPreferredSize(new Dimension(400, 200));  
    
    this.slider.setPaintTicks(true);     // adds ticks to slider
    this.slider.setMinorTickSpacing(5);  //sets distance between Minor ticks
    
    this.slider.setPaintTrack(true);     // adds ticks to slider
    this.slider.setMajorTickSpacing(25);  //sets distance between Major ticks

    this.slider.setPaintLabels(true);  // sets number in the slider
    this.slider.setFont(new Font("MV Boli", Font.PLAIN, 15));  // sets number in the slider

    this.slider.setOrientation(SwingConstants.VERTICAL);  //sets the orientation of slider

    this.slider.addChangeListener(this);*/


    //Label :
    label.setText(slider.getValue() + "°C ");  // get the value of slider
    label.setFont(new Font("MV Boli", Font.PLAIN, 25));  




    //Frame :
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(550,500);

    panel.add(slider);
    panel.add(label);
    frame.add(panel);

    frame.setVisible(true);




   }
}
