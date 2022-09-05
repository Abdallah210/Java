package secondaryFiles;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarFrame extends JFrame implements ActionListener {

    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu helpMenu;

    private JMenuItem newItem;
    private JMenuItem saveItem;
    private JMenuItem closeItem;
    private JMenuItem copyItem;
    private JMenuItem pasteItem;
    private JMenuItem cutItem;
    private JMenuItem aboutItem;

    private ImageIcon fileIcon = new ImageIcon("./images/MenuBar/fileIcon.png");
    private ImageIcon saveIcon = new ImageIcon("./images/MenuBar/saveIcon.png");
    private ImageIcon closeIcon = new ImageIcon("./images/MenuBar/closeIcon.png");
    private ImageIcon copyIcon = new ImageIcon("./images/MenuBar/copyIcon.png");
    private ImageIcon pasteIcon = new ImageIcon("./images/MenuBar/pasteIcon.png");
    private ImageIcon cutIcon = new ImageIcon("./images/MenuBar/cutIcon.png");
    private ImageIcon infoIcon = new ImageIcon("./images/MenuBar/infoIcon.png");


    public MenuBarFrame() {
        

        //Frame :
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Menu bar");


        //Menu bar -- Menu -- Item :

        //initialize :
        this.menuBar = new JMenuBar();

        this.fileMenu = new JMenu("File");
        this.editMenu = new JMenu("Edit");
        this.helpMenu = new JMenu("Help");

        this.newItem = new JMenuItem("New file");
        this.saveItem = new JMenuItem("Save file");
        this.closeItem = new JMenuItem("Close file");
        this.copyItem = new JMenuItem("Copy");
        this.pasteItem = new JMenuItem("Paste");
        this.cutItem = new JMenuItem("Cut");
        this.aboutItem = new JMenuItem("About");


        //set icon :
        this.newItem.setIcon(fileIcon);
        this.saveItem.setIcon(saveIcon);
        this.closeItem.setIcon(closeIcon);
        this.copyItem.setIcon(copyIcon);
        this.pasteItem.setIcon(pasteIcon);
        this.cutItem.setIcon(cutIcon);
        this.aboutItem.setIcon(infoIcon);



        //add action listener
        this.newItem.addActionListener(this);
        this.saveItem.addActionListener(this);
        this.closeItem.addActionListener(this);
        this.copyItem.addActionListener(this);
        this.pasteItem.addActionListener(this);
        this.cutItem.addActionListener(this);
        this.aboutItem.addActionListener(this);



        //add :

        this.fileMenu.add(newItem);
        this.fileMenu.add(saveItem);
        this.fileMenu.add(closeItem);
        this.editMenu.add(copyItem);
        this.editMenu.add(pasteItem);
        this.editMenu.add(cutItem);
        this.helpMenu.add(aboutItem);

        this.menuBar.add(fileMenu);
        this.menuBar.add(editMenu);
        this.menuBar.add(helpMenu);

        


        this.setVisible(true);

        this.setJMenuBar(menuBar);  // add menu to frame

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==newItem) {
            System.out.println("File created");
        }
        
        if (e.getSource()==saveItem) {
            System.out.println("File saved");
        }
                
        if (e.getSource()==closeItem) {
            this.dispose();
        }
                
        if (e.getSource()==copyItem) {
            System.out.println("File copied");
            
        }
                
        if (e.getSource()==pasteItem) {
            System.out.println("File pasted");
            
        }
                
        if (e.getSource()==cutItem) {
            System.out.println("File cutted");
            
        }
                
        if (e.getSource()==aboutItem) {
            System.out.println("info.......");
            
        }
        
    }


    
}
