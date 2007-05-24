/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.NumberAction;

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
	private final MouseListener[] defaultListeners = new JButton().getMouseListeners();
	
	public Board(model.Game game, Dimension dimension) {
		super();
		this.board = game.getCurrentBoard();
		this.game = game;
		this.setPreferredSize(dimension);
		createPanels(board.getSettings());
	}
	
	private void createPanels(model.GameSettings settings) {
		GridLayout quadrantLayout = new GridLayout();
		quadrantLayout.setColumns(settings.getQuadrantDimension());
		quadrantLayout.setRows(settings.getQuadrantDimension());
		quadrantLayout.setHgap(0);
		quadrantLayout.setVgap(0);
		for (int i = 0; i < settings.getBoardDimensions(); i = i + 1)
		{
			JPanel panel = new JPanel();
			panel.setLayout(quadrantLayout);
			
			createButtons(settings, panel, i);
			populateButtons();
			
			panel.setOpaque(false);
			
			this.add(panel);
		}
	}
	
	/**
	 * Gets the fieldId from the quadrantnumber and number inside the quadrant.
	 * Enables us to get the data from the board.
	 */
	private int getFieldIdFromCoords(model.GameSettings settings, int quadrantId, int fieldNum) {
		
		int fieldId = fieldNum % settings.getQuadrantDimension() + settings.getBoardDimensions() * (fieldNum / settings.getQuadrantDimension()) +
					(quadrantId % settings.getQuadrantDimension()) * settings.getQuadrantDimension() +
					(quadrantId / settings.getQuadrantDimension() * settings.getQuadrantDimension() * settings.getBoardDimensions());
		
		return fieldId;
	}
	
	private void setButtonProperties(JButton button) {
		button.setPreferredSize(ViewSettings.getButtonDimension());
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setFocusable(false);
		button.setFont(ViewSettings.getButtonFont());
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setBorderPainted(false);
	}
	
	private void removeButtonListeners(JButton button) {
		for (int length = 0; length < button.getMouseListeners().length; length++)
        {
            button.removeMouseListener(button.getMouseListeners()[length]);
        }
	}
	
	private void setStdButtonListeners(JButton button) {
		for  (int index = 0; index < defaultListeners.length; index++) {
			MouseListener listener = defaultListeners[index];
			if (listener != null) {
				button.addMouseListener(listener);
			}
		}
	}
	
	private void populateButtons() {		
		/*
		 * Array containing the quadrants (JPanel's)
		 */
		Component[] panels = this.getComponents();
		
		for (int quadrantId = 0; quadrantId < panels.length; quadrantId++) {
			/*
			 * Array containing the fields (JButton's)
			 */
			Component[] fields = ((JPanel)panels[quadrantId]).getComponents();
			
			for (int fieldNum = 0; fieldNum < fields.length; fieldNum++) {
				JButton button = (JButton)fields[fieldNum];
				
				/*
				 * Gets the fieldId
				 */
				int fieldId = getFieldIdFromCoords(this.board.getSettings(), quadrantId, fieldNum);
				int value = board.getValue(fieldId);
				String text;
				if (value == 0) {
					text = "";
					setStdButtonListeners(button);
					for (int i = 0; i < button.getActionListeners().length; i++) {
						button.removeActionListener(button.getActionListeners()[i]);
					}
					button.addActionListener(new controller.NumberAction(game, this, fieldId, this));
				} else {
					text = Integer.toString(value);
					for (int i = 0; i < button.getActionListeners().length; i++) {
						button.removeActionListener(button.getActionListeners()[i]);
					}
					removeButtonListeners(button);
				}
				
				button.setText(text);
			}
		}
	}
	
	private void createButtons(model.GameSettings settings, JPanel panel, int quadrantId) {
		for (int i = 0; i < settings.getBoardDimensions(); i = i + 1) {
			int fieldId = getFieldIdFromCoords(this.board.getSettings(), quadrantId, i);
			JButton button = new JButton();
			button.setName(Integer.toString(fieldId));
			setButtonProperties(button);
			panel.add(button);
		}
	}

	public void update(Observable o) {
		board = (model.Board)o;
		populateButtons();
	}

	public void update(Observable o, Object arg) {
		this.update(o);
	}

	public void setValue(int fieldId, int value) {
		/*
		 * Array containing the quadrants (JPanel's)
		 */
		Component[] panels = this.getComponents();
		
		for (int quadrantId = 0; quadrantId < panels.length; quadrantId++) {
			/*
			 * Array containing the fields (JButton's)
			 */
			Component[] fields = ((JPanel)panels[quadrantId]).getComponents();
			
			for (int fieldNum = 0; fieldNum < fields.length; fieldNum++) {
				JButton button = (JButton)fields[fieldNum];

				if (button.getName().equalsIgnoreCase(Integer.toString(fieldId))) {
					button.setText(Integer.toString(value));
				}
			}
		}
	}
}
