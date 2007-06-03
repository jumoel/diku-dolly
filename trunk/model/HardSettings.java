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
	
	public HardSettings()
	{
		super();
		numbersToRemove = 60;
	}

	public int getNumbersToRemove() {
		return numbersToRemove;
	}
}
