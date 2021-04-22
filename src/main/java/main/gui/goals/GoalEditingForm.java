package main.gui.goals;

import main.gui.Form;
import main.gui.Stylesheet;

import javax.swing.*;
import java.awt.*;

public class GoalEditingForm extends Form
{
	private final GoalCreationFormController controller;
	private PIGoal goal;
	
	public GoalEditingForm(GoalCreationFormController controller)
	{
		this.controller = controller;
		
		getContentPane().add(this.genMain());
	}
	
	private JPanel genMain()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setAutoscrolls(true);
		
		LayoutManager layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);
		
		mainPanel.add(genGoalsEditor());
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(genButtons());
		
		return mainPanel;
	}
	
	private JPanel genGoalsEditor()
	{
		JPanel editorPanel = new JPanel();
		editorPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
		
		LayoutManager layout = new GridLayout(4, 2);
		editorPanel.setLayout(layout);
		
		editorPanel.add(new JLabel("Title"));
		
		JTextField titleTextField = new JTextField();
		titleTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatInput(titleTextField);
		controller.bindTitleTextField(titleTextField);
		editorPanel.add(titleTextField);
		
		editorPanel.add(new JLabel("Description"));
		
		JTextField descTextField = new JTextField();
		descTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatInput(descTextField);
		controller.bindDescriptionTextField(descTextField);
		editorPanel.add(descTextField);
		
		editorPanel.add(new JLabel("End Date"));
		
		JTextField endDateTextField = new JTextField();
		endDateTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatInput(endDateTextField);
		controller.bindEndDateTextField(endDateTextField);
		editorPanel.add(endDateTextField);
		
		editorPanel.add(new JLabel("Target"));
		
		JTextField targetTextField = new JTextField();
		targetTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatInput(targetTextField);
		controller.bindTargetTextField(targetTextField);
		editorPanel.add(targetTextField);
		
		return editorPanel;
	}
	
	private JPanel genButtons()
	{
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		
		LayoutManager layout = new GridLayout();
		buttonsPanel.setLayout(layout);
		
		JButton doneButton = new JButton("Done");
		doneButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(doneButton, "primary");
		buttonsPanel.add(doneButton);
		this.controller.bindDoneButton(doneButton);
		
		return buttonsPanel;
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
