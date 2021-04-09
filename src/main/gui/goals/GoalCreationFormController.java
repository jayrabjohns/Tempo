package main.gui.goals;

import main.gui.Screen;
import main.gui.ScreenException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoalCreationFormController implements ActionListener
{
	private JButton doneButton;
	private JTextField titleTextField;
	private JTextField descriptionTextField;
	private JTextField endDateTextField;
	private JTextField targetTextField;
	
	private PIGoal goal;
	
	public void bindDoneButton(JButton button)
	{
		if (button != null)
		{
			button.addActionListener(this);
			doneButton = button;
		}
	}
	
	public void bindTitleTextField(JTextField textField)
	{
		if (textField != null)
		{
			textField.addActionListener(this);
			titleTextField = textField;
		}
	}
	
	public void bindDescriptionTextField(JTextField textField)
	{
		if (textField != null)
		{
			textField.addActionListener(this);
			descriptionTextField = textField;
		}
	}
	
	public void bindEndDateTextField(JTextField textField)
	{
		if (textField != null)
		{
			textField.addActionListener(this);
			endDateTextField = textField;
		}
	}
	
	public void bindTargetTextField(JTextField textField)
	{
		if (textField != null)
		{
			textField.addActionListener(this);
			targetTextField = textField;
		}
	}
	
	public void bindGoal(PIGoal goal)
	{
		if (goal != null)
		{
			this.goal = goal;
		}
	}
	
	private void finishCreatingGoal()
	{
		GoalsViewForm goalsViewForm = (GoalsViewForm)Screen.getForm("goalsView");
		Screen.showForm(goalsViewForm);
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
		
		if (source == doneButton && doneButton != null
				&& titleTextField != null && titleTextField.getText().length() > 0
				&& descriptionTextField != null
				&& endDateTextField != null)
		{
			String title = titleTextField.getText();
			String description = descriptionTextField.getText();
			String dateString = endDateTextField.getText();
			String targetString = targetTextField.getText();
			
			if (targetString.matches("^\\d+$"))
			{
				goal.setTitle(title);
				goal.setDescription(description);
				goal.setTarget(Integer.parseInt(targetString));
				
				// Getting end date
				DateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
				Date date = null;
				try
				{
					date = dateFormat.parse(dateString);
				}
				catch (ParseException parseException)
				{
					// Invalid date
				}
				goal.setEndDate(date);
				
				finishCreatingGoal();
			}
		}
	}
}
