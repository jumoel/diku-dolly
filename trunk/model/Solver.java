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
		 * Find the given board dimensions for many uses.
		 */
		int boardDim = board.getSettings().getBoardDimensions();
		
        /**
         * possibleValues initialized to the set of valid values given by the
         * settings in board.
         * Then, later it is used to store the values which are still, during
         * the solve operation, possible for the given fiels. And then in the 
         * end this can be called upon to check for a final set of values. 
         * Then, if this set consists of only one value, that value must be the
         * answer.
         */
		int[] levelOneResult = solverLevelOne(fieldNum, 
				board.getSettings().getValidValues(), board);
		
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
        for (int i = 0; i < boardDim; i++) { 
        	//System.out.println("jeg kom næsten ind" + i);
        	if (levelOneResult[i] > 0) {
        		System.out.println("jeg kom ind");
                        result = levelOneResult[i];
                        count = count + 1;
                }
        }
        
        //System.out.println("count = " + count);
		
        /**
         * If there is only one possible solution using solverLevelOne,
         * return this, otherwise try to solve using solverLevelTwo and return
         * output form that in same manner.
         */
		if (count == 1) {
			System.out.println("result = "+result);
			return result;
		} else return 0;/*{ 
			int[] levelTwoResult = 
				solverLevelTwo(fieldNum, board, levelOneResult);
			
			/**
	         * Reset count, then save the last possible value for the field in
	         * 'result' while counting the number of possible values.
	         */
		/*	count = 0;
	        for (int i = 0; i < boardDim; i++) {
	                if (levelTwoResult[i] > 0) {
	                        result = possibleValues[i];
	                        count++;
	                }
	        }
			if (count == 1) {
				return result;
			} else return 0;
		}*/
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
		 * @return an array of solutions for further calculation.
		 */
		private static int[] solverLevelOne(int fieldNum, int[] possibleVals,
											Board board) {
			/**
			 * Find the given board dimensions for many uses.
			 */
			int boardDim = board.getSettings().getBoardDimensions();
			
			/**
			 * Functions to keep the row, column and quadrant of the specific 
			 * field in local memory. This is including their individual array 
			 * of values.
			 */
			int[] row = SudokuMath.getRowFromPos(fieldNum, board);
			int[] column = SudokuMath.getColumnFromPos(fieldNum, board);
			int[] quadrant = SudokuMath.getQuadrantFromPos(fieldNum, board);
			
			int[] values = new int[boardDim];
			for (int iter = 0; iter < boardDim; iter = iter + 1) {
				values[iter] = possibleVals[iter];
			}
			/*for (int i = 0; i< quadrant.length; i++) {
			System.out.print(row[i] + ", ");
			}
			System.out.println();
			for (int i = 0; i< quadrant.length; i++) {
				System.out.print(column[i] + ", ");
				}
			System.out.println();
			for (int i = 0; i< quadrant.length; i++) {
				System.out.print(quadrant[i] + ", ");
				}
			System.out.print("\n" + quadrant.length + "\n");
			if (true) {
			throw new Error("lololol");
			}
			/**
			 * Here we filter out the values which cannot be the result, 
			 * subtract them from the possible values.
			 * 
			 * Cycle through the row, column and quadrant of the field.
			 * Then for all of those fields, with numbers greater than 0,
			 * remove that number from the array of possible values.
			 */
			for (int i = 0, j = -1; i < boardDim; i++) {
				if ((j = row[i]) > 0) {
					values[j - 1] = 0;
				}
				
				if ((j = column[i]) > 0) { 
					values[j - 1] = 0;
				}
                       
				if ((j = quadrant[i]) > 0) {
					values[j - 1] = 0;
				}
			}
			/**
			 * Return the set of possibleValues so they can be reused in
			 * the next levels of solvers.
			 */
			return values;
		}

       /**
        * Check for fields in rows, columns and quadrant of the field,
        * which have value of 0 stored in them.
        * Find all possible solutions for these fields using solverLevelOne, 
        * then subtract their individual possibleSolutions from the 
        * possibleSolutions of the field to solve.
        * If this gives the field a unique solution, return the solution, 
        * otherwise return 0. The field cannot be solved using solverLevelTwo.
        * 
        * @param fieldNum, the field number to solve.
        * @param board, the specific sudoku board.
        * @param prevSolutions, an array of the previous solutions from
        * solverLevelOne.
        * @return an array of solutions, this can either be seperated to give
        * a single solution or to move on with a level three solver.
        */	
       private static int[] solverLevelTwo(int fieldNum, Board board, 
    		   							 int[] prevSolutions) {
    	   /**
    	    * Find the given board dimensions for many uses.
    	    */
    	   int boardDim = board.getSettings().getBoardDimensions();
    	   
    	   /**
    	    * fieldRowNum, fieldColumnNum, fieldQuadrantNum are merely
    	    * preliminaries to make solverLevelTwo. They set the outline for
    	    * the field to be solved.
    	    */
    	   int fieldRowNum = SudokuMath.getRowNumber(fieldNum, 
				   board.getSettings());
    	   int fieldColumnNum = SudokuMath.getColumnNumber(fieldNum,
    			   board.getSettings());
    	   int fieldQuadrantNum = SudokuMath.getQuadrantNumber(fieldNum,
    			   board.getSettings());
    	   
    	   /**
    	    * quadDim denotes the quadrant dimensions, and thereby, for square
    	    * boards, also the number of quadrants in a row/column.
    	    */
    	   int quadDim = board.getSettings().getQuadrantDimension();
    	   
    	   /**
    	    * quadStartPos is the field number for the first field in the 
    	    * quadrant of the field to be solved.
    	    * 
    	    * This works by taking the quadrant number of the field, taking
    	    * modulus of this, with the number of quadrants gives makes it
    	    * symbolise only the first row of quadrants. Then, multiply by
    	    * number of fields in a quadrant and it gives the fieldNum of the
    	    * first field in the equivalent quadrant of the first quadrant row.
    	    * Now, since this is in row 0, find which row the first field of 
    	    * the quadrant we want is. So, truncate the row number to be
    	    * multiples of the quadDim. Then multiply with boardLength and
    	    * add this to the fieldNum of the first row.
    	    * 
    	    * @example field number is 70, this is the last quadrant, quadrant
    	    * 8. Lets assume a 9x9 board, which makes quadDim = 3. 
    	    * fieldRowNumber is 7 and boardLength is 9.
    	    * ((8 % 3) * 3) + (7 / 3 * 3 * 9) = 60.
    	    * 8 % 3 = 2.
    	    * 2 * 3 = 6.
    	    * 7 / 3 = 2.
    	    * 2 * 3 = 6.
    	    * 6 * 9 = 54.
    	    * 6 + 54 = 60.
    	    */
    	   int quadStartPos = ((fieldQuadrantNum % quadDim) * quadDim) + 
    	   					  (fieldRowNum / quadDim * quadDim * boardDim);
    	   
    	   /**
    	    * 
    	    */
    	   for (int i = 0; i < boardDim; i++) {
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
    	   return prevSolutions;
       }
}
