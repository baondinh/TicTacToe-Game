/*
 * @Author: Bao Dinh 
 * @Date: 2023-01-16 13:24:52 
 * @Last Modified by: Bao Dinh
 * @Last Modified time: 2023-01-16 17:06:03
 */

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font; 

class TicTacToeButton extends JButton
{
    private String name; 
    private ImageIcon icon; 
    
    //Constructor
    TicTacToeButton(String text)
    {
        name = text; 
        this.setText(name);  
    }

    //Instance methods
    public void changeButton()
    {
        if (name != "X" && name != "O")
        {
            name = "X"; 
            this.setText(name); 
            this.setFont(new Font("Times New Roman", Font.BOLD, 75)); 
            // this.setEnabled(false);         
            // this.setText("<html><font color = red>X</font></html>");    
            this.setForeground(Color.red); 
            this.setBackground(Color.lightGray); 
        }
    }
}
