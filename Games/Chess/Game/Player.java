package Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.GridLayout;

import Game.board.Board;
import Game.board.CountDownTimer;
import Game.pieces.Bishop;
import Game.pieces.King;
import Game.pieces.Knight;
import Game.pieces.Pawn;
import Game.pieces.Piece;
import Game.pieces.Queen;
import Game.pieces.Rook;

public class Player implements MouseListener {


    private Board board;

    private Color color;
    private String name;

    private int nbrOfDeath;

    private boolean positionChosen;
    private boolean myTurn;
    private boolean promoDisplayed;

    private Point[] positions = new Point[16];
    private Piece[] pieces = new Piece[16];
    private Piece[] deadPieces = new Piece[16];
    private JLabel[] labelWithoutImage = new JLabel[16];


    private JPanel deathPanel = new JPanel();
    private JLabel deathNumberLabel = new JLabel("0");
    private JLabel turnLabel = new JLabel("");
    private CountDownTimer timerPanel = new CountDownTimer();


    private JPanel choosePieceLabel;
    private ImageIcon queenImage = new ImageIcon("./images/Chess_qgt60.png");
    private ImageIcon knightImage = new ImageIcon("./images/Chess_ngt60.png");
    private ImageIcon bishopImage = new ImageIcon("./images/Chess_bgt60.png");
    private ImageIcon rookImage = new ImageIcon("./images/Chess_rgt60.png");
    
    private Font dubaiFont25 = new Font("Dubai", Font.BOLD, 25);
    private Font dubaiFont35 = new Font("Dubai", Font.BOLD, 35);


    public Player(Color color, Board board, boolean downPosition){
        
        this.board = board;
        this.color = color;
        this.name = "plaaaaayer";
        this.choosePieceLabel = new JPanel();

        //this.deathPanel.add(this.displayPanelPromotion());

        this.positionChosen = downPosition;
        this.myTurn = downPosition;
        this.promoDisplayed = false;

        int i = 0;
        while (i<16) {

            if (this.positionChosen==true) {
                for (int y = 7; y > 5; y--) {
                    for (int x = 0; x < 8; x++) {
                        positions[i] = new Point(y,x);
                        i++;
                    }
                }
            }


            if (this.positionChosen==false) {
                for (int y = 0; y < 2; y++) {
                    for (int x = 0; x < 8; x++) {
                        positions[i] = new Point(y,x);
                        i++;
                    }
                }
            }

        }


        for (int index = 0; index < 9; index++) {
            //Pawns :
                if(index<8) {

                Rook rook1 = new Rook((int)positions[8].getX(), (int)positions[8].getY(), this.board, this);
                pieces[index] = rook1;
                index++;

                Knight knight1 = new Knight((int)positions[9].getX(), (int)positions[9].getY(), this.board, this);
                pieces[index] = knight1;
                index++;

                Bishop bishop1 = new Bishop((int)positions[10].getX(), (int)positions[10].getY(), this.board, this);
                pieces[index] = bishop1;
                index++;

                Queen queen = new Queen((int)positions[11].getX(), (int)positions[11].getY(), this.board, this);
                pieces[index] = queen;
                index++;

                King king = new King((int)positions[12].getX(), (int)positions[12].getY(), this.board, this);
                pieces[index] = king;
                index++;

                Bishop bishop2 = new Bishop((int)positions[13].getX(), (int)positions[13].getY(), this.board, this);
                pieces[index] = bishop2;
                index++;

                Knight knight2 = new Knight((int)positions[14].getX(), (int)positions[14].getY(), this.board, this);
                pieces[index] = knight2;
                index++;
                
                Rook rook2 = new Rook((int)positions[15].getX(), (int)positions[15].getY(), this.board, this);
                pieces[index] = rook2;
                index++;

                }

                if (index == 8) {
                    for (int j = 0; j < 8; j++) {
                        Pawn pawn = new Pawn((int)positions[index+j].getX(), (int)positions[index+j].getY(), this.board, this);
                        pieces[index+j] = pawn;
                    }
                }


            }
        


        Color white = new Color(0xf6f6f6);
        if (this.color.getRGB()!=white.getRGB()) {
            for (Piece piece : pieces) {
                piece.setTeamColor("black");
            }
        }

        if (myTurn) {
            this.turnLabel.setText("It's your turn");
            this.turnLabel.setForeground(new Color(0x00822b));
        } else {
            this.turnLabel.setText("Wait your turn");
            this.turnLabel.setForeground(new Color(0xb80000));
        }

    }



    // Getters :
    public Board getBoard() {
        return this.board;
    }

    public Color getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public Piece[] getDeadPieces() {
        return this.deadPieces;
    }

    public boolean getPositionChosen() {
        return this.positionChosen;
    }

    public Piece[] getPieces() {
        return this.pieces;
    }

    public int getNbrOfDeaths() {
        int counter = 0;
        for (Piece piece : deadPieces) {
            if (piece!=null) {
                counter++;
            }
        }
        this.nbrOfDeath = counter;
        return this.nbrOfDeath;
    }

    public Point[] getPositions() {
        return this.positions;
    }

    public boolean isMyTurn() {
        return this.myTurn;
    }

    public boolean isPromoDisplayed() {
        return this.promoDisplayed;
    }

    public CountDownTimer getTimerPanel() {
        return this.timerPanel;
    }

    //--


    //Setters :

    public void setName(String name) {
        this.name = name;
    }

    public void setTurn(boolean turn) {
        this.myTurn = turn;
    }
    
    public void setPromoDiplayed(boolean value) {
        this.promoDisplayed = value;
    }

    public void addToDeathList(Piece newPiece) {
        for (int i = 0; i < deadPieces.length; i++) {
            if (deadPieces[i]==null) {
                deadPieces[i] = newPiece;
                ImageIcon icon = deadPieces[i].getImage();
                this.labelWithoutImage[i].setIcon(icon);
                this.deathNumberLabel.setText(this.getNbrOfDeaths()+"");
                break;
            }
        }
    }

    //--

    public JPanel displayPanelPromotion() {
 
        this.choosePieceLabel.setOpaque(true);
        this.choosePieceLabel.setLayout(new GridLayout(2,2));
        this.choosePieceLabel.setBackground(new Color(0xf6f6f6));
        this.choosePieceLabel.setBounds(60, 75, 180, 180);

        Rectangle[] positions = {new Rectangle(95,95,90,90),new Rectangle(215,95,90,90),new Rectangle(95,215,90,90),new Rectangle(215,215,90,90)};
        ImageIcon[] images = {queenImage, knightImage, rookImage, bishopImage};

        
        for (int i = 0; i < 4; i++) {
            JLabel piece = new JLabel();
            piece.setOpaque(true);
            piece.setBounds(positions[i]);
            piece.setIcon(images[i]);
            piece.setBorder(BorderFactory.createLineBorder(new Color(0x30c230), 2));
            piece.setBackground(new Color(0xf6f6f6));
            piece.setVerticalAlignment(JLabel.CENTER);
            piece.setHorizontalAlignment(JLabel.CENTER);
            piece.addMouseListener(this);
            this.choosePieceLabel.add(piece);
        }


        this.setPromoDiplayed(true);

        return this.choosePieceLabel;
    }

    public JLabel[] DeathLabels() {

        int[] cols = {25, 88, 151, 214};
        int[] rows = {360, 423, 486, 549};
        int counter = 0;
        
        for (int r : rows) {
            for (int c : cols) {
                JLabel label = new JLabel();
                label.setBounds(c, r, 60, 60);
                label.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 1));
                label.setOpaque(true);
                this.labelWithoutImage[counter] = label;
                label.setBackground(new Color(0x455565));
                counter++;
            }
        }

        return this.labelWithoutImage;
    }


    public JLabel turnLabel() {
        this.turnLabel.setFont(new Font("Dubai", Font.BOLD, 25));
        this.turnLabel.setBounds(0, 0, 300, 80);
        this.turnLabel.setVerticalAlignment(JLabel.CENTER);
        this.turnLabel.setHorizontalAlignment(JLabel.CENTER);

        return this.turnLabel;
    }

    public void startStopCountdown() {
        if (myTurn) {
            this.timerPanel.getTimer().start();
        } else {
            this.timerPanel.getTimer().stop();
        }
    }

    public JPanel getDeathPanel(){

        ImageIcon image = new ImageIcon("images/deathIcon.png");
        JLabel deathLabel = new JLabel();
        JLabel nameLabel = new JLabel();
        
        //Panel :
        if (positionChosen==true) {
            deathPanel.setBounds(1250, 50, 300, 850);
        } else {
            deathPanel.setBounds(50, 50, 300, 850);
        }
        
        deathPanel.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 3));
        deathPanel.setLayout(null);

        //Death pieces :
        deathLabel.setIcon(image);
        deathLabel.setBounds(82, 275, 65, 65);
        deathLabel.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 1));

        this.deathNumberLabel.setOpaque(true);
        this.deathNumberLabel.setVerticalAlignment(JLabel.CENTER);
        this.deathNumberLabel.setHorizontalAlignment(JLabel.CENTER);
        this.deathNumberLabel.setFont(new Font("Dubai", Font.BOLD, 25));
        this.deathNumberLabel.setBounds(147, 275, 65, 65);
        this.deathNumberLabel.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 1));


        //Name :
        nameLabel.setOpaque(true);
        nameLabel.setBounds(25, 630, 250, 150);
        nameLabel.setText(this.getName());
        nameLabel.setFont(dubaiFont25);
        nameLabel.setVerticalAlignment(JLabel.CENTER);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);


        //Timer
        this.timerPanel.getTimerLabel().setOpaque(true);
        this.timerPanel.getTimerLabel().setBounds(75, 95, 150, 100);
        this.timerPanel.getTimerLabel().setFont(this.dubaiFont35);
        this.timerPanel.getTimerLabel().setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 1));   
        this.timerPanel.getTimerLabel().setVerticalAlignment(JLabel.CENTER);
        this.timerPanel.getTimerLabel().setHorizontalAlignment(JLabel.CENTER);    
        this.timerPanel.countDown();


        //Colors
        deathPanel.setBackground(new Color(0x96a6b3));
        nameLabel.setBackground(new Color(0x96a6b3));
        timerPanel.getTimerLabel().setBackground(new Color(0xf6f6f6));



        for (JLabel label : this.DeathLabels()) { deathPanel.add(label); }
        deathPanel.add(this.turnLabel());
        deathPanel.add(timerPanel.getTimerLabel());
        deathPanel.add(nameLabel);
        deathPanel.add(deathNumberLabel);
        deathPanel.add(deathLabel);

        return deathPanel;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
