package main.gui.studyTimer;

import main.gui.Stylesheet;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class TimerRenderer implements ListCellRenderer<PITimer>
{
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
		return genTimerSetup();
	}
	
	public JPanel genTimerSetup()
	{
		JPanel setupPanel = new JPanel();
		
		LayoutManager bodyLayout = new BoxLayout(setupPanel, BoxLayout.X_AXIS);
		setupPanel.setLayout(bodyLayout);
		setupPanel.setBackground(Color.white);
		
		JPanel workPanel = genTimerSetupField("Work", Integer.toString(25), null);
		setupPanel.add(workPanel);
		
		JPanel restPanel = genTimerSetupField("Rest", Integer.toString(5), null);
		setupPanel.add(restPanel);
		
		return setupPanel;
	}
	
	private JPanel genTimerSetupField(String labelText, String defaultValueString, Consumer<JTextField> controllerBind)
	{
		JPanel panel = new JPanel();
		LayoutManager panelLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(panelLayout);
		panel.setBackground(Color.white);
		
		JLabel topLabel = new JLabel(labelText);
		topLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		topLabel.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(topLabel);
		
		JPanel inputPanel = new JPanel();
		LayoutManager inputPanelLayout = new BoxLayout(inputPanel, BoxLayout.X_AXIS);
		inputPanel.setLayout(inputPanelLayout);
		inputPanel.setBackground(Color.white);
		
		JTextField textField = new JTextField();
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatInput(textField);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));
		textField.setText(defaultValueString);
		inputPanel.add(textField);
		
		if (controllerBind != null)
		{
			controllerBind.accept(textField);
		}
		
		JLabel minsLabel = new JLabel("mins");
		minsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		minsLabel.setFont(new Font("Arial", Font.BOLD, 15));
		inputPanel.add(minsLabel);
		
		panel.add(inputPanel);
		
		return panel;
	}
}
