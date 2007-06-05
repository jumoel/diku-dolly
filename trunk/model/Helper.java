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
	 * @return A fieldId that is solveable and suggested to the player.
	 * @throws NoSuchFieldException 
	 */
	public static int findSolveable(Board board, GameSettings settings) throws NoSuchFieldException {
		
		int count = 0;
		
		/*
		 * Creates a random to be used to select a random field.
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
			if (count >= settings.getBoardLength()) {
				throw new NoSuchFieldException("Der er ingen felter der kan løses.");
			}
				
			fieldId = (fieldId + 1) % settings.getBoardLength();
		}
		
		return fieldId;
	}
	
	/**
	 * Finds a field on the current board which is solveable and returns that 
	 * fieldId.
	 * Calls findSolveable(game.getCurrentBoard(), game.getCurrentBoard().getSettings()); 
	 * 
	 * @param game The current game.
	 * @return A fieldId that is solveable and suggested to the player.
	 * @throws NoSuchFieldException 
	 */
	public static int findSolveable(Game game) throws NoSuchFieldException {
		return findSolveable(game.getCurrentBoard(), game.getCurrentBoard().getSettings());
	}
	
	/**
	 * This function scans the board for mistakes and returns how many
	 * mistakes there currently is.
	 * 
	 * @param game The current game that's being played.
	 * @return The number of mistakes currently on the board.
	 */
	public static int getAmountOfMistakes(Game game) {
		Board currentBoard = game.getCurrentBoard();
		Board solutionBoard = game.getSolutionBoard();
		int numberOfMistakes = 0;
		
		for (int fieldId = 0;
			 fieldId < currentBoard.getSettings().getBoardLength(); 
			 fieldId = fieldId + 1) {
				if (currentBoard.getValue(fieldId) != solutionBoard.getValue(fieldId) &&
					currentBoard.getValue(fieldId) != 0) {
						numberOfMistakes = numberOfMistakes + 1;
				}
		}
		return numberOfMistakes;
	}
	
	/**
	 * Gets an int-array with the fieldIds containing mistakes. 
	 * 
	 * @param game The current game.
	 * @param amountOfMistakes Used to the size of the result array.
	 * @return An int[] containing the fieldIds with mistakes.
	 */
	public static int[] getFieldsWithMistakes(Game game, int amountOfMistakes) {
		Board currentBoard = game.getCurrentBoard();
		Board solutionBoard = game.getSolutionBoard();
		int[] fieldsWithMistakes = new int[amountOfMistakes];
		
		for (int fieldId = 0, iter = 0; 
			 fieldId < currentBoard.getSettings().getBoardLength();
			 fieldId = fieldId + 1) {
				if (currentBoard.getValue(fieldId) != solutionBoard.getValue(fieldId) &&
					currentBoard.getValue(fieldId) != 0) {
						fieldsWithMistakes[iter] = fieldId;
						iter = iter + 1;
				}
		}
		return fieldsWithMistakes;
	}
	
	/**
	 * Gets an int-array with the fieldIds containing mistakes. 
	 * Calls getFieldsWithMistakes (game, getAmountOfMistakes(game));
	 * 
	 * @param game The current game.
	 * @return An int[] containing the fieldIds with mistakes.
	 */
	public static int[] getFieldsWithMistakes(Game game) {
		return getFieldsWithMistakes(game, getAmountOfMistakes(game));
	}
}