package main.gui.studyTimer;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimerRunningFormController implements ActionListener
{
    private JButton stopButton;
    private JButton pauseButton;

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

    }
}
