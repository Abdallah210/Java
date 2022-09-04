package OptionPaneMethods;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.Color;

public class ShowMessageDialog {

    /*
     There is 4 methods in JOptionPane >
        1- showMessageDialog()
        2- showConfirmDialog()
        3- showInputDialog()
        4- showOptionDialog()
     */

    // In this file we will see showMessageDialog()


    public static void main(String[] args) {

        JFrame frame = new JFrame();

        
        //BUttons :
        JButton exitButton = new JButton("X");
        exitButton.setBackground(Color.red);
        exitButton.setBounds(700, 25, 50, 50);
        exitButton.setFont(new Font(null, Font.BOLD, 10));
        exitButton.setFocusable(false);
        exitButton.addActionListener(e-> {
            frame.dispose();
        });


        JButton plainButton = new JButton("Plain");
        plainButton.setBackground(new Color(238,238,228));
        plainButton.setBounds(50, 200, 120, 60);
        plainButton.setFont(new Font(null, Font.BOLD, 15));
        plainButton.setFocusable(false);
        plainButton.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, "You clicked to  the plain message", "Plain message", JOptionPane.PLAIN_MESSAGE);
        });


        JButton infoButton = new JButton("Information");
        infoButton.setBackground(new Color(135,206,250));
        infoButton.setBounds(195, 200, 120, 60);
        infoButton.setFont(new Font(null, Font.BOLD, 15));
        infoButton.setFocusable(false);
        infoButton.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, "there is 5 type of JOptionPane message", "Information message", JOptionPane.INFORMATION_MESSAGE);
        });


        JButton questionButton = new JButton("Question");
        questionButton.setBackground(new Color(152,251,152));
        questionButton.setBounds(340, 200, 120, 60);
        questionButton.setFont(new Font(null, Font.BOLD, 15));
        questionButton.setFocusable(false);
        questionButton.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, "How are you ?", "Question message", JOptionPane.QUESTION_MESSAGE);
        });


        JButton warningButton = new JButton("Warning");
        warningButton.setBackground(new Color(255,215,0));
        warningButton.setBounds(485, 200, 120, 60);
        warningButton.setFont(new Font(null, Font.BOLD, 15));
        warningButton.setFocusable(false);
        warningButton.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, "Warning : There is a Virus in your computer !", "Warning message", JOptionPane.WARNING_MESSAGE);
        });


        JButton errorButton = new JButton("Error");
        errorButton.setBackground(new Color(220,20,60));
        errorButton.setBounds(630, 200, 120, 60);
        errorButton.setFont(new Font(null, Font.BOLD, 15));
        errorButton.setFocusable(false);
        errorButton.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, "Error 404 !!", "Error massage", JOptionPane.ERROR_MESSAGE);
        });

        JButton[] buttons = {exitButton, plainButton, infoButton, questionButton, warningButton, errorButton};


        //Label :
        JLabel label = new JLabel("chose the type of message :");
        label.setBounds(180, 80, 600, 75);
        label.setFont(new Font(null, Font.PLAIN, 35));






        //Frame :
        frame.setTitle("JOptionPane : showMessageDialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 400);
        frame.setLayout(null);
        frame.setLocation(600, 250);

        for (JButton button : buttons) {
            frame.add(button);
        }

        frame.add(label);


    }
}
