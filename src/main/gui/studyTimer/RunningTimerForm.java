package main.gui.studyTimer;

import main.gui.Form;

/**
 * Form for running the timer, this might need to be split into multiple forms for study / excersise later on.
 */
public class RunningTimerForm extends Form
{
	private final RunningTimerFormController controller;
	private PITimer timer;
	
	public RunningTimerForm(RunningTimerFormController controller)
	{
		this.controller = controller;
	}
	
	public void setTimer(PITimer timer)
	{
		this.timer = timer;
	}
}
