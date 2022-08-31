import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;

public class BorderLayoutMain {

    public static void main(String[] args) {

        //Frame
        JFrame frame = new JFrame();
        frame.setTitle("BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout(10,10));   // yuo can add margin between components (width, height)

        // Panels :
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setBackground(new Color(226,226,226));

        panel2.setBackground(new Color(45,133,197));
        panel3.setBackground(new Color(60,169,238));

        panel4.setBackground(new Color(97,189,238));
        panel5.setBackground(new Color(165,211,235));

        // Dimensions of rectangles :
        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,100));

        //-------- sub borders ---------//


        // Panels :
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panelX = new JPanel();

        panel6.setBackground(new Color(226,226,226));

        panel7.setBackground(new Color(195,55,38));
        panel8.setBackground(new Color(225,75,50));

        panel9.setBackground(new Color(220,110,85));
        panelX.setBackground(new Color(223,166,147));

        // Dimensions of rectangles :
        panel6.setPreferredSize(new Dimension(50,50));
        panel7.setPreferredSize(new Dimension(50,50));
        panel8.setPreferredSize(new Dimension(50,50));
        panel9.setPreferredSize(new Dimension(50,50));
        panelX.setPreferredSize(new Dimension(50,50));


        //-------- sub borders ---------//

        panel1.setLayout(new BorderLayout(10,10));

        panel1.add(panel6, BorderLayout.CENTER);
        panel1.add(panel7, BorderLayout.NORTH);
        panel1.add(panel8, BorderLayout.SOUTH);
        panel1.add(panel9, BorderLayout.WEST);
        panel1.add(panelX, BorderLayout.EAST);



        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.NORTH);
        frame.add(panel3, BorderLayout.SOUTH);
        frame.add(panel4, BorderLayout.WEST);
        frame.add(panel5, BorderLayout.EAST);


    }

    
}