package model;

/**
 * The hard gamesettings for a 9x9 Sudoku.
 */
public class HardSettings extends General9x9Settings implements GameSettings {
	public static final int IDENTIFIER = 3;
	
	private int numbersToRemove;
	private String difficulty;
	
	public HardSettings()
	{
		super();
		numbersToRemove = 60;
		difficulty = "Svær";
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
