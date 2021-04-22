package main.gui.timer;

import main.gui.Form;
import main.gui.Stylesheet;

import javax.swing.*;
import java.awt.*;


/**
 * Form for running the timer, this might need to be split into multiple forms for study / excersise later on.
 */
public class TimerRunningForm extends Form
{
	private final TimerRunningFormController controller;
	
	public TimerRunningForm(TimerRunningFormController controller)
	{
		this.controller = controller;
		getContentPane().add(this.genSetup());
	}
	
	public void setTimer(PITimer timer)
	{
		controller.startTimer(timer);
	}

	public JPanel genSetup()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setAutoscrolls(true);

		LayoutManager layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);
		mainPanel.setBackground(Color.white);


		mainPanel.add(this.timeRemaining());
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(this.genButtons());

		return mainPanel;
	}

	public JPanel timeRemaining(){
		JPanel bodyPanel = new JPanel();

		LayoutManager bodyLayout = new BoxLayout(bodyPanel, BoxLayout.X_AXIS);
		bodyPanel.setLayout(bodyLayout);
		bodyPanel.setBackground(Color.white);

		JLabel timeRemainingLabel = new JLabel("x minutes");
		timeRemainingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		timeRemainingLabel.setFont(new Font("Arial", Font.BOLD, 35));
		bodyPanel.add(timeRemainingLabel);
		this.controller.bindLabel(timeRemainingLabel);

		return bodyPanel;
	}

	public JPanel genButtons(){
		JPanel panel = new JPanel();

		LayoutManager panelLayout = new GridLayout();//(panel, BoxLayout.X_AXIS);
		panel.setLayout(panelLayout);
		panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

		JButton pauseButton = new JButton("Pause");
		pauseButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(pauseButton, "primary");
		pauseButton.setBackground(new Color(255,204,0));
		pauseButton.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(255,204,0)));
		panel.add(pauseButton);
		this.controller.bindPauseButton(pauseButton);

		JButton stopButton = new JButton("Stop");
		stopButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(stopButton, "primary");
		stopButton.setBackground(Color.RED);
		stopButton.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED));
		panel.add(stopButton);
		this.controller.bindStopButton(stopButton);
		
		JButton extendButton = new JButton("Add 1 min");
		Stylesheet.formatButton(extendButton, "primary");
		panel.add(extendButton);
		this.controller.bindExtendButton(extendButton);
		
		return panel;
	}
}
