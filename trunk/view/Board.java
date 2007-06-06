package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The graphical representation of our Sudokuboard.
 */
public class Board extends JPanel implements Observer {
	/**
	 * Classes that implement <code>Serializable</code> needs this.
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 7704761091317274700L;
	
	private model.Board board;
	private model.Game game;
	private MainInterface main;
	private JButton[] buttons;
	private JPanel[] quadrants;
	private Font font;
	private int quadDim;
	
	/**
	 * Creates a new Board where the dimensions are extracted
	 * from the MainInterface-object.
	 * @param main The object containing the board to base the view on.
	 */
	public Board(MainInterface main) {
		this(main, getViewBoardDimensions(main.getGame().getCurrentBoard()));
	}
	
	/**
	 * Creates a new Board with a specified dimension.
	 * @param main The object containing the board to base the view on.
	 * @param dimension The dimension the board should get.
	 */
	public Board(MainInterface main, Dimension dimension) {
		super();
		
		/*
		 * Set the private fields.
		 */
		this.main = main;
		this.game = main.getGame();
		this.board = game.getCurrentBoard();
		
		/*
		 * Set the size and make sure the panel isn't opaque.
		 */
		this.setPreferredSize(dimension);
		this.setSize(dimension);
		this.setOpaque(false);
		
		/*
		 * Set the layoutmanager based on the dimensions of the underlying model.Board. 
		 */
		quadDim = this.board.getSettings().getQuadrantDimensions();
		this.setLayout(new GridLayout(quadDim, quadDim, ViewSettings.getBoardSpacing(), ViewSettings.getBoardSpacing()));
		
		/*
		 * Try to set the font to use on the buttons.
		 * If it fails, go back to a standard Sans-Serif type.
		 */
		InputStream stream = this.getClass().getResourceAsStream("font/Edible_Pet.ttf");

		try {
			Font fs = Font.createFont(Font.TRUETYPE_FONT, stream);
			font = fs.deriveFont(Font.PLAIN, 14);
		} catch(FontFormatException fe) {
			/*
			 * If the font is somehow invalid, use a default system font.
			 */
			font = new Font("SansSerif", Font.BOLD, 12);
		} catch(IOException ioe) {
			/*
			 * If the font is not found, use a default system font.
			 */
			font = new Font("SansSerif", Font.BOLD, 12);
		} catch(UnsupportedOperationException UOEx) {
			/*
			 * Apparently this happens on some Linux-systems.
			 */
			font = new Font("SansSerif", Font.BOLD, 12);
		}

		/*
		 * Create all the buttons, JPanels etc. this board consists of.
		 */
		createButtons();
		createQuadrants();
		addButtons();
		addQuadrants();
		
		populateButtons();
	}
	
	/**
	 * Removes all colornotices from the board.
	 */
	public void clearNotices() {
		for (int i = 0; i < buttons.length; i++) {
			clearNotice(i);
		}
	}
	
	/**
	 * Removes all hintnotices from the board.
	 */
	public void clearHintNotices() {
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i].getBackground() == ViewSettings.getHintColor()) {
				clearNotice(i);
			}
		}
	}
	
	/**
	 * Removes a single notice from the board.
	 * @param fieldId The Id of the field whose backgroundcolor should be reset.
	 */
	public void clearNotice(int fieldId) {
		buttons[fieldId].setBackground(ViewSettings.getButtonBackground());
	}
	
	/**
	 * Sets a single notice on the board.
	 * @param fieldId The Id of the field whose backgroundcolor should be set.
	 * @param color The color the field should get.
	 */
	public void setNotice(int fieldId, Color color) {
		buttons[fieldId].setBackground(color);
	}
	
	/**
	 * Set notices on multiple fields.
	 * @param fieldIds An int-array containing the fieldIds of all the field
	 * 		  who should have their backgroundcolor set.
	 * @param color The color to set.
	 */
	public void setNotices(int[] fieldIds, Color color) {
		int max = board.getSettings().getBoardLength();
		for (int index : fieldIds) {
			if (index >= 0 && index < max) {
				setNotice(index, color);
			}
		}
	}
	
	/**
	 * Add the quadrants to the board.
	 * 
	 * createQuadrants() MUST have been called before this
	 * gets called!
	 */
	private void addQuadrants() {
		for (int i = 0; i < quadrants.length; i++) {
			this.add(quadrants[i]);
		}
	}
	
	/**
	 * Create the quadrants.
	 */
	private void createQuadrants() {
		/*
		 * Initiate the array
		 */
		quadrants = new JPanel[board.getSettings().getBoardDimensions()];
		
		/*
		 * Create each quadrant and change their appearences.
		 */
		for (int i = 0; i < board.getSettings().getBoardDimensions(); i++) {
			quadrants[i] = new JPanel();
			/*
			 * The two '1'-values denotes a 1-pixel space between the elements.
			 */
			quadrants[i].setLayout(new GridLayout(quadDim, quadDim, 1, 1));
			int dim = ViewSettings.getButtonDimension().height * quadDim;
			quadrants[i].setSize(new Dimension(dim, dim));
			quadrants[i].setPreferredSize(quadrants[i].getSize());
			quadrants[i].setBackground(Color.BLACK);
			quadrants[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		}
	}
	
	/**
	 * Creates the buttons / fields.
	 */
	private void createButtons() {
		buttons = new JButton[board.getSettings().getBoardLength()];
		for (int i = 0; i < board.getSettings().getBoardLength(); i++) {
			buttons[i] = new JButton();
			
			buttons[i].setSize(ViewSettings.getButtonDimension());
			buttons[i].setPreferredSize(ViewSettings.getButtonDimension());
			buttons[i].setBackground(ViewSettings.getButtonBackground());
			buttons[i].setFont(font);
			buttons[i].setText(Integer.toString(0));
			buttons[i].setMargin(new Insets(0, 0, 0, 0));
			buttons[i].setFocusable(false);
			buttons[i].setBorderPainted(false);
		}
	}
	
	/**
	 * Add the buttons to the right quadrants.
	 * 
	 * createQuadrants() and createButtons() MUST have been called
	 * before this gets called!
	 */
	private void addButtons() {
		for (int i = 0; i < buttons.length; i++) {
			int quadrant = model.SudokuMath.getQuadrantNumber(i, board.getSettings());
			quadrants[quadrant].add(buttons[i]);
		}
	}
	
	/**
	 * Remove actionslisteners from a button.
	 */
	private void removeActionListeners() {
		for (JButton button : buttons) {
			for (ActionListener action : button.getActionListeners()) {
				button.removeActionListener(action);
			}
		}
	}

	/**
	 * Sets the values of the buttons.
	 * Also enables/disables the buttons depending on whether or not
	 * they have an inital value.
	 * 
	 * If they dont have an initial value the get a NumberAction
	 * assigned as an ActionListener.
	 */
	private void populateButtons() {
		removeActionListeners();
		
		int values[] = board.toArray();
		for (int index = 0; index < board.getSettings().getBoardLength(); index++) {
			String value = Integer.toString(values[index]);
			Boolean enabled = false;
			
			/*
			 * If the field contains the value 0, enable the button
			 * add the ActionListener and set the text of the button to nothing.
			 */
			if (value.equalsIgnoreCase("0")) {
				value = "";
				enabled = true;
				buttons[index].addActionListener(
						new controller.NumberAction(main, index, this));
			}
			
			buttons[index].setEnabled(enabled);
			buttons[index].setText(value);
		}
	}
	
	/**
	 * Change the value of a button / field.
	 * @param fieldId The fieldId of the button / field whose value should be changed.
	 * @param value The value to change to.
	 */
	public void setValue(int fieldId, int value) {
		String valueStr;
		
		/*
		 * If the value equals 0 (the user has removed a number)
		 * remove any text from the button. Otherwise set the value
		 * to the supplied number.
		 */
		if (value == 0) {
			valueStr = "";
		} else {
			valueStr = Integer.toString(value);
		}
		buttons[fieldId].setText(valueStr);
	}
	
	/**
	 * When a new game gets created, this updates the board with the new values
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable arg0, Object arg1) {
		this.clearNotices();
		((MainInterface)this.getTopLevelAncestor()).getSheepSpeak().resetText();
		this.board = (model.Board)arg0;
		this.populateButtons();
	}
	
	/**
	 * Calculates the visual width of the current gameboard.
	 * @return The width of the board.
	 */
	public Dimension getViewBoardDimensions() {
		return getViewBoardDimensions(this.board);
	}
	
	/**
	 * Calculates the visual width of the supplied gameboard.
	 * @param board The board to calculate the width of
	 * @return The width of the board.
	 */
	public static Dimension getViewBoardDimensions(model.Board board) {
		int dimension = board.getSettings().getBoardDimensions() * 
						ViewSettings.getButtonSize();
		
		int finalWidth = 50 + dimension +
			(board.getSettings().getQuadrantDimensions() - 1) * ViewSettings.getBoardSpacing();
		
		return new Dimension(finalWidth, finalWidth);
	}
}
