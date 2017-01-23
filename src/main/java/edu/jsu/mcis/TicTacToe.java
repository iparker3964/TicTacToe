package edu.jsu.mcis;

import java.util.*;

public class TicTacToe {
	public enum boardMark{NONE, X, O, TIE};
	
	private int n = 3;
	
	public boardMark[][] myBoard = new boardMark[n][n];
	
	private int turnCounter;
	
	public boardMark userTurn;
	
	public TicTacToe(){
		turnCounter = 0;
		setUpBoard();
		userTurn = boardMark.X;
	}
	
	private void setUpBoard(){
		for(int i=0; i < myBoard.length; i++){
			for(int j = 0; j < myBoard[0].length; j++){
				myBoard[i][j]= boardMark.NONE;
			}
		}
	}
	public void playerMark(int row, int column){
		if(row >= 0&& row <= 2 && column >= 0 && column <= 2){
			if(myBoard[row][column]== boardMark.NONE){
				myBoard[row][column] = userTurn;
				turnCounter++;
				if(userTurn == boardMark.X){
					userTurn = boardMark.O;
				}
				else{
					userTurn = boardMark.X;
				}
			}
		}
	}
	public boardMark checkForWinner(){
		if(myBoard[0][0] == myBoard[1][1]&& myBoard[1][1]== myBoard[2][2]){
			return myBoard[0][0];
		}
		else if(myBoard[0][0] == myBoard[1][0] && myBoard[1][0]== myBoard[2][0]){
			return myBoard[0][0];
		}
		else if(myBoard[0][0] == myBoard[0][1] && myBoard[0][1]== myBoard[0][2]){
			return myBoard[0][0];
		}
		else if(myBoard[0][1]== myBoard[1][1] && myBoard[1][1] == myBoard[2][1]){
			return myBoard[0][1];
		}
		else if(myBoard[0][2]== myBoard[1][1] && myBoard[1][1] == myBoard[2][0]){
			return myBoard[0][2];
		}
		else if(myBoard[0][2]== myBoard[1][2] && myBoard[1][2] == myBoard[2][2]){
			return myBoard[0][2];
		}
		else if(myBoard[1][0] == myBoard[1][1] && myBoard[1][1] == myBoard[1][2]){
			return myBoard[1][0];
		}
		else if(myBoard[2][0] == myBoard[2][1] && myBoard[2][1] == myBoard[2][2]){
			return myBoard[2][0];
		}
		else if (turnCounter == 9){
			return boardMark.TIE;
		}
		else{
			return boardMark.NONE;
		}
	}
	
	public boardMark getTurn(){
		return userTurn;
	}
	
	public boardMark getBoardPosition(int row, int column){
		return myBoard[row][column];
	}
	public boardMark getMark(int row, int col) {
		if(myBoard[row][col] == boardMark.NONE) return boardMark.NONE;
		else if(myBoard[row][col] == boardMark.X) return boardMark.X;
		else return boardMark.O;
	}
	
    
}




	
