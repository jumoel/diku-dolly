/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Julian
 *
 */
public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3172688540921699213L;
	
	public MainWindow() {
		super("Sudoku");
	}
	
	public Background createBG() {
		Background background = new Background("stdSudokuBG.png");
		return (Background)this.add(background, 100);
	}
	
	public Component add(Component component, int zindex) {
		return this.getLayeredPane().add(component);
	}
	public Board createBoard(model.Game game) {
		Dimension boardDimension = Calculator.getBoardDimensions(game.getCurrentBoard());
		Board board = new Board(game, boardDimension);
		
		return (Board)this.add(board, 2);
	}
	
	/**
	 * Performs some standard operations on the window.
	 */
	public void setup() {
		//this.setGlassPane(panel);
		//panel.setVisible(true);
		
		/*
		 * Make sure the application exits when the close button is pressed.
		 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * Lay out the subcomponents correctly.
		 */
		this.validate();
		/*
		 * Disable resize of the window.
		 */
		this.setResizable(false);
		this.setUndecorated(true);
		
		this.setSize(700, 500);
		this.setPreferredSize(this.getSize());
		this.pack();
		/*
		 * Place on the center of the screen.
		 */
		PlaceCenter.placeCenter(this);
		
		/*
		 * Show the window.
		 */
		this.setVisible(true);
	}
}
