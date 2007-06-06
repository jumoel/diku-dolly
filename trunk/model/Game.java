/**
 * 
 */
package model;

/**
 * Contains the gameboard and the solution.
 * When a new game is created Game will create a new board.
 */
public class Game {
	private Board currentBoard;
	private Board solutionBoard;
	private Statistics statistics;
	
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
		
		statistics = new Statistics();
	}
	/**
	 * returns the current board
	 * @return The current board
	 */
	public Board getCurrentBoard() {
		return currentBoard;
	}
	/**
	 * returns the solved board
	 * @return The solved board
	 */
	public Board getSolutionBoard() {
		return solutionBoard;
	}
	/**
	 * stores the solved board
	 * @param solutionBoard
	 */
	public void setSolutionBoard(Board solutionBoard) {
		this.solutionBoard = solutionBoard;
	}
	/**
	 * creates a new statistics element based on the settings.
	 * @param settings
	 */
	public void reset(GameSettings settings) {
		this.statistics = null;
		this.statistics = new Statistics();
		currentBoard.reset(settings, this);
	}
	/**
	 * returns the statistics
	 * @return The statistics
	 */
	public Statistics getStatistics() {
		return this.statistics;
	}
}
