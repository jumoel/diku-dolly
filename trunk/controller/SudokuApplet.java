package controller;

import javax.swing.JApplet;

/**
 * The main initiation point for the Applet-version
 * of our game.
 */
public class SudokuApplet extends JApplet {
	/**
	 * Classes that implement <code>Serializable</code> needs this.
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 2727669396940884498L;
	
	private static view.MainApplet main;
	private static model.Game game;
	
	/**
	 * Gets run when the applet gets loaded into the browser.
	 */
	public void init() {
		/*
    	 * Create a new game
    	 */
    	game = new model.Game();
    	
    	/*
    	 * Create a new mainwindow and set it to use
    	 * the game we created above.
    	 */
    	main = new view.MainApplet();
    	main.setGame(game);
    	
    	/*
    	 * Create the actions for the controlbuttons...
    	 */
    	DifficultyAction difficultyAction = new DifficultyAction(main, game, false);
    	HelpAction helpAction = new HelpAction(main, game);
    	
    	/*
    	 * ... and then create and add the buttons themselves.
    	 */
    	main.createIngameControls(difficultyAction, helpAction);
    	
    	/*
    	 * Create and add the gameboard. It is essential that
    	 * setGame() has been called before this gets called!
    	 */
    	main.createBoard();
    	
    	/*
    	 * Add an observer to the board.
    	 */
    	game.getCurrentBoard().addObserver(main.getBoard());
    	
    	/*
    	 * Create and add the "SheepSpeak", which will be used
    	 * for helping etc.
    	 */
    	main.createSheepSpeak();
    	
    	/*
    	 * Create and add the header.
    	 */
    	main.createHeader();
    	
    	/*
    	 * Create and add the backgroundimage. 
    	 */
    	main.createBackgroundPanel("stdSudokuBG.png");
    	
    	/*
    	 * Create and set the menu
    	 */
    	main.setMenu();
    	
    	/*
    	 * Lay out the subcomponents correctly
    	 * and show them.
    	 */
    	main.setup();
    	
    	this.add(main);
    	
    	/*
    	 * Show the welcomescreen.
    	 */
    	DifficultyAction diffAction = new DifficultyAction(main, game, true);
    	diffAction.actionPerformed(null);
    }
}