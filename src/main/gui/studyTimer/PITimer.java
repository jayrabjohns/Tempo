package main.gui.studyTimer;

enum TimerState
{
    Initialised,
    Work,
    Rest,
    Paused,
}

/**
 * Holds work / rest times, frequency of big breaks.
 */
public class PITimer {
    private final int workDuration;
    private final int restDuration;
    private int totalSeconds;
    private TimerState currentState;
    
    public PITimer(int work, int rest)
    {
        this.workDuration = work;
        this.restDuration = rest;
        totalSeconds = workDuration * 60;
        currentState = TimerState.Initialised;
    }
    
    public void decrementTime()
    {
        totalSeconds--;
        if (totalSeconds <= 0 && currentState == TimerState.Work)
        {
            totalSeconds = restDuration * 60;
            setCurrentState(TimerState.Rest);
        }
        else if (totalSeconds <= 0 && currentState == TimerState.Rest)
        {
            totalSeconds = workDuration * 60;
            setCurrentState(TimerState.Work);
        }
    }
    
    public String getTimeString()
    {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds - minutes * 60;
        int hours = minutes / 60;
        minutes -= hours * 60;
        
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
    public int getWorkDuration()
    {
        return workDuration;
    }
    
    public int getRestDuration()
    {
        return restDuration;
    }
    
    public TimerState getCurrentState()
    {
        return currentState;
    }
    
    public void setCurrentState(TimerState newState)
    {
        this.currentState = newState;
    }
}
