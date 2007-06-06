/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;

/**
 * Abstract class containing the various settings
 * used in the GUI. 
 */
public abstract class ViewSettings {
	private static int mainWidth = 700;
	private static int mainHeight = 500;
	private static int alternateHeight = 525;
	private static int boardSpacing = 5;
	private static int buttonSize = 25;
	private static Color buttonBackground = Color.WHITE;
	private static Color hintColor = Color.GREEN;
	private static Color wrongNumberColor = Color.RED;
	
	/**
	 * @return The color used for showing hints on the board.
	 */
	public static Color getHintColor() {
		return hintColor;
	}

	/**
	 * @return The color used for wrong numbers on the board. 
	 */
	public static Color getWrongNumberColor() {
		return wrongNumberColor;
	}

	/**
	 * @return The size of the buttons on the board.
	 */
	public static int getButtonSize() {
		return buttonSize;
	}
	
	/**
	 * @return The size of the buttons as a Dimension.
	 */
	public static Dimension getButtonDimension() {
		return new Dimension(buttonSize, buttonSize);
	}
	/**
	 * @return The spacing between the quadrants on the board.
	 */
	public static int getBoardSpacing() {
		return boardSpacing;
	}
	/**
	 * @return The height of the mainwindow.
	 */
	public static int getMainHeight() {
		return mainHeight;
	}
	/**
	 * @return The width of the mainwindow.
	 */
	public static int getMainWidth() {
		return mainWidth;
	}

	/**
	 * @return The backgroundcolor of the buttons
	 */
	public static Color getButtonBackground() {
		return buttonBackground;
	}

	/**
	 * @return The alternate height used for the
	 * 		   congratulationscreen and difficultyselection.
	 */
	public static int getAlternateHeight() {
		return alternateHeight;
	}
}
