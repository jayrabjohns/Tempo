package main.gui.studyTimer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerCreationFormController implements ActionListener
{
	private JTextField workTextField;
	private JTextField restTextField;
	private JButton playButton;
	private JButton stopButton;
	private JButton pauseButton;

	public void bindWorkTextField(JTextField textField)
	{
		this.workTextField = textField;
	}
	
	public void bindRestTextField(JTextField textField)
	{
		this.restTextField = textField;
	}
	
	public void bindPlayButton(JButton button)
	{
		button.addActionListener(this);
		this.playButton = button;
		this.stopButton = button;
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
		
		// hide buttons n shit
		if (source == this.playButton)
		{
			workTextField.setText("Hello World!");
		}

	}
}
