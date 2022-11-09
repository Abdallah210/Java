package MyFrame;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("Title...");
        //this.getContentPane().setBackground(Color.white); 
        this.setLocation(700, 350);
        this.pack();

    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
