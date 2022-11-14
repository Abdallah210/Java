package Game.board.util;


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

    public CountDownTimer(int time) {
        
        this.speed = 1000; 
        this.seconds = 0;
        this.setMinutes(time);  //can be changed

    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
        if (minutes==5) {
            this.timerLabel.setText("0"+this.minutes +":0"+ this.seconds);  
        } else {
            this.timerLabel.setText(this.minutes +":0"+ this.seconds);  
        }
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
