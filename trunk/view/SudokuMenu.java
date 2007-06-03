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
	
	private MainWindow main;
	
	public SudokuMenu(MainWindow main) {
		this.main = main;
		
		JMenu menuGame = new JMenu("Spil");
		JMenu menuHelp = new JMenu("Hjælp");
		
		JMenuItem itemNewGame = new JMenuItem("Nyt spil");
			itemNewGame.addActionListener(new controller.DifficultyAction(main, main.getGame()));
		JMenuItem itemExit = new JMenuItem("Afslut spil");
		
		JMenuItem itemRules = new JMenuItem("Vis Sudoku-reglerne");
		JMenuItem itemHint = new JMenuItem("Få vist hint til løsning");
			itemHint.addActionListener(new controller.HelpAction(main, main.getGame()));
		
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
