package main.gui.timer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TimerListCellRenderer implements ListCellRenderer<PITimer>
{
	private JPanel timerPanel;
	private final Color unselectedBackgroundColour = Color.white;
	private final Color selectedBackgroundColour = Color.white;
	
	/**
	 * Return a component that has been configured to display the specified
	 * value. That component's <code>paint</code> method is then called to
	 * "render" the cell.  If it is necessary to compute the dimensions
	 * of a list because the list cells do not have a fixed size, this method
	 * is called to generate a component on which <code>getPreferredSize</code>
	 * can be invoked.
	 *
	 * @param list         The JList we're painting.
	 * @param value        The value returned by list.getModel().getElementAt(index).
	 * @param index        The cells index.
	 * @param isSelected   True if the specified cell was selected.
	 * @param cellHasFocus True if the specified cell has the focus.
	 * @return A component whose paint() method will render the specified value.
	 * @see JList
	 * @see ListSelectionModel
	 * @see ListModel
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends PITimer> list, PITimer value, int index, boolean isSelected, boolean cellHasFocus)
	{
		timerPanel = new JPanel();
		
		LayoutManager bodyLayout = new BoxLayout(timerPanel, BoxLayout.X_AXIS);
		timerPanel.setLayout(bodyLayout);
		
		Color backgroundColour = unselectedBackgroundColour;

		// If mouse is released over list item
		if (isSelected && !list.getValueIsAdjusting())
		{
			Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray);
			timerPanel.setBorder(border);
			backgroundColour = selectedBackgroundColour;
		}
		
		timerPanel.add(new TimerEditorPanel(value, backgroundColour));
		
		return timerPanel;
	}
}
