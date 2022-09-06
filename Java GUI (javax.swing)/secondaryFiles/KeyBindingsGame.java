package secondaryFiles;

import java.awt.event.ActionEvent;

import java.awt.Color;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;


public class KeyBindingsGame {

    JFrame frame = new JFrame();
    JLabel label = new JLabel();

    Action upAction = new UpAction();
    Action downAction = new DownAction();
    Action leftAction = new LeftAction();
    Action rightAction = new RightAction();

    public KeyBindingsGame(){

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(null);
        this.frame.setSize(500, 500);
        this.frame.setTitle("Keys Bindings");

        this.label.setBounds(50, 50, 50, 50);
        this.label.setBackground(Color.green);
        this.label.setOpaque(true);

        this.label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "UpAction");
        this.label.getActionMap().put("UpAction", upAction);

        this.label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "DownAction");
        this.label.getActionMap().put("DownAction", downAction);

        this.label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LeftAction");
        this.label.getActionMap().put("LeftAction", leftAction);

        this.label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "RightAction");
        this.label.getActionMap().put("RightAction", rightAction);



        this.frame.add(label);
        this.frame.setVisible(true);


    }



    public class UpAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(), label.getY()-10);
        }
        
    }


    public class DownAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(), label.getY()+10);
        }
        
    }


    public class LeftAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX()-10, label.getY());
        }
        
    }


    public class RightAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX()+10, label.getY());
        }
        
    }


    
}
