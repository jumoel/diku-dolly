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
	
	public Board getSolutionBoard() {
		return solutionBoard;
	}
	
	public void setSolutionBoard(Board solutionBoard) {
		this.solutionBoard = solutionBoard;
	}
	
	public void reset(GameSettings settings) {
		this.statistics = null;
		this.statistics = new Statistics();
		currentBoard.reset(settings, this);
	}
	
	public Statistics getStatistics() {
		return this.statistics;
	}
}
