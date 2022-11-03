package Game.board;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


import javax.swing.JLabel;


public class CountDownTimer {

    private int speed; 
    private int seconds; 
    private int minutes; 
    private JLabel timerLabel = new JLabel();
    private Timer timer;

    public CountDownTimer() {
        
        this.speed = 1000; 
        this.seconds = 0;
        this.minutes = 10;  //can be changed

        this.timerLabel.setText(this.minutes +":0"+ this.seconds);
        
    }


    public void countDown() {

        this.timer = new Timer(this.speed, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                if (seconds == 0) {
                    seconds = 59;
                    minutes--;
                } else {
                    seconds--;
                }

                String m;
                String s;

                if (seconds<10) {
                    s = "0"+seconds;
                } else {
                    s = ""+seconds;
                }

                if (minutes<10) {
                    m = "0"+minutes;
                } else {
                    m = ""+minutes;
                }
                
                timerLabel.setText(m+":"+s);
                
                if (minutes==0 && seconds==0) {
                    timer.stop();
                }
                
            }
        });
        
    }


    public JLabel getTimerLabel() {
        return this.timerLabel;
    }

    public Timer getTimer() {
        return this.timer;
    }
}
