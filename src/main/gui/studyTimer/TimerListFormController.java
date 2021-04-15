package main.gui.studyTimer;

import main.gui.Screen;
import main.gui.AbstractMainFormController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListFormController extends AbstractMainFormController implements ActionListener, ListSelectionListener
{
	private JButton playButton;
	private JButton addTimerButton;
	private JButton editTimerButton;
	
	private PITimer selectedTimer;
	
	// TODO: move this to some other globals class, create system for saving changes to file / initialising values on startup (Possibly same as system used for settings)
	private JList<PITimer> timersList;
	private DefaultListModel<PITimer> timersListModel;
	private final int defaultWorkMins = 25;
	private final int defaultRestMins = 5;
	
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
	
	public void bindEditTimerButton(JButton button)
	{
		if (button != null)
		{
			button.addActionListener(this);
			this.editTimerButton = button;
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
		if (timer != null)
		{
			TimerRunningForm timerForm = (TimerRunningForm)Screen.getForm("timerRun");
			timerForm.setTimer(timer);
			Screen.showForm(timerForm);
		}
	}
	
	private void editTimer(PITimer timer)
	{
		if (timer != null)
		{
			TimerEditorForm timerEditorForm = (TimerEditorForm)Screen.getForm("timerCreate");
			timerEditorForm.setTimer(timer);
			Screen.showForm(timerEditorForm);
		}
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
		
		if (source == playButton && playButton != null)
		{
			startTimer(selectedTimer);
		}
		else if (source == addTimerButton && addTimerButton != null)
		{
			addTimer();
		}
		else if (source == editTimerButton && editTimerButton != null)
		{
			editTimer(selectedTimer);
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
			selectedTimer = timersList.getSelectedValue();
		}
	}
}
