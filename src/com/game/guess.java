package com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class guess extends JFrame{
	private int randomNumber;
    private int attemptsLeft = 7;
    private int score = 100;
    
    private JTextField guessField;
    private JLabel messageLabel;
    private JLabel attemptsLabel;
    private JButton guessButton, resetButton;
    
    public guess() {
    setTitle("NUMBER GUESSING GAME");
    setSize(600, 500);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.decode("#cdcffa"));
    
    JPanel panel=new JPanel();
    panel.setBounds(0,0,600,40);
    JLabel title=new JLabel("GUESS THE NUMBER");
    title.setBounds(180,20,300,30);
    title.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
    title.setForeground(new Color(3, 4, 31));
    panel.add(title);
    add(panel);
    
    JLabel text=new JLabel("I'm thinkng of a number between 1 and 100.Can you guess what it is?");
    text.setBounds(10,50,550,40);
    text.setFont(new Font("Arial", Font.BOLD, 17));
    add(text);
    
    guessField=new JTextField();
    guessField.setBounds(120,120,350,50);
    guessField.setFont(new Font("Arial ", Font.BOLD,15));
    add(guessField);
    
    guessButton=new JButton("Guess");
    guessButton.setBounds(90,180,200,40);
    guessButton.setBackground(new Color(252, 177, 0));
    guessButton.setForeground(Color.BLACK);
    add(guessButton);
    
    resetButton=new JButton("Reset");
    resetButton.setBounds(300,180,200,40);
    add(resetButton);
    
    attemptsLabel = new JLabel("ATTEMPTS LEFT: " + attemptsLeft);
    attemptsLabel.setFont(new Font("Arial ", Font.BOLD,15));
    attemptsLabel.setBounds(100,220,200,30);
    add(attemptsLabel);
    
    messageLabel = new JLabel("Enter your guess above!", SwingConstants.CENTER);
    messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
    messageLabel.setForeground(Color.BLUE);
    messageLabel.setBounds(80, 260, 450, 40);
    add(messageLabel);
    
    guessButton.addActionListener(e -> checkGuess());
    resetButton.addActionListener(e -> resetGame());
    generateNumber();
    
    setVisible(true);
    }
    private void generateNumber() {
        randomNumber = new Random().nextInt(100) + 1;
    }
    private void checkGuess() {
    	String userText =guessField.getText();
     	
    	try {
    		int guess=Integer.parseInt(userText);
    		attemptsLeft--;
    		
    		if(guess==randomNumber)
    		{
    			messageLabel.setText("Correct! You scored:" + score);
    			messageLabel.setForeground(Color.GREEN);
    			guessButton.setEnabled(false);
    		} else if(guess < randomNumber)
    		{
    			messageLabel.setText("Too Low!");
    			score-= 10;
    		}
    		else {
    			messageLabel.setText("Too high!");
    			score-= 10;
    		}
            attemptsLabel.setText("Attempts left: " + attemptsLeft);
            
            if (attemptsLeft == 0 && guess != randomNumber) {
                messageLabel.setText(" Out of attempts! The number was: " + randomNumber);
                messageLabel.setForeground(Color.RED);
                guessButton.setEnabled(false);
            }
    	}catch (NumberFormatException e) {
            messageLabel.setText("Please enter a valid number!");
    	}
    }
    	
    	 private void resetGame() {
    	        generateNumber();
    	        attemptsLeft = 7;
    	        score = 100;
    	        guessButton.setEnabled(true);
    	        guessField.setText("");
    	        messageLabel.setText("Enter your guess above!");
    	        messageLabel.setForeground(Color.BLUE);
    	        attemptsLabel.setText("Attempts left: " + attemptsLeft);
    	    }
    public static void main(String args[])
    {
    	new guess();
    }
}
















