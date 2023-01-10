/*
 * @Author: Bao Dinh 
 * @Date: 2023-01-10 12:30:24 
 * @Last Modified by: Bao Dinh
 * @Last Modified time: 2023-01-10 12:36:56
 */

import javax.swing.JFrame;

public class Frame extends JFrame
{
    //Constructors
    Frame() 
    {
        this.setTitle("Tic-Tac-Toe"); 
        this.setVisible(true); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(800, 800);         
    }

    Frame(int size)
    {
        this.setTitle("Tic-Tac-Toe"); 
        this.setVisible(true); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(size, size); 
    }
}