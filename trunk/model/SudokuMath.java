/**
 * 
 */
package model;

/**
 * Performs various mathematical operations on SudokuBoards.
 * Everything is 0-index'ed. 
 * Fx. a row from a 3x3x9 Sudoku has the numbers 0 to 8.
 * 
 * @author Emil
 */
public abstract class SudokuMath {
	
	/**
	 * Converts a position to a rownumber, 
	 * by calculating (position / boardDimension).
	 * 
	 * @param position The position on the board.
	 * @return The number of the row.
	 */
	public static int getRowNumber(int position, GameSettings settings) {
		return (position / settings.getBoardDimensions());
	}
	
	/**
	 * Converts a position to a columnnumber, 
	 * by calculating (position % boardDimension).
	 * 
	 * @param position The position on the board.
	 * @return The number of the column.
	 */
	public static int getColumnNumber(int position, GameSettings settings) {
		return (position % settings.getBoardDimensions());
	}
	
	/**
	 * Converts a position to a quadrantnumber, by calculating
	 * ((rowNumber / quadrantDim) * quadrantDim + columnNumber / quadrantDim).
	 * 
	 * @param position The position on the board.
	 * @return The number of the quadrant.
	 */
	public static int getQuadrantNumber(int position, GameSettings settings) {
		int quadrantDim = settings.getQuadrantDimension();
		return ((getRowNumber(position, settings) / quadrantDim) * quadrantDim + 
				(getColumnNumber(position, settings) / quadrantDim));
	}
	
	/**
	 * Gets the contents of the row based on the position in the board.
	 * This is done by substracting the columnNumber from the position value,
	 * and adding values to an int-array until it has reached the length
	 * of the boardDimension. 
	 * 
	 * @param position The position to get the row from.
	 * @param board The board to get the row from.
	 * @return An int-array containing the row.
	 */
	public static int[] getRowFromPos(int position, Board board) {
		int boardDim = board.getSettings().getBoardDimensions();
		int[] rowResult = new int[boardDim];
		
		for(int rowPosition = position - getColumnNumber(position, board.getSettings()), 
				positionInArray = 0; positionInArray < boardDim; 
				rowPosition = rowPosition + 1, positionInArray = positionInArray + 1) {
			rowResult[positionInArray] = board.getValue(rowPosition);
		}
		return rowResult;
	}
	
	/**
	 * Gets the contents of the column based on the position in the board.
	 * This is done by first calculating the columnNumber, 
	 * adding the value this position contains to an array, 
	 * and then continuously adding boardDim to the columnNumber, 
	 * adding that value to the array until the array has boardDimension 
	 * values in it.
	 * 
	 * @param position The position to get the column from.
	 * @param board The board to get the column from.
	 * @return An int-array containing the column.
	 */
	public static int[] getColumnFromPos(int position, Board board) {
		int boardDim = board.getSettings().getBoardDimensions();
		int[] columnResult = new int[boardDim];
		int columnNum = getColumnNumber(position, board.getSettings());
		
		for(int positionInArray = 0; positionInArray < boardDim; 
				positionInArray = positionInArray + 1) {
			columnResult[positionInArray] = board.getValue(columnNum);
			columnNum = columnNum + boardDim;
		}
		return columnResult;
	}
	
	/**
	 * Gets the contents of the quadrant based on the position in the board.
	 * TODO: Elaborate on how this works (as there is no mathematic solution yet
	 * this is pending - it works though!).
	 * 
	 * @param position The position to get the quadrant from.
	 * @param board The board to get the cquadrant from.
	 * @return An int-array containing the quadrant.
	 */
	public static int[] getQuadrantFromPos(int position, Board board) {
		int boardDim = board.getSettings().getBoardDimensions();
		int quadrantNum = getQuadrantNumber(position, board.getSettings());
		int[] quadrantResult = new int[boardDim];
		
		// Temporary Solution (It's ugly, but it works for 3x3x9 boards):
		// O:-)
		
		switch(quadrantNum) {
			case 0:
				quadrantResult = new int[]
					{board.getValue(0),  board.getValue(1),  board.getValue(2), 
					 board.getValue(9),  board.getValue(10), board.getValue(11),
					 board.getValue(18), board.getValue(19), board.getValue(20)};
				break;
			case 1:
				quadrantResult = new int[]
					{board.getValue(3),  board.getValue(4),  board.getValue(5), 
					 board.getValue(12), board.getValue(13), board.getValue(14),
					 board.getValue(21), board.getValue(22), board.getValue(23)};
				break;
			case 2:
				quadrantResult = new int[]
					{board.getValue(6),  board.getValue(7),  board.getValue(8), 
					 board.getValue(15), board.getValue(16), board.getValue(17),
					 board.getValue(24), board.getValue(25), board.getValue(26)};
				break;
			case 3:
				quadrantResult = new int[]
					{board.getValue(27), board.getValue(28), board.getValue(29), 
					 board.getValue(36), board.getValue(37), board.getValue(38),
					 board.getValue(45), board.getValue(46), board.getValue(47)};
				break;
			case 4:
				quadrantResult = new int[]
					{board.getValue(30), board.getValue(31), board.getValue(32), 
					 board.getValue(39), board.getValue(40), board.getValue(41),
					 board.getValue(48), board.getValue(49), board.getValue(50)};
				break;
			case 5:
				quadrantResult = new int[]
					{board.getValue(33), board.getValue(34), board.getValue(35), 
					 board.getValue(42), board.getValue(43), board.getValue(44),
					 board.getValue(51), board.getValue(52), board.getValue(53)};
				break;
			case 6:
				quadrantResult = new int[]
					{board.getValue(54), board.getValue(55), board.getValue(56), 
					 board.getValue(63), board.getValue(64), board.getValue(65),
					 board.getValue(72), board.getValue(73), board.getValue(74)};
				break;
			case 7:
				quadrantResult = new int[]
					{board.getValue(57), board.getValue(58), board.getValue(59), 
					 board.getValue(66), board.getValue(67), board.getValue(68),
					 board.getValue(75), board.getValue(76), board.getValue(77)};
				break;
			case 8:
				quadrantResult = new int[]
					{board.getValue(60), board.getValue(61), board.getValue(62), 
					 board.getValue(69), board.getValue(70), board.getValue(71),
					 board.getValue(78), board.getValue(79), board.getValue(80)};
				break;
		}
		return quadrantResult;
	}
}