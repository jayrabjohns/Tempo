package main.gui.goals;

import main.gui.AbstractMainFormController;
import main.gui.Screen;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GoalChoosingFormController extends AbstractMainFormController implements ActionListener, ListSelectionListener
{
	private JButton selectButton;
	private JButton backButton;
	private JList<PIGoal> goalChoiceList;
	private DefaultListModel<PIGoal> goalChoiceListModel;
	
	private PIGoal[] preExistingGoals;
	private PIGoal selectedGoal;
	
	public void bindSelectButton(JButton button)
	{
		if (button != null)
		{
			selectButton = button;
			selectButton.addActionListener(this);
		}
	}
	
	public void bindBackButton(JButton button)
	{
		if (button != null)
		{
			backButton = button;
			backButton.addActionListener(this);
		}
	}
	
	public void bindGoalsList(JList<PIGoal> goalChoicesList, DefaultListModel<PIGoal> listModel)
	{
		if (goalChoicesList != null && listModel != null)
		{
			this.goalChoiceList = goalChoicesList;
			this.goalChoiceListModel = listModel;
			
			loadGoalSelection();
			
			goalChoicesList.addListSelectionListener(this);
		}
	}
	
	public void setPreExistingGoals(PIGoal[] preExistingGoals)
	{
		this.preExistingGoals = preExistingGoals;
		loadGoalSelection();
	}
	
	private void loadGoalSelection()
	{
		if (preExistingGoals != null)
		{
			// Defining some daily goals
			ArrayList<PIGoal> dailyGoals = new ArrayList<PIGoal>();
			dailyGoals.add(new PIGoal("Complete 3 Hours of Study", "desc", null, 3*60*60));
			dailyGoals.add(new PIGoal("Complete 3 Hours of Exercise", "desc", null, 3*60*60));
			
			// Selecting goals which haven't been chosen before
			for (int i = dailyGoals.size() - 1; i >= 0; i--)
			{
				PIGoal goal = dailyGoals.get(i);
				
				for (int j = 0; j < preExistingGoals.length; j++)
				{
					if (preExistingGoals[j].getTitle().equals(goal.getTitle()))
					{
						dailyGoals.remove(goal);
					}
				}
			}
			
			// Updating model
			goalChoiceListModel.clear();
			for (int i = 0; i < dailyGoals.size(); i++)
			{
				goalChoiceListModel.addElement(dailyGoals.get(i));
			}
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
		
		if (source == selectButton && selectButton != null)
		{
			if (selectedGoal != null)
			{
				GoalsViewForm form = (GoalsViewForm)Screen.getForm("goalsView");
				form.includeGoal(selectedGoal);
				Screen.showForm(form);
			}
		}
		if (source == backButton && backButton != null)
		{
			Screen.showForm("goalsView");
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
		if (source == goalChoiceList && goalChoiceList != null && !goalChoiceList.getValueIsAdjusting())
		{
			selectedGoal = goalChoiceList.getSelectedValue();
		}
	}
}
