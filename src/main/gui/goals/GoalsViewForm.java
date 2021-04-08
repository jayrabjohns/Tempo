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
		
		JButton addTimerButton = new JButton("Add new");
		addTimerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(addTimerButton, "primary");
		panel.add(addTimerButton);
		this.controller.bindAddGoalButton(addTimerButton);
		
		JButton editTimerButton = new JButton("Edit timer");
		editTimerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(editTimerButton, "primary");
		panel.add(editTimerButton);
		this.controller.bindEditGoalButton(editTimerButton);
		
		return panel;
	}
}
