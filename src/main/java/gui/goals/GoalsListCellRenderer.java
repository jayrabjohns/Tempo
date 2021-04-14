package gui.goals;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GoalsListCellRenderer implements ListCellRenderer<PIGoal>
{
	private JPanel goalPanel;
	
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
	public Component getListCellRendererComponent(JList<? extends PIGoal> list, PIGoal value, int index, boolean isSelected, boolean cellHasFocus)
	{
		goalPanel = new JPanel();
		goalPanel.setLayout(new BoxLayout(goalPanel, BoxLayout.Y_AXIS));
		
		// If mouse is released over list item
		if (isSelected && !list.getValueIsAdjusting())
		{
			Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray);
			goalPanel.setBorder(border);
		}
		
		goalPanel.add(genGoalDisplayPanel(value));
		goalPanel.add(genProgressbar(value));
		goalPanel.add(Box.createVerticalStrut(5));
		
		return goalPanel;
	}
	
	private JPanel genGoalDisplayPanel(PIGoal goal)
	{
		JPanel goalDisplayPanel = new JPanel();
		goalDisplayPanel.setLayout(new BoxLayout(goalDisplayPanel, BoxLayout.X_AXIS));
		
		// Left
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		leftPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel titleLable = new JLabel(goal.getTitle());
		leftPanel.add(titleLable);
		
		goalDisplayPanel.add(leftPanel);
		
		// Right
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		rightPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		if (goal.getEndDate() != null)
		{
			JLabel endDateLabel = new JLabel("Ends: " + goal.getEndDateString());
			rightPanel.add(endDateLabel);
		}
		
		rightPanel.add(Box.createHorizontalStrut(5));
		
		JLabel completionLable = new JLabel(String.format("%d%%", goal.getPercentageCompleted()));
		rightPanel.add(completionLable);
		
		goalDisplayPanel.add(rightPanel);
		
		return goalDisplayPanel;
	}
	
	private JPanel genProgressbar(PIGoal goal)
	{
		JPanel progressBarPanel = new JPanel();
		progressBarPanel.setLayout(new BoxLayout(progressBarPanel, BoxLayout.X_AXIS));
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(goal.getPercentageCompleted());
		progressBarPanel.add(progressBar);
		
		return progressBarPanel;
	}
}
