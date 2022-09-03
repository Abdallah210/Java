package HowToOpenNewWindow;

import javax.swing.JButton;
import javax.swing.JFrame;


public class LaunchPage  {

    private JFrame frame = new JFrame();
    private JButton button = new JButton("Open new window");

    LaunchPage(){

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("Old window");
        this.frame.setSize(500, 500);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        
        this.button.setBounds(100, 200, 300, 75);
        this.button.setFocusable(false);
        this.button.addActionListener(e-> 
        {
            if (e.getSource()==this.button) {
                this.frame.dispose();   //close the old window
                new NewWindow();  // this instence opens the window (frame)

            }


        });

        this.frame.add(this.button);


    }

}
