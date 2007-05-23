/**
 * 
 */
package view;

import java.awt.Dimension;

/**
 * @author Julian
 *
 */
public abstract class ViewSettings {
	private static int mainWidth = 700;
	private static int mainHeight = 500;
	private static int boardSpacing = 5;
	private static int buttonSize = 25;
	
	/**
	 * @return the boardSize
	 */
	public static int getButtonSize() {
		return buttonSize;
	}
	
	public static Dimension getButtonDimension() {
		return new Dimension(buttonSize, buttonSize);
	}
	/**
	 * @return the boardSpacing
	 */
	public static int getBoardSpacing() {
		return boardSpacing;
	}
	/**
	 * @return the mainHeight
	 */
	public static int getMainHeight() {
		return mainHeight;
	}
	/**
	 * @return the mainWidth
	 */
	public static int getMainWidth() {
		return mainWidth;
	}
}
