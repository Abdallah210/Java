package secondaryFiles;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

//import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerFrame extends JFrame implements MouseListener {


    private JPanel clickPanel = new JPanel();
    private JPanel pressedPanel = new JPanel();
    private JPanel releasePanel = new JPanel();
    private JPanel enterPanel = new JPanel();
    private JPanel exitPanel = new JPanel();

    private JLabel clickLabel = new JLabel("Click");
    private JLabel pressedLabel = new JLabel("Press");
    private JLabel releaseLabel = new JLabel("Release");
    private JLabel enterLabel = new JLabel("Enter");
    private JLabel exitLabel = new JLabel("Exit");

    private JPanel[] panels = {clickPanel, pressedPanel, releasePanel, enterPanel, exitPanel};
       
    private JLabel[]labels = {clickLabel, pressedLabel, releaseLabel, enterLabel, exitLabel};

    private Color[] lightColors = {new Color(127,255,212), new Color(218,112,214), new Color(255,99,71), new Color(255,255,0), new Color(176,196,222)};
    private Color[] darkColors = {new Color(0,128,128), new Color(139,0,139), new Color(255,0,0), new Color(255,215,0), new Color(112,128,144)};


    public MouseListenerFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 400);
        this.setTitle("Mouse listener");
        this.setLayout(null);

        //Panels :


       /* DONT WORK, WHY ? I DONT KNOW :( 
       for (JPanel panel : panels) {
            JLabel label = new JLabel(panel.getName());
            label.setPreferredSize(new Dimension(75, 50));
            panel.setPreferredSize(new Dimension(75, 75));

            this.add(label);
            this.add(panel);
        }*/

        int i = 0;
        int distance = 150;
        while (i<5) {

            panels[i].setBounds(50 + i*distance, 125, 125, 125);
            panels[i].setBackground(lightColors[i]);
            panels[i].setLayout(null);
            panels[i].addMouseListener(this);

            labels[i].setBounds(0, 0, 125, 125);
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            labels[i].setVerticalAlignment(JLabel.CENTER);
            labels[i].setFont(new Font("Serif", Font.BOLD, 20));

            panels[i].add(labels[i]);
            this.add(panels[i]);
            
            i++;
        }

        this.setVisible(true);

    }












    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==panels[0]) {
            if(panels[0].getBackground()==darkColors[0]){
                panels[0].setBackground(lightColors[0]);
            } else {
                panels[0].setBackground(darkColors[0]);
            }
        }

  
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource()==panels[1]) {
            panels[1].setBackground(darkColors[1]);
        }

        if (e.getSource()==panels[2]) {
            panels[2].setBackground(lightColors[2]);
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (e.getSource()==panels[2]) {
            panels[2].setBackground(darkColors[2]);
        }

        if (e.getSource()==panels[1]) {
            panels[1].setBackground(lightColors[1]);
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getSource()==panels[3]) {
            panels[3].setBackground(darkColors[3]);
        }

        if (e.getSource()==panels[4]) {
            panels[4].setBackground(lightColors[4]);
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource()==panels[4]) {
            panels[4].setBackground(darkColors[4]);
        }

        if (e.getSource()==panels[3]) {
            panels[3].setBackground(lightColors[3]);
        }
    }
    
}
