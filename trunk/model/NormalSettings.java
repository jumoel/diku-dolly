/**
 * 
 */
package model;

/**
 * @author Julian
 *
 */
public class NormalSettings extends General9x9Settings implements GameSettings {
	public static final int IDENTIFIER = 2;
	
	private int numbersToRemove;
	
	public NormalSettings()
	{
		numbersToRemove = 1;
	}

	public int getNumbersToRemove() {
		return numbersToRemove;
	}
}
