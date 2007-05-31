/**
 * 
 */
package controller;

import javax.swing.SwingUtilities;

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
            	
            	DifficultyAction difficultyAction = new DifficultyAction(main, game);
            	HelpAction helpAction = new HelpAction(main, game);
            	
            	main.createIngameControls(main, difficultyAction, helpAction);
            	
            	view.Board board = main.createBoard(game);
            	
            	game.getCurrentBoard().addObserver(board);
            	
            	view.SheepSpeak speak = new view.SheepSpeak();
            	main.add(speak, 50, 360, 210);
            	
            	main.createBG();
            	
            	main.setup();
            }
		});
	}
}
