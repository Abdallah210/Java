package secondaryFiles;

import javax.swing.JFrame;

public class AnimationFrame extends JFrame {

    AnimationPanel panel = new AnimationPanel();

    public AnimationFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Animation");
        this.setLocationRelativeTo(null);
        this.add(panel);
        this.pack();
        this.setVisible(true);

    }
    
}
