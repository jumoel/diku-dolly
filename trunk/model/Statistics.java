package model;

/**
 * The statistics of the current game.
 * 
 * Keeps track of the amount of Hints and Mistakes made.
 *
 * @author emil
 */
public class Statistics {
	
	private int hints;
	private int mistakes;
	
	/**
	 * Creates a new statistics type for the game.
	 * The amount of hints used and mistakes made from start is, naturally, 0.
	 */
	public Statistics() {
		this.hints = 0;
		this.mistakes = 0;
	}
	
	/**
	 * Increases the amount of hints used by 1.
	 */
	public void increaseHints() {
		hints = hints + 1;
	}

	/**
	 * Returns the amount of hints used.
	 * 
	 * @return The amount of hints.
	 */
	public int getHints() {
		return hints;
	}
	
	/**
	 * Increases the amount of mistakes used by 1.
	 */
	public void increaseMistakes() {
		mistakes = mistakes + 1;
	}
	
	/**
	 * Returns the amount of mistakes used.
	 * 
	 * @return The amount of mistakes
	 */
	public int getMistakes() {
		return mistakes;
	}
}