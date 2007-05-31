/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Julian
 *
 */
public class Board extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7704761091317274700L;
	
	private model.Board board;
	private model.Game game;
	private JButton[] buttons;
	private JPanel[] quadrants;
	private Font font;
	private int quadDim;
	
	public Board(model.Game game, Dimension dimension) {
		super();
		this.board = game.getCurrentBoard();
		this.game = game;
		this.setPreferredSize(dimension);
		this.setSize(dimension);
		this.setOpaque(false);
		quadDim = this.board.getSettings().getQuadrantDimension();
		this.setLayout(new GridLayout(quadDim, quadDim, ViewSettings.getBoardSpacing(), ViewSettings.getBoardSpacing()));
		
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

		createButtons();
		createQuadrants();
		addButtons();
		addQuadrants();
		
		populateButtons();
	}
	
	private void addQuadrants() {
		for (int i = 0; i < quadrants.length; i++) {
			this.add(quadrants[i]);
		}
	}
	
	private void createQuadrants() {
		quadrants = new JPanel[board.getSettings().getBoardDimensions()];
		
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
	
	private void createButtons() {
		buttons = new JButton[board.getSettings().getBoardLength()];
		for (int i = 0; i < board.getSettings().getBoardLength(); i++) {
			buttons[i] = new JButton();
			
			buttons[i].setSize(ViewSettings.getButtonDimension());
			buttons[i].setPreferredSize(ViewSettings.getButtonDimension());
			buttons[i].setBackground(Color.WHITE);
			buttons[i].setFont(font);
			buttons[i].setText(Integer.toString(0));
			buttons[i].setMargin(new Insets(0, 0, 0, 0));
			buttons[i].setFocusable(false);
			buttons[i].setBorderPainted(false);
		}
	}
	
	private void addButtons() {
		for (int i = 0; i < buttons.length; i++) {
			int quadrant = model.SudokuMath.getQuadrantNumber(i, board.getSettings());
			quadrants[quadrant].add(buttons[i]);
		}
	}

	private void populateButtons() {
		int values[] = board.toArray();
		for (int index = 0; index < board.getSettings().getBoardLength(); index++) {
			String value = Integer.toString(values[index]);
			Boolean enabled = false;
			if (value.equalsIgnoreCase("0")) {
				value = "";
				enabled = true;
				buttons[index].addActionListener(new controller.NumberAction(game, this, index, this));
			}
			
			buttons[index].setEnabled(enabled);
			buttons[index].setText(value);
		}
	}
	
	public void setValue(int fieldId, int value) {
		buttons[fieldId].setText(Integer.toString(value));
	}
	
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
