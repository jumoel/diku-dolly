/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.Dimension;

import controller.DifficultyAction;
import controller.HelpAction;

/**
 * @author Julian
 *
 */
public interface MainInterface {
	public void setMenu();
	
	public void createHeader();
	
	public IngameControls getControls();

	/**
	 * Create the SheepSpeak-object.
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
	 * Gets the background.
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
	
	public void setGlassPane(Component glassPane);
}
