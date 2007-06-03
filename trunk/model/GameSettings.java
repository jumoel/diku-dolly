/**
 * 
 */
package model;

/**
 * @author Julian
 *
 */
public interface GameSettings {
	public int getQuadrantDimensions();
	public int getBoardDimensions();
	public int getBoardLength();
	public int getNumbersToRemove();
	public int[] getStdBoardArray();
	public int[] getValidValues();
}
