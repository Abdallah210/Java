package secondaryFiles;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CheckBoxesFrame extends JFrame implements ActionListener {

    JCheckBox cb = new JCheckBox();
    JButton button = new JButton("Return the value"); 
    JLabel label = new JLabel("value of check box");
    JPanel panel = new JPanel();
    ImageIcon iconX = new ImageIcon("./images/x.jpg");
    ImageIcon iconO = new ImageIcon("./images/o.jpg");

    
    public CheckBoxesFrame(){



        //Frame :
        this.setTitle("Check boxes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 230);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.white); 
        this.setLocation(700, 350);

        
        //Button :
        this.button.setFocusable(false);
        this.button.setBackground(new Color(0x778899));
        this.button.addActionListener(this);
        this.button.setPreferredSize( new Dimension(250, 50));


        //Checkbox :
        this.cb.setText("I'm not robot !");
        this.cb.setFocusable(false);
        this.cb.setFont(new Font("Consolas", Font.PLAIN, 25));
        this.cb.setIcon(iconX);
        this.cb.setSelectedIcon(iconO);


        //Panel :
        this.panel.setPreferredSize(new DimensionUIResource(150, 50));
        this.panel.setBackground(new Color(135,206,250));
        this.panel.setLayout(new FlowLayout());


        //Label :
        this.label.setPreferredSize(new DimensionUIResource(150, 50));
        this.label.setVerticalAlignment(JLabel.CENTER);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        


        this.panel.add(this.label);

        this.add(this.cb);
        this.add(this.button);
        this.add(this.panel);


        this.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.button) {
            this.label.setText(String.valueOf(this.cb.isSelected()));  // --> true  or false  (data)
        }
        
    }

}
