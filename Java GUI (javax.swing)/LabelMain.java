import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Color;


public class LabelMain {

    public static void main(String[] args) {

        // Label :

        JLabel label = new JLabel();   // create a label (or JLabel label = new JLabel("My first label !"); )
   
        ImageIcon image = new ImageIcon("images/hxh.jpg");
        label.setIcon(image);

        Border border = BorderFactory.createLineBorder(Color.blue, 4);

        label.setHorizontalTextPosition(JLabel.CENTER);  // sets horizontal position of text in CENTER, RIGHT or LEFT...
        label.setVerticalTextPosition(JLabel.TOP);   // sets vertical position of text in CENTER, TOP or BOTTOM...

        label.setVerticalAlignment(JLabel.CENTER);    // sets vertical position of text and image in CENTER, RIGHT or LEFT...
        label.setHorizontalAlignment(JLabel.CENTER);  // sets horizontal position of text and image in CENTER, TOP or BOTTOM...

        label.setForeground(new Color(123, 5, 88));  // sets color of text
        label.setBackground(Color.gray);  // sets background color
        label.setOpaque(true);  // display background color


        label.setFont(new Font("nostalgia", Font.PLAIN, 25));   // sets font and size of text

        label.setIconTextGap(50);  // sets gab to the image

        label.setBorder(border);  // sets border of label
        label.setBounds(0, 0, 500,500); // sets x an y position within frame as well as dimisions




        
        // Frame : 

        JFrame frame = new JFrame();
        frame.setTitle("Label");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(750, 250);
        frame.setVisible(true);
        frame.setSize(500, 650);

        frame.add(label);   //add label to frame 

        frame.setLayout(null); // --> every comp should have .setBounds()

        //frame.pack();  --> the frame takes the size of components

    }
    
}
