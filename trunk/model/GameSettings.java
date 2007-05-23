/**
 * 
 */
package model;

/**
 * @author Julian
 *
 */
public abstract class GameSettings {
	
	private abstract class defaultSettings {
		private int QuadrantDimension = 3;
		private int BoardDimensions = QuadrantDimension * QuadrantDimension;
		private int BoardLength = BoardDimensions * BoardDimensions;

		public int getQuadrantDimension() {
			return QuadrantDimension;
		}
		public int getBoardDimensions() {
			return BoardDimensions;
		}
		public int getBoardLength() {
			return BoardLength;
		}
	}
	
	//public abstract class normalSettings extends defaultSettings
}
