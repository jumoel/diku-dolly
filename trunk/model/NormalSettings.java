package model;

/**
 * The normal gamesettings for a 9x9 Sudoku.
 */
public class NormalSettings extends General9x9Settings implements GameSettings {
	public static final int IDENTIFIER = 2;
	
	private int numbersToRemove;
	private String difficulty;
	
	public NormalSettings()
	{
		super();
		numbersToRemove = 40;
		difficulty = "Mellem";
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
