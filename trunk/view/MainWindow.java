/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
		Container container = this.getContentPane();

		Background background = new Background();
		container.add(background);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		this.createBoard(panel);
		
		this.setGlassPane(panel);
		panel.setVisible(true);
		
		this.setup();
	}
	
	private void createBoard(Container container) {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 0, 0);
		Dimension boardDimension = Calculator.getBoardDimensions(new model.Board());
		JPanel panel = new JPanel();
			panel.setLayout(layout);
			panel.setSize(boardDimension);
			panel.setPreferredSize(boardDimension);
			panel.setOpaque(true);
		
			Board board = new Board(new model.Board(), boardDimension);
			panel.add(board);
		
		container.add(panel);
	}
	
	/**
	 * Performs some standard operations on the window.
	 */
	private void setup() {
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
		//this.setResizable(false);
		
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
