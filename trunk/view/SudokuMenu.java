/**
 * 
 */
package view;

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
		
		menuGame = new JMenu("Spil");
		menuHelp = new JMenu("Hjælp");
		
		itemNewGame = new JMenuItem("Nyt spil");
			itemNewGame.addActionListener(new controller.DifficultyAction(this.mainWindow, game));
		itemExit = new JMenuItem("Afslut spil");
		
		itemRules = new JMenuItem("Vis Sudoku-reglerne");
		itemHint = new JMenuItem("Få vist hint til løsning");
			itemHint.addActionListener(new controller.HelpAction(this.mainWindow, game));
		
		menuGame.add(itemNewGame);
		menuGame.add(itemExit);
		
		menuHelp.add(itemRules);
		menuHelp.add(itemHint);
		
		this.add(menuGame);
		this.add(menuHelp);
		
		this.setSize(0, 25);
		this.setPreferredSize(this.getSize());
		
		this.setVisible(true);
	}
}
