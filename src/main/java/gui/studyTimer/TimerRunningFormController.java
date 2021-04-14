package gui.studyTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.AbstractMainFormController;
import gui.Screen;

public class TimerRunningFormController implements ActionListener
{
    private JButton stopButton;
    private JButton pauseButton;
    private JButton extendButton;
    private JLabel timeRemainingLabel;
    
    private final Timer actionTimer;
    private PITimer sessionTimer;

    private boolean pausing = true;

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
            checkPauseButton();
        }
    }
    
    public void stopTimer()
    {
        // if not paused end session and save it.
        if(!sessionTimer.getPaused()){
            sessionTimer.setRestSeconds(sessionTimer.getWorkMins()*60);

            //record session here.
            //time user has worked for to somehow send to database if it's being stopped during a work session.
            if (sessionTimer.getCurrentState() == TimerState.Work){
                sessionTimer.getElapsedSeconds();
            }

            sessionTimer.setElapsedSeconds(0);
        }
        this.actionTimer.stop();

    }
    
    public void togglePauseTimer()
    {
        sessionTimer.togglePause();
        checkPauseButton();

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

    private void checkPauseButton(){
        if (sessionTimer.getPaused()){
            pauseButton.setBackground(new Color(2, 117, 36));
            pauseButton.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(2, 117, 36)));
            pauseButton.setText("Resume");
        }
        else {
            pauseButton.setBackground(new Color(255,204,0));
            pauseButton.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(255,204,0)));
            pauseButton.setText("Pause");
        }
    }
}
