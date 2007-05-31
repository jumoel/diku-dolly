/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import controller.DifficultyAction;
import controller.HelpAction;

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
	
	public Component add(Component component, int zindex, int x, int y) {
		component.setLocation(x, y);
		return this.getLayeredPane().add(component, zindex);
	}
	public Board createBoard(model.Game game) {
		Dimension boardDimension = Calculator.getBoardDimensions(game.getCurrentBoard());
		Board board = new Board(game, boardDimension);
		
		return (Board)this.add(board, 2, 50, 100);
	}
	
	public Background createBG() {
		Background background = new Background("stdSudokuBG.png");
		return (Background)this.add(background, 100, 0, 0);
	}
	
	public IngameControls createIngameControls(MainWindow main, DifficultyAction difficultyAction, HelpAction helpAction) {
		IngameControls controls = new IngameControls(main, difficultyAction, helpAction);
		return (IngameControls)this.add(controls, 10, 375, 100);
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
