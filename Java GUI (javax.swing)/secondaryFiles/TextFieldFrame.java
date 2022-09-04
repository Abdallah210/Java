package secondaryFiles; 

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldFrame implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton button = new JButton("submit");
    private JTextField textField = new JTextField();   // create text field 



    public TextFieldFrame() {


        //Frame :
        this.frame.setTitle("Text field");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(500, 110);
        this.frame.setLayout(new FlowLayout());
        this.frame.getContentPane().setBackground(new Color(0x2F4F4F)); 
        //this.frame.setBounds(0, 25, 500, 150);



        //TextField :
        this.textField.setPreferredSize(new Dimension(250, 50));  // sets dimensions of text field
        this.textField.setFont(new Font("Consolas", Font.PLAIN, 25));  // sets font of the text
        this.textField.setCaretColor(Color.white);  // sets caret's color
        this.textField.setBackground(Color.black);  // sets background's color 
        this.textField.setForeground(Color.green);  // sets text's color
        this.textField.setText("...");

        //Button :
        button.setBounds(0, 25, 100, 50);
        this.button.setFocusable(false);
        this.button.setBackground(new Color(0x778899));
        this.button.addActionListener(this);


        this.frame.setVisible(true);
        //frame.pack();
        this.frame.add(button);
        this.frame.add(textField);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.button) {
            this.textField.getText();  // We can use the text (data)
            this.textField.setEditable(false);  // after this method we can't edit the text in the field
            this.button.setEnabled(false);  // disable the button 

        }
        
    }
    
}