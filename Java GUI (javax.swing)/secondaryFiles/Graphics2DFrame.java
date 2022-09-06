package secondaryFiles;

import javax.swing.JFrame;


public class Graphics2DFrame extends JFrame {

    Graphics2DPanel g2DPanel = new Graphics2DPanel();

    public Graphics2DFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.add(g2DPanel);
        this.pack();
        this.setVisible(true);

    }
    
}
