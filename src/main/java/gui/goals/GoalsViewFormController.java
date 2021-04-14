package gui.goals;

import gui.AbstractMainFormController;
import gui.Screen;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoalsViewFormController extends AbstractMainFormController implements ActionListener, ListSelectionListener
{
	private JButton addGoalButton;
	private JButton editGoalButton;
	
	private PIGoal selectedGoal;
	
	// TODO: move this to some other globals class, create system for saving changes to file / initialising values on startup (Possibly same as system used for settings)
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
	
	public void bindAddGoalButton(JButton button)
	{
		if (button != null)
		{
			button.addActionListener(this);
			addGoalButton = button;
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
	
	private void createGoal()
	{
		PIGoal goal = new PIGoal(null, null, null, -1);
		editGoal(goal);
		goalsListModel.addElement(goal);
	}
	
	private void editGoal(PIGoal goal)
	{
		if (goal != null)
		{
			GoalCreationForm goalCreationForm = (GoalCreationForm)Screen.getForm("goalsCreate");
			goalCreationForm.setGoal(goal);
			Screen.showForm(goalCreationForm);
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
		
		if (source == addGoalButton && addGoalButton != null)
		{
			createGoal();
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
