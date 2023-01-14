/*
 * @Author: Bao Dinh 
 * @Date: 2023-01-14 12:53:26 
 * @Last Modified by:   Bao Dinh 
 * @Last Modified time: 2023-01-14 12:53:26 
 */

import javax.swing.*;
import java.awt.*; 

public class Frame extends JFrame
{
    //Constructors
    Frame() 
    {
        this.setTitle("Tic-Tac-Toe"); 
        this.setVisible(true); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(700, 700);         
    }

    //Instance methods
    public void rulesLabel(String text)
    {
        JLabel label = new JLabel();
        label.setText(text); 
        label.setHorizontalTextPosition(JLabel.CENTER); 
        label.setVerticalTextPosition(JLabel.TOP); 

        this.add(label); 
    }

    public void buttonGrid() //3x3 grid with buttons that allows users to click and place marker
    {
        JButton button1 = new JButton(); 
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();
        JButton button5 = new JButton();
        JButton button6 = new JButton();
        JButton button7 = new JButton();
        JButton button8 = new JButton();
        JButton button9 = new JButton();
        
        //setBounds(x, y, width, height)
        button1.setBounds(50, 50, 100, 100); 
        button2.setBounds(150, 50, 100, 100);
        button3.setBounds(250, 50, 100, 100);
        button4.setBounds(50, 150, 100, 100);
        button5.setBounds(150, 150, 100, 100);
        button6.setBounds(250, 150, 100, 100);
        button7.setBounds(50, 250, 100, 100);
        button8.setBounds(150, 250, 100, 100);
        button9.setBounds(250, 250, 100, 100);

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
}