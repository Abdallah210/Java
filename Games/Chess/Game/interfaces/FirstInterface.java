package Game.interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class FirstInterface {

    private boolean visibility = true;
    private JButton button = new JButton(); 
    private ImageIcon logoEFA = new ImageIcon("./images/logoEFA.png");
    private ImageIcon logo = new ImageIcon("./images/logo.png");
    private JLabel logoLabel = new JLabel();
    private JLabel logoEFALabel = new JLabel();

    public FirstInterface() {

        // Button
        this.button.setText("PLAY"); 
        this.button.setFocusable(false);
        this.button.setHorizontalTextPosition(JButton.CENTER);
        this.button.setVerticalTextPosition(JButton.TOP);
        this.button.setFont(new Font("Comic Sans",Font.BOLD, 20));
        this.button.setBackground(new Color(0x616e7c));
        this.button.setForeground(new Color(0xc7ccd1));
        this.button.setEnabled(true);

        // Logo :
        this.logoLabel.setIcon(logo);
        this.logoLabel.setVerticalAlignment(JLabel.CENTER);    
        this.logoLabel.setHorizontalAlignment(JLabel.CENTER);
        this.logoLabel.setBounds(0, 0, 840,500);
        this.logoLabel.setOpaque(false);

        // EFA logo :
        this.logoEFALabel.setIcon(logoEFA);
        this.logoEFALabel.setVerticalAlignment(JLabel.CENTER);    
        this.logoEFALabel.setHorizontalAlignment(JLabel.CENTER);
        this.logoEFALabel.setBounds(0, 0, 300,175);
        this.logoEFALabel.setOpaque(false);

    }



    public boolean isVisible() {
        return this.visibility;
    }

    public JButton getButton() {
        return this.button;
    }

    public JLabel getLogo() {
        return this.logoLabel;
    }

    public JLabel getLogoEFA() {
        return logoEFALabel;
    }
    
}
