package secondaryFiles;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

public class SelectFileFrame extends JFrame implements ActionListener {


    JButton openFileButton;
    JButton saveFileButton;

    public SelectFileFrame(){

        //Frame :
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Select file");
        this.setLayout(new FlowLayout());
        

        //Button :
        this.openFileButton = new JButton("Open file");
        this.saveFileButton = new JButton("Save file");

        this.openFileButton.addActionListener(this);
        this.saveFileButton.addActionListener(this);
        
        this.add(openFileButton);
        this.add(saveFileButton);
        this.setVisible(true);


    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.openFileButton) {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("C:\\Users\\Elfil\\OneDrive\\Desktop"));

            int response = fileChooser.showOpenDialog(null);  // select file to open
            
            if (response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }

        if (e.getSource()==this.saveFileButton) {
            JFileChooser fileChooser = new JFileChooser();

            int response = fileChooser.showSaveDialog(null);  // select file to save
            
            if (response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }

    }

    
}
