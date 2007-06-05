/**
 * 
 */
package model;

/**
 * @author Julian
 *
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

	public int getNumbersToRemove() {
		return numbersToRemove;
	}

	public String getDifficulty() {
		return difficulty;
	}
}
