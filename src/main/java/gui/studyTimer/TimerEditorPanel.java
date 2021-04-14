package gui.studyTimer;

import gui.Stylesheet;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

/**
 * A panel for editing a timer.
 */
public class TimerEditorPanel extends JPanel
{
	private final PITimer timer;
	private final Consumer<JTextField> bindWorkTextField;
	private final Consumer<JTextField> bindRestTextField;
	private final Color backgroundColour;
	
	public TimerEditorPanel(PITimer timer, Color backgroundColour)
	{
		this(timer, null, null, backgroundColour);
	}
	
	public TimerEditorPanel(PITimer timer, Consumer<JTextField> bindWorkTextField, Consumer<JTextField> bindRestTextField, Color backgroundColour)
	{
		this.timer = timer;
		this.bindWorkTextField = bindWorkTextField;
		this.bindRestTextField = bindRestTextField;
		this.backgroundColour = backgroundColour;
		
		setupPanel();
	}
	
	/**
	 * Sets up the panel
	 */
	private void setupPanel()
	{
		LayoutManager bodyLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(bodyLayout);
		this.setBackground(backgroundColour);

		JPanel workPanel = genTimerSetupField("Work", Integer.toString(timer.getWorkMins()), bindWorkTextField);
		this.add(workPanel);

		JPanel restPanel = genTimerSetupField("Rest", Integer.toString(timer.getRestMins()), bindRestTextField);
		this.add(restPanel);
	}
	
	/**
	 * Sets up an individual part of the panel.
	 * @param labelText Label
	 * @param defaultValueString String present in text field when first seen.
	 * @param textFieldBinder Method to bind the text field to a controller.
	 * @return The setup panel.
	 */
	private JPanel genTimerSetupField(String labelText, String defaultValueString, Consumer<JTextField> textFieldBinder)
	{
		JPanel panel = new JPanel();
		LayoutManager panelLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(panelLayout);
		panel.setBackground(backgroundColour);

		JLabel topLabel = new JLabel(labelText);
		topLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		topLabel.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(topLabel);

		JPanel inputPanel = new JPanel();
		LayoutManager inputPanelLayout = new BoxLayout(inputPanel, BoxLayout.X_AXIS);
		inputPanel.setLayout(inputPanelLayout);
		inputPanel.setBackground(backgroundColour);

		JTextField textField = new JTextField();
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatInput(textField);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));
		textField.setText(defaultValueString);
		inputPanel.add(textField);

		if (textFieldBinder != null)
		{
			textFieldBinder.accept(textField);
		}

		JLabel minsLabel = new JLabel("mins");
		minsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		minsLabel.setFont(new Font("Arial", Font.BOLD, 15));
		inputPanel.add(minsLabel);

		panel.add(inputPanel);

		return panel;
	}
}
