package secondaryFiles;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxFrame extends JFrame implements ActionListener {

    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
    private JComboBox<String> comboBox = new JComboBox<>();


    public ComboBoxFrame(){

        //Frame :
        this.setTitle("Combo boxes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 200);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white); 
        this.setLocation(700, 350);


        //Label :
        this.label.setText("club");
        this.label.setBounds(0, 0 , 200, 50);
        this.label.setVerticalAlignment(JLabel.CENTER);
        this.label.setHorizontalAlignment(JLabel.CENTER);



        //Panel :
        this.panel.setBounds(200, 50 , 200, 50);
        this.panel.setBackground(new Color(0x998FB98));
        this.panel.setLayout(null);
        this.panel.add(label);


        //Combo boxes :
        String[] clubs = {"Real Madrid", "Ac Milan", "Liverpool", "Bayern Munchen", "Paris Saint German"}; 

        this.comboBox = new JComboBox<>(clubs);
        this.comboBox.setBounds(25, 50, 150, 20);
        this.comboBox.addActionListener(this); 

        //this.comboBox.setEditable(true);  --> to edit value
        this.comboBox.getItemCount();    // --> 
        this.comboBox.addItem("Manchester United");
        this.comboBox.addItem("Manchester City");
        this.comboBox.addItem("Chelsea");
        this.comboBox.addItem("Inter");
        this.comboBox.insertItemAt("Juventus", 0);
        this.comboBox.setSelectedItem(0);
        this.comboBox.removeItem("Real Madrid");
        this.comboBox.removeItemAt(6);
        //this.comboBox.removeAllItems();



        

        this.add(panel);
        this.add(comboBox);
        this.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.comboBox) {
            String clubChosen = (String) this.comboBox.getSelectedItem();
            int clubIndex = this.comboBox.getSelectedIndex();

            this.label.setText(clubIndex+1 + " - " + clubChosen);
            
        }
        
    }
    
}
