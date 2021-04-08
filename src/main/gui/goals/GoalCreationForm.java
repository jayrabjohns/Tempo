package main.gui.goals;

import main.gui.Form;

import javax.swing.*;
import java.awt.*;

public class GoalCreationForm extends Form
{
	private GoalCreationFormController controller;
	private PIGoal goal;
	
	public GoalCreationForm(GoalCreationFormController controller)
	{
		this.controller = controller;
		
		setGoal(new PIGoal());
		
		getContentPane().add(this.genMain());
	}
	
	private JPanel genMain()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setAutoscrolls(true);
		
		LayoutManager layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);
		
		mainPanel.add(new JLabel("test"));
		mainPanel.add(Box.createVerticalStrut(20));
		// mainPanel.add(this.genButtons());
		
		return mainPanel;
	}
	
	public void setGoal(PIGoal goal)
	{
		if (goal != null)
		{
			this.goal = goal;
			controller.bindGoal(goal);
		}
	}
}
