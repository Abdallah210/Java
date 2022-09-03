package HowToOpenNewWindow;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

public class NewWindow {

    JFrame newFrame = new JFrame();
    JLabel label = new JLabel("I'm a new window !!");

    NewWindow(){

        //frame :
        this.newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.newFrame.setTitle("New window");
        this.newFrame.setSize(500, 500);
        this.newFrame.setLayout(null);
        this.newFrame.setVisible(true);

        //Label :
        this.label.setFont(new Font(null, Font.PLAIN, 30));
        this.label.setBounds(0, 0, 500, 50);

        this.newFrame.add(label);
    }


    
}
