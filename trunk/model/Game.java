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
	private Board solutionBoard;
	
	/**
	 * Stores the solved board in solutionBoard. Makes the generator
	 * remove numbers until the desired difficulty is reached and then 
	 * stores the new board in currentBoard
	 */
	public Game() {
		currentBoard = new Board();
		
		int[] solution = new int[currentBoard.toArray().length];
		System.arraycopy(currentBoard.toArray(), 0, solution, 0, currentBoard.toArray().length);
		solutionBoard = new Board(solution);
		
		Generator.generate(currentBoard);
	}
	/**
	 * returns the current board
	 * @return The current board
	 */
	public Board getCurrentBoard() {
		return currentBoard;
	}
	
	public Board getSolutionBoard() {
		return solutionBoard;
	}
	
	public void reset(GameSettings settings) {
		currentBoard.reset(settings);
	}
}
