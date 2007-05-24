/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.Font;

/**
 * @author Julian
 *
 */
public abstract class ViewSettings {
	private static int mainWidth = 700;
	private static int mainHeight = 500;
	private static int boardSpacing = 10;
	private static int buttonSize = 30;
	private static Font buttonFont = new Font("SansSerif", Font.PLAIN, 11);
	
	/**
	 * @return the buttonFont
	 */
	public static Font getButtonFont() {
		return buttonFont;
	}

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
