/*
 * @Author: Bao Dinh 
 * @Date: 2023-01-14 12:53:26 
 * @Last Modified by: Bao Dinh
 * @Last Modified time: 2023-01-16 17:05:31
 */

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

class Frame extends JFrame implements ActionListener
{
    final private int SIZE = 700; 
    final private int MARGIN = 50; 

    // JButton button1, button2, button3, button4, button5, 
    //         button6, button7, button8, button9; 

    TicTacToeButton button1, button2, button3, button4, button5, 
    button6, button7, button8, button9; 
            
    //Constructors
    Frame() 
    {
        this.setTitle("Tic-Tac-Toe"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(SIZE, SIZE);         
        this.setLayout(null); 
    }

    public void showFrame()
    {
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

        setAction(); 
        
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

    private void setAction()
    {
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

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Button was clicked."); 
        if (e.getSource() == button1)
        {
            button1.changeButton(); 
        }
        else if (e.getSource() == button2)
        {
            button2.changeButton(); 
        }
        else if (e.getSource() == button3)
        {
            button3.changeButton(); 
        }
        else if (e.getSource() == button4)
        {
            button4.changeButton(); 
        }
        else if (e.getSource() == button5)
        {
            button5.changeButton(); 
        }
        else if (e.getSource() == button6)
        {
            button6.changeButton(); 
        }
        else if (e.getSource() == button7)
        {
            button7.changeButton(); 
        }
        else if (e.getSource() == button8)
        {
            button8.changeButton(); 
        }
        else if (e.getSource() == button9)
        {
            button9.changeButton(); 
        }
    }
}