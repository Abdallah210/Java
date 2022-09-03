import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Color;

public class LayeredPaneMain {

    public static void main(String[] args) {
        
        //Frame
        JFrame frame = new JFrame();
        frame.setTitle("LayeredPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(134,197,215));  
        frame.setSize(720, 250);
        frame.setVisible(true);
        frame.setLayout(null); 

        //Labels :
        JLabel labelTop1 = new JLabel();
        labelTop1.setBounds(50, 50, 250, 50);
        labelTop1.setBackground(new Color(239,248,255));
        labelTop1.setOpaque(true);

        JLabel labelTop2 = new JLabel();
        labelTop2.setBounds(400, 50, 250, 50);
        labelTop2.setBackground(new Color(239,248,255));
        labelTop2.setOpaque(true);

        JLabel labelTopMiddle1 = new JLabel();
        labelTopMiddle1.setBounds(100, 80, 150, 50);
        labelTopMiddle1.setBackground(new Color(203,233,244));
        labelTopMiddle1.setOpaque(true);

        JLabel labelTopMiddle2 = new JLabel();
        labelTopMiddle2.setBounds(450, 80, 150, 50);
        labelTopMiddle2.setBackground(new Color(203,233,244));
        labelTopMiddle2.setOpaque(true);

        JLabel labelBottomMiddle1 = new JLabel();
        labelBottomMiddle1.setBounds(150, 120, 195, 25);
        labelBottomMiddle1.setBackground(new Color(174,220,235));
        labelBottomMiddle1.setOpaque(true);

        JLabel labelBottomMiddle2 = new JLabel();
        labelBottomMiddle2.setBounds(355, 120, 195, 25);
        labelBottomMiddle2.setBackground(new Color(174,220,235));
        labelBottomMiddle2.setOpaque(true);

        JLabel labelBottom = new JLabel();
        labelBottom.setBounds(220, 140, 260, 20);
        labelBottom.setBackground(new Color(18,128,181));
        labelBottom.setOpaque(true);

        JLabel[] labels = {labelTop1, labelTop2, labelTopMiddle1, labelTopMiddle2, labelBottomMiddle1, labelBottomMiddle2, labelBottom};

        //LayenedPane
        JLayeredPane lp = new JLayeredPane();    // create LayeredPane 
        lp.setBounds(0,0,700,500);

        int counter = 0; 

        for (JLabel label : labels) {
            lp.add(label, Integer.valueOf(counter));  // sets the level of component 0 1 2 3 ...
            counter++;
        }
        // We can also use name of levels :
        // containerName.add(componentName, JLayeredPane.DEFAULT)  
        // names of levels : default -> palette -> modal -> popUp -> drag

        frame.add(lp);

    }


}
