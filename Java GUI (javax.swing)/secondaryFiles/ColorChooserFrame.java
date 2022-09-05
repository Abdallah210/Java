package secondaryFiles;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;



public class ColorChooserFrame extends JFrame implements ActionListener{

    public JButton button;
    public JPanel panel = new JPanel();

    public ColorChooserFrame(){
    
            //Frame :
            this.setSize(500, 500);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Color chooser");
            this.setLayout(new FlowLayout());
            
    
            //Button :
            this.button = new JButton("choose color");
            this.button.addActionListener(this);


            //Label :
            this.panel.setPreferredSize(new Dimension(150,150));
            this.panel.setBackground(Color.black);

            
            this.add(this.button);
            this.add(this.panel);
            this.setVisible(true);


        
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.button) {
            //JColorChooser colorChooser = new JColorChooser();

            Color newColor = JColorChooser.showDialog(null, "choose color", Color.black);
            this.panel.setBackground(newColor);


        }
        
    }


}
