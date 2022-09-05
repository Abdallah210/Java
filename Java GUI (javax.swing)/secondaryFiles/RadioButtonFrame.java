package secondaryFiles;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RadioButtonFrame extends JFrame implements ActionListener {

    JRadioButton salmonButton = new JRadioButton("Salmon color");  // Color(250,128,114)
    JRadioButton oliveButton = new JRadioButton("Olive color");  // Color(107,142,35)
    JRadioButton turquoiseButton = new JRadioButton("Turqouise color");  // Color(64,224,208)

    public RadioButtonFrame(){
        
        //Frame :
        this.setTitle("Radio button");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 230);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.white); 
        this.setLocation(700, 350);


        //Radio button :

        ButtonGroup group = new ButtonGroup();

        JRadioButton[] buttons = {salmonButton, oliveButton, turquoiseButton};

        for (JRadioButton button : buttons) {
            button.setFocusable(false);
            button.addActionListener(this);
            group.add(button);
            this.add(button);
        }

        this.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== salmonButton) {
            this.getContentPane().setBackground(new Color(250,128,114)); 
            salmonButton.setBackground(new Color(250,128,114));
            oliveButton.setBackground(new Color(250,128,114));
            turquoiseButton.setBackground(new Color(250,128,114));
            
        } else if(e.getSource()== oliveButton) {
            this.getContentPane().setBackground(new Color(107,142,35)); 
            salmonButton.setBackground(new Color(107,142,35));
            oliveButton.setBackground(new Color(107,142,35));
            turquoiseButton.setBackground(new Color(107,142,35));
            
        } else if(e.getSource()== turquoiseButton){
            this.getContentPane().setBackground(new Color(64,224,208)); 
            salmonButton.setBackground(new Color(64,224,208));
            oliveButton.setBackground(new Color(64,224,208));
            turquoiseButton.setBackground(new Color(64,224,208));

        }


    }

    
}
