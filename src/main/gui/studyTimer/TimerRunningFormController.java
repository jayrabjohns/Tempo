package main.gui.studyTimer;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.gui.Screen;

public class TimerRunningFormController implements ActionListener
{
    private JButton stopButton;
    private JButton pauseButton;
    private JLabel timeRemainingLabel;
    private Timer timer;
    private int test = 0;

    public TimerRunningFormController() {
        timer = new Timer(1000, this);
        timer.start();
    }

    public void bindPauseButton(JButton button)
    {
        button.addActionListener(this);
        this.pauseButton = button;
    }

    public void bindStopButton(JButton button)
    {
        button.addActionListener(this);
        this.stopButton = button;
    }

    public void bindLabel(JLabel timeRemainingLabel)
    {
        this.timeRemainingLabel = timeRemainingLabel;

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
        if (source == this.pauseButton)
        {
            System.out.println("Hello World!");
        }
        else if (source == this.stopButton)
        {
            Screen.showForm(Screen.getForm("createTimer"));
        }
        else if (source == timer){
            this.timeRemainingLabel.setText(Integer.toString(test++));

        }

    }


}
