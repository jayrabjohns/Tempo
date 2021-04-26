package main.gui.goals;

import main.gui.AbstractMainForm;
import main.gui.Stylesheet;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class GoalChoosingForm extends AbstractMainForm
{
	private GoalChoosingFormController controller;
	
	public GoalChoosingForm(GoalChoosingFormController controller)
	{
		super(controller);
		
		this.controller = controller;
		
		getContentPane().add(this.genMain());
	}
	
	public void setPreExistingGoals(HashSet<PIGoal> goals)
	{
		controller.setPreExistingGoals(goals);
	}
	
	@Override
	public JComponent genBody()
	{
		JPanel bodyPanel = new JPanel();
		bodyPanel.setAutoscrolls(true);
		
		LayoutManager bodyLayout = new BoxLayout(bodyPanel, BoxLayout.Y_AXIS);
		bodyPanel.setLayout(bodyLayout);
		bodyPanel.setBackground(Stylesheet.APP_BACKGROUND);
		
		bodyPanel.add(genGoalsList());
		bodyPanel.add(genButtons());
		
		return bodyPanel;
	}
	
	private JScrollPane genGoalsList()
	{
		DefaultListModel<PIGoal> listModel = new DefaultListModel<>();
		JList<PIGoal> goalsList = new JList<>(listModel);
		goalsList.setCellRenderer(new GoalsListCellRenderer());
		this.controller.bindGoalsList(goalsList, listModel);
		
		return new JScrollPane(goalsList);
	}
	
	private JPanel genButtons()
	{
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setAutoscrolls(true);
		
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.setBackground(Stylesheet.APP_BACKGROUND);
		
		JButton selectButton = new JButton("Select");
		selectButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(selectButton, "primary");
		buttonsPanel.add(selectButton);
		this.controller.bindSelectButton(selectButton);
		
		JButton backButton = new JButton("Back");
		backButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(backButton, "primary");
		buttonsPanel.add(backButton);
		this.controller.bindBackButton(backButton);
		
		return buttonsPanel;
	}
}
