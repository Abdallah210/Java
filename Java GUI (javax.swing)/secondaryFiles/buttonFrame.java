package secondaryFiles;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buttonFrame extends JFrame implements ActionListener{

    public JButton button = new JButton(); // create a button

    public buttonFrame(){

        // Button :
        this.button.setBounds(200, 100, 100, 50);   // sets dimisions of button
        this.button.setText("click here");   // sets the text inside of button
        this.button.addActionListener(this);  // add action to the button in the frame
                                

        // Frame :
        this.setTitle("Button");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);



    }

    // Action :
    @Override
    public void actionPerformed(ActionEvent e) {  
        if (e.getSource()==button) {
            System.out.println("clicked !");
            this.button.setEnabled(false); // enable/disable button

        }
        
    }



    // ADVANCE CONCEPT :
    // instead of implement ActionListener to the class and add actionPerformed() method
    // we can use the expression this.button.addActionListener(e -> System.out.println("clicked !"));
    
    // See buttonFrame2's class !
}
