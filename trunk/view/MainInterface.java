/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.Dimension;

import controller.DifficultyAction;
import controller.HelpAction;

/**
 * Interface for the two different kinds of windows our
 * program containts.
 */
public interface MainInterface {
	/**
	 * Creates and adds the menu to the frame.
	 */
	public void setMenu();
	
	/**
	 * Creates and adds the header to the frame.
	 */
	public void createHeader();
	
	/**
	 * Gets the IngameControls contained in the frame.
	 * @return The IngameControls
	 */
	public IngameControls getControls();

	/**
	 * Creates and adds the SheepSpeak-object.
	 */
	public void createSheepSpeak();
	
	/**
	 * Gets the current SheepSpeak - the
	 * box in which the wise words of the sheep
	 * are.
	 * @return The SheepSpeak-object.
	 */
	public SheepSpeak getSheepSpeak();
	
	/**
	 * Gets the background contained in the frame.
	 * @return The background.
	 */
	public Background getBackgroundPanel();

	/**
	 * Creates a new background with the supplied image.
	 * @param backgroundImage The image to use as a background.
	 */
	public void createBackgroundPanel(String backgroundImage);

	/**
	 * Gets the graphical representation of the board.
	 * @return The board.
	 */
	public Board getBoard();

	/**
	 * Creates a new board.
	 * setGame() must have been called before.
	 */
	public void createBoard();

	/**
	 * Gets the current instance of the game used.
	 * @return The game.
	 */
	public model.Game getGame();

	/**
	 * Sets the current game instance.
	 * Must be called before createBoard().
	 * @param game The game to set.
	 */
	public void setGame(model.Game game);

	/**
	 * Gets the current dimensions of the board.
	 * @return The dimensions of the board.
	 */
	public Dimension getBoardDimension();
	
	/**
	 * Adds a component to the window.
	 * @param component The component to add.
	 * @param zindex The Z-Index of the position.
	 * @param x The X-coordinate.
	 * @param y The Y-coordinate.
	 * @return The added component.
	 */
	public Component add(Component component, int zindex, int x, int y);

	/**
	 * Creates the ingamecontrols.
	 * @param difficultyAction The action to perform when the "New game" button is pressed.
	 * @param helpAction The action to perform when the "Help" button is pressed.
	 */
	public void createIngameControls(DifficultyAction difficultyAction, HelpAction helpAction);

	/**
	 * Performs some standard operations on the window.
	 */
	public void setup();
	
	/**
	 * Set the glasspane of the frame to the specified glasspane.
	 * @param glassPane The glassPane to set as glasspane.
	 */
	public void setGlassPane(Component glassPane);
}
