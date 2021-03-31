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
    private final Timer timer;
    private PITimer timerData;

    public TimerRunningFormController()
    {
        timer = new Timer(1000, this);
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

    public void bindLabel(JLabel timeRemainingLabel)
    {
        this.timeRemainingLabel = timeRemainingLabel;
    }
    
    public void startTimer(PITimer timer)
    {
        if (timer != null)
        {
            this.timerData = timer;
            timer.setCurrentState(TimerState.Work);
            this.timer.start();
    
            String timeString = timerData.getTimeString();
            this.timeRemainingLabel.setText(timeString);
        }
    }
    
    public void stopTimer()
    {
    
    }
    
    public void togglePauseTimer()
    {
    
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
            Screen.showForm(Screen.getForm("createTimer"));
        }
        else if (source == timer)
        {
            timerData.decrementTime();
            String timeString = timerData.getTimeString();
            this.timeRemainingLabel.setText(timeString);
        }
    }
}
