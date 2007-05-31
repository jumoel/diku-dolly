/**
 * 
 */
package model;

/**
 * @author Steen
 *
 */
public class Game {
	private Board currentBoard;
	/**
	 * Stores the solved board in solutionBoard. Makes the generator
	 * remove numbers until the desired difficulty is reached and then 
	 * stores the new board in currentBoard
	 */
	public Game() {
		currentBoard = new Board();
		Generator.generate(currentBoard);
	}
	/**
	 * returns the current board
	 * @return The current board
	 */
	public Board getCurrentBoard() {
		return currentBoard;
	}
	
	public void reset(int difficulty) {
		currentBoard.reset(difficulty);
	}
}
