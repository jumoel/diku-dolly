/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

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
	private JPanel panel;
	
	public MainWindow() {
		super("Sudoku");
		
		Background background = new Background();
		this.getContentPane().add(background);
		
		panel = new JPanel();
		panel.setOpaque(false);
	}
	
	public Component add(Component component) {
		return panel.add(component);
	}
	public Board createBoard(model.Game game) {
		GridBagLayout layout = new GridBagLayout();
		Dimension boardDimension = Calculator.getBoardDimensions(game.getCurrentBoard());
		JPanel panel = new JPanel();
			panel.setLayout(layout);
			panel.setSize(boardDimension);
			panel.setPreferredSize(boardDimension);
			panel.setOpaque(true);
			
			Board board = new Board(game, boardDimension);
			
			//board.setLayout(layout);
			board.setSize(boardDimension);
			board.setPreferredSize(boardDimension);
			board.setOpaque(false);
			
			//panel.add(board);
		
		return (Board)this.add(board);
	}
	
	/**
	 * Performs some standard operations on the window.
	 */
	public void setup() {
		this.setGlassPane(panel);
		panel.setVisible(true);
		
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
		
		this.setSize(700, 500);

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
