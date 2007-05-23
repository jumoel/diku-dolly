/**
 * 
 */
package model;

/**
 * @author Steen
 *
 */
public class Game {
	private Board solutionBoard;
	private Board currentBoard;
	/**
	 * Stores the solved board in solutionBoard. Makes the generator
	 * remove numbers until the desired difficulty is reached and then 
	 * stores the new board in currentBoard
	 */
	public Game() {
		currentBoard = new Board();
		solutionBoard = new Board(currentBoard.toArray());
		Generator.generate(currentBoard);
	}
	/**
	 * returns the solved board
	 * @return The solved board
	 */
	public Board getSolutionBoard() {
		return solutionBoard;
	}
	/**
	 * returns the current board
	 * @return The current board
	 */
	public Board getCurrentBoard() {
		return currentBoard;
	}
}
