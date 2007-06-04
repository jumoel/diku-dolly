/**
 * 
 */
package controller;

import javax.swing.JApplet;

/**
 * @author Julian
 *
 */
public class SudokuApplet extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2727669396940884498L;
	
	private static view.MainApplet main;
	private static model.Game game;
	
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
    	DifficultyAction difficultyAction = new DifficultyAction(main, game);
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
    	
    	main.setMenu();
    	
    	main.setup();
    	
    	this.add(main);
    	
    	/*
    	 * Show the welcomescreen.
    	 */
    	difficultyAction.actionPerformed(null);
    }
}