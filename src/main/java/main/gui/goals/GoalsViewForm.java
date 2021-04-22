package main.gui.goals;

import main.gui.AbstractMainForm;
import main.gui.Stylesheet;

import javax.swing.*;
import java.awt.*;

public class GoalsViewForm extends AbstractMainForm
{
	private final GoalsViewFormController controller;
	
	public GoalsViewForm(GoalsViewFormController controller)
	{
		super(controller);
		
		this.controller = controller;
		
		getContentPane().add(this.genMain());
	}
	
	@Override
	public JComponent genBody()
	{
		JPanel bodyPanel = new JPanel();
		bodyPanel.setAutoscrolls(true);
		
		LayoutManager bodyLayout = new BoxLayout(bodyPanel, BoxLayout.Y_AXIS);
		bodyPanel.setLayout(bodyLayout);
		bodyPanel.setBackground(Color.white);
		
		bodyPanel.add(Box.createVerticalStrut(20));
		bodyPanel.add(this.genGoalsList());
		bodyPanel.add(Box.createVerticalStrut(40));
		bodyPanel.add(this.genButtons());
		
		return bodyPanel;
	}
	
	private JScrollPane genGoalsList()
	{
		DefaultListModel<PIGoal> listModel = new DefaultListModel<>();
		
		// TODO remove this, it's just for debug purposes
		PIGoal goal = new PIGoal("Super duper test", "desc", null, 5);
		goal.increment(2);
		listModel.addElement(goal);
		
		ListCellRenderer<PIGoal> listCellRenderer = new GoalsListCellRenderer();
		
		JList<PIGoal> goalsList = new JList<>(listModel);
		goalsList.setCellRenderer(listCellRenderer);
		this.controller.bindGoalsList(goalsList, listModel);
		
		return new JScrollPane(goalsList);
	}
	
	private JPanel genButtons()
	{
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		
		LayoutManager layout = new GridLayout();
		panel.setLayout(layout);
		
		JButton chooseGoalButton = new JButton("Choose");
		chooseGoalButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(chooseGoalButton, "primary");
		panel.add(chooseGoalButton);
		this.controller.bindChooseGoalButton(chooseGoalButton);
		
		JButton editGoalButton = new JButton("Edit");
		editGoalButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(editGoalButton, "primary");
		panel.add(editGoalButton);
		this.controller.bindEditGoalButton(editGoalButton);
		
		return panel;
	}
}
