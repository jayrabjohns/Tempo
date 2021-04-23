package main.gui.goals;

import main.gui.AbstractMainFormController;
import main.gui.Screen;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoalsViewFormController extends AbstractMainFormController implements ActionListener, ListSelectionListener
{
	private JButton chooseGoalButton;
	private JButton editGoalButton;
	
	private PIGoal selectedGoal;
	
	private JList<PIGoal> goalsList;
	private DefaultListModel<PIGoal> goalsListModel;
	
	public void bindGoalsList(JList<PIGoal> goalsList, DefaultListModel<PIGoal> listModel)
	{
		if (goalsList != null && listModel != null)
		{
			goalsList.addListSelectionListener(this);
			this.goalsList = goalsList;
			goalsListModel = listModel;
		}
	}
	
	public void bindChooseGoalButton(JButton button)
	{
		if (button != null)
		{
			button.addActionListener(this);
			chooseGoalButton = button;
		}
	}
	
	public void bindEditGoalButton(JButton button)
	{
		if (button != null)
		{
			button.addActionListener(this);
			editGoalButton = button;
		}
	}
	
	public void includeGoal(PIGoal goal)
	{
		if (goalsListModel != null && goal != null && !goalsListModel.contains(goal))
		{
			goalsListModel.addElement(goal);
		}
	}
	
	private void chooseGoal()
	{
		// Getting array of pre existing goals
		PIGoal[] preExistingGoals = new PIGoal[goalsListModel.size()];
		for (int i = 0; i < goalsListModel.size(); i++)
		{
			 preExistingGoals[i] = goalsListModel.getElementAt(i);
		}
		
		// Setting up goal choosing form
		GoalChoosingForm form = (GoalChoosingForm)Screen.getForm("goalsChoose");
		form.setPreExistingGoals(preExistingGoals);
		Screen.showForm("goalsChoose");
	}
	
	private void editGoal(PIGoal goal)
	{
		if (goal != null)
		{
			GoalEditingForm goalEditingForm = (GoalEditingForm)Screen.getForm("goalsCreate");
			goalEditingForm.setGoal(goal);
			Screen.showForm(goalEditingForm);
		}
	}
	
	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e != null ? e.getSource() : null;
		
		if (source == chooseGoalButton && chooseGoalButton != null)
		{
			chooseGoal();
		}
		else if (source == editGoalButton && editGoalButton != null)
		{
			editGoal(selectedGoal);
		}
	}
	
	/**
	 * Called whenever the value of the selection changes.
	 *
	 * @param e the event that characterizes the change.
	 */
	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		Object source = e != null ? e.getSource() : null;
		
		// On mouse release over timer
		if (source == goalsList && goalsList != null && !goalsList.getValueIsAdjusting())
		{
			selectedGoal = goalsList.getSelectedValue();
		}
	}
}
