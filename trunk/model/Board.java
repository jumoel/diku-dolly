/**
 * 
 */
package model;

import java.util.Random;

/**
 * @author Julian
 *
 */
public class Board {
	private int[] board;
	private Random random;
	
	/**
	 * Creates a board with all fields filled in.
	 */
	public Board() {
		/*
		 * Creates a valid, shuffled board, which then gets shuffled.
		 */
		board = new int[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9,
				4, 5, 6, 7, 8, 9, 1, 2, 3,
				7, 8, 9, 1, 2, 3, 4, 5, 6,
				2, 3, 4, 5, 6, 7, 8, 9, 1,
				5, 6, 7, 8, 9, 1, 2, 3, 4,
				8, 9, 1, 2, 3, 4, 5, 6, 7,
				3, 4, 5, 6, 7, 8, 9, 1, 2,
				6, 7, 8, 9, 1, 2, 3, 4, 5,
				9, 1, 2, 3, 4, 5, 6, 7, 8
				};
		
		random = new Random();
		
		this.shuffle();
	}
	
	/**
	 * Sets a value b into board[] at position a
	 * @param a
	 * @param b
	 * @throws Exception
	 */
	public void setValue(int a, int b) {
		//TODO: kontroller Exception er lavet korrekt
		
		//if (a < 0 || a > (board.length-1)) 
			
			 board[a] = b;
		
	}
	
	/**
	 * Gets the value from board[] at position a
	 * @param a
	 * @return
	 * @throws Exception
	 */
	public int getValue(int a) {
		
		// TODO: kontroller Exception er lavet korrekt
		//if (a < 0 || a > (board.length-1)) 
			
			return board[a];
	}
	
	/**
	 * Shuffles rows, columns, quadrantcolums
	 * and quadrantrows of the board.
	 */
	public void shuffle() {
		/*
		 * To use when switch'ing.
		 * Currently we have four options to use
		 * when shuffling the board.
		 */
		final int numOfShuffleOptions = 4;
		final int shuffleColumns = 0;
		final int shuffleRows = 1;
		final int shuffleQuadrantColumns = 2;
		final int shuffleQuadrantRows = 3;

		/*
		 * Perform random shuffles a
		 * random number of times.
		 */
		int j = random.nextInt(100) + 100;
		for (int i = 0; i < j; i++) {
			int h = random.nextInt(numOfShuffleOptions);
			
			/*
			 * Generate two random numbers, defining the
			 * rows or columns to be swapped.
			 * 
			 * The adder defines which "large" row or column
			 * the rows/columns should be within.
			 * 
			 * Example (with a QuadrantDimension of 3):
			 * "first" gets the value 2, "second" the value 1.
			 * "adder" gets the initial value 1 which gets multiplied
			 * by 3.
			 * That implies that if the h-value gets the value 0
			 * and some columns needs to be shuffled, it will be the columns
			 * 4 and 5 - both contained in the middle "large" column.
			 */
			int dimension = GameSettings.getQuadrantDimension();
			int first = random.nextInt(dimension);
			int second = random.nextInt(dimension);
			int adder = random.nextInt(dimension) * 
						dimension;
			
			switch (h) {
			case shuffleColumns:
				this.switchColumns(first + adder, second + adder);
				break;
			case shuffleRows:
				this.switchRows(first + adder, second + adder);
				break;
			case shuffleQuadrantColumns:
				this.switchQuadrantColumns(first, second);
				break;
			case shuffleQuadrantRows:
				this.switchQuadrantRows(first, second);
				break;
			}
		}
	}
	
	/**
	 * Switches the two supplied columns in the board.
	 * @param first The first column to be switched.
	 * @param second The second column to be switched.
	 */
	public void switchColumns(int first, int second) {
		/*
		 * Don't perform the switch if it's the same columns.
		 */
		if (first != second) {
			first = (first < second) ? first : second;
			second = (first < second) ? second : first;
			
			// TODO: Tjek om kolonnerne er inden for samme "store" kolonne.
			// Dvs. tjek at de skal være mellem 1-3, 4-6 eller 7-9.
			
			int length = GameSettings.getBoardLength();
			int dimension = GameSettings.getBoardDimensions();
			
			for (int i = 0; i < length; i += dimension) {
				int temp = board[i + first];
				board[i + first] = board[i + second];
				board[i + second] = temp;
			}
		}
	}
	
	/**
	 * Switches the two supplied rows in the board.
	 * @param first The first row to be switched.
	 * @param second The second row to be switched.
	 */
	public void switchRows(int first, int second) {
		/*
		 * Don't perform the switch if it's the same columns.
		 */
		if (first != second) {
			// TODO: Tjek om rækkerne er inden for samme "store" række.
			// Dvs. tjek at de skal være mellem 1-3, 4-6 eller 7-9.
			
			int dimension = GameSettings.getBoardDimensions();
			
			/*
			 * Make sure that the first row is the one
			 * with the smallest number.
			 */
			first = (first < second) ? first : second;
			second = (first < second) ? second : first;
			
			// TODO: Forklar hvorfor det her virker
			for (int i = 0; i < dimension; i++) {
				int temp = board[dimension * first + i];
				board[dimension * first + i] = board[dimension * second + i];
				board[dimension * second + i] = temp;
			}
		}
	}
	
	/**
	 * Switches the two supplied quadrantcolumns in the board.
	 * @param first The first quadrantcolumn to be switched.
	 * @param second The second quadrantcolumn to be switched.
	 */
	public void switchQuadrantColumns(int first, int second)
	{
		/*
		 * Don't perform the switch if it's the same columns.
		 */
		if (first != second) {
			int width = GameSettings.getQuadrantDimension();
			
			int firstQC = first * width;
			int secondQC = second * width;
			
			for (int i = 0; i < width; i++) {
				switchColumns(firstQC + i, secondQC + i);
			}
		}
	}
	
	/**
	 * Switches the two supplied quadrantrows in the board.
	 * @param first The first quadrantrow to be switched.
	 * @param second The second quadrantrow to be switched.
	 */
	public void switchQuadrantRows(int first, int second)
	{
		/*
		 * Don't perform the switch if it's the same row.
		 */
		if (first != second) {
			int width = GameSettings.getQuadrantDimension();
			
			int firstQR = first * width;
			int secondQR = second * width;
			
			for (int i = 0; i < width; i++) {
				switchRows(firstQR + i, secondQR + i);
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < 81; i++) {
			System.out.print(Integer.toString(board[i]) + " ");
			if ((i+1) % 9 == 0)
				System.out.print("\n");
		}
	}
	
	public int[] toArray() {
		return this.board;
	}
}
