/*
 * @Author: Bao Dinh 
 * @Date: 2023-01-17 13:53:38 
 * @Last Modified by:   Bao Dinh 
 * @Last Modified time: 2023-01-17 13:53:38 
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

class TicTacToe {
    // static void createGUI()
    // {
    //     TicTacToeFrame frame = new TicTacToeFrame(); //Initialize GUI frame

    //     //Game Instructions
    //     frame.rulesLabel("<html>Players take turns marking a square. Only squares not already marked can be picked.<br/>"
    //                     + "Once a player has marked three squares in a row, that player wins! <br/>"
    //                     + "If all squares are marked and no three squares are the same, a tied game is declared.<br/>"
    //                     + "Have Fun!</html>");

    //     frame.buttonGrid(); 
    //     frame.setAction();
    //     frame.setVisible(true); 
    // }

    public static void main (String [] args)
    {
        // createGUI(); 
        TicTacToeFrame frame = new TicTacToeFrame(); //Initialize GUI frame

        //Game Instructions
        frame.rulesLabel("<html>Players take turns marking a square. Only squares not already marked can be picked.<br/>"
                        + "Once a player has marked three squares in a row, that player wins! <br/>"
                        + "If all squares are marked and no three squares are the same, a tied game is declared.<br/>"
                        + "Have Fun!</html>");

        frame.buttonGrid(); 
        frame.setAction();
        frame.setVisible(true); 
    }
}