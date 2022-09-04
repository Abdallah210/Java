package OptionPaneMethods;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;

import java.awt.Color;

    /*
     There is 4 methods in JOptionPane >
        1- showMessageDialog()
        2- showConfirmDialog()
        3- showInputDialog()
        4- showOptionDialog()
     */

    // In this file we will see showInputDialog()


public class ShowInputDialog {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();



        JLabel message = new JLabel(" **message** ");
        message.setBounds(10, 0, 500, 75);
        message.setFont(new Font(null, Font.PLAIN, 21));
        message.setVerticalAlignment(JLabel.CENTER);
        message.setHorizontalAlignment(JLabel.CENTER);



        //Panel :
        JPanel messagePanel = new JPanel();
        messagePanel.setBounds(28, 50, 500, 75);
        messagePanel.setBackground(new Color(135,206,250));
        messagePanel.setLayout(null);
        messagePanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        messagePanel.add(message);


        //Button :
        JButton button = new JButton("click here to show the input");
        button.setBackground(new Color(152,251,152));
        button.setBounds(125, 150, 300, 65);
        button.setFont(new Font(null, Font.PLAIN, 18));
        button.setFocusable(false);
        button.addActionListener(e-> {
            String result = JOptionPane.showInputDialog("type anything");
            message.setText(String.valueOf(result));
        });



        //Frame :
        frame.setTitle("JOptionPane : showConfirmDialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(575, 300);
        frame.setLayout(null);
        frame.setLocation(600, 250);

        frame.add(messagePanel);
        frame.add(button);

    }



    
}
