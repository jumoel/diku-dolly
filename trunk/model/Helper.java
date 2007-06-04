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
 * Finds a field on the current board which is solveable and returns that 
 * field id. 
 * @param board The board from which the help is needed.
 * @param settings The game settings from which the board is created under.
 * @return fieldId A field that is solveable and suggested to the player.
 */

	public static int findSolveable(Board board, GameSettings settings) {
		
		int count = 0;
		
		/*
		 * creates a random to be used to select a random field.
		 */
		Random random = new Random();
		
		/*
		 * Selects a random field from 0 to board length.
		 */
		int fieldId = random.nextInt(settings.getBoardLength());	
		
		/*
		 * If the solver cannont solve the targeted field or the field
		 * is already removed it will move on and try the following field.
		 */
		while (Solver.solveField(fieldId, board) == 0 || 
				board.getValue(fieldId) != 0) {
			count = count + 1;
			if (count >= settings.getBoardLength())
				break;
			fieldId = (fieldId + 1) % settings.getBoardLength();
		}
		
		return fieldId;
	}
	public static int findSolveable(Game game) {
		return findSolveable(game.getCurrentBoard(), game.getCurrentBoard().getSettings());
	}
}
