package main.gui.studyTimer;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.gui.AbstractMainFormController;
import main.gui.Screen;

public class TimerRunningFormController implements ActionListener
{
    private JButton stopButton;
    private JButton pauseButton;
    private JButton extendButton;
    private JLabel timeRemainingLabel;
    
    private final Timer actionTimer;
    private PITimer sessionTimer;

    public TimerRunningFormController()
    {
        actionTimer = new Timer(1000, this);
    }

    public void bindPauseButton(JButton button)
    {
        if (button != null)
        {
            button.addActionListener(this);
            this.pauseButton = button;
        }
    }

    public void bindStopButton(JButton button)
    {
        if (button != null)
        {
            button.addActionListener(this);
            this.stopButton = button;
        }
    }
    
    public void bindExtendButton(JButton button)
    {
        if (button != null)
        {
            button.addActionListener(this);
            this.extendButton = button;
        }
    }

    public void bindLabel(JLabel timeRemainingLabel)
    {
        if (timeRemainingLabel != null)
        {
            this.timeRemainingLabel = timeRemainingLabel;
        }
    }
    
    public void startTimer(PITimer timer)
    {
        if (timer != null)
        {
            this.sessionTimer = timer;
            this.actionTimer.start();
    
            updateTimeString();
        }
    }
    
    public void stopTimer()
    {
    
    }
    
    public void togglePauseTimer()
    {
    
    }
    
    public void updateTimeString()
    {
        String timeString = sessionTimer.getTimeString();
        this.timeRemainingLabel.setText(timeString);
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
        
        if (source == this.pauseButton)
        {
            System.out.println("Hello World!");
            togglePauseTimer();
        }
        else if (source == this.stopButton)
        {
            stopTimer();
            Screen.showForm(Screen.getForm("timerList"));
        }
        else if (source == actionTimer)
        {
            sessionTimer.stepTime();
            updateTimeString();
        }
        else if (source == extendButton)
        {
            sessionTimer.extendWorkDuration(60);
            updateTimeString();
        }
    }
}
