package edu.jsu.mcis;

import java.util.*;

public class TheBoard{
	private TicTacToe tictactoe;
	
	private int n = 3;
	
	public String [][] displayBoard = new String[n][n];

	public void startGame(){
		tictactoe = new TicTacToe();
	}
	
	private void updateBoard(){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(tictactoe.getBoardPosition(i,j) == TicTacToe.boardMark.NONE){
					displayBoard[i][j] = "Empty";
				}
				else if(tictactoe.getBoardPosition(i,j) == TicTacToe.boardMark.X){
					displayBoard[i][j] = "X";
				}
				else{
					displayBoard[i][j] = "O";
				}
			}
		}
	}
	
	private void userVisualOfBoard(){
		System.out.println(" " + displayBoard[0][0] + " | " + displayBoard[0][1] + " | " + displayBoard[0][2]);
		System.out.println("----------");
		System.out.println(" " + displayBoard[1][0] + " | " + displayBoard[1][1] + " | " + displayBoard[1][2]);
		System.out.println("----------");
		System.out.println(" " + displayBoard[2][0] + " | " + displayBoard[2][1] + " | " + displayBoard[2][2]);
	}
	public String getPlayerTurn(){
		TicTacToe.boardMark playerTurn = tictactoe.getTurn();
		if(playerTurn == TicTacToe.boardMark.X){
			return "Player X";
		}
		else{
			return "Player O";
		}
	}
	public static void main(String[] args){
		TheBoard theboard = new TheBoard();
		
		theboard.startGame();
		theboard.updateBoard();
		theboard.userVisualOfBoard();
		
		while(theboard.tictactoe.checkForWinner() == TicTacToe.boardMark.NONE){
			System.out.println("Where would you like to place your mark " + theboard.getPlayerTurn() + " ? enter the row[0-2] then press enter, then enter the column[0-2]");
			Scanner userRow = new Scanner(System.in);
			
			int Row = userRow.nextInt();
			
			Scanner userColumn = new Scanner(System.in);
			
			int Col = userColumn.nextInt();
			
			theboard.tictactoe.playerMark(Row, Col);
			
			theboard.tictactoe.checkForWinner();
			
			theboard.updateBoard();
			theboard.userVisualOfBoard();
			
		}
	}
}