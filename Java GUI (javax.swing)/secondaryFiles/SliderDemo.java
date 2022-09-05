package secondaryFiles;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderDemo implements ChangeListener{

    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;

    public SliderDemo(){

        this.frame = new JFrame("Slider");
        this.panel = new JPanel();
        this.label = new JLabel();
        this.slider = new JSlider(0, 100, 50);  // create slider (min, max, initialValue)

        //Slider :
        this.slider.setPreferredSize(new Dimension(400, 200));  
        
        this.slider.setPaintTicks(true);     // adds ticks to slider
        this.slider.setMinorTickSpacing(5);  //sets distance between Minor ticks
        
        this.slider.setPaintTrack(true);     // adds ticks to slider
        this.slider.setMajorTickSpacing(25);  //sets distance between Major ticks

        this.slider.setPaintLabels(true);  // sets number in the slider
        this.slider.setFont(new Font("MV Boli", Font.PLAIN, 15));  // sets number in the slider

        this.slider.setOrientation(SwingConstants.VERTICAL);  //sets the orientation of slider

        this.slider.addChangeListener(this);


        //Label :
        this.label.setText(this.slider.getValue() + "°C ");  // get the value of slider
        this.label.setFont(new Font("MV Boli", Font.PLAIN, 25));  




        //Frame :
        this.frame.setSize(550,500);

        this.panel.add(slider);
        this.panel.add(label);
        this.frame.add(panel);

        this.frame.setVisible(true);

    }


    @Override
    public void stateChanged(ChangeEvent e) {
        
        this.label.setText(this.slider.getValue() + "°C ");  // get the value of slider
        
    }
    
}
