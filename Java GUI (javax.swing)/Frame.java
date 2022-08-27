import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;

/**
 * Frame's class
 */
public class Frame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();  // create a frame 
 
        frame.setTitle("my first frame !");   // sets the title of frame


        frame.setSize(420, 420);  // sets the x dimention and y dimention of frame
        frame.setResizable(false);  // prevent frame to being resizable


        frame.setVisible(true); // make a frame visible


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   // exit out of the application
        /*
        #JAVADOC# 
        EXIT_ON_CLOSE         --> Exit the application using the System exit method. Use this only in applications. 
        HIDE_ON_CLOSE         --> Automatically hide the frame after invoking any registered WindowListener objects. 
        DO_NOTHING_ON_CLOSE   --> Don't do anything; require the program to handle the operation in the windowClosing method of a registered WindowListener object. 
        DISPOSE_ON_CLOSE      --> Automatically hide and dispose the frame after invoking any registered WindowListener objects. 
        */


        ImageIcon icon = new ImageIcon("images/animeIcon.png");  // create a image icon
        frame.setIconImage(icon.getImage());  // changes frame's icon
        // I don't know why .webp extention deosn't work, it's preferable to use .png .jpg extentions


        Color myColor = new Color(123, 50, 250);   // beautiful color (60,8,50) (123, 50, 250)
        frame.getContentPane().setBackground(myColor);  // changes the background's color
        /* 
        - getContentPane --> returns the container 

        - There is many ways to initialize a color : 
        1) new Color(....) : (255,0,0) -> red   (0,255,0) -> green   (0,0,255) -> blue 
        2) Color.green
        3) new Color(0xFFFFFF) --> Google for more colors
        */







    }
}
