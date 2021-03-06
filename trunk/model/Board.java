/**
 * 
 */
package model;

import java.util.Observable;
import java.util.Random;

/**
 * Board.java is able to generate sudoku boards, get values from  
 * fields and set values in fields.
 * It can compare two boards to check if the sudoku is solved.
 */
public class Board extends Observable {
	private int[] board;
	private Random random;
	private GameSettings settings;
	
	/**
	 * Creates a board with all fields filled in.
	 */
	public Board() {
		this(new NormalSettings());
	}
	public Board(GameSettings settings) {
		this.settings = settings;
		random = new Random();
		this.board = settings.getStdBoardArray();
		this.shuffle();
	}
	public Board(Board board) {
		this.settings = board.getSettings();
		random = new Random();
		this.board = board.toArray();
		this.shuffle();
	}
	public Board(int[] boardArray) {
		this(boardArray, new NormalSettings());
	}
	public Board(int[] boardArray, GameSettings settings) {
		this.settings = settings;
		random = new Random();
		this.board = boardArray;
	}
	
	/**
	 * Sets a value b into board[] at position a
	 * @param fieldId The fieldnumber whose value is to be set
	 * @param value The value to set
	 * @throws IllegalArgumentException
	 */
	public void setValue(int fieldId, int value) throws IllegalArgumentException {
		if (fieldId < 0 || fieldId >= settings.getBoardLength()) {
			throw new IllegalArgumentException(
					"fieldId is not in range of the boardlength."
					);
		}
		
		board[fieldId] = value;
	}
	
	/**
	 * Gets the value from board[] at position a
	 * @param fieldId
	 * @return The value at the fieldId-position.
	 * @throws IllegalArgumentException
	 */
	public int getValue(int fieldId) throws IllegalArgumentException {
		if (fieldId < 0 || fieldId >= settings.getBoardLength()) {
			throw new IllegalArgumentException(
					"fieldId is not in range of the boardlength."
					);
		}
		
		return board[fieldId];
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
			
			int dimension = settings.getQuadrantDimensions();
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
			int numberBackup = first;
			first = (first < second) ? first : second ;
			second = (first < second) ? second : numberBackup;
			
			int length = settings.getBoardLength();
			int dimension = settings.getBoardDimensions();
			
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
			int dimension = settings.getBoardDimensions();
			
			/*
			 * Make sure that the first row is the one
			 * with the smallest number.
			 */
			first = (first < second) ? first : second;
			second = (first < second) ? second : first;

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
			int width = settings.getQuadrantDimensions();
			
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
			int width = settings.getQuadrantDimensions();
			
			int firstQR = first * width;
			int secondQR = second * width;
			
			for (int i = 0; i < width; i++) {
				switchRows(firstQR + i, secondQR + i);
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < settings.getBoardLength(); i++) {
			if (i == 0) {
				System.out.print(" ");
			}
			if (i % (3 * 9) == 0 && i != 0) {
				System.out.print("\n");
				for (int j = 0; j < 3; j++) {
					for (int h = 0; h < 3; h++) {
						System.out.print("--");
					}
					if (j != 2) {
						System.out.print("-+");
					} else {
						System.out.print(" ");
					}
				}
			}
			if (i % 3 == 0 && i != 0 && i % 9 != 0) {
				System.out.print("| ");
			}
			if(i % 9 == 0 && i != 0) {
				System.out.print("\n ");
			}
			if (this.getValue(i) == 0) {
				System.out.print(".");
			} else {
				System.out.print(this.getValue(i));
			}
			System.out.print(" ");
			
		}
	}
	
	public int[] toArray() {
		return this.board;
	}

	/**
	 * @return the settings
	 */
	public GameSettings getSettings() {
		return settings;
	}
	/**
	 * Compares current board to supplied board to determine if the 
	 * sudoku is correctly solved.
	 * @param compareBoard The board to compare to.
	 * @return True or false depending on whether or not the boards are equal. 
	 */
	public boolean isEqualTo(Board compareBoard) {
		int count = 0;
		int[] compare = compareBoard.toArray();
		if (this.board.length != compare.length) {
			return false;
		}
		for (int i = 0; i < this.board.length; i = i + 1) {
			if (this.board[i] != compare[i]) {
				return false;
			} else { count++; }
		}
		return true;
	}
	
	public void reset(GameSettings settings, Game game) {
		if (settings == null) {
			settings = new NormalSettings();
		}
		this.settings = settings;
		
		this.board = settings.getStdBoardArray();
		this.shuffle();
		
		int solution[] = new int[settings.getBoardLength()];
		System.arraycopy(board, 0, solution, 0, settings.getBoardLength());
		
		game.setSolutionBoard(new Board(solution, settings));
		
		Generator.generate(this);
		
		this.setChanged();
		this.notifyObservers();
	}
}
