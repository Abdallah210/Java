package secondaryFiles;

import java.awt.*;
import javax.swing.*;


public class ProgressBarDemo {

    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar();

    public ProgressBarDemo(){

        //Progress bar :
        this.bar.setValue(0);  // sets the initial value of progress
        this.bar.setStringPainted(true);  // adds the color to the progress
        this.bar.setBounds(0,0,550, 50);
        this.bar.setFont(new Font("MV Boli", Font.BOLD, 15));  // sets number in the slider
        this.bar.setForeground(new Color(0x98FB98));
        this.bar.setBackground(Color.black);


        

        //Frame :
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("Progress bar");
        this.frame.setSize(550,500);
        this.frame.setLayout(null);

        this.frame.add(this.bar);
        this.frame.setVisible(true);

        fill();

    }

    public void fill(){
        int counter = 0;
        while (counter<=100) {

            bar.setValue(counter);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter++;
        }

        this.bar.setString("Done !");  // shows text in the bar 
    }
    

}
