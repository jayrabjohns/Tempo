package main.gui.studyTimer;

import main.gui.Form;
import main.gui.Stylesheet;

import javax.swing.*;
import java.awt.*;

public class TimerCreationForm extends Form
{
	private final TimerCreationFormController controller;
	
	public TimerCreationForm(TimerCreationFormController controller)
	{
		this.controller = controller;
		
		getContentPane().add(this.genSetup());
	}
	
	public JPanel genSetup()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setAutoscrolls(true);
		
		LayoutManager layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);

		mainPanel.add(this.genBody());
		mainPanel.add(this.genFooter());
		
		return mainPanel;
	}

	public JPanel genTimerRunning()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setAutoscrolls(true);

		LayoutManager layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);

		mainPanel.add(this.genTimeRemaining());
		mainPanel.add(this.genFooter());

		return mainPanel;
	}

	public JPanel genPaused()
	{
		return null;
	}
	
	public JPanel genBody()
	{
		JPanel bodyPanel = new JPanel();
		
		LayoutManager bodyLayout = new BoxLayout(bodyPanel, BoxLayout.X_AXIS);
		bodyPanel.setLayout(bodyLayout);
		
		
		//left side
		JPanel workPanel = new JPanel();
		LayoutManager workPanelLayout = new BoxLayout(workPanel, BoxLayout.Y_AXIS);
		workPanel.setLayout(workPanelLayout);
		
		//row1 left side
		JLabel workLabel = new JLabel("Work");
		workLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		workLabel.setFont(new Font("Arial", Font.BOLD, 15));
		workPanel.add(workLabel);
		
		//row2 left side divided into a left and right panel
		JPanel workInputPanel = new JPanel();
		LayoutManager workInputPanelLayout = new BoxLayout(workInputPanel, BoxLayout.X_AXIS);
		workInputPanel.setLayout(workInputPanelLayout);
		
		JTextField workTextField = new JTextField();
		workTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatInput(workTextField);
		workTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, workTextField.getPreferredSize().height));
		workInputPanel.add(workTextField);
		controller.bindWorkTextField(workTextField);
		
		JLabel workMinsLabel = new JLabel("mins");
		workMinsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		workMinsLabel.setFont(new Font("Arial", Font.BOLD, 15));
		workInputPanel.add(workMinsLabel);
		
		workPanel.add(workInputPanel);
		
		bodyPanel.add(workPanel);
		
		
		// right side
		JPanel restPanel = new JPanel();
		LayoutManager restPanelLayout = new BoxLayout(restPanel, BoxLayout.Y_AXIS);
		restPanel.setLayout(restPanelLayout);

		JLabel restLabel = new JLabel("Rest");
		restLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		restLabel.setFont(new Font("Arial", Font.BOLD, 15));
		restPanel.add(restLabel);
		
		JPanel restInputPanel = new JPanel();
		LayoutManager restInputPanelLayout = new BoxLayout(restInputPanel, BoxLayout.X_AXIS);
		restInputPanel.setLayout(restInputPanelLayout);

		JTextField restTextField = new JTextField();
		restTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatInput(restTextField);
		restTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, restTextField.getPreferredSize().height));
		restInputPanel.add(restTextField);
		controller.bindRestTextField(restTextField);
		
		JLabel restMinsLabel = new JLabel("mins");
		restMinsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		restMinsLabel.setFont(new Font("Arial", Font.BOLD, 15));
		restInputPanel.add(restMinsLabel);
		
		restPanel.add(restInputPanel);
		
		bodyPanel.add(restPanel);
		
		return bodyPanel;
	}

	public JPanel genTimeRemaining()
	{
		JPanel panel = new JPanel();

		LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);

		JLabel timeLabel = new JLabel("Remaining Time");
		timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		timeLabel.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(timeLabel);

		return panel;
	}
	
	public JPanel genFooter()
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
