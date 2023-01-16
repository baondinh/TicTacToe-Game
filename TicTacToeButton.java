/*
 * @Author: Bao Dinh 
 * @Date: 2023-01-16 13:24:52 
 * @Last Modified by: Bao Dinh
 * @Last Modified time: 2023-01-16 17:33:28
 */

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font; 
import java.awt.event.*; 

class TicTacToeButton extends JButton implements ActionListener
{
    private String name; 
    private String player; 
    
    //Constructor
    TicTacToeButton(String text)
    {
        name = text; 
        player = "p2"; 
        this.setText(name); 
        this.addActionListener(this);  
    }

    //Instance methods
    public void setPlayer() {   
        
    }

    public void changeButton()
    {
        if (name != "X" && name != "O") {
            if (player == "p1") {
                name = "X"; 
                this.setText(name); 
                this.setFont(new Font("Times New Roman", Font.BOLD, 75)); 
                // this.setEnabled(false);         
                // this.setText("<html><font color = red>X</font></html>");    
                this.setForeground(Color.red); 
                this.setBackground(Color.lightGray); 
            }
            else if (player == "p2") {
                name = "O"; 
                this.setText(name); 
                this.setFont(new Font("Times New Roman", Font.BOLD, 75)); 
                // this.setEnabled(false);         
                // this.setText("<html><font color = red>X</font></html>");    
                this.setForeground(Color.blue); 
                this.setBackground(Color.lightGray); 
            }
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this)
        {
            changeButton(); 
        }
    }
}
