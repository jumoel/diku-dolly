/**
 * 
 */
package model;

/**
 * @author Julian
 *
 */
public abstract class GameSettings {
	private static int QuadrantDimension = 3;
	private static int BoardDimensions = QuadrantDimension * QuadrantDimension;
	private static int BoardLength = BoardDimensions * BoardDimensions;

	public static int getQuadrantDimension() {
		return QuadrantDimension;
	}
	public static int getBoardDimensions() {
		return BoardDimensions;
	}
	public static int getBoardLength() {
		return BoardLength;
	}	
}
