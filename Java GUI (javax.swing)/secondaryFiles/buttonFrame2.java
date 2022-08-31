package secondaryFiles;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;


public class buttonFrame2 extends JFrame{

    public JButton button = new JButton(); // create a button
    public JLabel label = new JLabel();

    public buttonFrame2(){


        //ImageIcon :
        ImageIcon image = new ImageIcon("./images/hand.png");
        ImageIcon imageClicked = new ImageIcon("./images/clicked.jpg");


        // Label :
        this.label.setIcon(imageClicked);
        this.label.setBounds(100, 250, 300, 131);
        this.label.setVisible(false);



        // Button :
        this.button.setBounds(160, 75, 180, 150);  // sets dimisions of button
        this.button.setText("click here");  // sets the text inside of button


        // add action to the button in the frame :
        this.button.addActionListener(     
            e -> {
                System.out.println("clicked again !");
                this.label.setVisible(!this.label.isVisible());
                }
            );   


        this.button.setFocusable(false);
        this.button.setIcon(image);
        
        this.button.setHorizontalTextPosition(JButton.CENTER);
        this.button.setVerticalTextPosition(JButton.TOP);

        this.button.setHorizontalAlignment(JButton.CENTER);
        this.button.setVerticalAlignment(JButton.CENTER);

        this.button.setFont(new Font("Comic Sans",Font.BOLD, 20));
        this.button.setIconTextGap(5);

        this.button.setBackground(new Color(123, 50, 250));
        this.button.setForeground(Color.lightGray);

        // this.button.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        this.button.setBorder(BorderFactory.createEtchedBorder());

        this.button.setEnabled(true); // enable/disable button


        // Frame :
        this.setTitle("Button");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);



    }
}