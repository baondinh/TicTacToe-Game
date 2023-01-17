/*
 * @Author: Bao Dinh 
 * @Date: 2023-01-17 13:50:43 
 * @Last Modified by:   Bao Dinh 
 * @Last Modified time: 2023-01-17 13:50:43 
 */

/*
Merge TicTacToBoard.java with Frame.java
*/

import javax.swing.*; 
import java.awt.event.*;

class TicTacToeFrame extends JFrame implements ActionListener{
    
    final private int SIZE = 700; 
    final private int MARGIN = 50; 

    TicTacToeButton button1, button2, button3, button4, button5, 
    button6, button7, button8, button9; 

    TicTacToeButton [][] GRID = {   {button1, button2, button3},
                                    {button4, button5, button6},
                                    {button7, button8, button9} };
            
    private int player = 1; //Starts with player 1 
    private int gameStatus = 0; //0 active game, 1 p1 win, 2 p2 win, -1 tie
                                    
    //Constructors
    TicTacToeFrame() {
        this.setTitle("Tic-Tac-Toe"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(SIZE, SIZE);         
        this.setLayout(null); 
    }

    public void showFrame() {
        this.setVisible(true); 
    }

    //Instance methods
    public void rulesLabel(String text)
    {
        JLabel label = new JLabel();
        label.setBounds(MARGIN, 0, 600, 100); 
        label.setText(text); 
        this.add(label); 
    }

    public void buttonGrid() //3x3 grid with buttons that allows users to click and place marker
    {
        int buttonSize = ((SIZE/2) - MARGIN)/3; 

        button1 = new TicTacToeButton("1");
        button2 = new TicTacToeButton("2");
        button3 = new TicTacToeButton("3");
        button4 = new TicTacToeButton("4");
        button5 = new TicTacToeButton("5");
        button6 = new TicTacToeButton("6");
        button7 = new TicTacToeButton("7");
        button8 = new TicTacToeButton("8");
        button9 = new TicTacToeButton("9");
        
        //setBounds(x, y, width, height)
        button1.setBounds(MARGIN, MARGIN * 2 , buttonSize, buttonSize); 
        button2.setBounds(MARGIN + buttonSize, MARGIN * 2 , buttonSize, buttonSize);
        button3.setBounds(MARGIN + buttonSize * 2, MARGIN * 2 , buttonSize, buttonSize);
        button4.setBounds(MARGIN , MARGIN * 2  + buttonSize, buttonSize, buttonSize);
        button5.setBounds(MARGIN + buttonSize, MARGIN * 2 + buttonSize, buttonSize, buttonSize);
        button6.setBounds(MARGIN + buttonSize * 2, MARGIN * 2 + buttonSize, buttonSize, buttonSize);
        button7.setBounds(MARGIN , MARGIN * 2 + buttonSize * 2, buttonSize, buttonSize);
        button8.setBounds(MARGIN + buttonSize, MARGIN * 2 + buttonSize * 2, buttonSize, buttonSize);
        button9.setBounds(MARGIN + buttonSize * 2, MARGIN * 2 + buttonSize * 2, buttonSize, buttonSize); 
        
        //Add buttons
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9); 
    }

    //ActionListener buttons
    public void setAction() {
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
    }

    public void disableButtons() {
        button1.setEnabled(false); 
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
    }

    //Memory functionality **********************
    //true --> all board spaced filled and game is a tie
    //false --> blank space still available
    public boolean isTie() {
        if ((button1.getName() != "X" && button1.getName() != "O") && (button2.getName() != "X" && button2.getName() != "O") && (button3.getName() != "X" && button3.getName() != "O")
            && (button4.getName() != "X" && button4.getName() != "O") && (button5.getName() != "X" && button5.getName() != "O") && (button6.getName() != "X" && button6.getName() != "O")
            && (button7.getName() != "X" && button7.getName() != "O") && (button8.getName() != "X" && button8.getName() != "O") && (button9.getName() != "X" && button9.getName() != "O")) {
            return true; 
        }
        return false; 
    }

    //Returns 0 if NO WIN, 1 if WIN, and -1 if DRAW
    public int isWin() {
        //If isTie returns true, then the game is a tie
        if (isTie()) { return -1; }

        if (((button1.getName() == button2.getName() && button2.getName() == button3.getName()) && (button1.getName() == "X" || button1.getName() == "O"))      //Row 1
            || ((button4.getName() == button5.getName() && button5.getName() == button6.getName()) && (button4.getName() == "X" || button4.getName() == "O"))   //Row 2
            || ((button7.getName() == button8.getName() && button8.getName() == button9.getName()) && (button7.getName() == "X" || button7.getName() == "O"))   //Row 3
            || ((button1.getName() == button4.getName() && button4.getName() == button7.getName()) && (button1.getName() == "X" || button1.getName() == "O"))   //Column 1
            || ((button2.getName() == button5.getName() && button5.getName() == button8.getName()) && (button2.getName() == "X" || button2.getName() == "O"))   //Column 2
            || ((button3.getName() == button6.getName() && button6.getName() == button9.getName()) && (button3.getName() == "X" || button3.getName() == "O"))   //Column 3
            || ((button1.getName() == button5.getName() && button5.getName() == button9.getName()) && (button1.getName() == "X" || button1.getName() == "O"))   //Downwards diagonal
            || ((button3.getName() == button5.getName() && button5.getName() == button7.getName()) && (button3.getName() == "X" || button3.getName() == "O"))) {//Upwards diagonal
            disableButtons();
            return 1; //Win
        }
        else return 0; //If no win or draw
    }

    public void checkGame() {
        //Change game status
        gameStatus = isWin(); 

        //Check game status after each move
        if (gameStatus == 0) //If there is no win, then change player turn
        {
            if (player == 1) {player = 2;}  //Change to P2
            else player = 1;              //Change to P1
            System.out.println("It is Player " + player + "'s turn.");
        }
        if (gameStatus !=0) {
            if (gameStatus == 1) { //P1 wins
                System.out.println("Game Over - Player" + player + " WINS!!!");
            }
            else if (gameStatus == 2) { //P2 wins
                System.out.println("Game Over - Player" + player + " WINS!!!");
            }
            else if (gameStatus == -1) { //Draw
                System.out.println("Game Over - It's a TIE!!!");
            }
            else System.out.println("Error");
        }
    }

    //Button behavior
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            if (button1.legalMove() == true) {
                button1.setPlayer(player);
                button1.changeButton(); 
                checkGame(); 
            }
            else System.out.println("Error: ILLEGAL CHOICE! TRY AGAIN...");
        }
        else if (e.getSource() == button2) {
            if (button2.legalMove() == true) {
                button2.setPlayer(player);
                button2.changeButton(); 
                checkGame();
            }
            else System.out.println("Error: ILLEGAL CHOICE! TRY AGAIN...");
        }
        else if (e.getSource() == button3) {
            if (button3.legalMove() == true) {
                button3.setPlayer(player);
                button3.changeButton(); 
                checkGame();
            }
            else System.out.println("Error: ILLEGAL CHOICE! TRY AGAIN...");
        }
        else if (e.getSource() == button4) {
            if (button4.legalMove() == true) {
                button4.setPlayer(player);
                button4.changeButton(); 
                checkGame();
            }
            else System.out.println("Error: ILLEGAL CHOICE! TRY AGAIN...");
        }
        else if (e.getSource() == button5) {
            if (button5.legalMove() == true) {
                button5.setPlayer(player);
                button5.changeButton(); 
                checkGame();
            }
            else System.out.println("Error: ILLEGAL CHOICE! TRY AGAIN...");
        }
        else if (e.getSource() == button6) {
            if (button6.legalMove() == true) {
                button6.setPlayer(player);
                button6.changeButton(); 
                checkGame();
            }
            else System.out.println("Error: ILLEGAL CHOICE! TRY AGAIN...");
        }
        else if (e.getSource() == button7) {
            if (button7.legalMove() == true) {
                button7.setPlayer(player);
                button7.changeButton(); 
                checkGame();
            }
            else System.out.println("Error: ILLEGAL CHOICE! TRY AGAIN...");
        }
        else if (e.getSource() == button8) {
            if (button8.legalMove() == true) {
                button8.setPlayer(player); 
                button8.changeButton(); 
                checkGame();
            }
            else System.out.println("Error: ILLEGAL CHOICE! TRY AGAIN...");
        }
        else if (e.getSource() == button9) {
            if (button9.legalMove() == true) {
                button9.setPlayer(player); 
                button9.changeButton();
                checkGame(); 
            }
            else System.out.println("Error: ILLEGAL CHOICE! TRY AGAIN..."); 
        }
    }
}