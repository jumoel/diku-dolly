/**
 * 
 */
package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
		
		/*
		 * Adds a new DifficultyAction as the ActionListener to
		 * the menuitem. Shows the difficultyselection screen.
		 */
		itemNewGame = new JMenuItem("Nyt spil");
			itemNewGame.addActionListener(new controller.DifficultyAction(this.mainWindow, game, false));
		
		/*
		 * Only create the "exit" menuitem if the game is
		 * run as an application and not as an applet.
		 */
		if (main instanceof MainWindow) {
			itemExit = new JMenuItem("Afslut spil");
			itemExit.addActionListener(new controller.CloseListener());
		}

		itemRules = new JMenuItem("Vis Sudoku-reglerne");
			/*
			 * Create an actionlistener that displays a
			 * dialog.
			 * 
			 * The dialog shows an URL to a full walkthrough
			 * of the Sudokurules and a button, which copies the
			 * address to the clipboard.
			 * 
			 * This is done to save us from having to write a
			 * text explaining the rules ourselves.
			 */
			itemRules.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					/*
					 * Creates the dialog and sets the layoutmanager.
					 */
					JDialog dialog = new JDialog();
					dialog.setModal(false);
					Container container = dialog.getContentPane();
					container.setLayout(new GridLayout(2, 1, 5, 5));
					
					/*
					 * The URL of the Sudokurules.
					 */
					final String URL = "http://www.sudokumester.dk/?ID=guide";
					
					/*
					 * Creates a label which explains where the rules can be found.
					 */
					JLabel desc = new JLabel();
					desc.setText("<html>" +
							"De fulde Sudokuregler kan findes på " +
							"<a href=\"" + URL + "\">" + URL + "</a>");
					
					/*
					 * The button, capable of copying to the clipboard.
					 */
					JButton copyToClipboard = new JButton("Kopier adresse");
					copyToClipboard.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							/*
							 * Creates a StringSelection which is then copied to
							 * the clipboard.
							 */
							StringSelection stringSelection = new StringSelection(URL);
						    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						    clipboard.setContents(stringSelection, new ClipboardOwner() {
						    	/*
						    	 * Empty implementation of ClipboardOwner, as the
						    	 * functionality isn't needed.
						    	 */
								public void lostOwnership(Clipboard arg0, Transferable arg1) {
									/* 
									 * Do nothing.
									 */
								}
						    });
						}
					});
					
					/*
					 * Add the elements to the container.
					 */
					container.add(desc);
					container.add(copyToClipboard);
					
					/*
					 * Set the size of the dialog and show it.
					 */
					dialog.pack();
					dialog.setVisible(true);
				}
			});
		
		/*
		 * Adds a new HelpAction as the ActionCommand to the menuitem.
		 * Shows the same help as the button located next to the board.
		 */
		itemHint = new JMenuItem("Få vist hint til løsning");
			itemHint.addActionListener(new controller.HelpAction(this.mainWindow, game));
		
		/*
		 * Add the menuitems to the menus
		 */
				menuGame.add(itemNewGame);
		
				/*
				 * Obviously only add the menuitem
				 * if it's been created.
				 */
				if (main instanceof MainWindow) {
					menuGame.add(itemExit);
				}
				
				/*
				 * 
				 */
				menuHelp.add(itemRules);
				menuHelp.add(itemHint);
		
		/*
		 * Add the menus to the menubar (the current class).
		 */
		this.add(menuGame);
		this.add(menuHelp);
		
		/*
		 * Set the height to 25px;
		 */
		this.setSize(0, 25);
		this.setPreferredSize(this.getSize());
		
		/*
		 * Show the menubar.
		 */
		this.setVisible(true);
	}
}
