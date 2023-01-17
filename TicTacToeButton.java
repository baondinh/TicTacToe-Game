/*
 * @Author: Bao Dinh 
 * @Date: 2023-01-17 13:53:46 
 * @Last Modified by:   Bao Dinh 
 * @Last Modified time: 2023-01-17 13:53:46 
 */

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font; 

class TicTacToeButton extends JButton
{
    private String name; //Way to differentiate between buttons 
    private int player; 
    
    //Constructor
    TicTacToeButton(String text)
    {
        name = text;  
        this.setText(name);  
    }

    //Getter and Setter methods
    public String getName() {
        return name; 
    }

    public void setPlayer(int n) {   
        player = n; 
    }

    //Instance methods
    public void changeButton()
    {
        if (player == 1) {
            name = "X"; 
            this.setText(name); 
            this.setFont(new Font("Times New Roman", Font.BOLD, 75));    
            this.setForeground(Color.red); 
            this.setBackground(Color.lightGray); 
        }
        else if (player == 2) {
            name = "O"; 
            this.setText(name); 
            this.setFont(new Font("Times New Roman", Font.BOLD, 75));    
            this.setForeground(Color.blue); 
            this.setBackground(Color.lightGray); 
        }
    }

    public boolean legalMove() {
        if (name == "X" || name == "O") {
            return false;
        } 
        else return true;
    }
}
