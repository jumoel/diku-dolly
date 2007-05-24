/**
 * 
 */
package controller;

import javax.swing.SwingUtilities;

import view.IngameControls;

/**
 * @author Julian
 *
 */
public class SudokuGame {

	/**
	 * @param args
	 */
	private static view.MainWindow main;
	private static model.Game game;
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable()
		{
            public void run()
            {
            	game = new model.Game();
            	
            	main = new view.MainWindow();
            	view.Board board = main.createBoard(game);
            	
            	game.getCurrentBoard().addObserver(board);
            	
            	main.setup();
            	
            	DifficultyAction difficultyAction = new DifficultyAction(main, game);
            	HelpAction helpAction = new HelpAction(main, game);
            	IngameControls ingameControls =
            		new IngameControls("EN eller anden Titel?", main, difficultyAction, helpAction);
            	
            	main.add(ingameControls);
            	
            	main.pack();
            }
		});
	}
}
