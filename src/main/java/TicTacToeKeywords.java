import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
	private TicTacToe tictactoe;
	
	public void startNewGame() {
			tictactoe = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
			tictactoe.playerMark(row, col);
	}
	
	public String getMark(int row, int col) {
		return tictactoe.myBoard[row][col].toString();
	}
    
	public String getWinner() {
		return "" + tictactoe.checkForWinner();
	}
}
