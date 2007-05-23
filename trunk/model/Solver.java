/**
 * NOTE: seperate the solvers into different classes and use the abstraction level
 * to make more reuse of code.
 */
package model;

/**
 * @author Klaes
 * Solver class used to solve a Sudoku-puzzle.
 */
public abstract class Solver {
       
	/**
	 * In calling the solver, first solverLevelOne is used, then if this is unable
	 * to produce a unique result, call solverLevelTwo. 
	 * 
	 * @param fieldNum
	 * @param board
	 * @return
	 */
	public static int solveField(int fieldNum, Board board) {
        /**
         * This will be changed, the values should come from classes which 
         * specify the difficulty settings of the generated sudoku.
         * 
         * allValues specifies all the possible values for the given field
         * possibleValues is used to store the values which are still, during
         * the solve operation, possible for the given fiels. And then in the end
         * this can be called upon to check for a final set of values. Then, 
         * if this set consists of only one value, that value must be the answer.
         */
        int[] allValues = {1,2,3,4,5,6,7,8,9};
        int[] possibleValues = allValues;
        
		int[] levelOneResult = solverLevelOne(fieldNum, possibleValues, board);
		if (levelOneResult[0] != 0 && levelOneResult[1] == 0) {
			return levelOneResult[0];
		} else {
			return solverLevelTwo(fieldNum, board, possibleValues);
		}
	}
	
		/**
		 * Function to solve the next field in a Sudoku-puzzle.
		 * checks for the already used values in its row,
		 * column and quadrant, then returns 0 if there are 
		 * several possibilities and the solution if this 
		 * is singular.
		 * 
		 * @param fieldNum The position of the number to check.
		 * @param board The board in which the field is located.
		 * @return 0 if there are several possibilities,
		 * 		  and the solution if it is singular.
		 */
		private static int[] solverLevelOne(int fieldNum, int[] possibleValues, Board board) {
    	   /**
    	    * Functions to keep the row, column and quadrant of the specific field
    	    * in local memory.
    	    */
               int[] row = SudokuMath.getRowFromPos(fieldNum, board);
               int[] column = SudokuMath.getColumnFromPos(fieldNum, board);
               int[] quadrant = SudokuMath.getQuadrantFromPos(fieldNum, board);
               
               /**
                *  'count' is the number of final possible solutions for the field.
                *  'result' is the the solution to the field, this is only 0 if the field
                *  is already filled in.
                */
               int count = 0;
               int[] result = new int[possibleValues.length];

               /**
                * Here we filter out the values which cannot be the result, subtract
                * them from the possible values.
                * 
                * Cycle through the row, column and quadrant of the field.
                * Then for all of those fields, with numbers greater than 0,
                * remove that number from the array of possible values.
                */
               for (int i = 0, j = -1; i < possibleValues.length; i++) {
                       if ((j = row[i] - 1) > 0) {
                           possibleValues[j] = 0;
                       }
                       
                       if ((j = column[i] - 1) > 0) { 
                           possibleValues[j] = 0;
                       }
                       
                       if ((j = quadrant[i] - 1) > 0) {
                           possibleValues[j] = 0;
                       }
               }
               
               /**
                * Save the last possible value for the field in 'result' while
                * counting the number of possible values.
                */
               for (int i = 0; i < possibleValues.length; i++) {
                       if (possibleValues[i] > 0) {
                               result[count] = possibleValues[i];
                               count++;
                       }
               }
               return result;
       }

       /**
        * Check for fields in rows, columns and quadrant which have value of 0
        * stored in them.
        * Find all possible solutions for these fields using solverLevelOne, 
        * then subtract their individual possibleSolutions from the 
        * possibleSolutions of the field to solve.
        * If this gives the field a unique solution, return the solution, 
        * otherwise return 0. The field cannot be solved using solverLevelTwo.
        * 
        * @param fieldNum
        * @param board
        * @return
        */
       private static int solverLevelTwo(int fieldNum, Board board, int[] previousPossibilities) {
    	   for (int i = 0; i < previousPossibilities.length; i++) {
    		   
    	   }
    	   return 0;
       }
}
