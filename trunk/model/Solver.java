/**
 * 
 */
package model;

/**
 * @author Klaes
 * Solver class used to solve a Sudoku-puzzle.
 */
public abstract class Solver {
       
	/**
	 * In calling the solver, first solverLevelOne is used, then if this is 
	 * unable to produce a unique result, call solverLevelTwo. 
	 * 
	 * @param fieldNum, the integer value the specific field has on the board
	 * @param board, the sudoku board used
	 * @return the result of trying to solve the field, 0 if not solveable.
	 */
	public static int solveField(int fieldNum, Board board) {
        /**
         * This will be changed, the values should come from classes which 
         * specify the difficulty settings of the generated sudoku.
         * 
         * allValues specifies all the possible values for the given field
         * possibleValues is used to store the values which are still, during
         * the solve operation, possible for the given fiels. And then in the 
         * end this can be called upon to check for a final set of values. 
         * Then, if this set consists of only one value, that value must be the
         * answer.
         */
        int[] allValues = {1,2,3,4,5,6,7,8,9};
        int[] possibleValues = allValues;
        
		int[] levelOneResult = solverLevelOne(fieldNum, possibleValues, board);
		
        /**
         * 	'result' is a unique solution of the field
         *  'count' is the number of final possible solutions for the 
         *  field.
         */
		int result = 0;
        int count = 0;
        
        /**
         * Save the last possible value for the field in 'result' while
         * counting the number of possible values.
         */
        for (int i = 0; i < levelOneResult.length; i++) {
                if (levelOneResult[i] > 0) {
                        result = possibleValues[i];
                        count++;
                }
        }
		
        /**
         * If there is only one possible solution using solverLevelOne,
         * return this, otherwise try to solve using solverLevelTwo and return
         * output form that.
         */
		if (count == 1) {
			return result;
		} else {
			return solverLevelTwo(fieldNum, board, levelOneResult);
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
		private static int[] solverLevelOne(int fieldNum, int[] possibleValues,
											Board board) {
    	   /**
    	    * Functions to keep the row, column and quadrant of the specific 
    	    * field in local memory.
    	    */
               int[] row = SudokuMath.getRowFromPos(fieldNum, board);
               int[] column = SudokuMath.getColumnFromPos(fieldNum, board);
               int[] quadrant = SudokuMath.getQuadrantFromPos(fieldNum, board);

               /**
                * Here we filter out the values which cannot be the result, 
                * subtract them from the possible values.
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
                * Return the set of possibleValues so they can be reused in
                * the next levels of solvers.
                */
               return possibleValues;
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
       private static int solverLevelTwo(int fieldNum, Board board, 
    		   							 int[] prevSolutions) {
    	   int fieldRowNum = SudokuMath.getRowNumber(fieldNum, 
				   board.getSettings());
    	   int fieldColumnNum = SudokuMath.getColumnNumber(fieldNum,
    			   board.getSettings());
    	   int fieldQuadrantNum = SudokuMath.getQuadrantNumber(fieldNum,
    			   board.getSettings());
    	   int quadDim = board.getSettings().getQuadrantDimension();
    	   int boardLength = board.getSettings().getBoardDimensions();
    	   
    	   int quadStartPos = ((fieldQuadrantNum % quadDim) * quadDim) + 
    	   					  (fieldRowNum / 3 * 3 * boardLength);
    	   
    	   int l = prevSolutions.length;
    	   
    	   for (int i = 0; i < l; i++) {
    		   if (fieldColumnNum != i) {
    			   int[] resultsRow = 
    				   solverLevelOne(fieldNum - fieldColumnNum + i,
    						   prevSolutions, board);  
    			   for (int j = 0; resultsRow[j] != 0; j++) {
    				   prevSolutions[resultsRow[j] - 1] = 0;
    			   }
    		   }
    		   if (fieldRowNum != i) {
    			   int[] resultsColumn =
    				   solverLevelOne(fieldColumnNum + (fieldRowNum * i), 
    						   prevSolutions, board);
    			   for (int j = 0; resultsColumn[j] != 0; j++) {
    				   prevSolutions[resultsColumn[j] - 1] = 0;
    			   }
    		   }
    		   if (fieldColumnNum != i && fieldRowNum != i) {
    			   int[] resultsQuadrant = 
    				   solverLevelOne(quadStartPos + 
    						   (i % quadDim) * (fieldRowNum % quadDim), 
    					   	   prevSolutions, board);
    			   for (int j = 0; resultsQuadrant[j] != 0; j++) {
    				   prevSolutions[resultsQuadrant[j] - 1] = 0;
    			   }
    		   }
    	   }
    	   return 0;
       }
}
