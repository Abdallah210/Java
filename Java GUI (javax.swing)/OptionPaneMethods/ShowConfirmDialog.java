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

    // In this file we will see showConfirmDialog()


public class ShowConfirmDialog {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();



        //Labels :
        JLabel returnValue = new JLabel("");
        returnValue.setBounds(0, 0, 75, 75);
        returnValue.setFont(new Font(null, Font.BOLD, 30));
        returnValue.setVerticalAlignment(JLabel.CENTER);
        returnValue.setHorizontalAlignment(JLabel.CENTER);
        returnValue.setBorder(BorderFactory.createLineBorder(new Color(244,164,96), 3));

        JLabel message = new JLabel("The reponse of pop up return :");
        message.setBounds(10, 0, 375, 75);
        message.setFont(new Font(null, Font.PLAIN, 21));
        message.setVerticalAlignment(JLabel.CENTER);
        message.setHorizontalAlignment(JLabel.LEFT);
        //returnValue.setBorder(BorderFactory.createLineBorder(Color.black, 4));



        //Panel :
        JPanel valuePanel = new JPanel();
        valuePanel.setBounds(400, 50, 75, 75);
        valuePanel.setBackground(new Color(255,218,185));
        valuePanel.setLayout(null);
        valuePanel.add(returnValue);

        JPanel messagePanel = new JPanel();
        messagePanel.setBounds(80, 50, 310, 75);
        messagePanel.setBackground(new Color(135,206,250));
        messagePanel.setLayout(null);
        messagePanel.add(message);

        //Button :
        JButton button = new JButton("click here to show the pop up");
        button.setBackground(new Color(152,251,152));
        button.setBounds(125, 150, 300, 65);
        button.setFont(new Font(null, Font.PLAIN, 18));
        button.setFocusable(false);
        button.addActionListener(e-> {
            int result = JOptionPane.showConfirmDialog(null, "You clicked to  the plain message", "Plain message", JOptionPane.YES_NO_CANCEL_OPTION);
            returnValue.setText(String.valueOf(result));
        });



        //Frame :
        frame.setTitle("JOptionPane : showConfirmDialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(575, 300);
        frame.setLayout(null);
        frame.setLocation(600, 250);

        frame.add(valuePanel);
        frame.add(messagePanel);
        frame.add(button);

    }



    
}
