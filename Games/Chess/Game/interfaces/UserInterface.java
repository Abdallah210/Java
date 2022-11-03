package Game.interfaces;


import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Game;

public class UserInterface extends JLabel {

    private Game game;
    private JPanel mainPanel;

    public UserInterface(Game game) {
        
        this.game = game;
        this.setBounds(this.game.getFrameSize());
        this.setVerticalAlignment(JLabel.CENTER);  
        this.setHorizontalAlignment(JLabel.CENTER);

        this.mainPanel.setBounds(100,100,1400,800);
        this.setOpaque(true);
        
    }











    
}
