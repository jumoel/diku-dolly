/**
 * 
 */
package model;

import java.util.Random;

/**
 * @author Steen
 *
 */
	
	/**
	 * Gets a helping text, and points out a field on the Board,
	 * which only has one solution.
	 * @return a text
	 */
	public void getHelp() {
	// Kald til funktion fra Solver som lokaliserer et løsbart felt.
	// Gem dette fieldNum i en variabel.
	int SolvedField = 0;
	// Send denne værdi videre til view.Board, så fieldet med værdien
	// fieldNum bliver farvet grønt.
	
	// String help1 = "";
	// String help2 = "";
	// String help3 = "";
	// String help4 = "";
	// String help5 = "";
	// String help6 = "";
	
	}
	
	
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
