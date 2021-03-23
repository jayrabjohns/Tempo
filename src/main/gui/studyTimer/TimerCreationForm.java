package main.gui.studyTimer;

import main.gui.Form;
import main.gui.Screen;
import main.gui.Stylesheet;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class TimerCreationForm extends Form
{
	private final TimerCreationFormController controller;
	private int defaultWorkTime;
	private int defaultRestTime;
	
	public TimerCreationForm(TimerCreationFormController controller, int defaultWorkTime, int defaultRestTime)
	{
		this.controller = controller;
		this.defaultWorkTime = defaultWorkTime;
		this.defaultRestTime = defaultRestTime;
		
		getContentPane().add(this.genMain());
	}
	
	public JPanel genMain()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setAutoscrolls(true);
		
		LayoutManager layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);

		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(this.genTimerSetupFields());
		mainPanel.add(Box.createVerticalStrut(40));
		mainPanel.add(this.genButtons());
		mainPanel.add(Box.createVerticalStrut(Screen.getDefaultSize().height * 3 / 4));
		
		return mainPanel;
	}
	
	public JPanel genTimerSetupFields()
	{
		JPanel bodyPanel = new JPanel();
		
		LayoutManager bodyLayout = new BoxLayout(bodyPanel, BoxLayout.X_AXIS);
		bodyPanel.setLayout(bodyLayout);
		
		JPanel workPanel = genTimerSetupField("Work", Integer.toString(defaultWorkTime), controller::bindWorkTextField);
		bodyPanel.add(workPanel);
		
		JPanel restPanel = genTimerSetupField("Rest", Integer.toString(defaultRestTime), controller::bindRestTextField);
		bodyPanel.add(restPanel);
		
		return bodyPanel;
	}
	
	private JPanel genTimerSetupField(String labelText, String defaultValueString, Consumer<JTextField> controllerBind)
	{
		JPanel panel = new JPanel();
		LayoutManager panelLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(panelLayout);
		
		JLabel topLabel = new JLabel(labelText);
		topLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		topLabel.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(topLabel);
		
		JPanel inputPanel = new JPanel();
		LayoutManager inputPanelLayout = new BoxLayout(inputPanel, BoxLayout.X_AXIS);
		inputPanel.setLayout(inputPanelLayout);
		
		JTextField textField = new JTextField();
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatInput(textField);
		textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));
		textField.setText(defaultValueString);
		inputPanel.add(textField);
		controllerBind.accept(textField);
		
		JLabel minsLabel = new JLabel("mins");
		minsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		minsLabel.setFont(new Font("Arial", Font.BOLD, 15));
		inputPanel.add(minsLabel);
		
		panel.add(inputPanel);
		
		return panel;
	}
	
	public JPanel genButtons()
	{
		JPanel panel = new JPanel();
		
		LayoutManager layout = new GridLayout();
		panel.setLayout(layout);

		JButton playButton = new JButton("Start");
		playButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(playButton, "primary");
		panel.add(playButton);
		this.controller.bindPlayButton(playButton);
		
		return panel;
	}
}
