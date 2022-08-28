import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.BorderLayout;

// frame.setLayout() is so important if you want separate panels !

/* 
There is 2 ways to change the position of label in the panel :
    1) with BorderLayout() --> we use setHorizontalAlignment() and setVerticalAlignment() to panel
    2) without BorderLayout() --> we use setBounds() to label

*/

public class PanelMain {

    public static void main(String[] args) {
        

        JPanel panel =  new JPanel();  
        panel.setBackground(new Color(0x5da63a));   // sets color of panel
        panel.setBounds(0, 0 , 450, 250);  // set position and dimesions of panel
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 4)); // add border to panel
        panel.setLayout(new BorderLayout());  // to control the position of label in the panel with setVerticalAlignment() and setHorizontalAlignment()


        JPanel panel2 =  new JPanel(); 
        panel2.setBackground(new Color(0xe56400));  
        panel2.setBounds(450, 250 , 450, 250); 
        panel2.setBorder(BorderFactory.createLineBorder(Color.blue, 4));
        panel2.setLayout(null);   // if it's null should to add setBounds() to label



        // Label :
        JLabel label = new JLabel();
        ImageIcon newLogo = new ImageIcon("images/Hunter_x_hunter.png"); 
        label.setIcon(newLogo);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        JLabel label2 = new JLabel();
        ImageIcon newLogo2 = new ImageIcon("images/Hunter_x_hunter_old.jpg"); 
        label2.setIcon(newLogo2);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
              

        // Add labels to the panels (NOT FRAME)
        panel.add(label2);
        panel2.add(label);


        // Frame : 
        JFrame frame = new JFrame();
        frame.setTitle("Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(918, 547);
        frame.setVisible(true);
        frame.setLayout(null);  // So importantant !!!
        

        frame.add(panel);
        frame.add(panel2);

       
    }
}
