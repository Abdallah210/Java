package DragDrop;

import javax.swing.JFrame;

public class DragDropFrame extends JFrame {

    DragPanel dragPanel = new DragPanel(); 

    public DragDropFrame(){

        this.add(dragPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Drag & Drop");
        this.setVisible(true);

    }
    
}
