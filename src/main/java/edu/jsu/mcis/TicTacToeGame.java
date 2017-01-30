package edu.jsu.mcis;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGame extends JPanel{
	private TicTacToe tictactoe;
	private int size = 3;
	private JButton[][] buttons;
	
	public TicTacToeGame(){
		tictactoe = new TicTacToe();
		buttons = new JButton[size][size];
		setLayout(new GridLayout(size, size));
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				buttons[i][j] = new JButton("");
				buttons[i][j].setPreferredSize(new Dimension(200, 200));
				buttons[i][j].addActionListener(new TempListener());
				buttons[i][j].setName("Location" + i + j);
				add(buttons[i][j]);
			}
		}
	}
	private String getPlayerMark(int row, int col){
		TicTacToe.boardMark player = tictactoe.getBoardPosition(row, col);
		
		if(player == TicTacToe.boardMark.X){
			return "X";
		}
		else if(player == TicTacToe.boardMark.O){
			return "O";
		}
		else{
			return "";
		}
		
	}
	private class TempListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JButton button = (JButton)event.getSource();
			String location = button.getName().substring(8);
			System.out.println("Location" + location);
			char ch1 = location.charAt(0);
			char ch2 = location.charAt(1);
			int row = Integer.parseInt("" + ch1);
			int col = Integer.parseInt("" + ch2);
			tictactoe.playerMark(row,col);
			button.setText(getPlayerMark(row,col));
			checkForWinner();
		}
	}
	private void checkForWinner(){
		TicTacToe.boardMark winner = tictactoe.checkForWinner();
		final String result;
		
		JOptionPane myPane = new JOptionPane();
		if(winner == TicTacToe.boardMark.X){
			result = "X";
		}
		else if(winner == TicTacToe.boardMark.O){
			result = "O";
		}
		else if(winner == TicTacToe.boardMark.TIE){
			result = "TIE";
		}
		else{
			result = "NONE";
		}
		if(!result.equals("NONE")){
				new Thread(new Runnable(){
						public void run(){
								JOptionPane.showMessageDialog(null, "The winner is " + result , "Game Over", JOptionPane.INFORMATION_MESSAGE);
						}
				}).start();
		}
	}
	public static void main(String[] args){
		TicTacToeGame myPanel = new TicTacToeGame();
		JFrame myFrame = new JFrame("Tic Tac Toe");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(myPanel);
		myFrame.setVisible(true);
		myFrame.pack();
	}

}
