package main.gui.goals;

import main.backend.DBHandler;
import main.backend.Session;
import main.gui.AbstractMainFormController;
import main.gui.Screen;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class GoalsViewFormController extends AbstractMainFormController implements ActionListener, ListSelectionListener
{
	private JButton chooseGoalButton;
	private JButton editGoalButton;
	private JButton removeGoalButton;
	
	private PIGoal selectedGoal;
	
	private JList<PIGoal> goalsList;
	private DefaultListModel<PIGoal> goalsListModel;
	
	public void bindGoalsList(JList<PIGoal> goalsList, DefaultListModel<PIGoal> listModel)
	{
		if (goalsList != null && listModel != null)
		{
			goalsList.addListSelectionListener(this);
			this.goalsList = goalsList;
			this.goalsListModel = listModel;
			
			int userId = Session.get().getUserId();
			ArrayList<PIGoal> goals = DBHandler.getGoals(userId);
			for (int i = 0; i < goals.size(); i++)
			{
				goalsListModel.addElement(goals.get(i));
			}
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
	
	public void bindRemoveGoalButton(JButton button)
	{
		if (button != null)
		{
			button.addActionListener(this);
			removeGoalButton = button;
		}
	}
	
	private void chooseGoal()
	{
		// Getting array of pre existing goals
		HashSet<PIGoal> preExistingGoals = new HashSet<>(goalsListModel.size());
		for (int i = 0; i < goalsListModel.size(); i++)
		{
			 preExistingGoals.add(goalsListModel.getElementAt(i));
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
	
	public void includeGoal(PIGoal goal)
	{
		if (goalsListModel != null && goal != null && !goalsListModel.contains(goal))
		{
			goalsListModel.addElement(goal);
			saveGoal(goal);
		}
	}
	
	private void removeGoal(PIGoal goal)
	{
		if (goal != null && goalsListModel != null && goalsListModel.contains(goal))
		{
			goalsListModel.removeElement(goal);
			
			int userId = Session.get().getUserId();
			int goalId = goal.getGoalId();
			if (goalId != -1)
			{
				DBHandler.deleteGoal(userId, goal.getGoalId());
			}
		}
	}
	
	private void saveGoal(PIGoal goal)
	{
		if (goal != null)
		{
			int userId = Session.get().getUserId();
			Date expireyDate = goal.getEndDate() != null ? goal.getEndDate().getTime() : null;
			Date creationDate = goal.getCreationDate() != null ? goal.getCreationDate().getTime() : null;
			
			DBHandler.insertNewGoal(userId, goal.getTitle(), goal.getDescription(), expireyDate, goal.getGoalTarget(), goal.getGoalProgress(), creationDate);
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
		else if (source == removeGoalButton && removeGoalButton != null)
		{
			removeGoal(selectedGoal);
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
