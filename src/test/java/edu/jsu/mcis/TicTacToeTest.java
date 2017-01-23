package edu.jsu.mcis;

import java.util.*;
import edu.jsu.mcis.TicTacToe.boardMark;
import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	private TicTacToe tic;
	
	@Before
	public void setUp(){
		tic = new TicTacToe();
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				assertEquals(boardMark.NONE, tic.getBoardPosition(i,j));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		boardMark[][] gameBoard = tic.myBoard;
		gameBoard[0][2] = boardMark.X;
		tic.playerMark(0, 2);
		assertEquals(gameBoard[0][2], tic.myBoard[0][2]);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		boardMark[][] gameBoard = tic.myBoard;
		gameBoard[2][0] = boardMark.O;
		tic.playerMark(2,0);
		assertEquals(gameBoard[2][0], tic.myBoard[2][0]);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		tic.playerMark(0,0);
		tic.playerMark(0,0);
		assertEquals(boardMark.X, tic.myBoard[0][0]);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		tic.playerMark(0,0);
		boardMark thisPlayerWon = tic.checkForWinner();
		assertEquals(boardMark.NONE, thisPlayerWon);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		boardMark gameWinner;
		tic.playerMark(0,0);
		tic.playerMark(1,0);
		tic.playerMark(0,1);
		tic.playerMark(2,0);
		tic.playerMark(0,2);
		
		gameWinner = tic.checkForWinner();
		assertEquals(boardMark.X, gameWinner);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		boardMark gameWinner;
		
		tic.playerMark(0,0);
		tic.playerMark(1,1);
		tic.playerMark(2,0);
		tic.playerMark(0,2);
		tic.playerMark(0,1);
		tic.playerMark(1,0);
		tic.playerMark(1,2);
		tic.playerMark(2,1);
		tic.playerMark(2,2);
		gameWinner = tic.checkForWinner();
		assertEquals(boardMark.TIE, gameWinner);
	}	
}
