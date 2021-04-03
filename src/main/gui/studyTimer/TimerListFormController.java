package main.gui.studyTimer;

import main.gui.Screen;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListFormController implements ActionListener, ListSelectionListener
{
	private JTextField workTextField;
	private JTextField restTextField;
	private JButton playButton;
	private JButton addTimerButton;
	
	// TODO: move this to some other globals class, create system for saving changes to file / initialising values on startup (Possibly same as system used for settings)
	private JList<PITimer> timersList;
	private DefaultListModel<PITimer> timersListModel;
	private final int defaultWorkTime = 25;
	private final int defaultRestTime = 5;

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
	
	public void bindTimersList(JList<PITimer> timersList, DefaultListModel<PITimer> listModel)
	{
		if (timersList != null && listModel != null)
		{
			timersList.addListSelectionListener(this);
			this.timersList = timersList;
			this.timersListModel = listModel;
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
		if (this.playButton != null)
		{
			this.playButton.requestFocusInWindow();
		}
	}
	
	private void startTimer(PITimer timer)
	{
		TimerRunningForm timerForm = (TimerRunningForm)Screen.getForm("runTimer");
		timerForm.setTimer(timer);
		Screen.showForm(timerForm);
	}
	
	private void addTimer()
	{
		PITimer timer = new PITimer(defaultWorkMins * 60, defaultRestMins * 60);
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
		Object source = e != null ? e.getSource() : null;
		
		// Starting timer
		if (source == this.playButton && this.playButton != null && this.workTextField != null && this.restTextField != null)
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
		if (source == this.timersList && this.timersList != null && !this.timersList.getValueIsAdjusting())
		{
			int y = timersList.getSelectedIndex();
			int x  = 0;
		}
	}
}
