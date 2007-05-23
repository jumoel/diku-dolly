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
		Background background = new Background();
		this.add(background);
		//this.createBoard(this);
		this.setBackground(Color.BLACK);
		
		this.setup();
	}
	
	private void createBoard(Container container) {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 0, 0);
		Dimension boardDimension = new Dimension(245, 245);
		JPanel panel = new JPanel();
			panel.setLayout(layout);
			panel.setSize(boardDimension);
			panel.setPreferredSize(boardDimension);
		
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
