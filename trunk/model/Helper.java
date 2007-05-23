/**
 * 
 */
package model;

import java.util.Random;

/**
 * @author Steen
 *
 */	
	
public abstract class Helper {

/**
 * 
 * @param board 
 * @param settings
 * @return fieldId
 */

	public int findSolveable(Board board, GameSettings settings) {
		
		Random random = new Random();
		
		int fieldId = random.nextInt(settings.getBoardLength());	
		
		while (Solver.solveField(fieldId, board) == 0 || 
				board.getValue(fieldId) != 0) {
			fieldId = (fieldId + 1) % settings.getBoardLength();
		}
		
		return fieldId;
	}
}
