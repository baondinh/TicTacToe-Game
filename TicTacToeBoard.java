/*
 * @Author: Bao Dinh 
 * @Date: 2023-01-16 16:35:22 
 * @Last Modified by: Bao Dinh
 * @Last Modified time: 2023-01-16 16:36:04
 */

/*
Implementing TicTacToeBoard class with instance variables, constructors and instance methods 
TicTacToeBoard class methods do not print anything
Controls board state
*/

class TicTacToeBoard
{
    //Instance variables
    private char [][] board = {
                                {' ', ' ', ' '},
                                {' ', ' ', ' '},
                                {' ', ' ', ' '}
    }; 
    private String p1, p2; 

    //Constructors
    public TicTacToeBoard (String name1, String name2)
    {
        p1 = name1; 
        p2 = name2; 
    }
    
    public String toString()
    {
        String row1 = "";
        String row2 = "";
        String row3 = ""; 

        //Returned String is constructed one row at a time from game board
        for (int i = 0; i < this.board.length; i++)
        {
            row1 += (this.board[0][i] + " ");
            row2 += (this.board[1][i] + " ");
            row3 += (this.board[2][i] + " ");
        }

        String gameBoard = ("\nGame Board: \n"
                            +"| " + row1 +"|\n"
                            +"| " + row2 +"|\n"
                            +"| " + row3 +"|\n");
        return gameBoard;
    }

    //Instance method that returns false if invalid move made
    //Returns true if player is able to move and edits state of board
    public boolean move(String player, int row, int column)
    {
        int i = row - 1; 
        int j = column - 1; 
        if (i < 0 || i > 2 || j < 0 || j > 2)   //Out of range move
            { return false; }

        if (player == this.p1)                  //Player One's move 'X'
        {
            if (this.board[i][j] != ' ')        //Chosen location already filled
                { return false; }
            else
            {
                this.board[i][j] = 'X';
                return true;
            }
        }
        else                                    //Player Two's move 'O'
        {
            if (this.board[i][j] != ' ')        //Chosen location already filled
                { return false; }
            else
            {
                this.board[i][j] = 'O';
                return true;
            }
        }
    }

    //Returns true if all board spaces are filled and false otherwise
    public boolean isTie()
    {
        //Check grid for a blank space and return false if there is a blank
        for (int i = 0; i < this.board.length; i++)
        {
            for (int j = 0; j < this.board[i].length; j++)
            {
                if (this.board[i][j] == ' ')
                    { return false; }
            }
        }

        //If no blank is found, this indicates entire board has filled without a winner so game is a tie
        return true; 
    }

    //Returns 0 if NO WIN, 1 if WIN, and -1 if DRAW
    public int isWin()
    {
        //If isTie returns true, then the game is a tie
        if (isTie()) { return -1; }

        //Horizontal and vertical wins
        for (int i = 0; i < this.board.length; i++)
        {
            if ((this.board[i][0] == this.board[i][1] && this.board[i][1] == this.board[i][2])
                && this.board[i][0] != ' ') //horizontal win
                { return 1; }
            if ((this.board[0][i] == this.board[1][i] && this.board[1][i] == this.board[2][i])
                && this.board[0][i] != ' ') //vertical win
                { return 1; }
        }
        //Upwards diagonal win
        if ((this.board[2][0] == this.board[1][1] && this.board[1][1] == this.board [0][2])
            && this.board[1][1] != ' ')
            { return 1; }
        //Downwards diagonal win
        if ((this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board [2][2])
            && this.board[1][1] != ' ')
            { return 1; }

        //If there is no win or draw
        return 0; 
    }
}