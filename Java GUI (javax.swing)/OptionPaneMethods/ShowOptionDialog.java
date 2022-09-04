package OptionPaneMethods;



import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.awt.Dimension;

    /*
     There is 4 methods in JOptionPane >
        1- showMessageDialog()
        2- showConfirmDialog()
        3- showInputDialog()
        4- showOptionDialog()
     */

    // In this file we will see showOptionDialog()


public class ShowOptionDialog {

    public static void main(String[] args) {
        
        /*  
        Syntax :  .showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue)

            parentComponent  --> null (for now I don't know)
            message          --> String
            title            --> String
            optionType       --> JOptionPane.YES_NO_CANCEL_OPTION   or   .YES_NO_OPTION   or   YES_OPTION
            messagType       --> JOptionPane.PLAIN_MESSAGE  or  .INFORMATION_MESSAGE  or  .QUESTION_MESSAGE  or  .WARNING_MESSAGE  or  .ERROR_MESSAGE
            icon             --> ImageIcon
            options          --> String  or  String[]
            initialValue     --> 0  or  1  or  2  (the default value of response)



        */
        
        UIManager.put("OptionPane.minimumSize",new Dimension(300,150));   // change dimensions of pop up

        String[] options = {"option 1", "option 2", "option 3"};

        ImageIcon image = new ImageIcon("./images/hand.png");


        JOptionPane.showOptionDialog(null, "choose option :", "JOptionPane : showOptionDialog", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, image, options, 0);

    }



    
}
