package controller;

import javax.swing.SwingUtilities;

/**
 * The main initiation point for the Application-version
 * of our game.
 */
public class SudokuGame {

	private static view.MainWindow main;
	private static model.Game game;
	public static void main(String[] args) {
		/*
		 * Starts a new thread to avoid problems
		 * with the user interface not getting updated.
		 */
		SwingUtilities.invokeLater(new Runnable()
		{
            public void run()
            {
            	/*
            	 * Create a new game
            	 */
            	game = new model.Game();
            	
            	/*
            	 * Create a new mainwindow and set it to use
            	 * the game we created above.
            	 */
            	main = new view.MainWindow();
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
            	
            	main.setMenu();
            	
            	main.setup();
            	
            	/*
            	 * Show the welcomescreen.
            	 */
            	DifficultyAction diffAction = new DifficultyAction(main, game, true);
            	diffAction.actionPerformed(null);
            }
		});
	}
}
