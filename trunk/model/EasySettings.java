package model;

/**
 * The easy gamesettings for a 9x9 Sudoku.
 */
public class EasySettings extends General9x9Settings implements GameSettings {
	public static final int IDENTIFIER = 1;
	
	private int numbersToRemove;
	private String difficulty;
	
	public EasySettings()
	{
		super();
		numbersToRemove = 20;
		difficulty = "Let";
	}
	/**
	 * returns the numbers to remove
	 * @return The numbers to remove
	 */
	public int getNumbersToRemove() {
		return numbersToRemove;
	}
	/**
	 * returns the difficulty
	 * @return The difficulty
	 */
	public String getDifficulty() {
		return difficulty;
	}
}
