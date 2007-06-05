/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Julian
 *
 */
public class SudokuMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2863544055026997282L;
	
	private MainInterface mainWindow;
	private JMenu menuGame, menuHelp;
	private JMenuItem itemNewGame, itemExit, itemRules, itemHint;
	private model.Game game;
	
	public SudokuMenu(MainInterface main) {
		this.mainWindow = main;
		this.game = main.getGame();
		
		menuGame = new JMenu("Spil");
		menuHelp = new JMenu("Hjælp");
		
		itemNewGame = new JMenuItem("Nyt spil");
			itemNewGame.addActionListener(new controller.DifficultyAction(this.mainWindow, game));
		
		/*
		 * Only create the "exit" menuitem if the game is
		 * run as an application and not as an applet.
		 */
		if (main instanceof MainWindow) {
			itemExit = new JMenuItem("Afslut spil");
			itemExit.addActionListener(new controller.CloseListener());
		}

		itemRules = new JMenuItem("Vis Sudoku-reglerne");
		itemHint = new JMenuItem("Få vist hint til løsning");
			itemHint.addActionListener(new controller.HelpAction(this.mainWindow, game));
		
		menuGame.add(itemNewGame);
		
		/*
		 * Obviously only add the menuitem
		 * if it's been created.
		 */
		if (main instanceof MainWindow) {
			menuGame.add(itemExit);
		}
		
		menuHelp.add(itemRules);
		menuHelp.add(itemHint);
		
		this.add(menuGame);
		this.add(menuHelp);
		
		this.setSize(0, 25);
		this.setPreferredSize(this.getSize());
		
		this.setVisible(true);
	}
}
