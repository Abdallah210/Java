import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;

public class GridLayoutMain {

    public static void main(String[] args) {
        

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,750);

        frame.setLayout(new GridLayout(3, 3, 5, 5));  
        // GridLayout(x, y, z, k) : the (x, y) sets number of rowns and cols in the grid   x->rows        y->cols
        //                          ths (Z, k) sets the space between components           z->horzontal   k->vertical


        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");

        JButton[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9};
        
        for (JButton b : buttons) {
            frame.add(b);
        }
        

        frame.setVisible(true);

    }
    
}