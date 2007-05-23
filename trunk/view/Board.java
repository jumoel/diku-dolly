/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author Julian
 *
 */
public class Board extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7704761091317274700L;
	
	private GridLayout layout;
	
	public Board(model.Board board, Dimension dimension) {
		super();
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
			createButtons(settings, panel);
			panel.setOpaque(false);
			
			this.add(panel);
		}
	}
	
	private void createButtons(model.GameSettings settings, JPanel panel) {
		for (int i = 0; i < settings.getBoardDimensions(); i = i + 1) {
			JButton button = new JButton(Integer.toString(i));
			button.setPreferredSize(ViewSettings.getButtonDimension());
			button.setMargin(new Insets(0, 0, 0, 0));
			button.setFocusable(false);
			button.setFont(new Font("SansSerif", Font.PLAIN, 10));
			button.setBackground(Color.WHITE);
			button.setForeground(Color.BLACK);
			button.setBorderPainted(false);
			panel.add(button);
		}
	}
}
