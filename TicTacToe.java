/*
 * @Author: Bao Dinh 
 * @Date: 2023-01-10 12:29:34 
 * @Last Modified by: Bao Dinh
 * @Last Modified time: 2023-01-10 13:30:26
 */

/*
Program implements a full tic-tac-toe game between two players with the computer acting as a "referee"
Players must input their "move" and if it is valid, the board will update
If a player gets three X's or three O's in a row, a win message for the player is displayed
If no player wins before all board spaces are filled, a tie message will be displayed
Controls rules of the game and display messages
*/

/*
TicTacToe.java should initialize GUI and computer memory of gameboard state
TicTacToeBoard.java holds memory of gameboard state while Frame.java changes GUI to update with user input
*/

import java.util.Scanner;

class TicTacToe
{
    static final Scanner keyboard = new Scanner(System.in);

    static void game (String p1, String p2)
    {
        TicTacToeBoard gameBoard = new TicTacToeBoard(p1,p2);

        int gameStatus = gameBoard.isWin();
        int row, column;
        int turn = 0; //P1 goes on 0, P2 goes on 1, keeps track of index for player name
        String [] playerTurn = {p1, p2};

        //Show initial state of game board
        System.out.println(gameBoard.toString());
        //Player 1 initial turn
        System.out.println("It is " + playerTurn[turn] + "'s turn.");

        //Loop to continuously run the game until a winner is found or game ends in a draw
        do
        {
            //Player move
            System.out.print("Pick a row between 1 and 3: ");
            row = keyboard.nextInt();
            System.out.print("Pick a column between 1 and 3: ");
            column = keyboard.nextInt();

            //Check if move is legal and update board
            if (gameBoard.move(playerTurn[turn], row, column) == true)
            {
                //Show current state of game board
                System.out.println(gameBoard.toString());

                //Check game status
                gameStatus = gameBoard.isWin();
                if (gameStatus == 0) //If there is no win, then change player turn
                {
                    if (turn == 0) {turn = 1;}  //Change to P2
                    else turn = 0;              //Change to P1
                    System.out.println("It is " + playerTurn[turn] + "'s turn.");
                }
            }
            else System.out.println("ILLEGAL CHOICE! TRY AGAIN...");
        } while(gameStatus == 0);

        //Who wins?
        if (gameStatus !=0)
        {
            if (gameStatus == 1) //P1 wins
            {
                System.out.println("Game Over - " + playerTurn[turn] + " WINS!!!");
            }
            else if (gameStatus == 2) //P2 wins
            {
                System.out.println("Game Over - " + playerTurn[turn] + " WINS!!!");
            }
            else if (gameStatus == -1) //Draw
            {
                System.out.println("Game Over - It's a TIE!!!");
            }
            else System.out.println("Error");
        }
    }

    public static void main (String [] args)
    {
        Frame frame = new Frame(); //Initialize GUI frame
        //GUI rule display 
        //Game Instructions
        frame.createLabel("<html>Players take turns marking a square. Only squares not already marked can be picked.<br/>"
                        + "Once a player has marked three squares in a row, that player wins! <br/>"
                        + "If all squares are marked and no three squares are the same, a tied game is declared.<br/>"
                        + "Have Fun!</html>");


        //Welcome message and input for player names
        System.out.println("Welcome! Tic-Tac-Toe is a two player game.");
        // Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter player one's name: ");
        String p1 = keyboard.nextLine();
        System.out.print("Enter player two's name: ");
        String p2 = keyboard.nextLine();

        //Begin Game
        game(p1, p2);
        keyboard.close();
    }
}