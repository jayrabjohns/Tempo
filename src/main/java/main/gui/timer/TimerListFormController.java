package main.gui.timer;

import main.backend.LocalStorage.AppSettings;
import main.backend.LocalStorage.ResourceManager;
import main.gui.Screen;
import main.gui.AbstractMainFormController;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerListFormController extends AbstractMainFormController implements ActionListener, ListSelectionListener, ListDataListener
{
	private JButton playButton;
	private JButton addTimerButton;
	private JButton editTimerButton;
	private JButton removeTimerButton;
	private ToggleSwitch toggleSwitch;


	private PITimer selectedTimer;
	private JList<PITimer> timersList;
	private DefaultListModel<PITimer> timersListModel;

	private ArrayList<PITimer> studyTimerList = new ArrayList<>();
	private ArrayList<PITimer> exerciseTimerList = new ArrayList<>();

	public void bindPlayButton(JButton button)
	{
		if (button != null)
		{
			playButton = button;
			button.addActionListener(this);
		}
	}

	public void bindTimersList(JList<PITimer> timersList, DefaultListModel<PITimer> listModel)
	{
		if (timersList != null && listModel != null)
		{
			this.timersList = timersList;
			this.timersListModel = listModel;

			loadTimerListModel("exerciseTimerSetups.json", exerciseTimerList);
			loadTimerListModel("studyTimerSetups.json", studyTimerList);

			for (int i = 0; i < studyTimerList.size(); i++)
			{
				timersListModel.addElement(studyTimerList.get(i));
			}


			timersList.addListSelectionListener(this);
			listModel.addListDataListener(this);
		}
	}

	public void bindAddTimerButton(JButton button)
	{
		if (button != null)
		{
			addTimerButton = button;
			button.addActionListener(this);
		}
	}

	public void bindEditTimerButton(JButton button)
	{
		if (button != null)
		{
			editTimerButton = button;
			button.addActionListener(this);
		}
	}

	public void bindRemoveTimerButton(JButton button)
	{
		if (button != null)
		{
			removeTimerButton = button;
			button.addActionListener(this);
		}
	}

	public void bindToggleSwitch(ToggleSwitch toggleSwitch) {
		if (toggleSwitch != null)
		{
			this.toggleSwitch = toggleSwitch;
			toggleSwitch.addActionListener(this);
		}
	}


	/**
	 * Focuses the play button
	 */
	public void focusPlayButton()
	{
		if (this.playButton != null)
		{
			this.playButton.requestFocusInWindow();
		}
	}

	/**
	 * Transitions to the start timer screen and starts running a given timer
	 *
	 * @param timer The timer to start
	 */
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
	 * Transitions ot the edit timer screen and allows you to edit a timer
	 *
	 * @param timer The timer to edit
	 */
	private void editTimer(PITimer timer)
	{
		if (timer != null)
		{
			TimerEditorForm timerEditorForm = (TimerEditorForm)Screen.getForm("timerCreate");
			timerEditorForm.setTimer(timer);
			Screen.showForm(timerEditorForm);
			saveTimerListModel();
		}
	}

	/**
	 * Adds a timer to the current list of timer setups
	 */
	private void addNewTimer()
	{
		if (timersListModel != null) {
			AppSettings settings = ResourceManager.getInstance().getAppSettings();
			PITimer timer;

				if (!toggleSwitch.isActivated()) {
					timer = new PITimer(settings.getDefaultWorkMins() * 60, settings.getDefaultRestMins() * 60);
				} else {
					timer = new PITimer(settings.getDefaultExerciseSeconds(), settings.getDefaultBreakSeconds());
				}

				timersListModel.addElement(timer);
				timer.setStudyExercise(!toggleSwitch.isActivated());

		}
	}

	/**
	 * Removes a timer from the list
	 *
	 * @param timer The timer to remove
	 */
	private void removeTimer(PITimer timer)
	{
		if (timersListModel != null)
		{
			timersListModel.removeElement(timer);
		}
	}

	/**
	 * Saves the current list of timer setups to device.
	 */
	private void saveTimerListModel()
	{
		if (timersListModel != null)
		{
			PITimer[] timers = new PITimer[timersListModel.size()];
			for (int i = 0; i < timersListModel.size(); i++)
			{
				timers[i] = timersListModel.getElementAt(i);
			}

			if(toggleSwitch.isActivated())ResourceManager.getInstance().trySaveResourceAsJson("studyTimerSetups.json", timers);
			else ResourceManager.getInstance().trySaveResourceAsJson("exerciseTimerSetups.json", timers);
		}
	}

	/**
	 * Populates the current list of timer setups with those stored on device.
	 */
	private void loadTimerListModel(String filePathName, ArrayList<PITimer> loadList)
	{
		if (loadList != null)
		{
			PITimer[] storedListModel = ResourceManager.getInstance().loadJsonResource(filePathName, PITimer[].class);

			if (storedListModel != null)
			{
				loadList.clear();
				for (int i = 0; i < storedListModel.length; i++)
				{
					loadList.add(storedListModel[i]);
				}
			}
		}
	}

	public void timerSwap(ArrayList<PITimer> loading, ArrayList<PITimer> storing)
	{
		if (timersListModel != null)
		{
			storing.clear();
			for (int i = 0; i < timersListModel.size(); i++)
			{
				storing.add(timersListModel.get(i));
			}
			timersListModel.clear();
			for (int i = 0; i < loading.size(); i++)
			{
				timersListModel.addElement(loading.get(i));
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

		if (source == playButton && playButton != null)
		{
			startTimer(selectedTimer);
		}
		else if (source == addTimerButton && addTimerButton != null)
		{
			addNewTimer();
		}
		else if (source == editTimerButton && editTimerButton != null)
		{
			editTimer(selectedTimer);
		}
		else if (source == removeTimerButton && removeTimerButton != null)
		{
			removeTimer(selectedTimer);
		}
		else if (source == toggleSwitch){
			if(toggleSwitch.isActivated()){
				timersList.setBackground(new Color(255, 255, 255));
				timerSwap(studyTimerList,exerciseTimerList);
			}
			else{
				timersList.setBackground(new Color(0, 141, 76));
				timerSwap(exerciseTimerList,studyTimerList);
			}
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

	/**
	 * Sent after the indices in the index0,index1
	 * interval have been inserted in the data model.
	 * The new interval includes both index0 and index1.
	 *
	 * @param e a <code>ListDataEvent</code> encapsulating the
	 *          event information
	 */
	@Override
	public void intervalAdded(ListDataEvent e)
	{
		saveTimerListModel();
	}

	/**
	 * Sent after the indices in the index0,index1 interval
	 * have been removed from the data model.  The interval
	 * includes both index0 and index1.
	 *
	 * @param e a <code>ListDataEvent</code> encapsulating the
	 *          event information
	 */
	@Override
	public void intervalRemoved(ListDataEvent e)
	{
		saveTimerListModel();
	}

	/**
	 * Sent when the contents of the list has changed in a way
	 * that's too complex to characterize with the previous
	 * methods. For example, this is sent when an item has been
	 * replaced. Index0 and index1 bracket the change.
	 *
	 * @param e a <code>ListDataEvent</code> encapsulating the
	 *          event information
	 */
	@Override
	public void contentsChanged(ListDataEvent e)
	{
		saveTimerListModel();
	}



}
