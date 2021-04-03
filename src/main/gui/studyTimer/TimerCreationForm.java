package main.gui.studyTimer;

import main.gui.Form;
import main.gui.Stylesheet;

import javax.swing.*;
import java.awt.*;

public class TimerCreationForm extends Form
{
	private final TimerCreationFormController controller;
	private final Color backgroundColour = Color.white;
	private PITimer timer;
	
	public TimerCreationForm(TimerCreationFormController controller)
	{
		this.controller = controller;
		
		setTimer(new PITimer(25 * 60, 5 * 60));
		
		getContentPane().add(this.genMain());
	}
	
	private JPanel genMain()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setAutoscrolls(true);
		mainPanel.setBackground(backgroundColour);
		
		LayoutManager layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);
		
		mainPanel.add(this.genTimerEditor());//TODO make a reference to this and change it later?
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(this.genButtons());
		
		return mainPanel;
	}
	
	private JPanel genTimerEditor()
	{
		return new TimerEditorPanel(timer, controller::bindWorkTextField, controller::bindRestTextField, backgroundColour);
	}
	
	private JPanel genButtons()
	{
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		
		LayoutManager layout = new GridLayout();
		buttonsPanel.setLayout(layout);
		
		JButton startButton = new JButton("Start");
		startButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(startButton, "primary");
		buttonsPanel.add(startButton);
		this.controller.bindStartButton(startButton);
		
		return buttonsPanel;
	}
	
	public void setTimer(PITimer timer)
	{
		if (timer != null)
		{
			this.timer = timer;
			this.controller.bindTimer(timer);
		}
	}
}
