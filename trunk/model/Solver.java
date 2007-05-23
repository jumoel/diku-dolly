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
       public int solverLevelOne(int fieldNum, Board board) {
    	   /**
    	    * Functions to keep the row, column and quadrant of the specific field
    	    * in local memory.
    	    */
               int[] row = SudokuMath.getRowFromPos(fieldNum, board);
               int[] column = SudokuMath.getColumnFromPos(fieldNum, board);
               int[] quadrant = SudokuMath.getQuadrantFromPos(fieldNum, board);
               
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
               
               /**
                *  'count' is the number of final possible solutions for the field.
                *  'result' is the the solution to the field, this is only 0 if the field
                *  is already filled in.
                */
               int count = 0;
               int result = 0;

               /**
                * Here we filter out the values which cannot be the result, subtract
                * them from the possible values.
                * 
                * Cycle through the row, column and quadrant of the field.
                * Then for all of those fields, with numbers greater than 0,
                * remove that number from the array of possible values.
                */
               for (int i = 0, j = -1; i < possibleValues.length; i++) {
                       if ((j = row[i] - 1) > 0) 
                           possibleValues[j] = 0;
                       
                       if ((j = column[i] - 1) > 0) 
                           possibleValues[j] = 0;
                       
                       if ((j = quadrant[i] - 1) > 0) 
                           possibleValues[j] = 0;
               }
               
               /**
                * Save the last possible value for the field in 'result' while
                * counting the number of possible values.
                */
               for (int i = 0; i < 9; i++) {
                       if (possibleValues[i] > 0) {
                               result = possibleValues[i];
                               ++count;
                       }
               }
               
               /**
                * If there are more or less than one solution for the given field, 
                * report that the level 1 solver is unable to resolve the field by returning
                * a 0.
                * Otherwise, for a unique solution, give this solution back to the caller.
                */
               if (count != 1) {
                   return 0;
               } else {
            	   return result;
               }
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
       public int solverLevelTwo(int fieldNum, Board board) {
    	   
    	   return 0;
       }
}
