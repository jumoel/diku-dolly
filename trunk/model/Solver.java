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
        * Function to solve the next field in a Sudoku-puzzle.
        * checks for the already used values in its row,
        * column and quadrant, then returns 0 if there are 
        * several possibilities and the solution if this 
        * is singular.
        * 
        * @param fieldNum The position of the number to check.
        * @param board The board in which the field is located.
        * @return 0 if there are several possibilities,
        * 		  and the solution if it is singular...
        */
       public int fieldSolver(int fieldNum, Board board) {
               int[] row = SudokuMath.getRowFromPos(fieldNum, board);
               int[] column = SudokuMath.getColumnFromPos(fieldNum, board);
               int[] quadrant = SudokuMath.getQuadrantFromPos(fieldNum, board);
               
               int[] allValues = {1,2,3,4,5,6,7,8,9};
               int[] possibleValues = allValues;
               int j = -1;
               int count = 0;
               int result = 0;

               for (int i = 0; i < 9; i++) {
                       j = row[i] - 1;
                       if (j > 0) {
                           possibleValues[j] = 0;
                       }
                       
                       j = column[i] - 1;
                       if (j > 0) {
                           possibleValues[j] = 0;
                       }
                       
                       j = quadrant[i] -1;
                       if (j > 0) {
                           possibleValues[j] = 0;
                       }
               }
               for (int i = 0; i < 9; i++) {
                       if (possibleValues[i] > 0) {
                               result = possibleValues[i];
                               ++count;
                       }
               }
               if (count != 1) {
                   return 0;
               } else {
            	   return result;
               }
       }
}
