package main.gui.timer;

import main.gui.AbstractMainFormController;
import main.gui.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerEditorFormController extends AbstractMainFormController implements ActionListener
{
	private JTextField workTextField;
	private JTextField restTextField;
	private JButton startButton;
	private PITimer timer;
	
	public void bindWorkTextField(JTextField workTextField)
	{
		if (workTextField != null)
		{
			this.workTextField = workTextField;
		}
	}
	
	public void bindRestTextField(JTextField restTextField)
	{
		if (restTextField != null)
		{
			this.restTextField = restTextField;
		}
	}
	
	public void bindStartButton(JButton button)
	{
		if (button != null)
		{
			button.addActionListener(this);
			this.startButton = button;
		}
	}
	
	public void bindTimer(PITimer timer)
	{
		if (timer != null)
		{
			this.timer = timer;
			
			if (workTextField != null)
			{
				workTextField.setText(Integer.toString(timer.getWorkMins()));
			}
			
			if (restTextField != null)
			{
				restTextField.setText(Integer.toString(timer.getRestMins()));
			}
		}
	}
	
	private void startTimer(PITimer timer)
	{
		if (timer != null)
		{
			TimerRunningForm timerForm = (TimerRunningForm)Screen.getForm("timerRun");
			timerForm.setTimer(timer);
			Screen.showForm(timerForm);
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
		
		if (source == startButton && startButton != null && workTextField != null && restTextField != null && timer != null)
		{
			String workText = workTextField.getText();
			String restText = restTextField.getText();
			
			// Checking if both fields are positive integers
			if (workText.matches("^\\d+$") && restText.matches("^\\d+$"))
			{
				int workSeconds = Integer.parseInt(workText);
				int restSeconds = Integer.parseInt(restText);
				if (timer.getStudyExercise()) {
					workSeconds *= 60;
					restSeconds *= 60;
				}

				timer.setWorkSeconds(workSeconds);
				timer.setRestSeconds(restSeconds);
				
				startTimer(timer);
			}
		}
	}
}
