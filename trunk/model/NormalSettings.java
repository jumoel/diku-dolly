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

	public int getNumbersToRemove() {
		return numbersToRemove;
	}

	public String getDifficulty() {
		return difficulty;
	}
}
