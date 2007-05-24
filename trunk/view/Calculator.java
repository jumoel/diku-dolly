/**
 * 
 */
package view;

import java.awt.Dimension;

/**
 * @author Julian
 *
 */
public abstract class Calculator {
	/**
	 * Calculates the visual width of the gameboard.
	 * @param board The board to calculate the width of.
	 * @return The width of the board.
	 */
	public static Dimension getBoardDimensions(model.Board board) {
		int dimension = board.getSettings().getBoardDimensions() * 
						ViewSettings.getButtonSize();
		
		int finalWidth = dimension +
			(board.getSettings().getQuadrantDimension() - 1) * ViewSettings.getBoardSpacing();
		
		return new Dimension(finalWidth, finalWidth);
	}
}
