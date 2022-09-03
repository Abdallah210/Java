import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class FlowLayoutMain {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,750);
        frame.setLayout(new BorderLayout(10,10));


        JButton button1A = new JButton("1");
        JButton button2A = new JButton("2");
        JButton button3A = new JButton("3");
        JButton button4A = new JButton("4");
        JButton button5A = new JButton("5");
        JButton button6A = new JButton("6");
        JButton button7A = new JButton("7");

        JButton button1B = new JButton("1");
        JButton button2B = new JButton("2");
        JButton button3B = new JButton("3");
        JButton button4B = new JButton("4");
        JButton button5B = new JButton("5");
        JButton button6B = new JButton("6");
        JButton button7B = new JButton("7");

        JButton button1C = new JButton("1");
        JButton button2C = new JButton("2");
        JButton button3C = new JButton("3");
        JButton button4C = new JButton("4");
        JButton button5C = new JButton("5");
        JButton button6C = new JButton("6");
        JButton button7C = new JButton("7");


        JButton[] buttonsA = {button1A, button2A, button3A, button4A, button5A, button6A, button7A};
        JButton[] buttonsB = {button1B, button2B, button3B, button4B, button5B, button6B, button7B};
        JButton[] buttonsC = {button1C, button2C, button3C, button4C, button5C, button6C, button7C};


        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(254,221,216));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));  // sets position of components (center, leading, trailing...)


        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(215,226,232));
        panel2.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));  // sets margin between components


        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(207,227,226));
        panel3.setLayout(new FlowLayout(FlowLayout.TRAILING, 25, 25)); 



        panel1.setPreferredSize(new Dimension(200,200));
        panel2.setPreferredSize(new Dimension(200,200));
        panel3.setPreferredSize(new Dimension(200,200));
        
        //JPanel[] panels = {panel1, panel2, panel3};
        //for (JPanel panel : panels) {frame.add(panel);}

        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.NORTH);
        frame.add(panel3, BorderLayout.SOUTH);

        for (JButton button : buttonsA) { panel1.add(button); }
        for (JButton button : buttonsB) { panel2.add(button); }
        for (JButton button : buttonsC) { panel3.add(button); }




        frame.setVisible(true);




    }
    
}
