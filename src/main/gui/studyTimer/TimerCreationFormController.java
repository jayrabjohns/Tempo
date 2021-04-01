package main.gui.studyTimer;

import main.gui.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerCreationFormController implements ActionListener
{
	private JTextField workTextField;
	private JTextField restTextField;
	private JButton playButton;
	private JButton addTimerButton;
	
	// TODO: move this to some other globals class, create system for saving changes to file / initialising values on startup (Possibly same as system used for settings)
	private DefaultListModel<PITimer> timersListModel;

	public void bindWorkTextField(JTextField textField)
	{
		if (textField != null)
		{
			this.workTextField = textField;
		}
	}
	
	public void bindRestTextField(JTextField textField)
	{
		if (textField != null)
		{
			this.restTextField = textField;
		}
	}
	
	public void bindPlayButton(JButton button)
	{
		if (button != null)
		{
			button.addActionListener(this);
			this.playButton = button;
		}
	}
	
	public void bindTimersListModel(DefaultListModel<PITimer> timersListModel)
	{
		if (timersListModel != null)
		{
			this.timersListModel = timersListModel;
		}
	}
	
	public void bindAddTimerButton(JButton button)
	{
		if (button != null)
		{
			button.addActionListener(this);
			this.addTimerButton = button;
		}
	}

	public void focusPlayButton()
	{
		playButton.requestFocusInWindow();
	}
	
	private void startTimer(PITimer timer)
	{
		TimerRunningForm timerForm = (TimerRunningForm)Screen.getForm("runTimer");
		timerForm.setTimer(timer);
		Screen.showForm(timerForm);
	}
	
	private void addTimer()
	{
		PITimer timer = new PITimer(25, 5);
		timersListModel.addElement(timer);
	}
	
	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		// Starting timer
		if (source == this.playButton && workTextField != null && restTextField != null)
		{
			String workText = workTextField.getText();
			String restText = restTextField.getText();
			
			// Checking if both fields are positive integers
			if (workText.matches("^\\d+$") && restText.matches("^\\d+$"))
			{
				int workLength = Integer.parseInt(workText);
				int restLength = Integer.parseInt(restText);
				
				PITimer timer = new PITimer(workLength, restLength);
				startTimer(timer);
			}
		}
		
		// Creating new timer
		else if (source == this.addTimerButton)
		{
			addTimer();
		}
	}
}
