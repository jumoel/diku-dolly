package model;

import java.util.Calendar;

/**
 * The statistics of the current game.
 * 
 * Keeps track of the amount of Hints and Mistakes made.
 *
 * @author emil
 */
public class Statistics {
	
	private int hints;
	private int mistakes;
	private Calendar startTime;
	private Calendar stopTime;
	
	/**
	 * Creates a new statistics type for the game.
	 * The amount of hints used and mistakes made from start is, naturally, 0.
	 */
	public Statistics() {
		this.hints = 0;
		this.mistakes = 0;
		startTime = Calendar.getInstance();
		stopTime = null;
	}
	
	public String getElapsedTime() {
		if (stopTime != null) {
			int startSeconds =
				(startTime.get(Calendar.HOUR) * 60 + startTime.get(Calendar.MINUTE)) * 60 + 
				startTime.get(Calendar.SECOND);
			
			int stopSeconds =
				(stopTime.get(Calendar.HOUR) * 60 + stopTime.get(Calendar.MINUTE)) * 60 + 
				stopTime.get(Calendar.SECOND);
			
			int elapsedSeconds = stopSeconds - startSeconds;
			int seconds = elapsedSeconds % 60;
			int minutes = (elapsedSeconds / 60) % 60;
			int hours = (elapsedSeconds / 60) / 60;
			
			String elapsed = "";
			
			elapsed += (hours < 10) ? "0" : "";
			elapsed += Integer.toString(hours);
			elapsed += ":";
			
			elapsed += (minutes < 10) ? "0" : "";
			elapsed += Integer.toString(minutes);
			elapsed += ":";
			
			elapsed += (seconds < 10) ? "0" : "";
			elapsed += Integer.toString(seconds);
			
			return elapsed;
		} else {
			System.err.println("ERROR: stopTime not set yet.");
			return null;
		}
	}
	
	/**
	 * Sets the time at which the Sudoku was solved.
	 * @author Julian
	 */
	public void setStopTime() {
		this.stopTime = Calendar.getInstance();
	}
	
	/**
	 * Increases the amount of hints used by 1.
	 */
	public void increaseHints() {
		hints = hints + 1;
	}

	/**
	 * Returns the amount of hints used.
	 * 
	 * @return The amount of hints.
	 */
	public int getHints() {
		return hints;
	}
	
	/**
	 * Increases the amount of mistakes used by 1.
	 */
	public void increaseMistakes() {
		mistakes = mistakes + 1;
	}
	
	/**
	 * Returns the amount of mistakes used.
	 * 
	 * @return The amount of mistakes
	 */
	public int getMistakes() {
		return mistakes;
	}
}